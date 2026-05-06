package com.smartcampus.controller;
import com.smartcampus.entity.Event;import com.smartcampus.repository.*;import jakarta.validation.Valid;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.validation.BindingResult;import org.springframework.web.bind.annotation.*;
@Controller @RequestMapping("/admin")
public class AdminController{
 @Autowired EventRepository events; @Autowired RegistrationRepository regs;
 @GetMapping("/dashboard") String dash(Model m){m.addAttribute("events",events.findAll());m.addAttribute("registrations",regs.findAll());m.addAttribute("chartData",regs.countByEventTitle());return "admin-dashboard";}
 @GetMapping("/events/new") String form(Model m){m.addAttribute("event",new Event());return "event-form";}
 @GetMapping("/events/edit/{id}") String edit(@PathVariable Long id,Model m){m.addAttribute("event",events.findById(id).orElseThrow());return "event-form";}
 @PostMapping("/events/save") String save(@Valid @ModelAttribute Event event, BindingResult br){if(br.hasErrors())return "event-form";events.save(event);return "redirect:/admin/dashboard";}
 @GetMapping("/events/delete/{id}") String del(@PathVariable Long id){events.deleteById(id);return "redirect:/admin/dashboard";}
}
