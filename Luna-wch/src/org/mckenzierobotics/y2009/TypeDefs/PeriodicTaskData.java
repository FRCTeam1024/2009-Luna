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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Watchdog;

/**
 * A struct storing all the hardware.  It would maybe be a Good Idea to separate
 * input and output... but I like preserving the current code structure from the
 * original LabVIEW code.
 *
 * @author Luke Shumaker
 */
public class PeriodicTaskData {
	/* Notice: a normal-ish looking variable name prefixed with an
	 * `M' or `E' means that it is a Motor or Encoder.
	 * ~ Luke Shumaker
	 */
	
	/** INPUT: right joystick */public Joystick rJoystick;
	/** INPUT:  left joystick */public Joystick lJoystick;

	/** MOTOR: ball pickup    */public Victor MBallPickup;
	/** MOTOR: ball spinner   */public Victor MBallSpinner;
	/** MOTOR: ball to dumper */public Victor MToDumper;
	/** MOTOR: ball dumper    */public Victor MDumper;

	/** MOTOR:  left drive */public Victor MlDrive;
	/** MOTOR: right drive */public Victor MrDrive;

	/** MOTOR:    left steer */public Victor        MlSteer;
	/** MOTOR:   right steer */public Victor        MrSteer;
	/** MOTOR:    back steer */public Victor        MbSteer;
	/** ENCODER:  left steer */public AnalogChannel ElSteer;
	/** ENCODER: right steer */public AnalogChannel ErSteer;
	/** ENCODER:  back steer */public AnalogChannel EbSteer;

	/** ENCODER: right drive */public Encoder ErDrive;
	/** ENCODER:  left drive */public Encoder ElDrive;

	/** ENCODER: right idler wheel */public Encoder ErIdle;
	/** ENCODER:  left idler wheel */public Encoder ElIdle;

	/** WATCHDOG: the watchdog */public Watchdog WatchdogDevRef;
}
