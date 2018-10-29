package com.karlo.dive.annotation;


import com.karlo.dive.bootstrap.bean.ConditionSystemProperties;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(ConditionSystemProperties.class)
public @interface ConditionOnSystemProperties {

    String name();

    String value();
}
