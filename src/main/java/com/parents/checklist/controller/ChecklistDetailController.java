package com.parents.checklist.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.parents.AbstractBaseController;
import com.parents.checklist.model.Checklist;
import com.parents.checklist.model.User;
import com.parents.checklist.service.ChecklistService;

@Controller
@SessionAttributes("checklist")
@RequestMapping("/checklist/detail")
@Transactional
public class ChecklistDetailController extends AbstractBaseController {
    private static final Logger LOG = Logger.getLogger(ChecklistDetailController.class);
    
	@Override
	protected String getViewPath() {
		return "checklist/";
	}
	
	@Autowired
	private ChecklistService checklistService;

	@RequestMapping(value="/{listId}", method=RequestMethod.GET)
    public String getChecklist(@PathVariable Long listId, 
    		@ModelAttribute Checklist checklist,
    		Model model) {
		
		checklistService.refreshChecklist(checklist);

    	return getView("detail");
    }
    
    @RequestMapping(value="/{listId}", method=RequestMethod.POST)
    public String saveCheckList(HttpServletRequest request,
    		@ModelAttribute Checklist checklist,
    		BindingResult bindingResult,
    		Model model) {
    	User sessionUser = (User) request.getSession().getAttribute("user");
    	checklist.setLastUpdated(new DateTime());
    	if(checklist.getOwner().getUsername().equals(USERNAME)) {
    		checklist.setId(null); // so a new one will be persisted
    		checklist.setOwner(sessionUser);
    		LOG.info(String.format("persisting a new checklist for owner %s", sessionUser.getUsername()));
    	}
    	
    	checklistService.saveChecklist(checklist);
    	
    	return "redirect:" + checklist.getId();
    }

}
