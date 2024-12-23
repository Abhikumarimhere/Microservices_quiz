package com.Abhishek.QuizService.feign;

import com.Abhishek.QuizService.entity.ClientResponse;
import com.Abhishek.QuizService.entity.QuestionWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUIZQUESTIONSERVICE")
public interface QuizInterface {
    @GetMapping("/question/generate")
    public ResponseEntity<List<Integer>> getQuestions(@RequestParam String category,
                                                            @RequestParam Integer numQ);
    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(@RequestBody List<Integer> questionsID);

    @PostMapping("question/getScore")
    public ResponseEntity<String> getScore(@RequestBody List<ClientResponse> clientResponses);
}
