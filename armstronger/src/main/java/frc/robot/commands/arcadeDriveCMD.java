// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveSystem;
public class arcadeDriveCMD extends CommandBase {
  private final driveSystem drive;
  private DoubleSupplier speed;
  private DoubleSupplier rotation;
  /** Creates a new arcadeDriveCMD. */
  public arcadeDriveCMD(DoubleSupplier speed, DoubleSupplier rotation, driveSystem drive) 
  {
    this.speed = speed;
    this.rotation = rotation;
    this.drive = drive;
    addRequirements(drive);
      // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    drive.defaultDrive(speed.getAsDouble(), rotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
