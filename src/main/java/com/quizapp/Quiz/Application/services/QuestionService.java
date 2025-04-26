package com.quizapp.Quiz.Application.services;

import com.quizapp.Quiz.Application.entities.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    public ResponseEntity<Question> addNewQuestion(Question question);

    public ResponseEntity<List<Question>> getAllQuestions();

    public ResponseEntity<List<Question>> getQuestionByCategory(String category);
}
