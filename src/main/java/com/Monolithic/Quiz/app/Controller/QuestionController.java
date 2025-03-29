package com.Monolithic.Quiz.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Monolithic.Quiz.app.Model.quiz_questions;
import com.Monolithic.Quiz.app.Service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController
{
	@Autowired
	QuestionService questionService;
	@GetMapping("allquestion")
   public ResponseEntity<List<quiz_questions>> getAllQuestion() {
	   return  questionService.getAllQuestions();
   }
   @GetMapping("category/{language}")
   public   ResponseEntity< List<quiz_questions>> getQuestionsByLanguage(@PathVariable String language){
	   return questionService.getQuestionByLanguage(language);
   }
   @PostMapping("add")
   public  ResponseEntity<String> addQuestion(@RequestBody quiz_questions ques)
   {
	 return  questionService.addQuestion(ques);
   }
}
