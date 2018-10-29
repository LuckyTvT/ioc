package com.karlo.dive.bootstrap.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/14 17:26
 * @since 1.0.0
 */

public class BeanSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{ConfigurationBean.class.getName()};
    }
}
