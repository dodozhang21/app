package com.parents.checklist.dao;

import com.parents.GenericDaoImpl;
import com.parents.checklist.model.Checklist;

import org.springframework.stereotype.Repository;

@Repository("checklistDao")
public class ChecklistDaoImpl extends GenericDaoImpl<Checklist, Long> {
}
