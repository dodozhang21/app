package com.parents.checklist.model;

import com.parents.model.AbstractBaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="parents_checklist_task")
public class Task extends AbstractBaseModel {
    @Column
    private String description;
    @Column
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
