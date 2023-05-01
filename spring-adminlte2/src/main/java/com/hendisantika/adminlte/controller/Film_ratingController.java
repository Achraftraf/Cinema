package com.hendisantika.adminlte.controller;

import java.util.List;
import java.util.ArrayList;

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

import com.hendisantika.adminlte.model.Film_rating;
import com.hendisantika.adminlte.service.Film_ratingService;

@Controller
@RequestMapping("/film-ratings")
public class Film_ratingController {

    private Film_ratingService film_ratingService;

    @Autowired
    public void setFilmRatingService(Film_ratingService film_ratingService) {
        this.film_ratingService = film_ratingService;
    }


    
    @GetMapping(value = "/{pageNumber}")
    public String list(@PathVariable Integer pageNumber, Model model) {
        Page<Film_rating> page = film_ratingService.getList(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("list", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "film_rating/list";

    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("film_rating", new Film_rating());
        return "film_rating/form";
        

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("film_rating", film_ratingService.get(id));
        return "film_rating/form";

    }

    @PostMapping(value = "/save")
    public String save(Film_rating film_rating, final RedirectAttributes ra) {

        Film_rating save = film_ratingService.save(film_rating);
        ra.addFlashAttribute("successFlash", "Film_rating foi salvo com sucesso.");
        return "redirect:/film_rating";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        film_ratingService.delete(id);
        return "redirect:/film_rating";

    }
    
    @GetMapping(path = "/api/list", produces = "application/json")
    public @ResponseBody
    List<Film_rating> getAllFilm_rating()
    {
    	List<Film_rating> allFilm_rating = new ArrayList<Film_rating>();
        allFilm_rating = film_ratingService.getListAll();
        return allFilm_rating;
    }

}
