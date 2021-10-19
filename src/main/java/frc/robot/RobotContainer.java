// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.SwerveDrive;
import frc.robot.commands.Wheel;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Wheel bl = new Wheel (Constants.bl_angle, Constants.bl_speed);
  private Wheel br = new Wheel (Constants.br_angle, Constants.br_speed);
  private Wheel fr = new Wheel (Constants.fr_angle, Constants.fr_speed);
  private Wheel fl = new Wheel (Constants.fl_angle, Constants.fl_speed);
  
  private XboxController xc = new XboxController(Constants.xbox_p);
  private SwerveDrive sd = new SwerveDrive(br, bl, fr, fl);

  // The robot's subsystems and commands are defined here...
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    sd.drive(xc.getRawAxis(Constants.left_x_axis), -xc.getRawAxis(Constants.left_y_axis), xc.getRawAxis(Constants.right_x_axis));
    configureButtonBindings();
  }
  

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  }


  public Command getAutonomousCommand() {
    return null;
  }
}
