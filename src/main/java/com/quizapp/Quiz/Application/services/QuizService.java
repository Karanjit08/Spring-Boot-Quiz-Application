package com.quizapp.Quiz.Application.services;

import com.quizapp.Quiz.Application.entities.Question;
import com.quizapp.Quiz.Application.entities.QuestionWrapper;
import com.quizapp.Quiz.Application.entities.QuizSubmitRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuizService {


    ResponseEntity<String> createQuizByCategory(String category, int numberOfQuestions, String title);

    ResponseEntity<List<QuestionWrapper>> getQuestionById(int id);

    ResponseEntity<Integer> submitQuiz(QuizSubmitRequest quizSubmitRequest);
}
