package com.quizapp.Quiz.Application.dao;

import com.quizapp.Quiz.Application.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
