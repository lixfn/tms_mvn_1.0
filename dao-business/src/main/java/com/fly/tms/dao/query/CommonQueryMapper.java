package com.fly.tms.dao.query;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Map;

/**
 * Created by lixfn on 15-2-13.
 */
@MapperScan
public interface CommonQueryMapper {
    @SelectProvider(type = CommonQueryMapperProvider.class, method = "getSql")
    public <T> List<Map<String, Object>> queryByRowBounds(@Param("dto") T dto, RowBounds rowBounds);


    @SelectProvider(type = CommonQueryMapperProvider.class, method = "getSql")
    public <T> List<Map<String, Object>> query(@Param("dto") T dto);

    @SelectProvider(type = CommonQueryMapperProvider.class, method = "getRowCountSql")
    @Result(jdbcType = JdbcType.INTEGER)
    public <T> int getResultCount(@Param("dto") T dto);
}
