package com.Monolithic.Quiz.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Monolithic.Quiz.app.Model.QuestionWrapper;
import com.Monolithic.Quiz.app.Model.Response;
import com.Monolithic.Quiz.app.Model.quiz_questions;
import com.Monolithic.Quiz.app.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizservice;
	@PostMapping("create")
  public ResponseEntity<String>   createQuiz(@RequestParam String language,@RequestParam int num,@RequestParam String title){
	return quizservice.createQuiz(language,num,title);
}
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>>  getQuizQuestion(@PathVariable Integer id){
	return	quizservice.getQuizQuestions(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses)
	{
		return quizservice.calculateResult(id,responses);
	}	
}