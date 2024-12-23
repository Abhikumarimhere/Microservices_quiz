package com.Abhishek.QuizService.Controller;

import com.Abhishek.QuizService.Service.QuizService;
import com.Abhishek.QuizService.entity.ClientResponse;
import com.Abhishek.QuizService.entity.QuestionWrapper;
import com.Abhishek.QuizService.entity.QuizDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@Slf4j
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> CreateQuiz(@RequestBody QuizDTO quizDTO){
        log.info("Quiz DTO: {}",quizDTO.getTitle());
        log.info("Quiz DTO: {}",quizDTO.getCategory());
        log.info("Quiz DTO: {}",quizDTO.getNumQ());
        return quizService.createQuiz(quizDTO.getCategory(),
                quizDTO.getNumQ(),
                quizDTO.getTitle()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable("id") Long id){
        return quizService.getById(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<String> calculateScore(@PathVariable("id")Long id,@RequestBody List<ClientResponse> clientResponses){
        return quizService.calculateScore(id,clientResponses);
    }
}
