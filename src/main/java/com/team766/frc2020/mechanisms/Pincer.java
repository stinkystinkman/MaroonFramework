package com.team766.frc2020.mechanisms;

import com.team766.framework.Mechanism;

import com.team766.hal.RobotProvider;
import com.team766.hal.SpeedController;

public class Pincer extends Mechanism{
	private SpeedController pincers;

	public Pincer(){
		pincers=RobotProvider.instance.getMotor("gripper");
	}
	public void setPincerPower(boolean go){
		checkContextOwnership();
		if (go) {
			pincers.set(0.5);

		} else {
			pincers.set(0.0);
		}
	}
	public void setNegativePincerPower(boolean go){
		checkContextOwnership();
		if (go) {
			pincers.set(-0.5);

		} else {
			pincers.set(0.0);
		}
	}
}