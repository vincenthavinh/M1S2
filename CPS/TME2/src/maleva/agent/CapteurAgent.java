
package maleva.agent;

import maleva.framework.BasicComponent;
import maleva.framework.LifeCycleException;

public class CapteurAgent extends BasicComponent
implements /* provides */
AgentRefListService, 
/* requires */   
RequireEnvironmentFetchService,	       		
/* controllers */
AgentPartController,
LCStepperController {
	
	/* fields */
	protected AgentRef[] last_seen_agents;
	
	/* agent part */
	protected Agent outer;
	
	/* bound services */
	protected EnvironmentFetchService efs;
	
	/* properties */
	private int view_dist; // view distance
	
	public CapteurAgent(Agent outer) {
		efs = null;
		view_dist = 50;
		last_seen_agents = null;
		this.outer = outer;
	}
	
	public void bindEnvironmentFetchService(EnvironmentFetchService efs) {
		this.efs = efs;
	}
	
	public boolean isBound() {
		return efs!=null;
	}
	
	/* properties */
	public int getViewDist() {
		return view_dist;
	}
	
	public void setViewDist(int view_dist) {
		this.view_dist = view_dist;
	}
	
	/* AgentRefListService functionalities */
	public AgentRef[] getAgentRefs() {
		return last_seen_agents;
	}
	
	public int getNbAgentRefs() {
		return last_seen_agents.length;
	}
	
	/* Stepper Controller interface */
	public boolean step() throws LifeCycleException {
		if(efs==null)
			throw new LifeCycleException("Environment fetch service not bound");
		if (outer==null) throw new LifeCycleException("WAT");
                last_seen_agents = efs.fetchAgents(outer.getID(),outer.getPosX(),outer.getPosY(),outer.getAngle(),outer.getFieldOfView(), getViewDist());

		if(last_seen_agents == null || last_seen_agents.length==0) {
                        System.out.println(outer.toString() + " saw nothing.");
			return false; // step is not finished if nothing seen
                } else {
                        System.out.println(outer.toString() + " saw #" +
                                           last_seen_agents.length + " Agents:");
                        for (int i = 0; i < last_seen_agents.length; i++) {
                                System.out.println("   - " + last_seen_agents[i].toString());
                        }
			return true; // step is finished
                }
	}
}
