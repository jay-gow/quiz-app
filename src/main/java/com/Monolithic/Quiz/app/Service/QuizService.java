package com.Monolithic.Quiz.app.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Monolithic.Quiz.app.DAO.QuestionDao;
import com.Monolithic.Quiz.app.DAO.QuizDao;
import com.Monolithic.Quiz.app.Model.QuestionWrapper;
import com.Monolithic.Quiz.app.Model.Quiz;
import com.Monolithic.Quiz.app.Model.Response;
import com.Monolithic.Quiz.app.Model.quiz_questions;

@Service
public class QuizService 
{
	@Autowired
     QuizDao quizDao;
	@Autowired
	QuestionDao questiondao;

	public ResponseEntity<String> createQuiz(String language, int num, String title) {
		List<quiz_questions> questions=questiondao.findRandomQuestionsByLanguage(language,num);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
	Optional<Quiz> quiz=	quizDao.findById(id);
	List<quiz_questions> questionsFromDB=quiz.get().getQuestions();
	List<QuestionWrapper> questionForUser=new ArrayList<QuestionWrapper>();
	for(quiz_questions q:questionsFromDB) {
		QuestionWrapper qw=new QuestionWrapper(q.getQuestion_id(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
		questionForUser.add(qw);
	}
	return new ResponseEntity<> (questionForUser,HttpStatus.OK);
	
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz=quizDao.findById(id).get();
		List<quiz_questions> questions=quiz.getQuestions();
		int right=0;
		int i=0;
		for(Response response:responses) {
			if(response.getResponse().equals(questions.get(i).getRight_answer())){
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	} 
	
	
}
