package com.parents;

import org.springframework.beans.factory.annotation.Autowired;

import com.parents.checklist.dao.UserDaoImpl;


public abstract class AbstractBaseController {
	@Autowired
	private UserDaoImpl userDao;
	
	public static final String USERNAME = "dodo";
	
	protected String viewPath = "";
	
	protected String getView(String view) {
		return viewPath + view;
	}
}
