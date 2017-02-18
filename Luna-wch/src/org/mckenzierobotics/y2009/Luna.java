/*----------------------------------------------------------------------------*\
 * Copyright (c) FIRST 2008. All Rights Reserved.                             *
 * Open Source Software - may be modified and shared by FRC teams. The code   *
 * must be accompanied by the FIRST BSD license file in the root directory of *
 * the project.                                                               *
 *----------------------------------------------------------------------------*
 * Copyright (c) 2010 Luke Shumaker. All Rights Reserved.                     *
 * Free Software - you can redistribute it and/or modify                      *
 * it under the terms of the GNU General Public License as published by       *
 * the Free Software Foundation; either version 2, or (at your option)        *
 * any later version.                                                         *
 *                                                                            *
 * This is distributed in the hope that it will be useful,                    *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.                       *
 * See the GNU General Public License for more details.                       *
 *                                                                            *
 * You should have received a copy of the GNU General Public License          *
 * along with this program; see the file COPYING.                             *
 * If not, see <http://www.gnu.org/licenses>.                                 *
\*----------------------------------------------------------------------------*/

package org.mckenzierobotics.y2009;

import org.mckenzierobotics.y2009.TypeDefs.*;
import org.mckenzierobotics.y2009.TeamCode.*;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * 
 * @author Luke Shumaker
 */
public class Luna extends IterativeRobot {
	public PeriodicTaskData PeriodicTaskData = new PeriodicTaskData();
	public RobotData RobotData = new RobotData();
	public Control Control = new Control();

	public Teleop Teleop;
	public Autonomous Autonomous;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		Begin Begin = new Begin(PeriodicTaskData, RobotData, Control);
	}

	/**
	 * This function is run when the robot first enters autonomous and should be
	 * used for any initialization code.
	 */
	public void autonomousInit() {
		Autonomous = new Autonomous(PeriodicTaskData, RobotData, Control);
	}
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Autonomous.Periodic();
	}

	/**
	 * This function is run when the robot first enters teleop and should be
	 * used for any initialization code.
	 */
	public void teleopInit() {
		Teleop = new Teleop(PeriodicTaskData, Control);
	}
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Teleop.Periodic();
	}
	
}
