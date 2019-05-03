/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP Pavilion
 */
public class BeerModel {
    List<String> beers = new ArrayList<>();
    
    public List<String> getBeerList(String color){
            if (color.equals("brown")){
                beers.add("Beer 1");
                beers.add("Beer 2");
            }else if (color.equals("dark")){
                beers.add("Beer 3");
                beers.add("Beer 4");
            }else
                beers.add("Good beer");
            
           return beers;                
    }
}
