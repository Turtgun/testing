// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Ports
    public static final int xbox_p = 0;
    
    public static final int bl_angle = 1;
    public static final int bl_speed = 2;
    public static final int br_angle = 3;
    public static final int br_speed = 4;
    public static final int fr_angle = 5;
    public static final int fr_speed = 6;
    public static final int fl_angle = 7;
    public static final int fl_speed = 8;

    //Units per degrees 
    public static final double units_per_degree = 72.857777778;

    //Length and width of the robot
    public static final double side_over_radius = 0.84309923278;
    
    //Xbox Bindings
    public static final int left_x_axis = 0;
    public static final int left_y_axis = 1;
    public static final int right_x_axis = 4;
    public static final int right_y_axis = 5;

    //State variables
    public static int drive_mode;
	public static boolean in_auto;
}