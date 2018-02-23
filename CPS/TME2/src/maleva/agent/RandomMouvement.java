
package maleva.agent;

import java.util.Random;

import maleva.framework.LifeCycleException;

public class RandomMouvement extends ComportementAgent {
	
	/* fields */
	private Random rand;
	
	/* properties */
	private int angle_step = 20;
	
	public RandomMouvement(Agent outer) {
		super(outer);
		rand = new Random();
	}
	
	/* LCStepperController */
	
	public boolean step() throws LifeCycleException {
		super.outer.setAngle(super.outer.getAngle() + 2*(rand.nextInt(angle_step+1)) - angle_step);
		
		action = new Action(Action.MOVE, super.outer.getAngle());
		return true; // step is finished
		
	}
}
