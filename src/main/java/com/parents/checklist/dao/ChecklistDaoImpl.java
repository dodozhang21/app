package com.parents.checklist.dao;

import com.parents.checklist.model.Checklist;
import com.parents.dao.GenericDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("checklistDao")
public class ChecklistDaoImpl extends GenericDaoImpl<Checklist, Long> {
}
