package com.stapring.springboot.domain.analysisobject;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalysisObjectTest {

    @Autowired
    AnalysisObjectRepository analysisObjectRepository;

    @After
    public void cleanup() {
        analysisObjectRepository.deleteAll();
    }

    @Test
    public void analysisObject_등록() {
        String name = "연구 제목";
        String content = "연구 설명";
        String author = "나";
        String subject = "기계공학";
        String classification = "항공기체";
        String independentVariable = "비행기 속도";
        String dependentVariable = "비행기 날개 크기";
        BigDecimal weight = new BigDecimal("0.3424");
        LocalDateTime modifyDate = LocalDateTime.now();

        analysisObjectRepository.save(AnalysisObject.builder()
                .name(name)
                .content(content)
                .author(author)
                .subject(subject)
                .classification(classification)
                .independentVariable(independentVariable)
                .dependentVariable(dependentVariable)
                .weight(weight)
                .modifyDate(modifyDate)
                .build());

        List<AnalysisObject> analysisObjectsList = analysisObjectRepository.findAll();

        AnalysisObject ao = analysisObjectsList.get(0);
        Assertions.assertThat(ao.getName()).isEqualTo(name);
    }
}