package com.hiron.open.sdk.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * @author Luckymi
 * @since 2025/6/19
 */
@Target({METHOD,TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HrApi {
    String value();
    String method() default "";
}
