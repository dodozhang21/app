package com.parents.checklist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.parents.checklist.model.Checklist;
import com.parents.checklist.model.User;

@Controller
@SessionAttributes("checklist")
@RequestMapping("/checklist/detail")
@Transactional
public class ChecklistDetailController extends ChecklistBaseController {
    private static final Logger LOG = Logger.getLogger(ChecklistDetailController.class);

	@RequestMapping(value="/{listId}", method=RequestMethod.GET)
    public String getChecklist(@PathVariable Long listId, 
    		@ModelAttribute Checklist checklist,
    		Model model) {
		
		checklistService.refreshChecklist(checklist);

    	return getView("detail");
    }
    
    @RequestMapping(value="/{listId}", method=RequestMethod.POST)
    public String saveCheckList(HttpServletRequest request,
    		@ModelAttribute @Valid Checklist checklist,
    		BindingResult bindingResult,
    		Model model) {
    	
    	// validation errors
    	if(bindingResult.hasErrors()) {
    		return getView("detail");
    	}
    	
    	User sessionUser = getUserInSession("", request);
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
