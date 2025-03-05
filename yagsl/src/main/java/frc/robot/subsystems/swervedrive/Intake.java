package frc.robot.subsystems.swervedrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

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

public class Intake extends SubsystemBase {
    //IDK BRO
    //sim for elevator is brushed
    //everything still going to be spark maxes

    //^DIE!!!!!
    SparkMax intakeOne = new SparkMax(40, MotorType.kBrushless);
    SparkMax intakeTwo = new SparkMax(41, MotorType.kBrushless);
    private final RelativeEncoder encoderOne;
    private final RelativeEncoder encoderTwo;
    private final SparkMaxConfig config;
    private final SparkClosedLoopController controllerOne;
    private final SparkClosedLoopController controllerTwo;
    private final int amount = 5;


    public Intake()
    {
        encoderOne = intakeOne.getEncoder();
        encoderTwo = intakeTwo.getEncoder();
        controllerOne = intakeOne.getClosedLoopController();
        controllerTwo = intakeTwo.getClosedLoopController();
        config = new SparkMaxConfig();
        config.idleMode(IdleMode.kBrake);
        config.closedLoop.feedbackSensor(FeedbackSensor.kPrimaryEncoder).pid(0.002064500004053116,0.0,0.0);
        //config.encoder.positionConversionFactor(0.);
        
        intakeOne.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        intakeTwo.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        setDefaultCommand(
             runOnce(
                     () -> {
                       intakeOne.disable();
                       intakeTwo.disable();
                     })
                 .andThen(run(() -> {}))
                 .withName("Idle"));

      
    }

    public void intake()
    {
        setControllerBehavior(amount);
    }
    public void eject()
    {
        setControllerBehavior(-amount);
    }

    public void setControllerBehavior(double value)
    {
        controllerOne.setReference(value,ControlType.kVelocity);
        controllerTwo.setReference(-value,ControlType.kVelocity);
    }
    
}
