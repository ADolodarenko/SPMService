package org.dav.learn.enterprise.spmservice.controller;

import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcedureController {
    private static ProcedureInfo procedureInfo;

    static {
        procedureInfo = new ProcedureInfo();
        procedureInfo.setDatabaseId(5);
        procedureInfo.setProcedureId(1);
        procedureInfo.setProcedureName("usp_dav_test");
        procedureInfo.setProcedureDescription("usp_dav_test");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allProcedures() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("procedures");
        modelAndView.addObject("procedureInfo", procedureInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editProcedure() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editProcedure");
        return modelAndView;
    }
}
