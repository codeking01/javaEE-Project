package com.codeking.annotation;

/**
 * @author : codeking
 * @date : 2022/11/5 13:53
 */
public @interface MyAnnotation {
    String value() default "Hello!";
}
