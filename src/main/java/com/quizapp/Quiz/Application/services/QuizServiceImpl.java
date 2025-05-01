package com.quizapp.Quiz.Application.services;

import com.quizapp.Quiz.Application.dao.QuestionDao;
import com.quizapp.Quiz.Application.dao.QuizDao;
import com.quizapp.Quiz.Application.entities.Question;
import com.quizapp.Quiz.Application.entities.QuestionWrapper;
import com.quizapp.Quiz.Application.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(int id) {
        Optional<Quiz> quizOptional = quizDao.findById(id);

        if (quizOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Quiz quiz = quizOptional.get();

        List<QuestionWrapper> wrappedQuestions = quiz.getQuestionList().stream()
                .map(q -> new QuestionWrapper(
                        q.getId(),
                        q.getQuestionTitle(),
                        q.getOption1(),
                        q.getOption2(),
                        q.getOption3(),
                        q.getOption4()
                ))
                .collect(Collectors.toList());

        return new ResponseEntity<>(wrappedQuestions, HttpStatus.OK);
    }
}
