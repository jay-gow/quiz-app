package com.Monolithic.Quiz.app.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Monolithic.Quiz.app.DAO.QuestionDao;

import com.Monolithic.Quiz.app.Model.quiz_questions;

@Service
public class QuestionService {
   
	@Autowired
	 QuestionDao  questionDao;
	public ResponseEntity<List<quiz_questions>> getAllQuestions()
	{
		try {
	return new ResponseEntity( questionDao.findAll(),HttpStatus.OK);}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity( new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<quiz_questions>> getQuestionByLanguage(String language) {
		try {
			return new ResponseEntity( questionDao.findByLanguage(language),HttpStatus.OK);}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return new ResponseEntity( new ArrayList<>(),HttpStatus.BAD_REQUEST);
		
	}
	public ResponseEntity<String> addQuestion(quiz_questions ques) {
		 questionDao.save(ques);
		 return new ResponseEntity("success",HttpStatus.CREATED);
		
	}
      
}
