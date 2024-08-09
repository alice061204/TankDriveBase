// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
   // Creating all our variables, we will initialize them and set their values later
   WPI_TalonFX rightleader;
   WPI_TalonFX rightfollower;
   WPI_TalonFX leftleader;
   WPI_TalonFX leftfollower;
   DifferentialDrive drive;
   public DigitalInput limitswitch;
   //create motors : motorcontrolers are talon srx/ talon fx in code : check pheonix 5 docs
   //create differential drive or arcade drive : check WPILib docs
  

  public DriveSubsystem() {
     //initialize motor controllers
     rightleader = new WPI_TalonFX (Constants.rightLeaderCANID);
     rightfollower = new WPI_TalonFX(Constants.rightFollowerCANID);
     leftleader = new WPI_TalonFX(Constants.leftLeaderCANID);
     leftfollower = new WPI_TalonFX(Constants.leftFollowerCANID);
     //set to factory defaults
     rightleader.configFactoryDefault();
     rightfollower.configFactoryDefault();
     leftleader.configFactoryDefault();
     leftfollower.configFactoryDefault();
     //set motors to default toff braking
     rightleader.setNeutralMode(NeutralMode.Brake);
     rightfollower.setNeutralMode(NeutralMode.Brake);
     leftleader.setNeutralMode(NeutralMode.Brake);
     leftfollower.setNeutralMode(NeutralMode.Brake);

    //create differential drive
     drive = new DifferentialDrive(leftleader,rightleader);
    //Makes follower motors do the same thing as the leaders so that we don't have to pass arguments for all four
     rightfollower.follow(rightleader);
     leftfollower.follow(leftleader);
    // invert left motors from the right motors because they are inverted 180 degrees
    leftleader.setInverted(true);
    leftfollower.setInverted(true);
    
    
  }

  public void drive(double left, double right) {
    //Drive command
  drive.tankDrive(left,right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
