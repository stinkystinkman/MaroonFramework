package com.team766.frc2020.procedures;
import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.frc2020.Robot;
import com.team766.hal.RobotProvider;

public class Launch extends Procedure{
	public void run(Context context){
			log("time = "+RobotProvider.getTimeProvider().get());
			context.takeOwnership(Robot.launcher);

			Robot.launcher.setPusher(true);

			context.waitForSeconds(1);

			Robot.launcher.setPusher(false);

			context.waitForSeconds(1);
		
		
	}
}