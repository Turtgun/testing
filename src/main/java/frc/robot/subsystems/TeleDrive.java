// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.functional.SwerveDrive;
import frc.robot.functional.Wheel;

public class TeleDrive extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private Wheel bl = new Wheel(Constants.bl_angle, Constants.bl_speed);
  private Wheel br = new Wheel(Constants.br_angle, Constants.br_speed);
  private Wheel fr = new Wheel(Constants.fr_angle, Constants.fr_speed);
  private Wheel fl = new Wheel(Constants.fl_angle, Constants.fl_speed);

  public SwerveDrive sd = new SwerveDrive(br, bl, fr, fl);
  private XboxController xc;

  public TeleDrive(XboxController xc) {
    this.xc = xc;
  }

  public void drive() {
    sd.drive(xc.getRawAxis(Constants.left_x_axis), xc.getRawAxis(Constants.left_y_axis), xc.getRawAxis(Constants.right_x_axis));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}