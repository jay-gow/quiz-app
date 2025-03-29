package com.Monolithic.Quiz.app.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quiz_id;
    private String title;

    @ManyToMany
    @JoinTable(
        name = "quiz_quiz_questions",
        joinColumns = @JoinColumn(name = "quiz_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<quiz_questions> questions;

	public Integer getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(Integer quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<quiz_questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<quiz_questions> questions) {
		this.questions = questions;
	}
    
   
}
