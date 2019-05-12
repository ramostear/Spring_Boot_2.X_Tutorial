package com.ramostear.spring.boot.starter.site;

/**
 * @author ramostear
 * @create-time 2019/5/12 0012-22:52
 * @modify by :
 * @since:
 */
public class SiteInformationProvider {

    SiteInformation information;

    public SiteInformation getInformation() {
        return information;
    }

    public void setInformation(SiteInformation information) {
        this.information = information;
    }

    public SiteInformation getInfo(){
        return information;
    }
}
