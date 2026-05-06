package com.smartcampus.exception;
import org.springframework.ui.Model;import org.springframework.web.bind.annotation.*;
@ControllerAdvice
public class GlobalExceptionHandler{ @ExceptionHandler(Exception.class) public String err(Exception e,Model m){m.addAttribute("message",e.getMessage());return "error";} }
