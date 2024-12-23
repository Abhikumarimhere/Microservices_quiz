package com.Abhishek.QuizService.Service;


import com.Abhishek.QuizService.Repository.QuizRepository;
import com.Abhishek.QuizService.Repository.quizQuestionList;
import com.Abhishek.QuizService.entity.ClientResponse;
import com.Abhishek.QuizService.entity.QuestionWrapper;
import com.Abhishek.QuizService.entity.Quiz;
import com.Abhishek.QuizService.feign.QuizInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizInterface quizInterface;

    @Autowired
    private quizQuestionList quizQuestionList;
    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {

       List<Integer> questionIDs=quizInterface.getQuestions(category,numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIDs);
        log.info("logs : {}",quiz.getQuestionIds());
        quizRepository.save(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body("Success");
    }

    public ResponseEntity<List<QuestionWrapper>> getById(Long id) {
        Quiz quiz=quizRepository.findById(id).get();
        List<QuestionWrapper> questionWrappers=
                quizInterface.getQuestionsByID(quiz.getQuestionIds()).getBody();
        return ResponseEntity.status(HttpStatus.FOUND).body(questionWrappers);
    }

    public ResponseEntity<String> calculateScore(Long id,List<ClientResponse> clientResponses) {
        String result=quizInterface.getScore(clientResponses).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
