package edu.javavt17Second.controllers;

import edu.javavt17Second.model.Director;
import edu.javavt17Second.model.Film;
import edu.javavt17Second.service.DirectorService;
import edu.javavt17Second.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class JdbcController {

    private static final String INSTRUMENT = "jdbc";
    private static final String TITLE = "JDBC";

    @Autowired
    @Qualifier("directorJdbcService")
    private DirectorService directorService;
    @Autowired
    @Qualifier("filmJdbcService")
    private FilmService filmService;

    @RequestMapping(value = "/"+INSTRUMENT+"", method = RequestMethod.GET)
    public String printJdbc(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("instrument", INSTRUMENT);

        List<Director> listDirector = directorService.list();
        List<Film> listFilm = filmService.list();

        model.addAttribute("listFilm",listFilm);
        model.addAttribute("listDirector",listDirector);
        return "content";
    }

    //CRUD operations with CarBrand entity
    @RequestMapping(value = "/"+INSTRUMENT+"/addDirector", method = RequestMethod.GET)
    public String addDirector(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");

        Director director = new Director();
        model.addAttribute("director", director);

        return "directorForm";
    }

    @RequestMapping(value = { "/"+INSTRUMENT+"/addDirector" }, method = RequestMethod.POST)
    public String saveDirector(Director director) {

        directorService.saveOrUpdate(director);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = { "/"+INSTRUMENT+"/delete-director/{idDirector}" }, method = RequestMethod.GET)
    public String deleteDirector(@PathVariable int idDirector) {
        directorService.delete(idDirector);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-director/{idDirector}" }, method = RequestMethod.GET)
    public String editDirector(@PathVariable int idDirector, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");

        Director director = directorService.get(idDirector);
        model.addAttribute("director", director);
        return "directorForm";
    }

    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-director/{idDirector}" }, method = RequestMethod.POST)
    public String updateDirector(Director director) {
        directorService.saveOrUpdate(director);
        return "redirect:/"+INSTRUMENT;
    }

    //CRUD operations with CarModel entity
    @RequestMapping(value = "/"+INSTRUMENT+"/addFilm", method = RequestMethod.GET)
    public String addFilm(ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Add new");

        List<Director> listDirector = directorService.list();
        System.out.println(listDirector);
        Film film = new Film();
        model.addAttribute("listDirector", listDirector);
        model.addAttribute("film", film);

        return "filmForm";
    }

    @RequestMapping(value = { "/"+INSTRUMENT+"/addFilm" }, method = RequestMethod.POST)
    public String saveFilm(Film film) {
        filmService.saveOrUpdate(film);
        return "redirect:/"+INSTRUMENT;
    }


    @RequestMapping(value = { "/"+INSTRUMENT+"/delete-film/{idFilm}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable int idFilm) {
        filmService.delete(idFilm);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-film/{idFilm}" }, method = RequestMethod.GET)
    public String editFilm(@PathVariable int idFilm, ModelMap model) {
        model.addAttribute("title", TITLE);
        model.addAttribute("action", "Edit");

        Film film = filmService.get(idFilm);
        List<Director> listDirector = directorService.list();

        model.addAttribute("film", film);
        model.addAttribute("listDirector", listDirector);

        return "filmForm";
    }

    @RequestMapping(value = {  "/"+INSTRUMENT+"/edit-film/{idFilm}" }, method = RequestMethod.POST)
    public String updateFilm(Film film) {
        filmService.saveOrUpdate(film);
        return "redirect:/"+INSTRUMENT;
    }

    @RequestMapping(value = {"/"+INSTRUMENT+"/pdfReport", "/"+INSTRUMENT+"/xlsxReport.xlsx"}, method = RequestMethod.GET)
    public ModelAndView downloadReport(@RequestParam("view") String view) {
        ModelAndView modelAndView = new ModelAndView();

        List<Director> listDirector = directorService.list();
        List<Film> listFilm = filmService.list();
        // return a view which will be resolved by a ResourceBundleViewResolver
        modelAndView.addObject("director", listDirector);
        modelAndView.addObject("film", listFilm);
        modelAndView.setViewName(view);

        return modelAndView;
    }
}