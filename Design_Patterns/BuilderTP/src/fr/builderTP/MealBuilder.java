package fr.builderTP;

import fr.builderTP.model.ChickenBurger;
import fr.builderTP.model.Coke;
import fr.builderTP.model.Item;
import fr.builderTP.model.Meal;
import fr.builderTP.model.Pepsi;
import fr.builderTP.model.VegBurger;

public class MealBuilder {
	
	Meal listItems = new Meal();
	
	public MealBuilder prepareVegMeal() {
		this.addItem(new VegBurger());
		this.addItem(new Pepsi());
		return this;
	}
	
	public MealBuilder prepareNonVegMeal() {
		this.addItem(new ChickenBurger());
		this.addItem(new Coke());
		return this;
	}
	
	public MealBuilder addItem(Item Item) {
		listItems.addItem(Item);
		return this;
	}
	
	public Meal Build() {
		 Meal result = this.listItems;
		 this.listItems = new Meal();
		 return result;
	}
}
