package com.parents.checklist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.parents.AbstractBaseModel;

@Entity
@Table(name="parents_checklist_task")
public class Task extends AbstractBaseModel {
    @Column(nullable=false)
    @NotEmpty
    private String description;
    @Column(nullable=false)
    private boolean completed;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
