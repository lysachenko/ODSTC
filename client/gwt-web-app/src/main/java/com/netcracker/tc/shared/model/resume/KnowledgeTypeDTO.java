package com.netcracker.tc.shared.model.resume;

import java.io.Serializable;

public class KnowledgeTypeDTO implements Serializable {

    private Long id;
    private String description;

    public KnowledgeTypeDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public KnowledgeTypeDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KnowledgeTypeDTO that = (KnowledgeTypeDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}