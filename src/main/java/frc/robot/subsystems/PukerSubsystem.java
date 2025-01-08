package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PukerSubsystem extends SubsystemBase {

    private final double MOTOR_DEFAULT_SPEED = 1.0;

    private TalonFX m_motor;
    private double m_motorSpeed;

    public PukerSubsystem(int id, double m_motorSpeed) {
        m_motor = new TalonFX(id, "rio");
    }

    public PukerSubsystem(int id) {
        m_motor = new TalonFX(id, "rio");
    }

    public void setSpeed(double speed) {
        m_motor.set(speed);
    }

    public Command setSpeedCommand(double speed) {
        return new InstantCommand(() -> setSpeed(speed));
    }

    public Command startMotorCommand() {
        return setSpeedCommand((m_motorSpeed != 0.0) ? m_motorSpeed : MOTOR_DEFAULT_SPEED);
    }

    public Command stopMotorCommand() {
        return setSpeedCommand(0.0);
    }
}
