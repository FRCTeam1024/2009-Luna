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

/**
 * Contains all Autonomous data and code.
 * 
 * @author Luke Shumaker
 */
public class Autonomous {
	PeriodicTaskData PTD;
	RobotData RD;
	Control C;

	/**
	 * Initialize Autonomous object
	 *
	 * @param PTD PeriodicTaskData
	 * @param RD  RobotData
	 * @param C   Control
	 */
	public Autonomous(PeriodicTaskData PTD, RobotData RD, Control C) {
		//init
		this.PTD = PTD;
		this.RD  = RD;
		this.C   = C;
	}

	/**
	 * Run this method periodically to run autonomous code
	 */
	public void Periodic() {
		//execute
		//TODO: write autonomous
	}
}
