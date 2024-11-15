package org.firstinspires.ftc.teamcode.Tyre.OpModes.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotManager.MechanumDriveTrain;
import org.firstinspires.ftc.teamcode.Tyre.Configurator;
import org.firstinspires.ftc.teamcode.Tyre.ControlCenterTeleOp;

@TeleOp
public class MecDriveTest extends LinearOpMode {

    private MechanumDriveTrain robot;

    @Override
    public void runOpMode() throws InterruptedException{
        robot = new MechanumDriveTrain(this);
        robot.addHardware(Configurator.getDriveTrainMotors(robot));

        waitForStart();

        robot.driveWithController(robot.ctrl1());


        while (opModeIsActive())
            robot.getLogger().updateLog();

        robot.stopAllThreads();
    }
}