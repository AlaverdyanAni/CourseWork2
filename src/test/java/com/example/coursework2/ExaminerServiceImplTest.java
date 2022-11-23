package com.example.coursework2;

import com.example.coursework2.Service.ExaminerService;
import com.example.coursework2.Service.Impl.ExaminerServiceImpl;
import com.example.coursework2.Service.Impl.JavaQuestionService;
import com.example.coursework2.exception.QuestionNotFoundException;
import com.example.coursework2.exception.QuestionsLimitException;
import com.example.coursework2.model.Question;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> javaQuestions=new ArrayList<>();

    @BeforeEach
    public void beforeEach(){
        javaQuestions.clear();
        javaQuestions.addAll(
                Stream.of(
                        new Question("Вопрос1","Ответ1"),
                        new Question("Вопрос2","Ответ2"),
                        new Question("Вопрос3","Ответ3")
                ).collect(Collectors.toSet()));
                when(javaQuestionService.getAll()).thenReturn(javaQuestions);
    }
    @Test
    public void getQuestionsNegativeTest(){
        assertThatExceptionOfType(QuestionsLimitException.class)
                .isThrownBy(()-> examinerService.getQuestions(-1));
    }
    @Test
    public void getQuestionPositiveTest(){
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                new Question("Вопрос1", "Ответ1"),
                new Question("Вопрос2", "Ответ2"),
                new Question("Вопрос1", "Ответ1"),
                new Question("Вопрос2", "Ответ2"),
                new Question("Вопрос3", "Ответ3")
        );
        assertThat(examinerService.getQuestions(3))
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Вопрос1", "Ответ1"),
                        new Question("Вопрос2", "Ответ2"),
                        new Question("Вопрос3", "Ответ3")
                );
    }

}
