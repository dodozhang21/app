package com.parents.checklist.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parents.AbstractBaseService;
import com.parents.checklist.dao.ChecklistDaoImpl;
import com.parents.checklist.dao.UserDaoImpl;
import com.parents.checklist.model.Checklist;
import com.parents.checklist.model.User;

@Component("checklistService")
public class ChecklistService extends AbstractBaseService {
	@Autowired
	private ChecklistDaoImpl checklistDao;
	@Autowired
	private UserDaoImpl userDao;
	
	public List<Checklist> getListsForUser(String username) {
		User user = userDao.findByUsername(username);
		
		if(user == null) {
			return new ArrayList<Checklist>();
		}
		
		return user.getChecklists();
		
	}
}
