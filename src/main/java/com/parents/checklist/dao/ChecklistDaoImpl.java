package com.parents.checklist.dao;

import org.springframework.stereotype.Repository;

import com.parents.GenericDaoImpl;
import com.parents.checklist.model.Checklist;

@Repository("checklistDao")
public class ChecklistDaoImpl extends GenericDaoImpl<Checklist, Long> {
}
