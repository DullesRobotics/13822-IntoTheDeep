/***

 ***IMPORTANT***

 * This is all experimental, this may be removed if deemed not necessary

 * The point of this file is to hold a structure to run swerve drive with

 ***/

package org.firstinspires.ftc.teamcode.RobotManager;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Controller;
import org.firstinspires.ftc.teamcode.Hardware.Motor.DrivetrainMotor;
import org.firstinspires.ftc.teamcode.Hardware.Motor.MotorType;
import org.firstinspires.ftc.teamcode.Libraries.IMU;
import org.firstinspires.ftc.teamcode.Libraries.PID;

import java.util.logging.Level;

public class SwerveDriveTrain extends StandardDriveTrain{

    /**
     * Takes in super initiators
     * @param op The op mode this is used for
     * @param pid The PID values returned
     */
    public SwerveDriveTrain(LinearOpMode op, PID pid){super(op,pid);};


    /**
     * Takes in super initiators
     * @param op The op mode this is used for
     */
    public SwerveDriveTrain(LinearOpMode op){super(op);};

    public void DriveWithController(Controller ctrl){
        getLogger().log(Level.INFO, "Begin driving with controller, swerve");
        addThread(new Thread(() ->{
            double lm1 = 0, lm2 = 0, rm1 = 0, rm2 = 0, currentSpeed = 0, maxSpeed;
            while (op().opModeIsActive()){

                int numBumpersActive = (ctrl.rightBumper() ? 1 : 0) + (ctrl.leftBumper() ? 1 : 0);
                switch(numBumpersActive) {
                    case 1: maxSpeed = precisionSpeed; break;
                    case 2: maxSpeed = ultrasPSpeed; break;
                    default:
                    case 0: maxSpeed = speed;
                }

                if(currentSpeed < maxSpeed){
                    currentSpeed += maxSpeed/1000;
                }
                if(maxSpeed < currentSpeed){
                    currentSpeed = maxSpeed;
                }

                getLogger().putData("Joystick speed", currentSpeed);

                //IMPORTANT: CUT DOWN CODE
                if(ctrl.leftY() >  ctrl.leftX()){
                    lm1 = ctrl.leftY();
                    //+ ctrl.leftTrigger() - ctrl.rightTrigger(); ADD LATER
                    lm2 = (-ctrl.leftY());
                    //+ ctrl.leftTrigger() - ctrl.rightTrigger(); ADD LATER
                }
                else if(ctrl.leftY() <  ctrl.leftX()){
                    lm1 = ctrl.leftX();
                    lm2 = ctrl.leftX();
                    //+ ctrl.leftTrigger() - ctrl.rightTrigger(); ADD LATER
                    //+ ctrl.leftTrigger() - ctrl.rightTrigger(); ADD LATER
                }
                if(ctrl.rightY() >  ctrl.rightX()){
                    rm1 = ctrl.rightY();
                    //+ ctrl.leftTrigger() - ctrl.rightTrigger(); ADD LATER
                    rm2 = (-ctrl.rightY());
                    //+ ctrl.leftTrigger() - ctrl.rightTrigger(); ADD LATER
                }
                else if(ctrl.rightY() <  ctrl.rightX()){
                    rm1 = ctrl.rightX();
                    //+ ctrl.leftTrigger() - ctrl.rightTrigger(); ADD LATER
                    rm2 = (ctrl.rightX());
                    //+ ctrl.leftTrigger() - ctrl.rightTrigger(); ADD LATER
                }

                //Maybe add new function to it
                setIndividualDrivePower(currentSpeed * lm1, currentSpeed * lm2, currentSpeed * rm1, currentSpeed * rm2);

            }
        }),true);
    }

}
