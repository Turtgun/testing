// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.controller.PIDController;

public class Wheel {
  public TalonSRX angle_m;
  public TalonSRX speed_m;
  private PIDController pidController;
  private final double MAX_VOLTS = 4.95;

  /** Creates a new Wheel. */
  public Wheel(int angle_p, int speed_p, int encoder) {
    this.angle_m = new TalonSRX(angle_p);
    this.speed_m = new TalonSRX(speed_p);

    pidController = new PIDController(0, 0, 0);
    pidController.enableContinuousInput(-180, 180);
  }

  public void drive(double speed, double angle) {
    speed_m.set(ControlMode.Position, speed);

    double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here.
    if (setpoint < 0) {
        setpoint = MAX_VOLTS + setpoint;
    }
    if (setpoint > MAX_VOLTS) {
        setpoint = setpoint - MAX_VOLTS;
    }

    pidController.setSetpoint(setpoint);
  }
}
