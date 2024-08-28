package com.ericsson.sibuto.managedobject;

import com.ericsson.sibuto.node.NodeType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lmieody on 27/07/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MOStrategy {
    String[] moTypes();
    NodeType nodeType();
    String minMimLetter() default "A";
    int minMimVersion() default 0;
    int minMimRelease() default 0;
    String maxMimLetter() default "Z";
    int maxMimVersion() default 9;
    int maxMimRelease() default 999;
}
