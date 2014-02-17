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


public class Constants
{
	public static final String PROGRAM_NAME =
			"encaminatorplus";
	
	public static final String INFORM_ABOUT_INVALID_ARGUMENT =
			"An argument is invalid.\n" +
			"Check the correct use of the program by executing " + PROGRAM_NAME + " -h";
	
	public static final String PROGRAM_LAUNCH_GUIDELINES =
			"Launche the program following this guidelines:\n" +
			PROGRAM_NAME + "<nodes per dimension> <network dimensions> <is torus (0/1)>" +
			" <origin node number> <destination node number>";
	
	public static final String PROGRAM_LAUNCH_EXAMPLE =
			"Example: " + PROGRAM_NAME + "10 2 0 23 76";
	
	public static final int TOO_LONG_POSITIVE = 1;
	public static final int TOO_LONG_NEGATIVE = -1;
	public static final int NOT_TOO_LONG = 0;

	public static final String OUTPUT_TRAVELLED_DIST = "The distance travelled is: ";
	public static final String OUTPUT_RE = "RE is: ";
	public static final String OUTPUT_PATH = "The nodes in the message path are: ";
}
