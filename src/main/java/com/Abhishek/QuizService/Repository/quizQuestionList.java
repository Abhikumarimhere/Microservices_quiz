package com.Abhishek.QuizService.Repository;

import com.Abhishek.QuizService.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizQuestionList extends JpaRepository<Quiz,Long> {
}
