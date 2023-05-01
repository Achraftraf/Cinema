package com.hendisantika.adminlte.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hendisantika.adminlte.model.Seance;
import com.hendisantika.adminlte.service.SeanceService;

@Controller
@RequestMapping("seances")
public class SeanceController {

    private SeanceService seanceService;

    @Autowired
    public void setSeanceService(SeanceService seanceService) {
        this.seanceService = seanceService;
    }

    @GetMapping
    public String index() {
        return "redirect:/seances/1";
    }

    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
    	
    	
        Page<Seance> page = seanceService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "seances/list";

    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("seance", new Seance());
        return "seances/form";
        

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("seance", seanceService.get(id));
        return "seances/form";

    }

    @PostMapping(value = "/save")
    public String save(Seance seance, final RedirectAttributes ra) {

        Seance save = seanceService.save(seance);
        ra.addFlashAttribute("successFlash", "Seance has been saved successfully.");
        return "redirect:/seances";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        seanceService.delete(id);
        return "redirect:/seances";

    }
    
    @GetMapping(path = "/api/list", produces = "application/json")
    public @ResponseBody
    List<Seance> getAllSeances()
    {
    List<Seance> allSeances = new ArrayList<Seance>();
    allSeances = seanceService.getListAll();
    return allSeances;
    }
}
