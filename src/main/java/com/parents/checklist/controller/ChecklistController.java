package com.parents.checklist.controller;


import com.parents.controller.AbstractBaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/checklist")
public class ChecklistController extends AbstractBaseController {
    static final Logger LOG = Logger.getLogger(ChecklistController.class);

    @RequestMapping("/list")
    public String loadLists(Model model) {
        model.addAttribute("message", "hello world");
        return "hello";
    }

}
