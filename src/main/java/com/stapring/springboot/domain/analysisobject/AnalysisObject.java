package com.stapring.springboot.domain.analysisobject;

import com.stapring.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class AnalysisObject extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;
    private String subject;
    private String classification;
    private String independentVariable;
    private String dependentVariable;

    @Column(columnDefinition = "TEXT", nullable = false)
    private BigDecimal weight;

    private LocalDateTime modifyDate;

    @Builder
    public AnalysisObject(Long id, String name, String content, String author, String subject, String classification, String independentVariable, String dependentVariable, BigDecimal weight, LocalDateTime modifyDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.author = author;
        this.subject = subject;
        this.classification = classification;
        this.independentVariable = independentVariable;
        this.dependentVariable = dependentVariable;
        this.weight = weight;
        this.modifyDate = modifyDate;
    }

    public void update(Long id, String name, String content, String author, String subject, String classification, String independentVariable, String dependentVariable, BigDecimal weight, LocalDateTime modifyDate) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.author = author;
        this.subject = subject;
        this.classification = classification;
        this.independentVariable = independentVariable;
        this.dependentVariable = dependentVariable;
        this.weight = weight;
        this.modifyDate = modifyDate;
    }
}
