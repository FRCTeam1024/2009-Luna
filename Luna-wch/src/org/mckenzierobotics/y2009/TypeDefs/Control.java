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

package org.mckenzierobotics.y2009.TypeDefs;

/**
 * A struct for storing all user input.  This can be spoofed by autonomous.
 *
 * @author Luke Shumaker
 */
public class Control {
	/** use tank drive? */public boolean Tank;
	/** if using tank drive, which type? */public int TankType;

	/** use crab-drive (instead of Kil-A-Drive)? */public boolean Crab;
	/** enable traction control? */public boolean TractionControl;

	/** X value of the right joystick */public double rJoystickX;
	/** Y value of the right joystick */public double rJoystickY;
	/** Y value of the  left joystick */public double lJoystickY;

	/** enable ackerman?    */public boolean Ackerman;
	/** dumper speed        */public double Dumper;
	/** main spinner speed? */public double Main;
	/** toDumper     speed  */public double ToDumper;
	/** ball pickup  speed  */public double BallPickup;
	/** enable rear-stearing */public boolean RearSteer;
}
