package com.example.coursework2;

import com.example.coursework2.Service.Impl.JavaQuestionService;
import com.example.coursework2.exception.QuestionNotFoundException;
import com.example.coursework2.exception.QuestionsAlreadyExistException;
import com.example.coursework2.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private final JavaQuestionService  javaQuestionService=new JavaQuestionService();

    @Test
    public void addTest(){
        javaQuestionService.add(new Question("test","test"));
        assertThatExceptionOfType(QuestionsAlreadyExistException.class)
                .isThrownBy(()->javaQuestionService.add(new Question("test","test")));
        assertThat(javaQuestionService.getAll()).containsExactlyInAnyOrder(new Question("test","test"));
    }

   @Test
    public void add2Test(){
        String question="test";
        String answer="test";
        Question q=new Question(question,answer);
        javaQuestionService.add(question,answer);

        assertThatExceptionOfType(QuestionsAlreadyExistException.class)
                .isThrownBy(()->javaQuestionService.add(question,answer));
        assertThat(javaQuestionService.getAll()).contoinsExactlyInAnyOrder(q);
    }

   @Test
    public void removeTest(){
        javaQuestionService.add(new Question("test","test"));
        javaQuestionService.remove(new Question("test","test"));
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(()->javaQuestionService.remove(new Question("test","test")));
    }
    @ParameterizedTest
    @MethodSource("questions")
    public void getRandomQuestionTest(Set<Question> questions){
        questions.forEach(javaQuestionService::add);
        assertThat(javaQuestionService.getRandomQuestion()).isIn(javaQuestionService.getAll());
    }

    public static Stream<Arguments> questions(){
        return Stream.of(
                Arguments.of(
                        Set.of(
                                new Question("Question1","Answer1"),
                                new Question("Question2","Answer2"),
                                new Question("Question3","Answer3")
                        )
                )
        );
    }
}
