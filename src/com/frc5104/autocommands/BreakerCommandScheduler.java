package com.frc5104.autocommands;

import com.frc5104.utilities.console;

/*Breakerbots Robotics Team 2018*/
/**
 * Handles the Execution of BreakerCommands inside the assigned BreakerCommandGroup (Entire Path)
 */
public class BreakerCommandScheduler {
	static BreakerCommandScheduler m_instance = null;
	public static BreakerCommandScheduler getInstance() { if (m_instance == null) { m_instance = new BreakerCommandScheduler(); } return m_instance; }
	
	public BreakerCommandGroup r = null;
	public int i = 0;
	public boolean s = false;
	
	/**
	 * Set the target command group
	 */
	public void set(BreakerCommandGroup commandGroup) {
		//Save the new Command Group
		r = null;
		r = commandGroup;
		
		//Reset Command Group Filter Index
		i = 0;
		
		//Make the Command Init Commands and Add To Array
		r.init();
		
		//Say that the first command hasn't been Initiated
		s = false;
	}
	
	/**
	 * The update function call in Autonomous Periodic
	 */
	public void update() {
		//if the command index is less than the commandGroup length
		if (i < r.cl) {
			//If command has not been initialized
			if (!s) {
				//Call the init function
				r.cs[i].init();
				
				//Dont call it next time
				s = true;
			}
			
			//Call the update function (then if finished)
			if (r.cs[i].update()) {
				//Call the end init function
				r.cs[i].end();
				
				//Go to the next command
				i++;
				
				//Say the command hasn't been initialized
				s = false;
			}
		}
	}
}
