package com.tactfactory.designpattern.controle.builder;

import com.tactfactory.designpattern.controle.entities.CheeseBurger;
import com.tactfactory.designpattern.controle.entities.Coca;
import com.tactfactory.designpattern.controle.entities.Fries;
import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Meal;
import com.tactfactory.designpattern.controle.entities.Menu;
import com.tactfactory.designpattern.controle.entities.Orangina;
import com.tactfactory.designpattern.controle.entities.Potatoes;
import com.tactfactory.designpattern.controle.entities.VeganBurger;
import com.tactfactory.designpattern.controle.factory.Factory;

public class Builder {

	private Coca coca;
	private Orangina orangina;
	private CheeseBurger cheeseBurger;
	private VeganBurger veganburger;
	private Fries fries;
	private Potatoes potatoes;
	private Meal meal = new Meal();
	private Item item;
	private int size;
	
	public Item addMenu(int size) {
		Factory factory = new Factory();
		item = factory.CreateMenu(size);
		return item;
	}
	
	public Item addDrink(String drink) {
		switch (drink) {
		case "Coca-Cola Small":
			coca = new Coca();
			coca.setSize(1);
			item = coca;
			meal.addItem(item);
			break;
		case "Coca-Cola Medium":
			coca = new Coca();
			coca.setSize(2);
			item = coca;
			meal.addItem(item);
			break;
		case "Coca-Cola Big":
			coca = new Coca();
			coca.setSize(3);
			item = coca;
			meal.addItem(item);
			break;
		case "Orangina Small":
			orangina = new Orangina();
			orangina.setSize(1);
			item = orangina;
			meal.addItem(item);
			break;
		case "Orangina Medium":
			orangina = new Orangina();
			orangina.setSize(2);
			item = orangina;
			meal.addItem(item);
			break;
		case "Orangina Big":
			orangina = new Orangina();
			orangina.setSize(3);
			item = orangina;
			meal.addItem(item);
			break;
		default:
			break;
		}
		return item;
	}
	
	public Item addBurger(String burger) {
		switch (burger) {
		case "Cheese Burger":
			item = new CheeseBurger();
			meal.addItem(item);
			break;
		case "Vegan Burger":
			item = new VeganBurger();
			meal.addItem(item);
			break;
		default:
			break;
		}
		return item;
	}
	
	public Item addAccompaniment(String accompaniment) {
		switch (accompaniment) {
		case "Fries Small":
			fries = new Fries();
			fries.setSize(1);
			item = fries;
			meal.addItem(item);
			break;
		case "Fries Medium":
			fries = new Fries();
			fries.setSize(2);
			item = fries;
			meal.addItem(item);
			break;
		case "Fries Big":
			fries = new Fries();
			fries.setSize(3);
			item = fries;
			meal.addItem(item);
			break;
		case "Potatoes Small":
			potatoes = new Potatoes();
			potatoes.setSize(1);
			item = potatoes;
			meal.addItem(item);
			break;
		case "Potatoes Medium":
			potatoes = new Potatoes();
			potatoes.setSize(2);
			item = potatoes;
			meal.addItem(item);
			break;
		case "Potatoes Big":
			potatoes = new Potatoes();
			potatoes.setSize(3);
			item = potatoes;
			meal.addItem(item);
			break;
		default:
			break;
		}
		return potatoes;
	}
	
	public Meal Build() {
		 Meal result = this.meal;
		 this.meal = new Meal();
		 return result;
	}
}
