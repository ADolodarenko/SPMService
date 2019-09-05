package org.dav.learn.enterprise.spmservice.controller;

import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;
import org.dav.learn.enterprise.spmservice.service.ProcedureService;
import org.dav.learn.enterprise.spmservice.service.ProcedureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProcedureController {
    private ProcedureService procedureService;

    @Autowired
    public void setProcedureService(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allProcedures() {
        List<ProcedureInfo> procedures = procedureService.allProcedures();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("procedures");
        modelAndView.addObject("proceduresList", procedures);
        return modelAndView;
    }

    //Go to the edit procedure page
    @RequestMapping(value = "/edit/{dbid}-{procid}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("dbid") short databaseId, @PathVariable("procid") int procedureId) {
        ProcedureInfo procedureInfo = procedureService.getByIds(databaseId, procedureId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("procedure", procedureInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editProcedure(@ModelAttribute("procedure") ProcedureInfo procedureInfo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        procedureService.edit(procedureInfo);
        return modelAndView;
    }
}
