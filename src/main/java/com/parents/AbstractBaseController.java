package com.parents;

import org.springframework.beans.factory.annotation.Autowired;

import com.parents.checklist.dao.UserDaoImpl;


public abstract class AbstractBaseController {
	@Autowired
	private UserDaoImpl userDao;
	
	public static final String USERNAME = "dodo";
	
	protected abstract String getViewPath();
	
	protected String getView(String view) {
		return getViewPath() + view;
	}
}
