/**
* Copyright (C) 2014 Inversebit
* This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.inversebit.main;

import java.awt.PageAttributes.OriginType;
import java.util.LinkedList;


public class Main{
	
	private static int nodesPerDimension;
	private static int networkDimensions;
	private static boolean isTorus;
	private static int originNode;
	private static int destinationNode;
	
	private static int[] originNodePosition;
	private static int[] destinationNodePosition;
	
	private static int travellingDistance;
	private static int[] RE;
	private static LinkedList<int[]> path;
	
	public static void main(String[] args)
	{
		try{
			checkArgumentValidity(args);
		}
		catch(IllegalArgumentException e){
			informAboutExceptionAndEndProgram();
		}
		
		parseArguments();
		
		getSystemResult();
		
		printResult();
	}

	private static void informAboutExceptionAndEndProgram(){
		System.out.println(Constants.INFORM_ABOUT_INVALID_ARGUMENT);	
		System.exit(1);
	}

	private static void checkArgumentValidity(String[] args) throws IllegalArgumentException{
		//TODO
	}

	private static void parseArguments()
	{
		// TODO Auto-generated method stub
		
	}

	private static void getSystemResult()
	{
		initOriginAndDestinationNodePosition();	
	}

	private static void initOriginAndDestinationNodePosition()
	{
		originNodePosition = getNodePosition(originNode);
		destinationNodePosition = getNodePosition(destinationNode);
	}

	private static int[] getNodePosition(int nodeNumber)
	{
		int[] positionVector = new int[networkDimensions];
		
		for(int i = networkDimensions-1; i >= 0; i--){
			int divisor = (int) Math.pow(nodesPerDimension, i);
			positionVector[i] = (int)(nodeNumber/divisor);	
		}
		
		return positionVector;
	}

	private static void printResult()
	{
		// TODO Auto-generated method stub
		
	}

	
}
