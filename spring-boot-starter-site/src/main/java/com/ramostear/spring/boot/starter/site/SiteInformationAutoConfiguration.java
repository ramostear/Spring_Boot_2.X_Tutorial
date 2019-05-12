package com.ramostear.spring.boot.starter.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ramostear
 * @create-time 2019/5/12 0012-22:57
 * @modify by :
 * @since:
 */
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(SiteInformation.class)
public class SiteInformationAutoConfiguration {

    @Autowired
    private SiteInformation information;

    @Bean
    @ConditionalOnMissingBean(SiteInformationProvider.class)
    public SiteInformationProvider provider(){
        SiteInformationProvider provider = new SiteInformationProvider();
        provider.setInformation(information);
        return provider;
    }
}
