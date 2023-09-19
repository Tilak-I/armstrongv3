// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants.DrivebaseConstants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class driveSystem extends SubsystemBase {
  private final CANSparkMax backLeft;
  private final CANSparkMax frontLeft;
  private final CANSparkMax backRight;
  private final CANSparkMax frontRight;

  private final MotorControllerGroup leftDrive;
  private final MotorControllerGroup rightDrive;
  private final DifferentialDrive vroomVroom;

  private final Encoder blEncoder;
  private final Encoder flEncoder;
  private final Encoder frEncoder;
  private final Encoder brEncoder;

  /** Creates a new driveSystem. */
  public driveSystem() 
  {
    backLeft = new CANSparkMax(DrivebaseConstants.LB_MOTOR_CANID, MotorType.kBrushless);
    frontLeft = new CANSparkMax(DrivebaseConstants.LF_MOTOR_CANID, MotorType.kBrushless);
    frontRight = new CANSparkMax(DrivebaseConstants.RF_MOTOR_CANID, MotorType.kBrushless);
    backRight = new CANSparkMax(DrivebaseConstants.RB_MOTOR_CANID, MotorType.kBrushless);

    blEncoder = new Encoder(1,2);
    flEncoder = new Encoder(3,4);
    brEncoder = new Encoder(5,6);
    frEncoder = new Encoder(7,8);

    backLeft.setInverted(true);
    frontLeft.setInverted(true);

    leftDrive = new MotorControllerGroup(backLeft, frontLeft);
    rightDrive = new MotorControllerGroup(backRight, frontRight);

    vroomVroom = new DifferentialDrive(leftDrive, rightDrive);
    

  }

  public void defaultDrive(double speed, double rotation)
  {
    vroomVroom.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Front Left Speed: ", frontLeft.get());
    SmartDashboard.putNumber("Back Right Speed: ", backRight.get());
    SmartDashboard.putNumber("Back Left Speed: ", backLeft.get());
    SmartDashboard.putNumber("Front Right Speed: ", frontRight.get());

    // This method will be called once per scheduler run
  }
}
