package com.fly.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lixfn on 15-2-12.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WhereCondition {
    public String condition();

    /**
     * 条件类型 0正常类型 1in类型
     *
     * @return
     */
    public int conditiontype() default 0;

    /**
     * 内容类型,仅仅当 in类型条件时使用
     *
     * @return
     */
    public DBColumnType itemType() default DBColumnType.STRING;

    /**
     * null sql语句
     *
     * @return
     */
    public String nullCondition() default "";

    /**
     * 值为null时，是否包含null sql语句
     *
     * @return
     */
    public boolean nullValueInWhere() default false;
}
