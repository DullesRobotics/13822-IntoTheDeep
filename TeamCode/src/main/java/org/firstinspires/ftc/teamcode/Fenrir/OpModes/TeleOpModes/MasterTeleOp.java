package org.firstinspires.ftc.teamcode.Fenrir.OpModes.TeleOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Fenrir.ControlCenterTeleOp;
import org.firstinspires.ftc.teamcode.RobotManager.MechanumDriveTrain;
import org.firstinspires.ftc.teamcode.RobotManager.StandardDriveTrain;
import org.firstinspires.ftc.teamcode.Fenrir.Configurator;

@TeleOp
public class MasterTeleOp extends LinearOpMode {
    private MechanumDriveTrain baseRobot;
    private DcMotor lf = null;
    private DcMotor lb = null;
    private DcMotor rb = null;
    private DcMotor rf = null;
    private Servo rC = null;
    private Servo lC = null;
    private Servo lP = null;
//    private Servo rP = null;
    private DcMotor LH = null;
    private DcMotor RH = null;

    @Override
    public void runOpMode() throws InterruptedException {

//        baseRobot = new MechanumDriveTrain(this);
//        baseRobot.addHardware(Configurator.getHardware(baseRobot));
//
//        waitForStart();
//
//        baseRobot.driveWithController(baseRobot.ctrl1());
//        ControlCenterTeleOp.VSHANG(baseRobot,baseRobot.ctrl2());
//        ControlCenterTeleOp.CLAW(baseRobot,baseRobot.ctrl2());
//        ControlCenterTeleOp.ARM(baseRobot,baseRobot.ctrl2());

        double VSPwrUp = 0.9, VSPwrDown = 0.6, VSPwrNone = 0.0;
        double clawClose = 0.2, clawOpen = 0.5;
        double pivotNorm = 0.1, pivotFull = 0.6;
        double extendNorm = 0, extendFull = 0.4;


        rf = hardwareMap.dcMotor.get("FRM");
        rb = hardwareMap.dcMotor.get("BRM");
        lf = hardwareMap.dcMotor.get("FLM");
        lb = hardwareMap.dcMotor.get("BLM");
        LH = hardwareMap.dcMotor.get("LSLD");
        RH = hardwareMap.dcMotor.get("RSLD");
//        rC = hardwareMap.get(Servo.class, "RCLAW");
//        lC = hardwareMap.get(Servo.class, "LCLAW");
//        rP = hardwareMap.get(Servo.class, "RPIVOT");
//        lP = hardwareMap.get(Servo.class, "LPIVOT");
       // lb.setDirection(DcMotorSimple.Direction.REVERSE);
       // lf.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();


        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            lf.setPower(frontLeftPower);
            lb.setPower(backLeftPower);
            rf.setPower(frontRightPower);
            rb.setPower(backRightPower);

//            if (gamepad2.x) {
//                lC.setPosition(clawOpen);
//                rC.setPosition(clawOpen);
//            } else {
//                lC.setPosition(clawClose);
//                rC.setPosition(clawClose);
//            }
//
            if(gamepad2.left_trigger >= 1){
                LH.setPower(VSPwrUp);
                RH.setPower(VSPwrUp);
            }
            else if(gamepad2.right_trigger >= 1){
                LH.setPower(-VSPwrDown);
                RH.setPower(-VSPwrDown);
            }
            else{
                LH.setPower(VSPwrNone);
                RH.setPower(VSPwrNone);
            }

//            if(gamepad2.y){
//                lP.setPosition(pivotFull);
////                rP.setPosition(pivotFull);
//            }
//            else{
//                lP.setPosition(pivotNorm);
////                rP.setPosition(pivotNorm);
//            }

            waitForStart();


//            while (opModeIsActive())
//                baseRobot.getLogger().updateLog();


        }
    }
}