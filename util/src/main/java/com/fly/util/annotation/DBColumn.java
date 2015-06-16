package com.fly.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lixfn on 15-2-13.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBColumn {
    public String name();

    public DBColumnType columnType() default DBColumnType.STRING;

    public String descName() default "";

    public int columnIndex() default 50;
}
