package com.ramostear.customstartertest;

import com.ramostear.spring.boot.starter.site.SiteInformation;
import com.ramostear.spring.boot.starter.site.SiteInformationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CustomStarterTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomStarterTestApplication.class, args);
	}


	@Autowired
	private SiteInformationProvider provider;

	@GetMapping(value = "/site/info",produces = "application/json;charset=utf-8")
	public SiteInformation getSiteInfo(){
		return provider.getInfo();
	}
}
