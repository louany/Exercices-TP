package fr.builderTP;

import fr.builderTP.model.Meal;

public class BuilderPatternsDemo {
	
	
	    public static void main(String[] args) {
	    	
	    	MealBuilder mealBuilder = new MealBuilder();
	    	
	    	Meal vegMeal = mealBuilder.prepareVegMeal().Build();
	    	
	    	System.out.println(vegMeal);
	    	vegMeal.showItems();
	    	
	    }
}
