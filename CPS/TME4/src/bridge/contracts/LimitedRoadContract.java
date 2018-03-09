package bridge.contracts;

import bridge.decorators.LimitedRoadDecorator;
import bridge.services.LimitedRoadService;

public class LimitedRoadContract extends LimitedRoadDecorator {

	public LimitedRoadContract(LimitedRoadService delegate) {
		super(delegate);
	}

	public void checkInvariant() {
		// remarque : include et non refine donc on n'hérite
		// pas des invariants de RoadSectionService, il faut refaire des tests.
				
		if(!(getNbCars() >= 0)) {
			Contractor.defaultContractor().invariantError("LimitedService","The number of cars should be positive");
		}
		if(isFull()){
			if(getNbCars()!=getLimit()){
				Contractor.defaultContractor().invariantError("LimitedService","The number of cars should be equal to the limit when bridge is full");
			}
		}
		if(getNbCars()>getLimit()){
			Contractor.defaultContractor().invariantError("LimitedService","The number of cars should be lesser or equal to the limit");
			
		}
	}
	
	@Override
	public void init(int lim){
		
		// \pre lim>0
		if(!(lim>0)){
			Contractor.defaultContractor().preconditionError("LimitedService", "enter", "The cars limit should be positive");
		}
		
		super.init(lim);
		
		// \inv pre
		checkInvariant();
		
		// \post getLimit()=lim
		if(!(getLimit()==lim)){
			Contractor.defaultContractor().postconditionError("LimitedService", "enter", "Limit should be positive");
		}
		
		// \post getNbCars()=0
		if(getNbCars()!=0){
			Contractor.defaultContractor().postconditionError("LimitedService", "enter", "Number of cars after init should be null");
		}
		
		// \const
		
	}
	
	@Override
	public void enter() {

		// \pre ¬isFull()
		if(isFull()){
			Contractor.defaultContractor().preconditionError("LimitedService", "enter", "The cars limit has been reached");
		}
		
		// inv pre
		checkInvariant();

		// captures
		int getNbCars_atPre = getNbCars();
		int limit_atpre = getLimit();
		
		// run
		super.enter();
		
		// inv post
		checkInvariant();
		
		// post: getNbCars() == getNbCars()@pre + 1 
		if(!(getNbCars() == getNbCars_atPre + 1)) {
			Contractor.defaultContractor().postconditionError("LimitedService", "enter", "The cars count did not increase");
		}
		
		// \const limit_atpre = getLimit
		
		if(limit_atpre!=getLimit()){
			Contractor.defaultContractor().postconditionError("LimitedService", "enter", "LIMIT IS CONSTANT");
		}
	}
	
	@Override
	public void leave() {
		// pre: getNbCars() > 0
		if(!(getNbCars() > 0)) {
			Contractor.defaultContractor().preconditionError("LimitedService", "leave", "The number of cars is not strictly positive");
		}
		// captures
		int getNbCars_atPre = getNbCars();
		int limit_atpre = getLimit();
		
		// inv pre
		checkInvariant();
		// run
		super.leave();
		// int post
		checkInvariant();
		// post: getNbCars() == getNbCars()@pre - 1 
		if(!(getNbCars() == getNbCars_atPre - 1)) {
			Contractor.defaultContractor().postconditionError("LimitedService", "leave", "The cars count did not decrease");
		}
		
		if(limit_atpre!=getLimit()){
			Contractor.defaultContractor().postconditionError("LimitedService", "enter", "LIMIT IS CONSTANT");
		}
		
	}
		
	
}
