package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.frc2020.Robot;
import com.team766.framework.Context;

public class Score5 extends Procedure {

	public void run(Context context) {
		new CollectBalls().run(context);

		new DriveBackward().run(context);

		new TurnRight().run(context);

		context.takeOwnership(Robot.drive);
		Robot.drive.setDrivePower(0.25, 0.25);
		context.waitForSeconds(0.8);
		Robot.drive.setDrivePower(0.0, 0.0);
		context.waitForSeconds(0.5);

		for (int i = 0; i < 5; ++i) {
			new Launch().run(context);
		}
	}

}