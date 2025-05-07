package com.quizapp.Quiz.Application.controller;

import com.quizapp.Quiz.Application.entities.Question;
import com.quizapp.Quiz.Application.entities.QuestionWrapper;
import com.quizapp.Quiz.Application.entities.QuizSubmitRequest;
import com.quizapp.Quiz.Application.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuizByCategory(@RequestParam String category, @RequestParam int numberOfQuestions, @RequestParam String title) {
        return quizService.createQuizByCategory(category,numberOfQuestions,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@PathVariable int id) {
        return this.quizService.getQuestionById(id);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody QuizSubmitRequest quizSubmitRequest) {
        return this.quizService.submitQuiz(quizSubmitRequest);
    }
}
