package org.firstinspires.ftc.teamcode.Fenrir.OpModes.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotManager.MechanumDriveTrain;
import org.firstinspires.ftc.teamcode.Fenrir.Configurator;
import org.firstinspires.ftc.teamcode.Fenrir.ControlCenterTeleOp;

@TeleOp
public class MecDriveTest extends LinearOpMode {

    private MechanumDriveTrain robot;

    @Override
    public void runOpMode() throws InterruptedException{
        robot = new MechanumDriveTrain(this);
        robot.addHardware(Configurator.getHardware(robot));

        waitForStart();

        robot.driveWithController(robot.ctrl1());
        ControlCenterTeleOp.VSHANG(robot, robot.ctrl2());



        while (opModeIsActive())
            robot.getLogger().updateLog();

        robot.stopAllThreads();
    }
}