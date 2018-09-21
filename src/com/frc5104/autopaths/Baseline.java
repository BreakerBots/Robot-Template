package com.frc5104.autopaths;

import com.frc5104.autocommands.*;

import jaci.pathfinder.Waypoint;

public class Baseline extends BreakerCommandGroup {
	Waypoint[] points = {
		new Waypoint(0, 0, 0),
		new Waypoint(10, 10, 0)
	};
		
	public void init() {
		add(new MotionProfile(points));
	}
}
