package lift.test;

import lift.contracts.LiftContract;
import liftimpl2.Lift2;

public class Lift2Test extends AbstractLiftTest{

	@Override
	public void beforeTests() {
		setLift(new LiftContract(new Lift2()));
	}
}
