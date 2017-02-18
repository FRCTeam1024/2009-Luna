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

import org.mckenzierobotics.y2009.TypeDefs.*;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * Contains all Teleop data and code.
 *
 * @author Luke Shumaker
 */
public class Teleop {
	public DriverStation DriverStation;
	public PeriodicTaskData PTD;
	public Control C;

	/**
	 * Initialize the Teleop object.
	 *
	 * @param iPTD PeriodicTaskData
	 * @param iC   Control
	 */
	public Teleop(PeriodicTaskData iPTD, Control iC) {
		//init
		PTD = iPTD;
		C = iC;
		DriverStation = edu.wpi.first.wpilibj.DriverStation.getInstance();
	}

	/**
	 * Run this method periodically to run periodic code
	 */
	public void Periodic () {
		//execute
		C.Tank=false;
		C.TankType=0;
		C.Crab           =  PTD.rJoystick.getRawButton(1);
		C.TractionControl= !PTD.rJoystick.getRawButton(2);
		C.rJoystickX     =  PTD.rJoystick.getX();//axis 1
		C.rJoystickY     = -PTD.rJoystick.getY();//axis 2
		C.lJoystickY     = -PTD.lJoystick.getY();//axis 2

		C.Ackerman = DriverStation.getDigitalIn(0);
		C.Dumper = (DriverStation.getDigitalIn(1) ? 0 : -0.5);

		/* NOTE: I assume DriverStation digital ins start at 0.
		 * ~ Luke Shumaker
		 */
		//C.Main
		     if   ( DriverStation.getDigitalIn(6))   C.Main = -1;
		else if ( (!DriverStation.getDigitalIn(1)) &&
		          ( DriverStation.getDigitalIn(5)) ) C.Main = 1;
		else                                         C.Main = 0;
		//C.ToDumper
		     if   ( DriverStation.getDigitalIn(6))   C.ToDumper = -1;
		else if ( (!DriverStation.getDigitalIn(1)) &&
		          ( DriverStation.getDigitalIn(4)) ) C.ToDumper = 0.7;
		else                                         C.ToDumper = 0;
		//C.BallPickup
		     if ( ( DriverStation.getDigitalIn(2)) &&
			      ( DriverStation.getDigitalIn(6)) ) C.BallPickup= -1;
		else if ( (!DriverStation.getDigitalIn(1)) &&
		          ( DriverStation.getDigitalIn(5)) ) C.BallPickup = 1;
		else                                         C.BallPickup = 0;

		C.RearSteer = PTD.lJoystick.getRawButton(1);

		/*
		//stop
		C.Dumper=0;
		*/
	}
}
