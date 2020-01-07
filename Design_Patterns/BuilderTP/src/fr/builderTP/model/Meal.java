package fr.builderTP.model;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	
	private static List<Item> itemList = new ArrayList<Item>();

	
	public void addItem(Item item) {
		itemList.add(item);
	}
	
	public float getCost() {
		float cost = 0;
		for (Item i : itemList ) {
			cost += i.price();
		}
		return cost;
	}
	
	public void showItems() {
		for (Item i : itemList ) {
			System.out.println(i);
		}
	}
}
