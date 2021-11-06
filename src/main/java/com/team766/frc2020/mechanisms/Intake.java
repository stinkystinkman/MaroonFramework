package com.team766.frc2020.mechanisms;

import com.team766.framework.Mechanism;

import com.team766.hal.RobotProvider;
import com.team766.hal.SpeedController;
import com.team766.hal.SolenoidController;

public class Intake extends Mechanism{
	private SpeedController intakeWheels;
	private SolenoidController intakeArm;

	public Intake() {
		intakeWheels = RobotProvider.instance.getMotor("intakeWheels");
		intakeArm = RobotProvider.instance.getSolenoid("intakeArm");
	}
	
	public void setDrivePower(boolean go){
		checkContextOwnership();
		if (go) {
			intakeWheels.set(1.0);

		} else {
			intakeWheels.set(0.0);
		}
	}
	public void setNegativeDrivePower(boolean go){
			checkContextOwnership();
			if (go) {
				intakeWheels.set(-1.0);
	
			} else {
				intakeWheels.set(0.0);
			}
	} 

	public void setPusher(boolean extended) {
		checkContextOwnership();
 
		intakeArm.set(extended);
	}

}