// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveDrive;

public class TeleDrive extends CommandBase {
  /** Creates a new DriveTrain. */
  private XboxController xc;
  private SwerveDrive sd;

  public TeleDrive(SwerveDrive sd, XboxController xc) {
    this.xc = xc;
    this.sd = sd;

  }

  @Override
  public void execute() {
    sd.drive(xc.getRawAxis(Constants.left_x_axis), xc.getRawAxis(Constants.left_y_axis), xc.getRawAxis(Constants.right_x_axis));
  }
}