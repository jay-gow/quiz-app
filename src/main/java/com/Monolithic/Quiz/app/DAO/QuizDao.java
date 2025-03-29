package com.Monolithic.Quiz.app.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Monolithic.Quiz.app.Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>
{

}
