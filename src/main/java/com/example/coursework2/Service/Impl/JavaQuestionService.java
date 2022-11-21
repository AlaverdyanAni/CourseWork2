package com.example.coursework2.Service.Impl;

import com.example.coursework2.Service.QuestionService;
import com.example.coursework2.exception.QuestionNotFoundException;
import com.example.coursework2.exception.QuestionsAlreadyExistException;
import com.example.coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Random random;
    private final Set<Question> questions;

    public JavaQuestionService(){
        this.random=new Random();
        this.questions=new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if(!questions.add(question)){
            throw new QuestionsAlreadyExistException();
        }
        return question;
    }

    @Override
        public Question remove(Question question) {
        if(!questions.contains(question)){
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
        //return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.size()==0) {
            return null;
        }
        //return new ArrayList<>(questions).get(random.nextInt(questions.size()));
        return questions.stream()
                .skip(random.nextInt(questions.size()))
                .findAny()
                .orElse(null);
    }
}
