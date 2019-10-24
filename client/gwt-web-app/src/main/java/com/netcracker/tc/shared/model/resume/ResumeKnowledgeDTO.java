package com.netcracker.tc.shared.model.resume;

import java.io.Serializable;

/**
 * Created by unconsionable on 25.08.2014.
 */
public class ResumeKnowledgeDTO implements Serializable {

    private Long id;
    private KnowledgeTypeDTO knowledgeType;
    private Long knowledgeLevel;

    public ResumeKnowledgeDTO(Long id, KnowledgeTypeDTO knowledgeType, Long knowledgeLevel) {
        this.id = id;
        this.knowledgeType = knowledgeType;
        this.knowledgeLevel = knowledgeLevel;
    }

    public ResumeKnowledgeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KnowledgeTypeDTO getKnowledgeType() {
        return knowledgeType;
    }

    public void setKnowledgeType(KnowledgeTypeDTO knowledgeType) {
        this.knowledgeType = knowledgeType;
    }

    public Long getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(Long knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }
}