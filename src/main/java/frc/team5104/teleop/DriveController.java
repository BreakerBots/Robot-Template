/* BreakerBots Robotics Team (FRC 5104) 2020 */
package frc.team5104.teleop;

import frc.team5104.Controls;
import frc.team5104.subsystems.Drive;
import frc.team5104.util.DriveHelper;
import frc.team5104.util.managers.TeleopController;

public class DriveController extends TeleopController {
	protected String getName() { return "Drive-Controller"; }

	protected void update() {
		double forward = Controls.DRIVE_FORWARD.get() - Controls.DRIVE_REVERSE.get();
		Controls.DRIVE_TURN.changeCurveX1(DriveHelper.getTurnAdjust(forward));
		double turn = Controls.DRIVE_TURN.get();
		Drive.set(DriveHelper.get(turn, forward, true));
	}
}
