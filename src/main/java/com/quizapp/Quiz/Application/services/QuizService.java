package com.quizapp.Quiz.Application.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface QuizService {


    ResponseEntity<String> createQuizByCategory(String category, int numberOfQuestions, String title);
}
