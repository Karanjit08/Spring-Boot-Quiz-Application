package com.quizapp.Quiz.Application.controller;


import com.quizapp.Quiz.Application.entities.Question;
import com.quizapp.Quiz.Application.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    // Add Question
    @PostMapping("/add")
    public ResponseEntity<Question> addNewQuestion(@RequestBody Question question) {
        return this.questionService.addNewQuestion(question);
    }

    // Get all Questions
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestion() {
        return this.questionService.getAllQuestions();
    }

    // Get Question based on Category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return this.questionService.getQuestionByCategory(category);
    }


}
