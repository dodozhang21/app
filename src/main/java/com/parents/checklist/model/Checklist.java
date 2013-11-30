package com.parents.checklist.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.parents.AbstractBaseModel;
import com.sun.istack.internal.NotNull;

@Entity
@Table(name="parents_checklist")
public class Checklist extends AbstractBaseModel {
    @Column
    private String name;

    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastUpdated;

    @OneToMany
    @JoinColumn(name="checklist_id", nullable = false)
    @OrderBy("completed")
    private List<Task> tasks = new ArrayList<Task>();

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @NotNull
    private User owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
