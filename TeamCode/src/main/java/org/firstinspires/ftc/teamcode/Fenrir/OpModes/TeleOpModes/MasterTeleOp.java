package org.firstinspires.ftc.teamcode.Fenrir.OpModes.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotManager.MechanumDriveTrain;
import org.firstinspires.ftc.teamcode.RobotManager.StandardDriveTrain;
import org.firstinspires.ftc.teamcode.Fenrir.Configurator;
import org.firstinspires.ftc.teamcode.Fenrir.ControlCenterTeleOp;

@TeleOp
public class MasterTeleOp extends LinearOpMode {
    private MechanumDriveTrain baseRobot;
    @Override
    public void runOpMode() throws InterruptedException {
        baseRobot = new MechanumDriveTrain(this);
        baseRobot.addHardware(Configurator.getHardware(baseRobot));

        waitForStart();

        baseRobot.driveWithController(baseRobot.ctrl1());
        ControlCenterTeleOp.arm(baseRobot, baseRobot.ctrl2());
        ControlCenterTeleOp.linearSlide(baseRobot, baseRobot.ctrl2());
        ControlCenterTeleOp.hang(baseRobot, baseRobot.ctrl2());
        ControlCenterTeleOp.input(baseRobot, baseRobot.ctrl2());


//        while (opModeIsActive())
//            baseRobot.getLogger().updateLog();

//        baseRobot.stopAllThreads();
    }
}