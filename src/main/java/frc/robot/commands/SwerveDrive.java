// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class SwerveDrive {
  private Wheel br;
  private Wheel bl;
  private Wheel fr;
  private Wheel fl;

public SwerveDrive (Wheel br, Wheel bl, Wheel fr, Wheel fl) {
    this.br = br;
    this.bl = bl;
    this.fr = fr;
    this.fl = fl;
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
}
