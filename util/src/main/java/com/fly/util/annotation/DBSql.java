package com.fly.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lixfn on 15-2-12.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBSql {
    /**
     * sql中必须包含where 语句
     *
     * @return
     */
    public String sql();
}
