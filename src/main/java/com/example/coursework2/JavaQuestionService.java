package com.example.coursework2;

import java.util.*;

public class JavaQuestionService implements QuestionService{
    private Set<Question> questions=new HashSet<>();
    public JavaQuestionService(){
        this.questions=new HashSet<>();
    }
    private void fillQustions(){
        questions.add(new Question("Question1","Answer1"));
        questions.add(new Question("Question2","Answer2"));
        questions.add(new Question("Question3","Answer3"));
        questions.add(new Question("Question4","Answer4"));
        questions.add(new Question("Question5","Answer5"));
        questions.add(new Question("Question6","Answer6"));
        questions.add(new Question("Question7","Answer7"));
        questions.add(new Question("Question8","Answer8"));
        questions.add(new Question("Question9","Answer9"));
        questions.add(new Question("Question10","Answer10"));
        questions.add(new Question("Question11","Answer11"));
        questions.add(new Question("Question12","Answer12"));
        questions.add(new Question("Question13","Answer13"));
        questions.add(new Question("Question14","Answer14"));
        questions.add(new Question("Question15","Answer15"));
        questions.add(new Question("Question16","Answer16"));
        questions.add(new Question("Question17","Answer17"));
        questions.add(new Question("Question18","Answer18"));
        questions.add(new Question("Question19","Answer19"));
        questions.add(new Question("Question20","Answer20"));

    }
    @Override
    public Question add(String question, String answer) {
        Question questionForAdd=new Question(question,answer);
        return add(questionForAdd);
    }

    @Override
    public Question add(Question question) {
        if(question==null){
            throw new RuntimeException("Напишите вопрос!");
        }
        questions.add(question);
        return question;
    }

    @Override
        public Question remove(Question question) {
        if(question==null){
            throw new RuntimeException("Напишите вопрос!");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return questions.stream()
                .skip(new Random().nextInt(questions.size()))
                .findFirst()
                .orElse(null);
    }
}
