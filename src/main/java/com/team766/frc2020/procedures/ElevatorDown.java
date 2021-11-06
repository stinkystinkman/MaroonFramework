package com.team766.frc2020.procedures;
import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.frc2020.Robot;

public class ElevatorDown extends Procedure{
	public void run(Context context){
		while (true) {
			context.takeOwnership(Robot.elevator);
			Robot.elevator.setNegativeElevatorPower(true);
			context.waitForSeconds(2);
		}
	}
}