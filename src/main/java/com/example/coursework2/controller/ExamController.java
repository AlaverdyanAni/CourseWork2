package com.example.coursework2.controller;

import com.example.coursework2.Service.ExaminerService;
import com.example.coursework2.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService){
        this.examinerService=examinerService;
    }

    @GetMapping(path="/get/{amount}")
    public Collection<Question>getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }
}
