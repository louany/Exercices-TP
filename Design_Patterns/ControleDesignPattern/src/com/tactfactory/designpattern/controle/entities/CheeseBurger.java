package com.tactfactory.designpattern.controle.entities;

public class CheeseBurger implements Item{

	@Override
	public String name() {
		return "Cheese Burger";
	}
	
	@Override
	public Packing packing(){
		return new Wrapper();
	}
	
	@Override
	public float price() {
		return 5.5F;
	}
}
