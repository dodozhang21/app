package com.parents.checklist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.parents.AbstractBaseModel;
import com.sun.istack.internal.NotNull;

@Entity
@Table(name="parents_checklist_task")
public class Task extends AbstractBaseModel {
    @Column
    @NotNull
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
