package com.coolio.mailman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * @author Aseem Savio
 *
 * Configuration Class for teh API.
 */

@Configuration
public class CoolioConfig {

    @Primary // As another instance of this bean is created in the Service package, this is made primary.
    @Bean
    public FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean(){
        FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
        freeMarkerConfigurationFactoryBean.setTemplateLoaderPath("classpath:/templates");
        return freeMarkerConfigurationFactoryBean;
    }
}
