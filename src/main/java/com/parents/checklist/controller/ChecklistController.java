package com.parents.checklist.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parents.checklist.model.Checklist;
import com.parents.checklist.model.User;

@Controller
@RequestMapping("/checklist")
@Transactional
public class ChecklistController extends ChecklistBaseController {
    private static final Logger LOG = Logger.getLogger(ChecklistController.class);

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
    
    @RequestMapping(value="/print/{listId}", method=RequestMethod.GET)
    public String printChecklist(HttpServletRequest request,
    		@PathVariable Long listId,
    		Model model) {
    	Checklist checklist = checklistService.getChecklistById(listId);
    	
    	model.addAttribute("checklist", checklist);
    	
    	return getView("print");
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
}
