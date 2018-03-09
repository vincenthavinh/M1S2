package bridge.contracts;

import bridge.services.BridgeService;

public class BridgeContract extends LimitedRoadContract implements BridgeService {

	public BridgeContract(BridgeService delegate) {
		super(delegate);
	}

	@Override
	protected BridgeService getDelegate() {
		return (BridgeService) super.getDelegate();
	}
	
	@Override
	public int getNbIn() {
		return getDelegate().getNbIn();
	}

	@Override
	public int getNbOut() {
		return getDelegate().getNbOut();
	}
	
	public void checkInvariant() {
		super.checkInvariant();
		
		if(!(getNbIn()>=0)) 
			Contractor.defaultContractor().invariantError("BridgeService","nbIn must be positive");
		
		if(!(getNbOut()>=0)) 
			Contractor.defaultContractor().invariantError("BridgeService","nbOut must be positive");
	
		if(!(getNbCars() == getNbIn()+getNbOut())) 
		Contractor.defaultContractor().invariantError("BridgeService","nbCars must equal nbIn + nbOut");
	}
	

	/*@Override
	public void init() {
		// TODO
		getDelegate().init();
	}*/

	@Override
	public void init(int lim) {
		/*preconditions*/
		//pre: lim > 0
		if(!(lim > 0)) 
			Contractor.defaultContractor().preconditionError("BridgeService", "init", "parameter lim must be > 0");
		
		/*traitement*/
		getDelegate().init(lim);
		
		/*invariants post-traitement*/
		checkInvariant();
		
		/*postconditions*/
		//post: getNbIn() == 0
		if(!(getNbIn() == 0)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "init", "getNbIn must be == 0");
		//post: getNbOut() == 0
		if(!(getNbOut() == 0)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "init", "getNbOut must be == 0");
		
	}

	@Override
	public void enterIn() {
		/*preconditions*/
		//pre: !isFull()
		if(!(!isFull())) 
			Contractor.defaultContractor().preconditionError("BridgeService", "enterIn", "isFull() me be false");
		
		/*Invariants*/
		checkInvariant();
		
		/*captures*/
		int getNbIn_atpre = getNbIn();
		int getNbOut_atpre = getNbOut();
		
		/*traitement*/
		getDelegate().enterIn();
		
		/*Invariants*/
		checkInvariant();
		
		/*postconditions*/
		//post: getNbIn() == getNbIn()@pre + 1
		if(!(getNbIn() == getNbIn_atpre + 1)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "enterIn", "must be getNbIn() == getNbIn()@pre + 1");
		//post: getNbOut() == getNbOut()@pre
				if(!(getNbOut() == getNbOut_atpre)) 
					Contractor.defaultContractor().postconditionError("BridgeService", "enterIn", "must be getNbOut() == getNbOut()@pre");
			
	
	}

	@Override
	public void leaveIn() {
		/*preconditions*/
		//pre: getNbIn() > 0
		if(!(getNbIn() > 0)) 
			Contractor.defaultContractor().preconditionError("BridgeService", "leaveIn", "must be getNbIn() > 0");
		
		/*invariants*/
		checkInvariant();
		
		/*captures*/
		int getNbIn_atpre = getNbIn();
		int getNbOut_atpre = getNbOut();
		
		/*traitement*/
		getDelegate().leaveIn();
		
		/*invariants*/
		checkInvariant();
		
		/*postconditions*/
		//post: getNbIn() == getNbIn()@pre - 1
		if(!(getNbIn() == getNbIn_atpre - 1)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "leaveIn", "must be getNbIn() == getNbIn()@pre - 1");
		//post: getNbOut() == getNbOut()@pre
		if(!(getNbOut() == getNbOut_atpre)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "leaveIn", "must be getNbOut() == getNbOut()@pre");
		
	}

	@Override
	public void enterOut() {
		/*preconditions*/
		//pre: !isFull()
		if(!(!isFull())) 
			Contractor.defaultContractor().preconditionError("BridgeService", "enterOut", "must be !isFull()");
							
		/*invariants*/
		checkInvariant();
		
		/*capture*/
		int getNbOut_atpre = getNbOut();
		int getNbIn_atpre = getNbIn();
		
		/*traitement*/
		getDelegate().enterOut();
		
		/*invariants*/
		checkInvariant();
		
		/*postconditions*/
		//post: getNbOut() == getNbOut()@pre + 1
		if(!(getNbOut() == getNbOut_atpre + 1)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "enterOut", "must be getNbOut() == getNbOut()@pre + 1");
		//post: getNbIn() == getNbIn()@pre
		if(!(getNbIn() == getNbIn_atpre)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "enterOut", "must be getNbIn() == getNbIn()@pre");
		
	}

	@Override
	public void leaveOut() {
		/*preconditions*/
		//pre: getNbOut() > 0
		if(!(getNbOut() > 0)) 
			Contractor.defaultContractor().preconditionError("BridgeService", "leaveIn", "must be getNbOut() > 0");
		
		/*invariants*/
		checkInvariant();
		
		/*captures*/
		int getNbIn_atpre = getNbIn();
		int getNbOut_atpre = getNbOut();
		
		/*traitement*/
		getDelegate().leaveOut();
		
		/*invariants*/
		checkInvariant();
		
		/*postconditions*/
		//post: getNbOut() == getNbOut()@pre - 1
		if(!(getNbOut() == getNbOut_atpre - 1)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "leaveIn", "must be getNbOut() == getNbOut()@pre - 1");
		//post: getNbIn() == getNbIn()@pre
		if(!(getNbIn() == getNbIn_atpre)) 
			Contractor.defaultContractor().postconditionError("BridgeService", "leaveIn", "must be getNbIn() == getNbIn()@pre");
	}
	
	@Override
	public void enter() {
		
		/*preconditions*/
		//pre: !isFull()
		if(isFull())
			Contractor.defaultContractor().preconditionError("LimitedService", "enter", "The cars limit has been reached");
		
		/*invariants*/
		checkInvariant();
		
		/*captures*/
		int limit_atpre = getLimit();
		int getNbCars_atpre = getNbCars();
		int getNbIn_atpre = getNbIn();
		int getNbOut_atpre = getNbOut();
		
		/*traitement*/
		getDelegate().enter();
		
		/*invariants*/
		checkInvariant();
		
		/*postconditions*/
		// post: getNbCars() == getNbCars()@pre + 1 
		if(!(getNbCars() == getNbCars_atpre + 1))
			Contractor.defaultContractor().postconditionError("LimitedService", "enter", "The cars count did not increase");
		/*post: if getNbIn()@pre > getNbOut()@pre
		 *       then
		 *         getNbIn() == getNbIn()@pre
		 *         getNbOut() == getNbOut()@pre + 1 
		 *       else
		 *         getNbIn() == getNbIn()@pre + 1
		 *         getNbOut() == getNbOut()@pre 
		 */
		if (getNbIn_atpre > getNbOut_atpre) {
			if(!(getNbIn() == getNbIn_atpre))
				Contractor.defaultContractor().postconditionError("LimitedService", "leave", "must be getNbIn() == getNbIn()@pre"); 
			if(!(getNbOut() == getNbOut_atpre + 1))
				Contractor.defaultContractor().postconditionError("LimitedService", "leave", "must be getNbOut() == getNbOut()@pre + 1");
		}else {
			if(!(getNbIn() == getNbIn_atpre + 1))
				Contractor.defaultContractor().postconditionError("LimitedService", "leave", "must be getNbIn() == getNbIn()@pre + 1"); 
			if(!(getNbOut() == getNbOut_atpre))
				Contractor.defaultContractor().postconditionError("LimitedService", "leave", "must be getNbOut() == getNbOut()@pre");
		}
		
		/*observateurs constants*/
		if(limit_atpre!=getLimit())
			Contractor.defaultContractor().postconditionError("LimitedService", "enter", "LIMIT IS CONSTANT");
	}
	
	@Override
	public void leave() {
		/*preconditions*/
		//pre: getNbCars() > 0
		if(!(getNbCars() > 0))
			Contractor.defaultContractor().preconditionError("LimitedService", "enter", "must be getNbCars() > 0");
		
		/*invariants*/
		checkInvariant();
		
		/*captures*/
		int getNbCars_atpre = getNbCars();
		int limit_atpre = getLimit();
		int getNbIn_atpre = getNbIn();
		int getNbOut_atpre = getNbOut();
		
		/*traitement*/
		getDelegate().leave();
		
		/*invariants*/
		checkInvariant();
		
		/*postconditions*/
		// post: getNbCars() == getNbCars()@pre - 1 
		if(!(getNbCars() == getNbCars_atpre - 1))
			Contractor.defaultContractor().postconditionError("LimitedService", "leave", "The cars count did not decrease");
		/* post: if getNbIn()@pre > getNbOut()@pre
		 *       then
		 *         getNbIn() == getNbIn()@pre - 1
		 *         getNbOut() == getNbOut()@pre
		 *       else
		 *         getNbIn() == getNbIn()@pre
		 *         getNbOut() == getNbOut()@pre - 1
		 */
		if (getNbIn_atpre > getNbOut_atpre) {
			if(!(getNbIn() == getNbIn_atpre - 1))
				Contractor.defaultContractor().postconditionError("LimitedService", "leave", "must be getNbIn() == getNbIn()@pre - 1"); 
			if(!(getNbOut() == getNbOut_atpre))
				Contractor.defaultContractor().postconditionError("LimitedService", "leave", "must be getNbOut() == getNbOut()@pre");
		}else {
			if(!(getNbIn() == getNbIn_atpre))
				Contractor.defaultContractor().postconditionError("LimitedService", "leave", "must be getNbIn() == getNbIn()@pre"); 
			if(!(getNbOut() == getNbOut_atpre - 1))
				Contractor.defaultContractor().postconditionError("LimitedService", "leave", "must be getNbOut() == getNbOut()@pre - 1");
		}
			
		/*observateurs constants*/
		if(limit_atpre!=getLimit())
			Contractor.defaultContractor().postconditionError("LimitedService", "enter", "LIMIT IS CONSTANT");
	}
	
}
