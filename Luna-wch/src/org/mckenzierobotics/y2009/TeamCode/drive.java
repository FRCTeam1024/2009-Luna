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
 * Originally just a struct to hold drive motor settings.
 * However, the drive logic has been moved to a method of this class.
 *
 * @author Luke Shumaker
 */
public class drive {
	public double lDrive;
	public double rDrive;

	public double lSteer;
	public double rSteer;
	public double bSteer;

	/**
	 * Update all the motor settings based on a Control object.
	 *
	 * @param C Control
	 */
	public void drive(Control C) {
		int drivingType=0;

		if (C.Tank) {
			switch (drivingType) {
				case 0:
					//Skid-Steering
					lDrive = C.lJoystickY;
					rDrive = C.rJoystickY;
					break;
				case 1:
					//Skid-Steering with Ramping
					//TODO: skid-steering with ramping (not used anyway)
					break;
				case 2:
					//Skid-Steering - Reduced
					lDrive = C.lJoystickY/2;
					rDrive = C.rJoystickY/2;
					break;
			}
			lSteer =
			rSteer =
			bSteer = 0;
		} else {
			if (C.Crab) {
				//Crab-Drive
				       lDrive=rDrive=C.rJoystickY;
				bSteer=lSteer=rSteer=C.rJoystickX;
			} else {
				//Kil-A-Drive
				boolean forward;
				if (functions.sign(C.lJoystickY) == functions.sign(C.rJoystickY)) {
					forward = C.rJoystickY<0;
				} else {
					forward = ( ((C.lJoystickY<0) && (C.rJoystickY==0)) ||
							   ((C.rJoystickY<0) && (C.lJoystickY==0)) );
				}
				double speed = (forward ? Math.max(C.rJoystickY, C.lJoystickY) :
										  Math.min(C.rJoystickY, C.lJoystickY) );
				double diff = C.lJoystickY-C.rJoystickY;
				if (diff != 0) {
					double ndiff = (forward ? -diff : diff);

					double ddiff = ndiff/2.67;
					lDrive = speed+ddiff;
					rDrive = speed-ddiff;

					double sdiff = ndiff/2;
					double y=22.5; //CONTROL
					double plSteer;
					double prSteer;
					if (C.Ackerman) {
						double outer = functions.convert(sdiff, y);
						double l=17;
						l=(C.RearSteer?l:l/2);
						double inner = functions.ackerman(l, 27, outer);
						if (sdiff >0) {
							plSteer=outer;
							prSteer=inner;
						} else {
							plSteer= -inner;
							prSteer= -outer;
						}
					} else {
						plSteer = prSteer = y*sdiff;
					}
					double range = 5/(2*Math.PI);
					lSteer = plSteer*range;
					rSteer = prSteer*range;
					bSteer = (C.RearSteer ? -sdiff : 0 );
				} else {
					lDrive =
					rDrive = speed;

					rSteer =
					lSteer =
					bSteer = 0;
				}
			}
		}
	}

	public void TractionControl(PeriodicTaskData PTD) {
		//TODO: write traction control
	}
}
