package frc.robot.subsystems.swervedrive;

import static edu.wpi.first.wpilibj2.command.Commands.parallel;

import com.revrobotics.RelativeEncoder;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkClosedLoopController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Lift extends SubsystemBase {
    private final SparkMax liftMotor = new SparkMax(31, MotorType.kBrushless);
    private final RelativeEncoder m_Encoder;
    private final SparkMaxConfig config;
    private final SparkClosedLoopController m_controller;
    private final int amount = 70;
    
    public Lift() {
        // m_Encoder = liftMotor.getEnconder
        m_Encoder = liftMotor.getEncoder();
        m_controller = liftMotor.getClosedLoopController();
        config = new SparkMaxConfig();
        config.idleMode(IdleMode.kBrake);
        config.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder).pid(0.002064500004053116,0.0,0.0);
        //config.encoder.positionConversionFactor(0.);
        
        liftMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
      
   

    
  

    
        // Set default command to turn off both the shooter and feeder motors, and then idle
        // setDefaultCommand(
        //     runOnce(
        //             () -> {
        //               liftMotor.disable();
        //             })
        //         .andThen(run(() -> {}))
        //         .withName("Idle"));
      }
    public void raiseLift()
    { 
      //System.out.println("inside raiseLift, " + m_Encoder.getPosition());
      m_controller.setReference(0,ControlType.kPosition);        
    }
    public void lowerLift()
    {
      //System.out.println("inside raiseLift, " + m_Encoder.getPosition());
      m_controller.setReference(-amount,ControlType.kPosition);
    }
    public void incrementLowerLift()
    {
      //System.out.println("inside raiseLift, " + m_Encoder.getPosition());
      m_controller.setReference(m_Encoder.getPosition() - 5,ControlType.kPosition);
    }
    public void getEncoderPosition()
    {
      System.out.println("Encoder POS: " + m_Encoder.getPosition());
    }
}
