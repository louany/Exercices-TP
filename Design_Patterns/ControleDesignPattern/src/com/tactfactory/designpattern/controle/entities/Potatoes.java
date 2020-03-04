package com.tactfactory.designpattern.controle.entities;

public class Potatoes implements Item{
	
	private float price;
	private int size;
	
	
	@Override
	public String name() {
		return "Potatoes";
	}

	@Override
	public Packing packing() {
		Packing Corner = new Corner();
		return Corner;
	}

	@Override
	public float price() {
		if( size == 1) {
			price = 2.F;
		}
		if (size == 2 ) {
			price = 2.5F;
		}
		if (size == 3 ) {
			price = 3F;
		}
		return price;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
