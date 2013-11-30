package com.parents.checklist.model;


import com.parents.AbstractBaseModel;
import com.sun.istack.internal.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
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
