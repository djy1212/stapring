package com.stapring.springboot.web.dto.anlysisobject;

import com.stapring.springboot.domain.analysisobject.AnalysisObject;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
public class AnalysisObjectDto {
    private Long id;
    private String name;
    private String content;
    private String author;
    private String subject;
    private String classification;
    private String independentVariable;
    private String dependentVariable;
    private BigDecimal weight;
    private LocalDateTime modifyDate;

    public AnalysisObjectDto(AnalysisObject ao) {
        this.id = ao.getId();
        this.name = ao.getName();
        this.content = ao.getContent();
        this.author = ao.getAuthor();
        this.subject = ao.getSubject();
        this.classification = ao.getClassification();
        this.independentVariable = ao.getIndependentVariable();
        this.dependentVariable = ao.getDependentVariable();
        this.weight = ao.getWeight();
        this.modifyDate = ao.getModifyDate();
    }
}
