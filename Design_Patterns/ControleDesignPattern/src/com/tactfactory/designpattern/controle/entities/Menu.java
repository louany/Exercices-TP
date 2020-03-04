package com.tactfactory.designpattern.controle.entities;

public class Menu implements Item{
	
	private int size;
	private String name;
	private float price;
	
	private Item burger;
	private Item drink;
	private Item accompaniment;
	
	@Override
	public String name() {
		if( size == 1) {
			name = "BestOf";
		}
		if (size == 2 ) {
			name = "MaxiBestOf";
		}
		return name;
	}

	@Override
	public String toString() {
		return "Menu "+ name + "," + burger + "," + drink + "," + accompaniment + " price: " + price;
	}

	@Override
	public Packing packing() {
		return null;
	}

	@Override
	public float price() {
		if( size == 1) {
			price = 8.5F;
		}
		if ( size == 2) {
			price = 9F;
		}
		return price;
	}

	public Menu() {
		
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Item getBurger() {
		return burger;
	}

	public void setBurger(Item burger) {
		this.burger = burger;
	}

	public Item getDrink() {
		return drink;
	}

	public void setDrink(Item drink) {
		this.drink = drink;
	}

	public Item getAccompaniment() {
		return accompaniment;
	}

	public void setAccompaniment(Item accompaniment) {
		this.accompaniment = accompaniment;
	}

}
