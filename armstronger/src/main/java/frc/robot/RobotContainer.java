// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DrivebaseConstants;
import frc.robot.commands.arcadeDriveCMD;
import frc.robot.subsystems.driveSystem;


public class RobotContainer {
  private final CommandXboxController controller;
  private final driveSystem rDrive;

  public RobotContainer() {
    controller = new CommandXboxController(DrivebaseConstants.CONTROLLER_PORT);
    rDrive = new driveSystem();
    
    rDrive.setDefaultCommand(new arcadeDriveCMD(
    () -> controller.getLeftY(),
     () -> controller.getRightX(),
      rDrive));
    configureBindings();

  }

  private void configureBindings() 
  {

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
