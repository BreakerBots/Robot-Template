package com.frc5104.autopaths;

import com.frc5104.autocommands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Waypoint;

public class Baseline extends BreakerCommandGroup {
	Waypoint[] points = {
		new Waypoint(0, 0, 0),
		new Waypoint(10, 10, 0)
	};
		
	public void init() {
		double curTime = (double)(System.currentTimeMillis());

		add(new MotionProfile(points));
		add(new StopDrive());
		
		System.out.println("MP Gen Took: " + (((double)(System.currentTimeMillis()) - curTime) / 1000) + "s");
	}
}
