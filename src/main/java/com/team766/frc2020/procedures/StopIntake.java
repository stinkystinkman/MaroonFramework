package com.team766.frc2020.procedures;
import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.frc2020.Robot;
 
public class StopIntake extends Procedure {
	public void run(Context context){
		while (true) {
			context.takeOwnership(Robot.intake);
			Robot.intake.setPusher(false);
			Robot.intake.setDrivePower(false);
		}
	}
}