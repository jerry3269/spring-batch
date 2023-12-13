package com.example.spring_batch.job.pass.expire;

import com.example.spring_batch.builder.ObjectBuilder;
import com.example.spring_batch.config.TestBatchConfig;
import com.example.spring_batch.entity.PassEntity;
import com.example.spring_batch.repository.PassRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBatchTest
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = {ExpirePassesJobConfig.class, TestBatchConfig.class})
class ExpirePassesJobConfigTest extends ObjectBuilder {
    private JobLauncherTestUtils jobLauncherTestUtils;
    private PassRepository passRepository;
    public ExpirePassesJobConfigTest(
            @Autowired JobLauncherTestUtils jobLauncherTestUtils,
            @Autowired PassRepository passRepository
            ) {
        this.jobLauncherTestUtils = jobLauncherTestUtils;
        this.passRepository = passRepository;
    }

    @DisplayName("이용권 만료 배치 테스트")
    @Test
    void expirePassesStep() throws Exception {
        //given
        ArrayList<PassEntity> passEntities = addPassEntities(10);
        passRepository.saveAll(passEntities);

        //when
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        JobInstance jobInstance = jobExecution.getJobInstance();

        //then
        assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
        assertEquals("expirePassesJob", jobInstance.getJobName());
    }



}