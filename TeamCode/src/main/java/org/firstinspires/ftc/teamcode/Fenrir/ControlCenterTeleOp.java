package org.firstinspires.ftc.teamcode.Fenrir;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Hardware.Controller;
import org.firstinspires.ftc.teamcode.Hardware.Motor.Motor;
import org.firstinspires.ftc.teamcode.RobotManager.Robot;
import org.jetbrains.annotations.Nullable;


@Config
public class ControlCenterTeleOp {
        public static double ogPivotPos = 0.0, pivotPos = 0.5;
        public static double ogExtendPos = 0.0, ExtendPos = 0.3;
        public static double linearBottom = 0.0, linearMid = 0.3, linearTop = 0.5;
        public static double bucketdrop = 0.4, bucketOg = 0.0;

    public static void arm(Robot r, Controller ctrl){
                Servo leftPivot = r.getServo("LPIVOT");
                Servo rightPivot = r.getServo("RPIVOT");

                Servo leftExtend = r.getServo("LEXTEND");
                Servo rightExtend = r.getServo("REXTEND");

                leftPivot.setPosition(ogExtendPos);
                rightPivot.setPosition(ogExtendPos);

                while(r.op().opModeIsActive()){
                    if(ctrl.buttonX()){
                        leftPivot.setPosition(pivotPos);
                        rightPivot.setPosition(pivotPos);
                        if(ctrl.buttonY()){
                            leftExtend.setPosition(ExtendPos);
                            rightExtend.setPosition(ExtendPos);
                        }
                        else{
                            leftExtend.setPosition(ogExtendPos);
                            rightExtend.setPosition(ogExtendPos);
                        }
                    }
                    else {
                        leftPivot.setPosition(ogPivotPos);
                        rightPivot.setPosition(ogPivotPos);
                        leftExtend.setPosition(ogExtendPos);
                        rightExtend.setPosition(ogExtendPos);
                    }
                }
        }

    public static void linearSlide(Robot r, Controller ctrl){
        Motor linear = r.getMotor("LINSLIDE");
        Servo bucket = r.getServo("BUCKET");
        linear.get().setPower(linearBottom);
        bucket.setPosition(bucketOg);
        while(r.op().opModeIsActive()){
            if(ctrl.leftTrigger() > 0) linear.get().setPower(linearTop * ctrl.leftTrigger());
            else linear.get().setPower(linearBottom);

            if(ctrl.rightTrigger() > 0) bucket.setPosition(bucketdrop);
            else bucket.setPosition(bucketOg);
        }
    }

}
