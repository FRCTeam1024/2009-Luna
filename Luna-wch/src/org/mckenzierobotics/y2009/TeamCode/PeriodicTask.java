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

/**
 * Updates the motors based on Control
 *
 * @author Luke Shumaker
 */
import org.mckenzierobotics.y2009.TypeDefs.*;

import edu.wpi.first.wpilibj.PIDController;

public class PeriodicTask {
	drive Drive = new drive();
	PIDController lSteer;
	PIDController rSteer;
	PIDController bSteer;

	/**
	 * Initialize PeriodicTask
	 *
	 * @param PTD PeriodicTaskData
	 * @param RD  RobotData
	 * @param C   Control
	 */
	public void PeriodicTask(PeriodicTaskData PTD, RobotData RD, Control C) {
		//init goes here
		                        //(P,I,D, Source     , Output     );
		lSteer = new PIDController(1,0,0, PTD.ElSteer, PTD.MlSteer);
		rSteer = new PIDController(1,0,0, PTD.ErSteer, PTD.MrSteer);
		bSteer = new PIDController(1,0,0, PTD.EbSteer, PTD.MbSteer);

		lSteer.setInputRange(0,5);
		rSteer.setInputRange(0,5);
		bSteer.setInputRange(0,5);

		lSteer.setOutputRange(-0.4,0.4);
		rSteer.setOutputRange(-0.4,0.4);
		bSteer.setOutputRange(-0.5,0.5);

		lSteer.enable();
		rSteer.enable();
		bSteer.enable();
	}

	/**
	 * Run the PeriodicTasks
	 *
	 * @param PTD PeriodicTaskData
	 * @param RD  RobotData
	 * @param C   Control
	 */
	public void Periodic(PeriodicTaskData PTD, RobotData RD, Control C) {
		Drive.drive(C);
		if (C.TractionControl) {
			Drive.TractionControl(PTD);
		}

		PTD.MlDrive.set(Drive.lDrive);
		PTD.MrDrive.set(Drive.rDrive);

		//TODO: check if I'm using wpilibj's PID correctly
		lSteer.setSetpoint(-Drive.lSteer);
		rSteer.setSetpoint( Drive.rSteer);
		bSteer.setSetpoint( Drive.bSteer);
	}

}
