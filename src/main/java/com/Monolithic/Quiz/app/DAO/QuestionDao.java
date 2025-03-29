
package com.Monolithic.Quiz.app.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.Monolithic.Quiz.app.Model.quiz_questions;

@Repository
public interface QuestionDao extends JpaRepository<quiz_questions, Integer>
{

	         List<quiz_questions>  findByLanguage(String language);
	         @Query(value="SELECT * FROM quiz_questions WHERE language = :language ORDER BY RANDOM() LIMIT :num", nativeQuery = true)
	         List<quiz_questions> findRandomQuestionsByLanguage(String language, int num);

}
