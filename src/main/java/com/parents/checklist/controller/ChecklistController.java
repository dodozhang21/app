package com.parents.checklist.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parents.AbstractBaseController;
import com.parents.checklist.model.Checklist;
import com.parents.checklist.model.User;
import com.parents.checklist.service.ChecklistService;

@Controller
@RequestMapping("/checklist")
@Transactional
public class ChecklistController extends AbstractBaseController {
    private static final Logger LOG = Logger.getLogger(ChecklistController.class);
    
    @Autowired
    private ChecklistService checklistService;

    @RequestMapping("/")
    public String loadLists(HttpServletRequest request) {
    	User sessionUser = getUserInSession("", request);
    	
    	if(sessionUser != null) {
    		List<Checklist> userLists = checklistService.getListsForUser(sessionUser.getUsername());
    		request.setAttribute("userLists", userLists);
    	}
    	
    	List<Checklist> results = checklistService.getListsForUser(USERNAME); // hard coded for now; but should get it from elsewhere
        request.setAttribute("lists", results);
        
        return getView("list");
    }
    
    @RequestMapping(value="/list/{listId}", method=RequestMethod.GET)
    public String getChecklist(HttpServletRequest request,
    		@PathVariable Long listId, 
    		@ModelAttribute Checklist checklist) {
    	checklist = checklistService.getChecklistById(listId);
    	
    	request.getSession().setAttribute("checklist", checklist);
    	
    	// redirect to form controller
    	LOG.info("redirect to form controller");
    	return "redirect:../detail/" + checklist.getId();
    }
    
    
    
    /********* SERVICE PORTION **********/
    @RequestMapping("/user/{username}")
    public @ResponseBody User getSessionUser(@PathVariable String username, HttpServletRequest request) {
    	return getUserInSession(username, request);
    }

    @RequestMapping("/user/")
    public @ResponseBody Boolean getSessionUser(HttpServletRequest request, HttpServletResponse response) {
    	User sessionUser = getUserInSession("", request);
    	if(sessionUser == null) {
    		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    		return null;
    	} else {
    		return Boolean.TRUE;
    	}
    }
    
    private User getUserInSession(String username, HttpServletRequest request) {
    	User userInSession = (User) request.getSession().getAttribute("user");

    	if(StringUtils.isNotBlank(username) 
    			&& (userInSession == null || !StringUtils.equals(username, userInSession.getUsername()))) {
    		userInSession = checklistService.getOrMakeUser(username);
    		request.getSession().setAttribute("user", userInSession);
    	}
    	
    	return userInSession;
    }
    
    @Override
    protected String getViewPath() {
    	return "checklist/";
    }
}
