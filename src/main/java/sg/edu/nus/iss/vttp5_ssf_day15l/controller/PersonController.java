package sg.edu.nus.iss.vttp5_ssf_day15l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.vttp5_ssf_day15l.model.Person;
import sg.edu.nus.iss.vttp5_ssf_day15l.service.PersonService;
import sg.edu.nus.iss.vttp5_ssf_day15l.util.Util;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    PersonService personService;

    @GetMapping("")
    public String personListPage(Model model) {

        List<Person> persons = personService.findAll(Util.keyPerson);
        model.addAttribute("persons", persons);
        
        return "personlist";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);

        return "personcreate";
    }
    
    @PostMapping("/create")
    public String createPersonRecord(@ModelAttribute("person") Person person, BindingResult bindingResult, Model model) {
        personService.addPerson(Util.keyPerson, person);

        return "redirect:/persons";
    }
    
    @GetMapping("/delete/{person-id}")
    public String deletePersonRecord(@PathVariable("person-id") String personId) {
        // logic here (currently, simply do it here)
        // or shift the logic to service layer
        List<Person> persons = personService.findAll(Util.keyPerson);
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(Integer.parseInt(personId))).findFirst().get();
        System.out.println("foundPerson : " + foundPerson.toString());

        personService.delete(Util.keyPerson, foundPerson);

        return "redirect:/persons";
    }
    
    
}