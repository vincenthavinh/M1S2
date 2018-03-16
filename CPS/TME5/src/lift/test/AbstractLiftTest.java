package lift.test;

import static org.junit.Assert.*;
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
		this.toString();
	}

	@Test
	public void testInitPositif(){
		int min = 2;
		int max = 5;
		//
		//			assertTrue("min doit etre superieur ou egal a 0", min>=0);
		//			assertTrue("min doit etre inferieur a max",min<max);	
		//op
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
		//				assertTrue(lift.getMinLevel()==min);
		//				assertTrue(lift.getMaxLevel()==max);
		//				assertTrue(lift.getLiftStatus() == LiftStatus.IDLE);
		//				assertTrue(lift.getDoorStatus() == DoorStatus.OPENED);
		//				assertTrue(lift.getCommands().getNbDownCommands()==0);
		//				assertTrue(lift.getCommands().getNbUpCommands()==0);
	}


	@Test
	public void testInitNegatif(){
		int min = 2;
		int max = 2;
		//				assertTrue("pre: min>=0", min>=0);
		//				assertTrue("pre: min<max",min<max);	
		//op
		try{
			lift.init(min, max);
			//	setCommands(new CommandsImpl());
			fail("pre init");
		}
		catch(Error e) {}
		//oracle
		//				assertTrue(lift.getMinLevel()==min);
		//				assertTrue(lift.getMaxLevel()==max);
		//				assertTrue(lift.getLiftStatus() == LiftStatus.IDLE);
		//				assertTrue(lift.getDoorStatus() == DoorStatus.OPENED);
		//				assertTrue(lift.getCommands().getNbDownCommands()==0);
		//				assertTrue(lift.getCommands().getNbUpCommands()==0);


	}

	@Test
	public void testInitNegatif2(){
		int min = -2;
		int max = 2;
		//op
		try{
			lift.init(min, max);
			fail("pre init");
		}catch(Error e){

		}
	}

	@Test
	public void testBeginMoveUpPositif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			lift.doorAck();
			//op
			lift.beginMoveUp();	
			//oracle
			assertTrue(lift.getLiftStatus() == LiftStatus.STANDBY_UP);
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLevel() < commands.getNextUpCommand());
		}
		catch(Error e){
			fail("post BeginMoveUpPositif");
		}
	}

	@Test
	public void testBeginMoveUpNegatif(){	
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			//op
			lift.beginMoveUp();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.STANDBY_UP);
			assertTrue(lift.getLevel() < commands.getNextUpCommand());
			fail("truc");
		}catch(Error e){

		}
	}

	@Test		
	public void testBeginMoveUpNegatif2(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.doorAck();
			lift.beginMoveUp();	

			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.STANDBY_UP);
			assertTrue(lift.getLevel() < commands.getNextUpCommand());
			fail("");
		}catch(Error e){}
	}

	@Test
	public void testStepMoveUpPositif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			lift.doorAck();
			lift.beginMoveUp();

			//op
			lift.stepMoveUp();

			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_UP);
			assertTrue(lift.getLevel() < commands.getNextUpCommand());

		}
		catch(Error e){fail("truc");}
	}

	@Test		
	public void testStepMoveUpNegatif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();

			//op
			lift.stepMoveUp();	

			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_UP);
			assertTrue(lift.getLevel() < commands.getNextUpCommand());
			fail("truc");
		}catch(Error e){}
	}

	@Test		
	public void testStepMoveUpNegatif2(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.doorAck();
			//op
			lift.stepMoveUp();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_UP);
			assertTrue(lift.getLevel() < commands.getNextUpCommand());
			fail("tryuc");
		}
		catch(Error e){}
	}


	@Test
	public void testEndMoveUpPositif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			lift.doorAck();
			lift.stepMoveUp();
			//op
			lift.endMoveUp();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_UP);
			assertTrue(lift.getLevel() == commands.getNextUpCommand());
		}catch(Error e){fail("truc");}
	}


	@Test
	public void testEndMoveUpNegatif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();

			//op
			lift.endMoveUp();	

			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_UP);
			assertTrue(lift.getLevel() == commands.getNextUpCommand());
			fail("trc");
		}catch(Error e){}
	}


	@Test
	public void testEndMoveUpNegatif2(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.doorAck();

			//op
			lift.endMoveUp();	

			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_UP);
			assertTrue(lift.getLevel() == commands.getNextUpCommand());
			fail("truc");
		}catch(Error e){}
	}


	@Test
	public void testBeginMoveDownPositif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			lift.doorAck();
			//op
			lift.beginMoveDown();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.STANDBY_DOWN);
			assertTrue(lift.getLevel() > commands.getNextUpCommand());
		}
		catch(Error e){}
	}


	@Test
	public void testBeginMoveDownNegatif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			//op
			lift.beginMoveDown();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.STANDBY_DOWN);
			assertTrue(lift.getLevel() > commands.getNextUpCommand());
			fail("truc");
		}catch(Error e){}
	}

	@Test		
	public void testBeginMoveDownNegatif2(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.doorAck();
			//op
			lift.beginMoveDown();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.STANDBY_DOWN);
			assertTrue(lift.getLevel() > commands.getNextUpCommand());
			fail("truc");
		}catch(Error e){}
	}



	@Test
	public void testStepMoveDownPositif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			lift.doorAck();
			lift.beginMoveDown();
			//op
			lift.stepMoveDown();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_DOWN);
			assertTrue(lift.getLevel() > commands.getNextUpCommand());
		}catch(Error e){fail("Truc");}
	}

	@Test		
	public void testStepMoveDownNegatif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			//op
			lift.stepMoveDown();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_DOWN);
			assertTrue(lift.getLevel() > commands.getNextUpCommand());
			fail("truc");
		}catch(Error e){}
	}

	@Test		
	public void testStepMoveDownNegatif2(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.doorAck();
			//op
			lift.stepMoveDown();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_DOWN);
			assertTrue(lift.getLevel() > commands.getNextUpCommand());
			fail("truc");
		}
		catch(Error e){}
	}



	@Test
	public void testEndMoveDownPositif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			lift.doorAck();
			lift.stepMoveDown();
			//op
			lift.endMoveDown();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_DOWN);
			assertTrue(lift.getLevel() == commands.getNextUpCommand());
		}catch(Error e){fail("truc");}

	}


	@Test
	public void testEndMoveDownNegatif(){

		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			//op
			lift.endMoveDown();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_DOWN);
			assertTrue(lift.getLevel() == commands.getNextUpCommand());
			fail("truc");
		}catch(Error e){}
	}


	@Test
	public void testEndMoveDownNegatif2(){

		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.doorAck();
			//op
			lift.endMoveUp();	
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_DOWN);
			assertTrue(lift.getLevel() == commands.getNextUpCommand());
			fail("tryuc");
		}catch(Error e){}
	}



	@Test
	public void testOpenDoorPositif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			lift.doorAck();
			//op
			lift.openDoor();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STOP_UP) || (lift.getLiftStatus() == LiftStatus.STOP_DOWN) );
		}catch(Error e){fail("truc");}

	}


	@Test
	public void testOpenDoorNegatif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			//op
			lift.openDoor();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STOP_UP) || (lift.getLiftStatus() == LiftStatus.STOP_DOWN) );
			fail("tryuc");
		}catch(Error e){}
	}


	@Test
	public void testOpenDoorNegatif2(){
		try{
			int min = 2;
			int max = 5;
			lift.init(min, max);
			lift.closeDoor();
			//op
			lift.openDoor();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.CLOSED);
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STOP_UP) || (lift.getLiftStatus() == LiftStatus.STOP_DOWN) );
			fail("truc");}catch(Error e){}
	}

	@Test
	public void testCloseDoorPositif(){
		try{
			int min = 2;
			int max = 5;
			lift.init(min, max);
			lift.openDoor();
			lift.doorAck();
			//op
			lift.closeDoor();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.OPENED);
			assertTrue( (lift.getLiftStatus() == LiftStatus.STANDBY_UP) || (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STANDBY_DOWN) );
		}catch(Error e){fail("truc");}

	}

	@Test
	public void testCloseDoorNegatif(){
		try{
			int min = 2;
			int max = 5;
			lift.init(min, max);
			//op
			lift.closeDoor();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.OPENED);
			assertTrue( (lift.getLiftStatus() == LiftStatus.STANDBY_UP) || (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STANDBY_DOWN) );
			fail("truc");}catch(Error e){}
	}


	@Test
	public void testCloseDoorNegatif2(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.openDoor();
			//op
			lift.closeDoor();
			//oracle
			assertTrue(lift.getDoorStatus() == DoorStatus.OPENED);
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STANDBY_UP) || (lift.getLiftStatus() == LiftStatus.STANDBY_DOWN) );
			fail("truc");}catch(Error e){}

	}

	@Test
	public void testDoorAckPositif(){
		try{
			int min = 2;
			int max = 5;
			lift.init(min, max);
			lift.openDoor();
			//op
			lift.doorAck();
			//oracle
			assertTrue( (lift.getDoorStatus() == DoorStatus.OPENING) || (lift.getDoorStatus() == DoorStatus.CLOSING) );
		}catch(Error e){fail("truc");}
	}


	@Test
	public void testDoorAckPositif2(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			lift.closeDoor();
			//op
			lift.doorAck();
			//oracle
			assertTrue( (lift.getDoorStatus() == DoorStatus.OPENING) || (lift.getDoorStatus() == DoorStatus.CLOSING) );
		}catch(Error e){fail("truc");}
	}


	@Test
	public void testDoorAckNegatif(){
		int min = 2;
		int max = 5;
		try{
			lift.init(min, max);
			//op
			lift.doorAck();
			//oracle
			assertTrue( (lift.getDoorStatus() == DoorStatus.OPENING) || (lift.getDoorStatus() == DoorStatus.CLOSING) );
			fail("truc");
		}catch(Error e){}
	}

	@Test
	public void testSelectLevelPositif(){
		int min = 2;
		int max = 5;
		int level = 6;
		try{
			lift.init(min, max);
			//op
			lift.selectLevel(level);
			//oracle
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STANDBY_UP) || (lift.getLiftStatus() == LiftStatus.STOP_DOWN) );
			assertTrue( (lift.getMinLevel() <= level) && (level <= lift.getMaxLevel()) );
		}catch(Error e){fail("truc");}
	}

	@Test
	public void testSelectLevelPositif2(){
		int min = 2;
		int max = 5;
		int level = 7;
		try{
			lift.init(min, max);
			//op
			lift.selectLevel(level);
			//oracle
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STANDBY_UP) || (lift.getLiftStatus() == LiftStatus.STOP_DOWN) );
			assertTrue( (lift.getMinLevel() <= level) && (level <= lift.getMaxLevel()) );
		}catch(Error e){fail("truc");}
	}


	@Test
	public void testSelectLevelPositif3(){
		int min = 2;
		int max = 5;
		int level = 8;
		try{
			lift.init(min, max);
			//op
			lift.selectLevel(level);
			//oracle
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STANDBY_UP) || (lift.getLiftStatus() == LiftStatus.STOP_DOWN) );
			assertTrue( (lift.getMinLevel() <= level) && (level <= lift.getMaxLevel()) );
		}catch(Error e){fail("truc");}
	}


	@Test
	public void testSelectLevelNegatif(){
		int min = 2;
		int max = 5;
		int level = 0;
		lift.init(min, max);
		try{
			//op
			lift.selectLevel(level);
			//oracle
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STANDBY_UP) || (lift.getLiftStatus() == LiftStatus.STOP_DOWN) );
			assertTrue( (lift.getMinLevel() <= level) && (level <= lift.getMaxLevel()) );
			fail("truc");
		}catch(Error e){}
	}


	@Test
	public void testSelectLevelNegatif2(){
		int min = 2;
		int max = 5;
		int level = 10;
		lift.init(min, max);
		try{
			//op
			lift.selectLevel(level);
			//oracle
			assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) || (lift.getLiftStatus() == LiftStatus.STANDBY_UP) || (lift.getLiftStatus() == LiftStatus.STOP_DOWN) );
			assertTrue( (lift.getMinLevel() <= level) && (level <= lift.getMaxLevel()) );
			fail("truc");
		}catch(Error e){}
	}




	//Transitions
	@Test
	public void testTransitionInit(){
		int min = 2;
		int max = 5;
		//op
		lift.init(min, max);
		//oracle
		assertTrue("init min == min", lift.getMinLevel() == min);
		assertTrue("init max == max", lift.getMaxLevel() == max);
		assertTrue("init level == min", lift.getLevel() == min);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue("init state == IDLE", lift.getLiftStatus() == LiftStatus.IDLE);
		assertTrue("doors status init = OPENED", lift.getDoorStatus() == DoorStatus.OPENED);
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
		assertTrue("commands init == new Commands()", lift.getCommands() == commands);
	}


	@Test
	public void testTransitionBeginMoveUp(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.closeDoor();
		lift.doorAck();
		//op
		lift.beginMoveUp();	
		//oracle			
		assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_UP);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getDoorStatus() == DoorStatus.CLOSED ) && lift.getLiftStatus() == LiftStatus.MOVING_UP ) || ( (  lift.getDoorStatus() == DoorStatus.CLOSED  && lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}

	@Test
	public void testTransitionStepMoveUp(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.closeDoor();
		lift.doorAck();
		lift.beginMoveUp();
		//op
		lift.stepMoveUp();
		//oracle	
		assertTrue(lift.getLevel() == lift.getLevel() + 1);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getDoorStatus() == DoorStatus.CLOSED ) && lift.getLiftStatus() == LiftStatus.MOVING_UP ) || ( (  lift.getDoorStatus() == DoorStatus.CLOSED  && lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}

	@Test
	public void testTransitionEndMoveUp(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.closeDoor();
		lift.doorAck();
		lift.stepMoveUp();
		//op
		lift.endMoveUp();	
		//oracle		
		assertTrue(lift.getLiftStatus() == LiftStatus.STOP_UP);
		assertTrue(lift.getCommands() == commands);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getDoorStatus() == DoorStatus.CLOSED ) && lift.getLiftStatus() == LiftStatus.MOVING_UP ) || ( (  lift.getDoorStatus() == DoorStatus.CLOSED  && lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}


	@Test
	public void testTransitionBeginMoveDown(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.closeDoor();
		lift.doorAck();
		//op
		lift.beginMoveDown();	
		//oracle	
		assertTrue(lift.getLiftStatus() == LiftStatus.MOVING_DOWN);	
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getDoorStatus() == DoorStatus.CLOSED ) && lift.getLiftStatus() == LiftStatus.MOVING_UP ) || ( (  lift.getDoorStatus() == DoorStatus.CLOSED  && lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}

	@Test
	public void testTransitionStepMoveDown(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.closeDoor();
		lift.doorAck();
		lift.beginMoveDown();
		//op
		lift.stepMoveDown();
		//oracle	
		assertTrue(lift.getLevel() == lift.getLevel() - 1);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getDoorStatus() == DoorStatus.CLOSED ) && lift.getLiftStatus() == LiftStatus.MOVING_UP ) || ( (  lift.getDoorStatus() == DoorStatus.CLOSED  && lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}	


	@Test
	public void testTransitionEndMoveDown(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.closeDoor();
		lift.doorAck();
		lift.stepMoveDown();
		//op
		lift.endMoveDown();	
		//oracle	
		assertTrue(lift.getLiftStatus() == LiftStatus.STOP_DOWN);
		assertTrue(lift.getCommands() == commands);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getDoorStatus() == DoorStatus.CLOSED ) && lift.getLiftStatus() == LiftStatus.MOVING_UP ) || ( (  lift.getDoorStatus() == DoorStatus.CLOSED  && lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}

	@Test
	public void testTransitionOpenDoor(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.closeDoor();
		lift.doorAck();
		//op
		lift.openDoor();
		//oracle	
		assertTrue(lift.getDoorStatus() == DoorStatus.OPENING);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getLiftStatus() == LiftStatus.MOVING_UP ) && lift.getDoorStatus() == DoorStatus.CLOSED ) || ( ( lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) && lift.getDoorStatus() == DoorStatus.CLOSED ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}


	@Test
	public void testTransitionCloseDoor(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.openDoor();
		lift.doorAck();
		//op
		lift.closeDoor();
		//oracle	
		assertTrue(lift.getDoorStatus() == DoorStatus.CLOSING);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getDoorStatus() == DoorStatus.CLOSED ) && lift.getLiftStatus() == LiftStatus.MOVING_UP ) || ( (  lift.getDoorStatus() == DoorStatus.CLOSED  && lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}

	@Test
	public void testTransitionDoorAck(){
		int min = 2;
		int max = 5;
		lift.init(min, max);
		lift.openDoor();
		//op
		lift.doorAck();
		//oracle	
		assertTrue( ( (lift.getDoorStatus() != DoorStatus.OPENING) || (lift.getDoorStatus() == DoorStatus.OPENED) ) || ( (lift.getDoorStatus() != DoorStatus.CLOSING) || (lift.getDoorStatus() == DoorStatus.CLOSED) ) );
		assertTrue( ( (lift.getLiftStatus() != LiftStatus.IDLE) || (commands.getNbDownCommands() <= 0) ) || (lift.getLiftStatus() == LiftStatus.STANDBY_DOWN)  );
		assertTrue( ( (lift.getLiftStatus() != LiftStatus.IDLE) || (commands.getNbUpCommands() <= 0) ) || (lift.getLiftStatus() == LiftStatus.STANDBY_UP)  );
		assertTrue( ( (lift.getLiftStatus() != LiftStatus.IDLE) || (commands.getNbUpCommands() != 0) || (commands.getNbDownCommands() != 0) ) || (lift.getLiftStatus() == LiftStatus.IDLE)  );
		assertTrue(lift.getLiftStatus() == LiftStatus.IDLE);
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) && lift.getDoorStatus() == DoorStatus.CLOSED ) || ( ( lift.getLiftStatus() == LiftStatus.MOVING_UP ) && lift.getDoorStatus() == DoorStatus.CLOSED ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}


	@Test
	public void testTransitionSelectLevel(){
		int min = 2;
		int max = 5;
		int level = 4;
		lift.init(min, max);
		//op
		lift.selectLevel(level);
		//oracle		
		assertTrue( (level <= lift.getLevel()) || (lift.getCommands() == commands) );
		assertTrue( (level >= lift.getLevel()) || (lift.getCommands() == commands) );
		assertTrue( (level != lift.getLevel()) || (lift.getCommands() == commands) );
		assertTrue( (lift.getMinLevel() <= lift.getLevel()) && (lift.getLevel() <= lift.getMaxLevel()) );
		assertTrue( ( ( lift.getLiftStatus() == LiftStatus.MOVING_DOWN ) && lift.getDoorStatus() == DoorStatus.CLOSED ) || ( ( lift.getLiftStatus() == LiftStatus.MOVING_UP ) && lift.getDoorStatus() == DoorStatus.CLOSED ) );
		assertTrue( (lift.getLiftStatus() == LiftStatus.IDLE) && (lift.getDoorStatus() == DoorStatus.OPENED) );
	}

}
