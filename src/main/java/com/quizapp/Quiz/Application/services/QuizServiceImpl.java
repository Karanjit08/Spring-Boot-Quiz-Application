package com.quizapp.Quiz.Application.services;

import com.quizapp.Quiz.Application.dao.QuestionDao;
import com.quizapp.Quiz.Application.dao.QuizDao;
import com.quizapp.Quiz.Application.entities.Question;
import com.quizapp.Quiz.Application.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    @Override
    public ResponseEntity<String> createQuizByCategory(String category, int numberOfQuestions, String title) {
        Quiz quiz = new Quiz();
        List<Question> questionList = questionDao.findQuestionByCategoryAndNumber(category,numberOfQuestions);
        quiz.setTitle(title);
        quiz.setQuestionList(questionList);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
