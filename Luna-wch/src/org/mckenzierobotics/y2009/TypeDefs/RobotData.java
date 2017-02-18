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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Watchdog;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Most everything that should be here got shoved into PeriodicTaskData.
 *
 * @author Luke Shumaker
 */
public class RobotData {
	public Watchdog WatchdogDevRef;

	public DigitalInput AutonomousSwitch1;
	public DigitalInput AutonomousSwitch2;

	//public usbDevice Steering;
	public RobotDrive RobotDriveDevRef;
	public Encoder rEncoder;
	public Encoder lEncoder;
}
