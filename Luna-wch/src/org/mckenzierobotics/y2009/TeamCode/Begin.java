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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Initializes all data-structures/TypeDefs
 *
 * @author Luke Shumaker
 */
public class Begin {
	/**
	 * Initialize a 2-channel digital encoder.
	 *
	 * This is NOT a good universal method.  It makes assumptions about the
	 * robot configuration.  But that's fine, because this happens to be how
	 * 1024's robot is configured.
	 *
	 * @param aChan ChannelA on slot 4
	 * @param bChan ChannelB on slot 4
	 * @param distance distance per click
	 * @return the properly initialized encoder
	 */
	static private Encoder EncoderInit(int aChan, int bChan, double distance) {
		DigitalInput aSource = new DigitalInput(4,aChan);
		DigitalInput bSource = new DigitalInput(4,bChan);

		Encoder enc = new Encoder(aSource,bSource,false,EncodingType.k4X);

		enc.setDistancePerPulse(distance);
		enc.setMinRate(5);
		enc.start();

		return enc;
	}

	/**
	 * Initialize the following classes:
	 * <ul>
	 *   <li>PeriodicTaskData</li>
	 *   <li>RobotData</li>
	 *   <li>Control</li>
	 * </ul>
	 * We should probably do this in those classes, but this is how last year's
	 * LabVIEW code did it, and we're keeping the structure the same for
	 * simplicity.
	 *
	 * @param PTD PeriodicTaskData
	 * @param RD  RobotData
	 * @param C   Control
	 */
	public Begin(PeriodicTaskData PTD, RobotData RD, Control C) {
		/* As a reminder, a normal-ish looking variable name prefixed with an
		 * `M' or `E' means that it is a Motor or Encoder.
		 * ~ Luke Shumaker
		 */
		PTD.rJoystick = new Joystick(1);
		PTD.lJoystick = new Joystick(2);

		PTD.MBallPickup  = new Victor(4,7);
		PTD.MBallSpinner = new Victor(4,8);
		PTD.MToDumper= new Victor(4,9);
		PTD.MDumper = new Victor(4,10);

		PTD.MlDrive = new Victor(4,1);
		PTD.MrDrive = new Victor(4,2);

		PTD.MlSteer = new Victor(4,3);// left steer motor
		PTD.MrSteer = new Victor(4,4);//right steer motor
		PTD.MbSteer = new Victor(4,5);// back steer motor
		PTD.ElSteer = new AnalogChannel(1,1);// left steer encoder
		PTD.ErSteer = new AnalogChannel(1,2);//right steer encoder
		PTD.EbSteer = new AnalogChannel(1,3);// back steer encoder

		PTD.ErDrive = EncoderInit(1,2,0.035);
		PTD.ElDrive = EncoderInit(5,6,0.035);
		
		PTD.ErIdle = RD.rEncoder = EncoderInit( 9,10,0.0348);
		PTD.ElIdle = RD.lEncoder = EncoderInit(13,14,0.0348);
		
		PTD.WatchdogDevRef = RD.WatchdogDevRef =
				edu.wpi.first.wpilibj.Watchdog.getInstance();

		RD.AutonomousSwitch1 = new DigitalInput(4,3);
		RD.AutonomousSwitch2 = new DigitalInput(4,4);
		
		/* //TODO: put in some defaults here
		C.Tank       =;
		C.TankType   =;

		C.Crab       =;
		C.TractionC  =;

		C.rJoystickX =;
		C.rJoystickY =;
		C.lJoystickY =;

		C.Ackerman   =;
		C.Dumper     =;
		C.Main       =;
		C.ToDumper   =;
		C.BallPickup =;
		C.RearSteer  =;
		*/
	}
}
