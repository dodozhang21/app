package com.parents.checklist.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.parents.AbstractBaseModel;

@Entity
@Table(name="parents_user")
public class User extends AbstractBaseModel {
    @Column(length=50)
    @NaturalId
    private String username;
    // mappedBy is the inverse of the bidirectional relationship, needs review on what that means
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @OrderBy("last_updated desc")
    private List<Checklist> checklists = new ArrayList<Checklist>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Checklist> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<Checklist> checklists) {
        this.checklists = checklists;
    }
}

