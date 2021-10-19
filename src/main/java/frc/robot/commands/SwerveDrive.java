// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.functional.Wheel;

/** An example command that uses an example subsystem. */
public class SwerveDrive extends CommandBase{
    private Wheel br;
    private Wheel bl;
    private Wheel fr;
    private Wheel fl;
    private XboxController xc;

  public SwerveDrive (Wheel br, Wheel bl, Wheel fr, Wheel fl, XboxController xc) {
    this.br = br;
    this.bl = bl;
    this.fr = fr;
    this.fl = fl;
    this.xc = xc;
  }

  public void drive (double x1, double y1, double x2) {
    double sine = Constants.side_over_radius;

    double a = x1 - x2 * sine;
    double b = x1 + x2 * sine;
    double c = y1 - x2 * sine;
    double d = y1 + x2 * sine;

    double brSpeed = Math.sqrt ((b * b) + (d * d));
    double blSpeed = Math.sqrt ((b * b) + (c * c));
    double frSpeed = Math.sqrt ((a * a) + (d * d));
    double flSpeed = Math.sqrt ((a * a) + (c * c));

    double brAngle = (Math.atan2 (b, d) / Math.PI) * 180;
    double blAngle = (Math.atan2 (b, c) / Math.PI) * 180;
    double frAngle = (Math.atan2 (a, d) / Math.PI) * 180;
    double flAngle = (Math.atan2 (a, c) / Math.PI) * 180;

    br.drive (brSpeed, brAngle);
    bl.drive (blSpeed, blAngle);
    fr.drive (frSpeed, frAngle);
    fl.drive (flSpeed, flAngle);
  }

  @Override
  public void initialize() {}
  @Override
  public void execute() {
    drive(xc.getRawAxis(Constants.left_x_axis), xc.getRawAxis(Constants.left_y_axis), xc.getRawAxis(Constants.right_x_axis));
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
