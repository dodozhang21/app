package com.parents.checklist.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.parents.AbstractBaseModel;

@Entity
@Table(name="parents_checklist")
public class Checklist extends AbstractBaseModel {
    @Column(nullable=false)
    @NotEmpty(message="Name is required.")
    private String name;

    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastUpdated;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="checklist_id", nullable = false)
    @OrderBy("completed")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Task> tasks = new ArrayList<Task>();

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
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
