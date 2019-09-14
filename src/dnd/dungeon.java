package dnd;

import dnd.die.*;
import dnd.models.*;
import dnd.exceptions.*;
import java.util.ArrayList;



/**
@author Will Pringle
*/
public class dungeon{
	
	
	public static void main(String args[]){
		D20 d20 = new D20();
		ChamberShape chamberShape = new ChamberShape();
		
		// Generate the Shape of the room
		chamberShape.setShape(d20.roll());
		ArrayList list = chamberShape.getExits();
		
		// Print Aspects of the chamber 
		System.out.print(chamberShape.getShape());
		try{
			System.out.print(" " + chamberShape.getWidth());
		}
		catch(UnusualShapeException e){	
		}
		
		System.out.println("Exits: " + list.size());
		
		
		// Generate the treasure
		Treasure roomTreasure = new Treasure();
		roomTreasure.setDescription();
		roomTreasure.setContainer(d20.roll());
		
		System.out.println("In terms of treasure, there's " + roomTreasure.getDescription() + " inside of " + roomTreasure.getContainer());
		
		try{
			System.out.println("The treasure is protected by " + roomTreasure.getProtection()); // FIX, SOMTIMES NULL???
		}
		catch(NotProtectedException e){
			System.out.println("No one is watching over the treasure.");
		}

		// Generate the Trap
		Trap trap = new Trap();
		
		System.out.println("Trap: " + trap.getDescription());
		
		// Generate the Stairs
		Stairs stairs = new Stairs();
		
		System.out.println("Stairs: " + stairs.getDescription());
		
		// Generate the Monster
		Monster monster = new Monster();
		System.out.println("Ahh!!! Oh no look! " + monster.getDescription() + " " + monster.getMinNum() + "-" + monster.getMaxNum());
	}


}
