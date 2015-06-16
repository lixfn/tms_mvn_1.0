package com.fly.tms.dao.query;

import com.fly.util.annotation.*;
import com.fly.tms.dao.query.*;
import com.fly.util.StringUtil;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixfn on 15-2-13.
 */
public class CommonQueryMapperProvider {

    private static Map<String, QuerySqlConfig> mapSqlConfig = new HashMap<String, QuerySqlConfig>();


    private String generateSql(Object dto, Integer sqlType) throws Exception {
        Class<?> dtoClass = dto.getClass();
        boolean hasCache = mapSqlConfig.containsKey(dtoClass.toString());
        QuerySqlConfig sqlConfig = null;
        if (hasCache) {
            sqlConfig = mapSqlConfig.get(dtoClass.toString());
        } else {
            //获取sql缓存数据
            sqlConfig = new QuerySqlConfig();
            //sql预计
            DBSql dbSql = dto.getClass().getAnnotation(DBSql.class);
            if (dbSql == null) {
                throw new Exception("类型" + dtoClass.toString() + "未定义SQL语句");
            }
            sqlConfig.setSql(dbSql.sql());
            //获取记录数语句
            DBRowCountSql dbRowCountSql = dto.getClass().getAnnotation(DBRowCountSql.class);
            if (dbRowCountSql != null) {
                sqlConfig.setRowCountSql(dbRowCountSql.rowCountSql());
            }
            //排序
            OrderBy orderBy = dto.getClass().getAnnotation(OrderBy.class);
            if (orderBy != null) {
                sqlConfig.setSortWith(orderBy.sortWith());
            }
            //条件语句
            Field[] fields = dto.getClass().getDeclaredFields();
            Map<String, WhereCondition> conditionMap = new HashMap<String, WhereCondition>();
            for (Field field : fields) {
                WhereCondition condition = field.getAnnotation(WhereCondition.class);
                if (condition != null) {
                    conditionMap.put(field.getName(), condition);
                }
            }
            sqlConfig.setMapCondition(conditionMap);

            //缓存sql
            synchronized (CommonQueryMapperProvider.class) {
                if (mapSqlConfig.containsKey(dtoClass.toString()) == false) {
                    mapSqlConfig.put(dtoClass.toString(), sqlConfig);
                }
            }
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("缓存SQL配置");
            System.out.println("--------------------------------------------------------------------------------");
        }

        //开始拼Sql语句
        StringBuilder sqlBuilder = new StringBuilder();

        if (sqlType == 0) {
            //sql语句
            sqlBuilder.append(sqlConfig.getSql());
        } else if (sqlType == 1) {
            //获取记录数sql
            if (StringUtil.isEmpty(sqlConfig.getRowCountSql())) {
                sqlBuilder.append(sqlConfig.getSql());
            } else {
                sqlBuilder.append(sqlConfig.getRowCountSql());
            }
        }
        //循环加查询条件
        Field[] fields = dto.getClass().getDeclaredFields();
        Map<String, WhereCondition> mapCondition = sqlConfig.getMapCondition();
        boolean nullValue = false;
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object o = field.get(dto);
                //如果值非空,就加入这个条件

                if (mapCondition.containsKey(field.getName())) {
                    if (o != null && StringUtil.getNotNullString(o).equals("") == false) {
                        nullValue = false;
                    } else {
                        nullValue = true;
                    }
                    if (mapCondition.get(field.getName()).nullValueInWhere() || (o != null && StringUtil.getNotNullString(o).equals("") == false)) {
                        if (mapCondition.get(field.getName()).conditiontype() == 1) {
                            StringBuilder itemBuilder = new StringBuilder();
                            boolean isfirst = true;
                            DBColumnType dbColumnType = mapCondition.get(field.getName()).itemType();
                            if (o.getClass().isArray()) {
                                for (Object itemObj : (Object[]) o) {
                                    if (dbColumnType == DBColumnType.STRING) {
                                        if (isfirst) {
                                            isfirst = false;
                                            itemBuilder.append(itemObj != null ? "'" + itemObj.toString() + "'" : "''");
                                        } else {
                                            itemBuilder.append(itemObj != null ? ",'" + itemObj.toString() + "'" : ",''");
                                        }
                                    } else {
                                        if (isfirst) {
                                            isfirst = false;
                                            itemBuilder.append(itemObj != null ? itemObj.toString() : "null");
                                        } else {
                                            itemBuilder.append(itemObj != null ? "," + itemObj.toString() : ",null");
                                        }
                                    }
                                }
                                sqlBuilder.append(" " + mapCondition.get(field.getName()).condition().replace("?", itemBuilder.toString()));
                            } else {
                                try {
                                    for (Object itemObj : (List) o) {
                                        if (dbColumnType == DBColumnType.STRING) {
                                            if (isfirst) {
                                                isfirst = false;
                                                itemBuilder.append(itemObj != null ? "'" + itemObj.toString() + "'" : "''");
                                            } else {
                                                itemBuilder.append(itemObj != null ? ",'" + itemObj.toString() + "'" : ",''");
                                            }
                                        } else {
                                            if (isfirst) {
                                                isfirst = false;
                                                itemBuilder.append(itemObj != null ? itemObj.toString() : "null");
                                            } else {
                                                itemBuilder.append(itemObj != null ? "," + itemObj.toString() : ",null");
                                            }
                                        }
                                    }
                                    sqlBuilder.append(" " + mapCondition.get(field.getName()).condition().replace("?", itemBuilder.toString()));
                                } catch (Exception ex) {
                                    sqlBuilder.append(" " + mapCondition.get(field.getName()).condition().replace("?", o.toString()));
                                }
                            }
                        } else {
                            sqlBuilder.append("  " + (nullValue ? mapCondition.get(field.getName()).nullCondition() : mapCondition.get(field.getName()).condition()));
                        }
                    }
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //sql查询,添加排序
        if (sqlType == 0) {
            if (StringUtil.isEmpty(sqlConfig.getSortWith()) == false) {
                sqlBuilder.append(" order by " + sqlConfig.getSortWith());
            }
        }
        //如果是获取记录数量sql,并且获取记录数量sql未配置,需要在最终sql语句外边加汇总语句.
        if (sqlType == 1 && StringUtil.isEmpty(sqlConfig.getRowCountSql()) == true) {
            sqlBuilder.insert(0, "select count(0) from(");
            sqlBuilder.append(")t");
        }

        return sqlBuilder.toString();
    }

    public String getSql(Map<String, Object> parameters) throws Exception {
        return generateSql(parameters.get("dto"), 0);
    }

    /**
     * 获取查询结果行数
     *
     * @param parameters
     * @return
     */
    public String getRowCountSql(Map<String, Object> parameters) throws Exception {
        return generateSql(parameters.get("dto"), 1);
    }
}
