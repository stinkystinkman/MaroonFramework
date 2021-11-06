package com.team766.frc2020.mechanisms;

import com.team766.framework.Mechanism;

import com.team766.hal.RobotProvider;
import com.team766.hal.SpeedController;

public class Elevator extends Mechanism{
	private SpeedController elevator;

	public Elevator(){
		elevator=RobotProvider.instance.getMotor("elevator");
	}
	public void setElevatorPower(boolean go){
		checkContextOwnership();
		if (go) {
			elevator.set(0.5);

		} else {
			elevator.set(0.0);
		}
	}
	public void setNegativeElevatorPower(boolean go){
		checkContextOwnership();
		if (go) {
			elevator.set(-0.5);

		} else {
			elevator.set(0.0);
		}
	}
}