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

import java.util.LinkedList;


public class Main{
	
	private static int nodesPerDimension;
	private static int networkDimensions;
	private static boolean isTorus = false;
	private static int originNode;
	private static int destinationNode;
	
	private static int[] originNodePosition;
	private static int[] destinationNodePosition;
	
	private static int travellingDistance;
	private static int[] RE;
	private static LinkedList<int[]> path;
	
	private static boolean requestingHelp = false;
	
	public static void main(String[] args)
	{
		try{
			checkArgumentValidity(args);
		}
		catch(IllegalArgumentException e){
			informAboutExceptionAndEndProgram();
		}
		
		parseArguments(args);
		
		if(requestingHelp){
			showHelp();
		}
		else{
			getSystemResult();
			
			printResult();
		}		
	}

	private static void informAboutExceptionAndEndProgram(){
		System.out.println(Constants.INFORM_ABOUT_INVALID_ARGUMENT);	
		System.exit(1);
	}

	private static void checkArgumentValidity(String[] args) throws IllegalArgumentException{
		//TODO
	}

	private static void parseArguments(String[] args)
	{
		if(args[1].equals("-h")){
			requestingHelp = true;
		}
		else{
			nodesPerDimension = Integer.parseInt(args[1]);
			networkDimensions = Integer.parseInt(args[2]);
			
			if(Integer.parseInt(args[3]) == 1){
				isTorus = true;
			}
			
			originNode = Integer.parseInt(args[4]);
			destinationNode = Integer.parseInt(args[5]);		
		}
	}

	private static void showHelp()
	{
		System.out.println(Constants.PROGRAM_LAUNCH_GUIDELINES);
		System.out.println(Constants.PROGRAM_LAUNCH_EXAMPLE);
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
