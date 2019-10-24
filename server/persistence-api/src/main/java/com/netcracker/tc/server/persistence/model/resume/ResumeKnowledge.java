package com.netcracker.tc.server.persistence.model.resume;

public class ResumeKnowledge {

    private Long id;

    private Long knowledgeLevel ;
    private Resume resume;
    private KnowledgeType knowledgeType;

    public ResumeKnowledge() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(Long knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public KnowledgeType getKnowledgeType() {
        return knowledgeType;
    }

    public void setKnowledgeType(KnowledgeType knowledgeType) {
        this.knowledgeType = knowledgeType;
    }
}