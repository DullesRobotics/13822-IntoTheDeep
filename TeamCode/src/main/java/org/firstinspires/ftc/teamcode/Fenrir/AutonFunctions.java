package org.firstinspires.ftc.teamcode.Fenrir;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotManager.MechanumDriveTrain;

@Config
public class AutonFunctions {
    private static volatile MechanumDriveTrain mainFrame;

    public static void startNew(LinearOpMode op, TeamColor t) {
        mainFrame = new MechanumDriveTrain(op);
        mainFrame.addHardware(org.firstinspires.ftc.teamcode.Fenrir.Configurator.getHardware(mainFrame));
        op.waitForStart();
        if (op.isStopRequested()) return;

    }

    public enum TeamColor {
        RED, BLUE
    }

    public enum Direction {
        RIGHT, LEFT
    }
}

