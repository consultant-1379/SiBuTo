package com.ericsson.sibuto.node;

import com.ericsson.sibuto.mimconverter.MimVersion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ANodeStrategy {
    String name();
    int version();
    int release();
}
