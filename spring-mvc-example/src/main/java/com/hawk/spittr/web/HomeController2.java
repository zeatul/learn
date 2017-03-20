package com.hawk.spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value={"/home","homepage"})
public class HomeController2 {

  @RequestMapping(value="/home",method = GET)
  public String home(Model model) {
    return "home";
  }

}
