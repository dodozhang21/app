package com.parents.checklist.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.parents.AbstractBaseController;
import com.parents.checklist.model.User;
import com.parents.checklist.service.ChecklistService;

public class ChecklistBaseController extends AbstractBaseController {
	@Autowired
    protected ChecklistService checklistService;
    
    @Override
    protected String getViewPath() {
    	return "checklist/";
    }
	
    protected User getUserInSession(String username, HttpServletRequest request) {
    	User userInSession = (User) request.getSession().getAttribute("user");

    	if(StringUtils.isNotBlank(username) 
    			&& (userInSession == null || !StringUtils.equals(username, userInSession.getUsername()))) {
    		userInSession = checklistService.getOrMakeUser(username);
    		request.getSession().setAttribute("user", userInSession);
    	}
    	
    	return userInSession;
    }

}
