package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Context;

public class DriveSquare extends Procedure {

	public void run(Context context) {
		for (int i = 0; i < 4; ++i) {
			// Drive along the side of the square
			new DriveStraight().run(context);

			// Turn at the corner
			new TurnRight().run(context);
		}
	}

}