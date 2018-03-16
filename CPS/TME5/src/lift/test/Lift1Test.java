package lift.test;

import lift.contracts.LiftContract;
import liftimpl1.Lift1;
import liftimpl2.Lift2;
import liftimpl3.Lift3;

public class Lift1Test extends AbstractLiftTest{


	
	@Override
	public void beforeTests() {
		LiftContract lc = new LiftContract(new Lift1());
		setLift(lc);
		lc.toString();
	}
	

	
	
}
