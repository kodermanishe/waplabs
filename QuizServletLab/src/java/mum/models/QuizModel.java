/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author HP Pavilion
 */
public class QuizModel {
    private final List<String> questions;
    private final List<Integer> answers;
    //private static QuizModel instance;
    private int questionNumber = 0;
    private int correct = 0;
    
    public QuizModel(){
       questions = Arrays.asList("3, 1, 4, 1, 5", "1, 1, 2, 3, 5"
               , "1, 4, 9, 16, 25", "2, 3, 5, 7, 11", "1,2,4,8,16");
       answers = Arrays.asList(9, 8, 36, 13, 32);
    }
    
    //public static QuizModel newInstance(){    
    //    if (Objects.isNull(instance))
    //        instance = new QuizModel();        
    //    return instance;
    //}
    
    private String getQuestion(int n){
        return questions.get(n);
    }
    
    public void putAnswer(int ans){
        if (ans == answers.get(questionNumber - 1))
            correct++;
    }
    
    public int getCorrectAnswers(){
        return correct;
    }
    
    public boolean isGameFinished(){
        return questionNumber == questions.size();
    }
    
    public String next(){
        if (isGameFinished())
            return "";
        
        return getQuestion(questionNumber++);
    }
    
    public int getCountOfQuestions(){
        return questionNumber;
    }
    
}
