package com.tactfactory.designpattern.controle.entities;

public class Corner implements Packing{

	public int size;
	
	@Override
	public String pack() {
		return "Corner";
	}
	
	public int size() {
		return this.size;
	}
	
}
