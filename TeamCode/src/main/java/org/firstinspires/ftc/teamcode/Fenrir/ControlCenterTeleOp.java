package org.firstinspires.ftc.teamcode.Fenrir;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Hardware.Controller;
import org.firstinspires.ftc.teamcode.Hardware.Motor.Motor;
import org.firstinspires.ftc.teamcode.RobotManager.Robot;
import org.jetbrains.annotations.Nullable;


@Config
public class ControlCenterTeleOp {

    static double VSPwrUp = 0.9, VSPwrDown = 0.6;
    static double clawClose = 0.2, clawOpen = 0.5;
    static double pivotNorm = 0.1, pivotFull = 0.6;
    static double extendNorm = 0, extendFull = 0.4;

    public static void VSHANG(Robot r, Controller ctrl){
        Motor LHang = r.getMotor("LSLD");
        Motor RHang = r.getMotor("LSLD");
        LHang.get().setPower(0.0);
        RHang.get().setPower(0.0);
        while(r.op().opModeIsActive()){
            if(ctrl.leftTrigger() >= 1){
                LHang.get().setPower(VSPwrUp);
                RHang.get().setPower(VSPwrUp);
            }
            else if(ctrl.rightTrigger() >= 1){
                LHang.get().setPower(-VSPwrDown);
                RHang.get().setPower(-VSPwrDown);
            }
        }
    }

    public static void CLAW(Robot r, Controller ctrl){
        Servo LClaw = r.getServo("LCLAW");
        Servo RClaw = r.getServo("RCLAW");
        LClaw.setPosition(clawClose);
        RClaw.setPosition(clawClose);
        while(r.op().opModeIsActive()){
            if(ctrl.buttonX()){
                LClaw.setPosition(clawOpen);
                RClaw.setPosition(clawOpen);
            }
            else{
                LClaw.setPosition(clawClose);
                RClaw.setPosition(clawClose);
            }
        }
    }

}
