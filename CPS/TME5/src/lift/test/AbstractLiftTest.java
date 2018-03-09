package lift.test;

import static org.junit.Assert.*;
import lift.impl.CommandsImpl;
import lift.services.CommandsService;
import lift.services.DoorStatus;
import lift.services.LiftService;
import lift.services.LiftStatus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractLiftTest {
	private LiftService lift;
	private CommandsService commands;

	protected AbstractLiftTest() {
		lift = null;
		commands = null;
	}

	protected final LiftService getLift() {
		return lift;
	}

	protected final CommandsService getCommands() {
		return commands;
	}

	protected final void setLift(LiftService lift) {
		this.lift = lift;
	}

	protected final void setCommands(CommandsService commands) {
		this.commands = commands;
	}

	@Before
	public abstract void beforeTests(); 

	@After
	public final void afterTests() {
		lift = null;
		commands = null;
	}

	@Test
	public void testInitPositif(){

		int min = 2;
		int max = 5;

		//conditions initiales
		//		assertTrue("min doit etre superieur ou egal a 0", min>=0);
		//		assertTrue("min doit etre inferieur a max",min<max);	

		//operations
		try{
			assertTrue(max>0);
			lift.init(min, max);
			assertTrue(max>0);
			//setCommands(new CommandsImpl());

		}
		catch(Error e){
			e.printStackTrace();
			fail("Pre init");
			
		}

		//oracle
		//		assertTrue(lift.getMinLevel()==min);
		//		assertTrue(lift.getMaxLevel()==max);
		//		assertTrue(lift.getLiftStatus() == LiftStatus.IDLE);
		//		assertTrue(lift.getDoorStatus() == DoorStatus.OPENED);
		//		assertTrue(lift.getCommands().getNbDownCommands()==0);
		//		assertTrue(lift.getCommands().getNbUpCommands()==0);

	}


	@Test
	public void testInitNegatif(){

		int min = 2, max = 2;

		//conditions initiales
		//		assertTrue("pre: min>=0", min>=0);
		//		assertTrue("pre: min<max",min<max);	

		//operations
		try{
			lift.init(min, max);
			//	setCommands(new CommandsImpl());
			fail("pre init");
		}
		catch(Error e) {}

		//oracle
		//		assertTrue(lift.getMinLevel()==min);
		//		assertTrue(lift.getMaxLevel()==max);
		//		assertTrue(lift.getLiftStatus() == LiftStatus.IDLE);
		//		assertTrue(lift.getDoorStatus() == DoorStatus.OPENED);
		//		assertTrue(lift.getCommands().getNbDownCommands()==0);
		//		assertTrue(lift.getCommands().getNbUpCommands()==0);


	}

	@Test
	public void testInitNegatif2(){

		int min = -2, max = 2;

		//conditions initiales

		//operations
		try{
			lift.init(min, max);
			//		setCommands(new CommandsImpl());
			fail("pre init");
		}catch(Error e){

		}




		//oracle
		//		assertTrue(lift.getMinLevel()==min);
		//		assertTrue(lift.getMaxLevel()==max);
		//		assertTrue(lift.getLiftStatus() == LiftStatus.IDLE);
		//		assertTrue(lift.getDoorStatus() == DoorStatus.OPENED);
		//		assertTrue(lift.getCommands().getNbDownCommands()==0);
		//		assertTrue(lift.getCommands().getNbUpCommands()==0);


	}

	@Test
	public void testBeginMoveUpPositif(){
		/* DANS UNINVARIANT CONTRACT SI L ASCENCEUR EST IDLE LES PORTES SONT OUVERTES, 
		 * PRECON VALIDES, puis opération , puis POST CONDITIONS VIOLENT INVARIANTS
		 * A FAIRE : VIRER INVARIANT EN DISANT SI ASCENCEUR IDLE ALORS PORTES SOIT OPEN SOIT CLOSING
		 */
		
		//CI 
		lift.init(2,5);
		
		// Il faudrait faire un lift.setStatus(STANDBY)
		lift.closeDoor();
		lift.doorAck();
		
		try{
			lift.beginMoveUp();
		}catch(Error  e){
			e.printStackTrace();
			fail("pre begin move up");}


		//Operateur
		

	}

	@Test
	public void testBeginMoveUpNegatif(){
		//CI
		lift.init(2,5);
		
		
		//Operateur
		try{
			lift.beginMoveUp();
			fail("pre begin move up");
		}
		catch(Error e){}

		//Oracle
//		assertTrue(lift.getDoorStatus()==DoorStatus.CLOSED);
//		assertTrue(lift.getLiftStatus()==LiftStatus.MOVING_UP);
//		assertTrue(lift.getLevel() < lift.getCommands().getNextUpCommand());

	
		



	}






}
