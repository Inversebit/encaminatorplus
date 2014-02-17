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

import java.util.Iterator;
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
	private static LinkedList<int[]> pathPositions;
	private static LinkedList<Integer> path;
	
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
		if(args[0].equals("-h")){
			requestingHelp = true;
		}
		else{
			nodesPerDimension = Integer.parseInt(args[0]);
			networkDimensions = Integer.parseInt(args[1]);
			
			if(Integer.parseInt(args[2]) == 1){
				isTorus = true;
			}
			
			originNode = Integer.parseInt(args[3]);
			destinationNode = Integer.parseInt(args[4]);		
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
		calculateRE();
		calculateDistance();
		calculateMessagePath();
	}

	private static void initOriginAndDestinationNodePosition()
	{
		originNodePosition = getNodePosition(originNode);
		destinationNodePosition = getNodePosition(destinationNode);
	}

	private static int[] getNodePosition(int nodeNumber)
	{
		int numerator = nodeNumber;
		int[] positionVector = new int[networkDimensions];
		
		for(int i = 0; i < positionVector.length; i++){
			int divisor = (int) Math.pow(nodesPerDimension, networkDimensions - (i + 1));
			positionVector[i] = (int)(numerator/divisor);
			numerator = numerator%divisor;
		}
		
		return positionVector;
	}

	private static void calculateRE()
	{
		RE = new int[networkDimensions];
		
		for(int i = 0; i < RE.length; i++){
			RE[i] = destinationNodePosition[i] - originNodePosition[i];
			
			if(isTorus){				
				int unnecessarilyLong = isUnnecessarilyLong(RE[i]);
				
				if(unnecessarilyLong == Constants.TOO_LONG_POSITIVE){
					RE[i] = RE[i] - nodesPerDimension;
				}
				else{
					if(unnecessarilyLong == Constants.TOO_LONG_NEGATIVE){
						RE[i] = RE[i] + nodesPerDimension;
					}
				}
			}
		}
	}

	private static int isUnnecessarilyLong(int REinI)
	{
		if(REinI > (int)(nodesPerDimension/2)){
			return Constants.TOO_LONG_POSITIVE;
		}
		else{
			if(REinI < -(int)(nodesPerDimension/2)){
				return Constants.TOO_LONG_NEGATIVE;
			}
			else{
				return Constants.NOT_TOO_LONG;
			}
		}
	}

	private static void calculateDistance()
	{
		travellingDistance = 0;
		
		for(int i = 0; i < RE.length; i++){
			travellingDistance += Math.abs(RE[i]);
		}
	}

	private static void calculateMessagePath()
	{
		initPath();
		generatePathPositions();
		generatePath();
	}

	private static void initPath()
	{
		pathPositions = new LinkedList<int[]>();
		pathPositions.add(originNodePosition);		
	}

	private static void generatePathPositions()
	{		
		int[] intermediateNodePosition = new int[networkDimensions];
				
		for(int i = RE.length - 1; i >= 0; i--){
			while(RE[i] != 0){
				intermediateNodePosition = pathPositions.getLast().clone();

				if(RE[i] > 0){
					if(intermediateNodePosition[i] < nodesPerDimension){
						intermediateNodePosition[i] = intermediateNodePosition[i] + 1;
					}
					else{
						intermediateNodePosition[i] = 0;
					}
					RE[i] = RE[i] - 1;
				}else{
					if(intermediateNodePosition[i] > 0){
						intermediateNodePosition[i] = intermediateNodePosition[i] - 1;					}
					else{
						intermediateNodePosition[i] = nodesPerDimension - 1;
					}
					RE[i] = RE[i] + 1;
				}
				
				pathPositions.addLast(intermediateNodePosition);
			}
		}
	}

	private static void generatePath()
	{
		path = new LinkedList<>();
		
		parseAndConvertPositions();
	}

	private static void parseAndConvertPositions()
	{
		Iterator<int[]> pathPositionsItr = pathPositions.iterator();
		while(pathPositionsItr.hasNext()){
			int[] nextPosition = pathPositionsItr.next();
			path.addLast(getNodeNumberInPosition(nextPosition));
		}
	}

	private static Integer getNodeNumberInPosition(int[] nodePosition)
	{
		int node = 0;
		
		for(int i = 0; i < nodePosition.length; i++){
			node += Math.pow(nodePosition[networkDimensions-1-i],i);
		}
		
		return node;
	}

	private static void printResult()
	{
		
	}
}
