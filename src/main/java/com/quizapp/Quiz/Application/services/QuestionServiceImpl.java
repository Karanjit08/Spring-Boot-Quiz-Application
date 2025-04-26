package com.quizapp.Quiz.Application.services;

import com.quizapp.Quiz.Application.dao.QuestionDao;
import com.quizapp.Quiz.Application.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionDao questionDao;


    @Override
    public ResponseEntity<Question> addNewQuestion(Question question) {
        return  new ResponseEntity<>(questionDao.save(question),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
    }
}
