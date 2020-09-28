package com.team766.frc2020.procedures;

import com.team766.framework.Context;
import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.logging.Category;

public class ExampleDriveSequence extends Procedure {
	public ExampleDriveSequence() {
		loggerCategory = Category.AUTONOMOUS;
	}

	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		context.takeOwnership(Robot.intake);

		Robot.intake.setIntakeArm(true);
		Robot.intake.setIntakePower(1.0);

		for (int i = 0; i < 4; ++i) {
			log("Forward movement begins");
			Robot.drive.setDrivePower(0.3, 0.3);
			context.waitForSeconds(2.3);
			log("Forward movement finished");
			
			log("Turning movement begins");
			Robot.drive.setDrivePower(0.1, -0.1);
			context.waitForSeconds(2.35);
			log("Turning movement finished");

			context.startAsync(new Launch());
		}
		
		Robot.drive.setDrivePower(0.0, 0.0);
	}
}
