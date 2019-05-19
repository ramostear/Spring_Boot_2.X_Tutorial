package com.ramostear.spring.boot.exception.handing.data;/**
 * @author and @date : Created by Tan Chaohong on 2019/5/19 0019.
 */

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author ramostear
 * @create-time 2019/5/19 0019-15:01
 * @modify by :
 * @since:
 */
@Slf4j
@Component
@AllArgsConstructor
public class SampleUserDataInit implements ApplicationRunner {

    private SampleUserData sampleUserData;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Loading user data into memory database...");
        sampleUserData.createSampleUserData();
    }
}
