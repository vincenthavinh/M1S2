package fileprio;

import java.util.Set;

public interface FilesPrioService<T> {
	/* Observators */

	public int getSize();
	public boolean isEmpty();
	public Set<Integer> getActivePrios();
	public boolean isActive(int i);
	public int getMaxPrio();
	public int getSizePrio(int i);
	public T getPrio(int i);
	//\pre getSizePrio(i)>0
	public T getElem();
	//\pre getSize()>0
	public T getElemPrio(int i, int k);
	//\pre i \in getActivePrios() \and getSizePrio(i)>=k \and k>0

	/*Constructor*/
	public void init();
	// \post getSize()=0

	/* Invariants */
	// \inv getSize() == (\sum i:int \with i \in getActivePrio(), getSizePrio(i) )
	// \inv isEmpty() == (getSize()==0)
	// \inv isActive(i) ==  (i:int \in getActivePrio())
	// \keyword \max0 renvoi le max d'un ensemble ou zéro s'il est vide
	// \inv getMaxPrio() == \max0 getActivePrios()
	// \inv getPrio(i) == getElementPrio(i,1)
	// \inv getElem() == getPrio(getMaxPrio())
	// \inv \forall i:int \in getActivePrios() { getSizePrio(i)>0 }
	// \inv \forall i:int \not \in getActivePrios() { getSizePrio(i) = 0 }
	// \inv \forall i:int \with i \in getActivePrios() \and \forall k:int \with k>=1\and k<=getSizePrio(i)
			// { getElemPrio(i,k)!=null }

	/* Operators */
	/*Note : prio(putPrio(P,i,e),i) = e : on va chercher e avec elemPrio(putPrio(P,i,e),i,1)*/
	
	// \pre i:int > 0 \and e!=\null
	public void putPrio(int i, T e);
	// \post isActive(i) \imp getActivePrios()=getActivePrios()@pre  
	// \post \not isActive(i) \imp getActivePrios() = getActivePrios()@pre \ union i
	// \post getSizePrio(i) == getSizePrio(i)@pre + 1
	// \post forall j:int \with j \in getActivePrios() \less i { getSizePrio(j) = getSizePrio(j)@pre }
	// \post getPrio(i)= getElemPrio(i, 1)
	// \post \forall 


}
