package com.team766.frc2020.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Context;


public class DriveSquare extends Procedure{
	public void run(Context context){
		for (int i=0;i<4;++i){
			new DriveStraight().run(context);
			log("I drove straight after turning right in an angle that isn't 90 degrees");
			new TurnRight().run(context);
			log("I turned right in an angle that isn't 90 degrees");
		}
	}
}