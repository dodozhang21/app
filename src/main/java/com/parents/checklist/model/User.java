package com.parents.checklist.model;

import com.parents.model.AbstractBaseModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parents_user")
public class User extends AbstractBaseModel {
    @Column
    private String username;
    // mappedBy is the inverse of the bidirectional relationship, needs review on what that means
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

