package lift.test;

import lift.contracts.LiftContract;
import liftimpl1.Lift1;
import liftimpl2.Lift2;
import liftimpl3.Lift3;

public class LiftTest1 extends AbstractLiftTest{


	
	@Override
	public void beforeTests() {
		setLift(new LiftContract(new Lift3()));
	}

	
	
}
