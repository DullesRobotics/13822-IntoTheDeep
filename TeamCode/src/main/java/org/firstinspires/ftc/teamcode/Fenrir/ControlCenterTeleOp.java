package org.firstinspires.ftc.teamcode.Fenrir;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.Hardware.Controller;
import org.firstinspires.ftc.teamcode.Hardware.Motor.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Servo;
import org.firstinspires.ftc.teamcode.RobotManager.Robot;


@Config
public class ControlCenterTeleOp {

    double VSPwrUp = 0.9, VSPwrDown = 0.6;
    double clawClose = 0.2, clawOpen = 0.5;
    double pivotNorm = 0.1, pivotFull = 0.6;
    double extendNorm = 0, extendFull = 0.4;

    public static void VSHANG(Robot r, Controller ctrl){
        Motor LHang = r.getMotor("LSLD");
        Motor RHang = r.getMotor("LSLD");
        while(r.op().opModeIsActive()){
            if(ctrl.leftTrigger() > 1)
        }
    }

}
