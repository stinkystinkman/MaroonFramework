package com.team766.frc2020.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.EncoderReader;
import com.team766.hal.RobotProvider;
import com.team766.hal.SpeedController;
import com.team766.logging.Category;

public class Drive extends Mechanism {
	private SpeedController m_leftMotor;
	private SpeedController m_rightMotor;
	private EncoderReader m_leftEncoder;
	private EncoderReader m_rightEncoder;

	public Drive() {
		loggerCategory = Category.DRIVE;

		m_leftMotor = RobotProvider.instance.getMotor("drive.leftMotor");
		m_rightMotor = RobotProvider.instance.getMotor("drive.rightMotor");
		m_leftEncoder = RobotProvider.instance.getEncoder("drive.leftEncoder");
		m_rightEncoder = RobotProvider.instance.getEncoder("drive.rightEncoder");
	}

	public void setDrivePower(double leftPower, double rightPower) {
		checkContextOwnership();

		m_leftMotor.set(leftPower);
		m_rightMotor.set(rightPower);
	}

	public void setArcadeDrivePower(double forward, double turn) {
		double leftMotorPower = turn + forward;
		double rightMotorPower = -turn + forward;
		setDrivePower(leftMotorPower, rightMotorPower);
	}

	public double getEnoderDistance() {
		double leftValue = m_leftEncoder.getDistance();
		double rightValue = m_rightEncoder.getDistance();
		log("Encoders: " + leftValue + " " + rightValue);
		return (leftValue + rightValue) / 2;
	}

	public void resetEncoders() {
		checkContextOwnership();

		m_leftEncoder.reset();
		m_rightEncoder.reset();
	}
}