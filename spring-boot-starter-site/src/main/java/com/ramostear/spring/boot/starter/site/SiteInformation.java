package com.ramostear.spring.boot.starter.site;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ramostear
 * @create-time 2019/5/12 0012-22:45
 * @modify by :
 * @since:
 */
@ConfigurationProperties(prefix = "site")
public class SiteInformation {

    private static final String NAME = "unknown";

    private static final String DOMAIN = "unknown";

    private static final String COPYRIGHT = "unknown";

    private static final String KEYWORDS = "unknown";

    private static final String DESCRIPTION = "unknown";


    private String name = NAME;

    private String domain = DOMAIN;

    private String copyright = COPYRIGHT;

    private String keywords = KEYWORDS;

    private String description = DESCRIPTION;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
