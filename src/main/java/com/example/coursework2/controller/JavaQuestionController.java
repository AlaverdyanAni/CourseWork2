package com.example.coursework2.controller;

import com.example.coursework2.exception.QuestionNotFoundException;
import com.example.coursework2.exception.QuestionsAlreadyExistException;
import com.example.coursework2.exception.QuestionsLimitException;
import com.example.coursework2.model.Question;
import com.example.coursework2.Service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping ("/java")

public class JavaQuestionController {
    private  final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService){
        this.questionService=questionService;
    }

    @GetMapping(path = "/add")
        public Question addQuestion(
                @RequestParam(value = "question")String questionText,
                @RequestParam(value = "answer")String questionAnswer){
        return questionService.add(questionText,questionAnswer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(
            @RequestParam(value = "question")String questionText,
            @RequestParam(value = "answer")String questionAnswer){
        return questionService.remove(new Question(questionText,questionAnswer));
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        Collection<Question> questions = null;
        questions = questionService.getAll();
        return questions;
    }
    @ExceptionHandler(QuestionsAlreadyExistException.class)
    public ResponseEntity<String> handleQuestionAlreadyExistException(QuestionsAlreadyExistException e){
        return ResponseEntity.badRequest().body("Такой вопрос уже есть!");
    }

    @ExceptionHandler(value = {
            QuestionsAlreadyExistException.class,
            QuestionNotFoundException.class,
            QuestionsLimitException.class}
    )
    public ResponseEntity<String> handleQuestionAlreadyExistException(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getClass().getName()
        );
    }
}
