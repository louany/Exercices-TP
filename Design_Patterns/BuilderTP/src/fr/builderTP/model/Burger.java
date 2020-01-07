package fr.builderTP.model;

public abstract class Burger implements Item{

	public Packing packing(){
		return new Wrapper();
	}

}
