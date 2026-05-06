package com.smartcampus.controller;
import com.smartcampus.entity.Event;import com.smartcampus.repository.EventRepository;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping("/api")
public class ApiController{ @Autowired EventRepository repo; @GetMapping("/events") public List<Event> all(){return repo.findAll();} }
