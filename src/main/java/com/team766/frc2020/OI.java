package com.team766.frc2020;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.frc2020.Robot;
import com.team766.frc2020.procedures.*;
import com.team766.hal.JoystickReader;
import com.team766.hal.RobotProvider;
import com.team766.logging.Category;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the code that allow control of the robot.
 */
public class OI extends Procedure {
	private JoystickReader m_joystick0;
	private JoystickReader m_joystick1;
	private JoystickReader m_joystick2;
	
	public OI() {
		loggerCategory = Category.OPERATOR_INTERFACE;

		m_joystick0 = RobotProvider.instance.getJoystick(0);
		m_joystick1 = RobotProvider.instance.getJoystick(1);
		m_joystick2 = RobotProvider.instance.getJoystick(2);
	}
	
	
	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		while (true) {
			// Add driver controls here - make sure to take/release ownership
			// of mechanisms when appropriate.
			
			Robot.drive.setArcadeDrivePower(m_joystick0.getAxis(1), m_joystick1.getAxis(0));

			if(m_joystick0.getButtonPressed(1)){
				log("Launched");
				context.startAsync(new Launch());
			}
			if (m_joystick2.getButtonPressed(2)){
				context.takeOwnership(Robot.intake);
				log("pincers out");
				context.startAsync(new PincersOpen());
			}
			if (m_joystick2.getButtonPressed(1)){
				context.takeOwnership(Robot.intake);
				log("pincers in");
				context.startAsync(new PincersClose());
			}
			if (m_joystick1.getButtonPressed(2)){
				context.takeOwnership(Robot.elevator);
				log("button 2 was pressed");
				context.startAsync(new ElevatorUp());
			}
			if (m_joystick0.getButtonPressed(2)){
				context.takeOwnership(Robot.elevator);
				log("button 0 was pressed");
				context.startAsync(new ElevatorDown());
			}

			context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData());
		}
	}
}
