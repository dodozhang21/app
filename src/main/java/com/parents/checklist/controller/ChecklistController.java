package com.parents.checklist.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parents.AbstractBaseController;
import com.parents.checklist.model.Checklist;
import com.parents.checklist.service.ChecklistService;

@Controller
@RequestMapping("/checklist")
public class ChecklistController extends AbstractBaseController {
    static final Logger LOG = Logger.getLogger(ChecklistController.class);
    
    protected String viewPath = "checklist/";
    
    @Autowired
    private ChecklistService checklistService;

    @RequestMapping("/")
    public String loadLists(Model model) {
    	List<Checklist> results = checklistService.getListsForUser(USERNAME); // hard coded for now; but should get it from elsewhere
        model.addAttribute("lists", results);
        return getView("list");
    }

}
