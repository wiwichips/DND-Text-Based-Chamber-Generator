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
		// Print the shape, size and 
		System.out.print(chamberShape.getShape());
		try{
			System.out.print(" " + chamberShape.getWidth());
		}
		
		catch(UnusualShapeException e){
			
		}
		
		System.out.println("Exits: " + list.size());
		
	}


}
