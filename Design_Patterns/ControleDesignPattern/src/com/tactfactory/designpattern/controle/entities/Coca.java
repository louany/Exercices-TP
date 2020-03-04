package com.tactfactory.designpattern.controle.entities;

public class Coca implements Item{
	
	private float price;
	private int size;
	
	@Override
	public String name() {
		return "Coca-Cola";
	}

	@Override
	public Packing packing() {
		Packing Bottle = new Bottle();
		return Bottle;
	}
	
	@Override
	public float price() {
		if( size == 1) {
			price = 2.5F;
		}
		if (size == 2 ) {
			price = 3F;
		}
		if (size == 3 ) {
			price = 3.5F;
		}
		return price;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
