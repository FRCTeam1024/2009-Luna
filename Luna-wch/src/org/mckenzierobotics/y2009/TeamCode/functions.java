/* Copyright (c) 2010 Luke Shumaker. All Rights Reserved.
 *
 * This is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; see the file COPYING.
 * If not, see <http://www.gnu.org/licenses>.
 */

package org.mckenzierobotics.y2009.TeamCode;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Contains misc. functions for whatever.
 *
 * @author Luke Luke Shumaker
 */
public class functions {
	private static double atan(double x) {
		return com.sun.squawk.util.MathUtils.atan(x);
	}

	private static double tan(double x) {
		return Math.tan(x);
	}

	/**
	 * Returns the angle needed to turn the inner wheel if the outer wheel is
	 * at rad
	 *
	 * @param l length of the robot (in same units as `w')
	 * @param w  width of the robot (in same units as `l')
	 * @param outer the angle of the outer wheel
	 * @return	  the angle of the inner wheel
	 */
	public static double ackerman(double l, double w, double outer) {
		return atan(l/((l/tan(outer))-w));
	}

	/**
	 * I don't really remember what this does.  Sorry.
	 *
	 * @param percent
	 * @param max
	 * @return idk
	 */
	public static double convert(double percent, double max) {
		return Math.abs(percent*(max*(Math.PI/180)));
	}

	/**
	 * Returns the sign of the input number
	 *
	 * @param x the number to get the sign of
	 * @return -1, 0, 1
	 */
	public static int sign(double x) {
		//return (x==0?0:x/Math.abs(x));
		     if (x <0) return -1;
		else if (x==0) return  0;
		else           return  1;
	}
}
