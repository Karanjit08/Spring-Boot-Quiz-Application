package com.quizapp.Quiz.Application.dao;

import com.quizapp.Quiz.Application.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);
}
