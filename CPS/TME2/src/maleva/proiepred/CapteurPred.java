
package maleva.proiepred;

import maleva.agent.Agent;
import maleva.agent.CapteurAgent;
import maleva.framework.LifeCycleException;

public class CapteurPred extends CapteurAgent {

    public CapteurPred(Agent outer) {
	super(outer);
    }
	       
    /* LCActivateController interface */
    public boolean step() throws LifeCycleException {
    	if(efs==null)
			throw new LifeCycleException("Environment fetch service not bound");
		if (outer==null) throw new LifeCycleException("WAT");
                last_seen_agents = efs.fetchPreds(outer.getID(),outer.getPosX(),outer.getPosY(),outer.getAngle(),outer.getFieldOfView(), getViewDist());

		if(last_seen_agents == null || last_seen_agents.length==0) {
                        //System.out.println(outer.getID() + " saw nothing.");
			return false; // step is not finished if nothing seen
                } else {
                        System.out.println("Trouillard '"+outer.getID() + "' saw #" +
                                           last_seen_agents.length + " Predateurs:");
                        for (int i = 0; i < last_seen_agents.length; i++) {
                                System.out.println("   - " + last_seen_agents[i].getID());
                        }
			return true; // step is finished
                }
    }
}
