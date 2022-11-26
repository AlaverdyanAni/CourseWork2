package com.example.coursework2.Service.Impl;

import com.example.coursework2.Service.ExaminerService;
import com.example.coursework2.Service.QuestionService;
import com.example.coursework2.model.Question;
import com.example.coursework2.exception.QuestionsLimitException;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public  ExaminerServiceImpl(JavaQuestionService questionService){
        this.questionService=questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount>questionService.getAll().size()||amount<1){
            throw new QuestionsLimitException();
        }
        Set<Question> result=new HashSet<>();
        while (result.size()<amount){
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
