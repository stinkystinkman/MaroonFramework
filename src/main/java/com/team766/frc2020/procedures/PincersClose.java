package com.team766.frc2020.procedures;
import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.frc2020.Robot;

public class PincersClose extends Procedure{
	public void run(Context context){
		while (true) {
			context.takeOwnership(Robot.pincer);
			Robot.pincer.setNegativePincerPower(true);
			context.waitForSeconds(2);
		}
	}
}