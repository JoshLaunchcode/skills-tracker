package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {

    String options = "<option value='Javascript'>Javascript</option>" +
            "<option value='Python'>Python</option>" +
            "<option value='Java'>Java</option>";

    @GetMapping()
    @ResponseBody
    public String defaultPage(){
        return "<html>" +
                "<body>" +
                "<h1>Skills Tracker</h1>" +
                "<h3>We have a few skills we would like to learn. Here is the list!</h3>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>" +
                "Customize your list of favorites! <a href='/form'>Click Here</a>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("/form-data")
    @ResponseBody
    public String getPageFromParams(@RequestParam String name, @RequestParam String firstChoice, @RequestParam String secondChoice, @RequestParam String thirdChoice){
        return "<html>" +
                "<body>" +
                "<h1>" + name + "</h1>" +
                "<ol>" +
                "<li>" + firstChoice + "</li>" +
                "<li>" + secondChoice + "</li>" +
                "<li>" + thirdChoice + "</li>" +
                "<ol>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("form")
    @ResponseBody
    public String requestForm(){
        return "<html>" +
                "<body>" +
                "<form method='post' action='form-data'>" +
                "<label>Name: <input type='name' name='name' placeholder='name' /></label></br>" +
                "<label>First favorite language: <select name='firstChoice' id='firstChoice'>" +
                options +
                "</select></label></br>" +
                "<label>My second favorite language: <select name='secondChoice' id='secondChoice'>" +
                options +
                "</select></label></br>" +
                "<label>My third favorite language: <select name='thirdChoice' id='thirdChoice'>" +
                options +
                "</select></label></br>" +
                "<input type='submit' value='Submit' />" +
                "</form>" +
                "</body>" +
                "</html>";

    }
}
