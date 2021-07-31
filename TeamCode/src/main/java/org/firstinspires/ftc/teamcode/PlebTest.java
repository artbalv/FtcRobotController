package org.firstinspires.ftc.teamcode;

import android.os.SystemClock;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class PlebTest extends LinearOpMode{
    DcMotor fLeft;
    DcMotor fRight;
    DcMotor bLeft;
    DcMotor bRight;

    @Override

    public void runOpMode() throws InterruptedException {
        fLeft = hardwareMap.dcMotor.get("fLeft");
        fRight = hardwareMap.dcMotor.get("fRight");
        bLeft = hardwareMap.dcMotor.get("bLeft");
        bRight = hardwareMap.dcMotor.get("bRight");

        fLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        bLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        fRight.setDirection(DcMotorSimple.Direction.REVERSE);
        bRight.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        while(opModeIsActive()) {
            double power = gamepad1.left_stick_y;

            fLeft.setPower(power);
            fRight.setPower(power);
            bLeft.setPower(power);
            bRight.setPower(power);

            telemetry.addData("Time", SystemClock.elapsedRealtime());
            telemetry.update();

            telemetry.addData("GP1 LStick X", gamepad1.left_stick_x);
            telemetry.addData("GP1 LStick Y", gamepad1.left_stick_y);
            telemetry.update();
        }
    }
}
