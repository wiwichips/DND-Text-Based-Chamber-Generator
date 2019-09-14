package dnd;

import dnd.die.*;



/**
@author Will Pringle
*/
public class dungeon{
	
	
	public static void main(String args[]){
		System.out.println("hello world");
		
		
		D10 dice = new D10();
		
		int number = dice.roll();
		
		System.out.println("te numebr is ="+number);
		
		
		
		
	}


}
