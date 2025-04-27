package com.quizapp.Quiz.Application.dao;

import com.quizapp.Quiz.Application.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM Question WHERE category = :category LIMIT :numberOfQuestions", nativeQuery = true)
    List<Question> findQuestionByCategoryAndNumber(@Param("category") String category, @Param("numberOfQuestions") int numberOfQuestions);
}
