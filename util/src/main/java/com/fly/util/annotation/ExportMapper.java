package com.fly.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导出映射注解
 * Created by lixfn on 15-3-5.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExportMapper {
    /**
     * 导出列描述
     *
     * @return
     */
    public String columnDesc() default "";

    /**
     * 导入列次序
     *
     * @return
     */
    public int columnIndex() default 50;
}
