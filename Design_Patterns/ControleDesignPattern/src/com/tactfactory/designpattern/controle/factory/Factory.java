package com.tactfactory.designpattern.controle.factory;

import com.tactfactory.designpattern.controle.entities.Item;
import com.tactfactory.designpattern.controle.entities.Menu;

public class Factory {
	
	private Menu menu;
	private Item item;
	private int size;
	private Item burger;
	private Item drink;
	private Item accompaniment;
	
   public Item CreateMenu(int size){
      if( size == 1 ){
    	  menu = new Menu();
    	  menu.setSize(1);
    	  item = menu;
         return item;	         
      } 
      if( size == 2 ){
    	  menu = new Menu();
    	  menu.setSize(2);
    	  item = menu;
         return item;	      
      }
	return null;
   }
}
