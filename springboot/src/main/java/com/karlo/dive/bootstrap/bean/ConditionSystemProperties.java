package com.karlo.dive.bootstrap.bean;

import com.karlo.dive.annotation.ConditionOnSystemProperties;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.stream.Stream;


public class ConditionSystemProperties implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        MultiValueMap<String, Object> attributes = annotatedTypeMetadata.getAllAnnotationAttributes(ConditionOnSystemProperties.class.getName());
        List<Object> name = attributes.get("name");
        List<Object> value = attributes.get("value");
        Stream.of(name).forEach(System.out::println);
        Stream.of(value).forEach(System.out::println);
        return true;
    }
}
