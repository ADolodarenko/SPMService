package org.dav.learn.enterprise.spmservice.controller;

import org.dav.learn.enterprise.spmservice.config.ViewConfig;
import org.dav.learn.enterprise.spmservice.model.ProcedureInfo;
import org.dav.learn.enterprise.spmservice.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProcedureController {
    private ProcedureService procedureService;
    private int pageNumber;

    @Autowired
    public void setProcedureService(ProcedureService procedureService) {
        this.procedureService = procedureService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allProcedures(@RequestParam(defaultValue = "1") int page) {
        pageNumber = page;
        List<ProcedureInfo> procedures = procedureService.allProcedures(pageNumber);
        int proceduresCount = procedureService.proceduresCount();
        int pagesCount = (proceduresCount + ViewConfig.RECORDS_PER_PAGE - 1) / ViewConfig.RECORDS_PER_PAGE;

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("procedures");
        modelAndView.addObject("proceduresList", procedures);
        modelAndView.addObject("proceduresCount", proceduresCount);
        modelAndView.addObject("pagesCount", pagesCount);
        modelAndView.addObject("page", pageNumber);

        return modelAndView;
    }

    //Go to the edit procedure page
    @RequestMapping(value = "/edit/{dbid}-{procid}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("dbid") short databaseId, @PathVariable("procid") int procedureId) {
        ProcedureInfo procedureInfo = procedureService.getByIds(databaseId, procedureId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("procedure", procedureInfo);
        modelAndView.addObject("page", pageNumber);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editProcedure(@ModelAttribute("procedure") ProcedureInfo procedureInfo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/?page=" + pageNumber);
        procedureService.edit(procedureInfo);
        return modelAndView;
    }
}
