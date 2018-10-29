package com.karlo.dive.annotation;


import com.karlo.dive.bootstrap.bean.BeanSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(BeanSelector.class)
public @interface EnableHello {
}
