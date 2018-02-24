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
	public T getPrio(int i); 	//\pre getSizePrio(i) > 0
	public T getElem();			//\pre getSize() > 0
	public T getElemPrio(int i, int k); 	//\pre i \in getActivePrios() \and getSizePrio(i)>=k \and k>0

	/*Constructor*/
	
	public void init();
	// \post getSize()=0

	/* Invariants */
	
	// \inv \min getSize() == \sum i:int \with i \in getActivePrios() { getSizePrio(i) }
	// \inv \min isEmpty() == (getSize()==0)
	// \inv \min isActive(i) ==  (i \in getActivePrios())
	// \keyword \max0 renvoie le max d'un ensemble ou zéro si l'ensemble est vide
	// \inv \min getMaxPrio() == \max0 getActivePrios()
	// \inv \min getPrio(i) == getElementPrio(i,1)
	// \inv \min getElem() == getPrio(getMaxPrio())
	// \inv \forall i:int \with i \in getActivePrios() { getSizePrio(i)>0 }
	// \inv \forall i:int \with i \not \in getActivePrios() { getSizePrio(i) = 0 }
	// \inv \forall i:int \with i \in getActivePrios() {
	//				\forall k:int \with k>=1 \and k<=getSizePrio(i) {
	//						getElemPrio(i,k)!=null }}

	/* Operators */
	/*Note : prio(putPrio(P,i,e),i) = e : on va chercher e avec elemPrio(putPrio(P,i,e),i,1)*/
	
	// \pre i>= 0 \and e!=null
	public void putPrio(int i, T e);
	// \post isActive(i)@pre \imp getActivePrios() == getActivePrios()@pre  
	// \post \not isActive(i)@pre \imp getActivePrios() == getActivePrios()@pre \ union i
	// \post getSizePrio(i) == getSizePrio(i)@pre + 1
	// \post \forall j:int \with j \in getActivePrios()@pre \less i { getSizePrio(j) == getSizePrio(j)@pre }
	// \post \forall k:int \with k>=2 \and k<=getSizePrio(i)@pre+1 { getElemPrio(i,k) == getElemPrio(i,k-1)@pre }
	// \post \forall j:int \with j \in getActivePrios()@pre \less i {
	// 				 \forall k:int \with k>=1 \and k<=getSizePrio(j)@pre { 
	//						 getElemPrio(j,k) == getElemPrio(j,k)@pre }}
	
	// \pre e!=null
	public void put(T e);
	// \post put(e) = putPrio(e,getMaxPrio()@pre)@pre
	
	// \pre getSizePrio(i) > 0
	public void removePrio(int i);
	// \post getSizePrio(i)@pre > 1 \imp getActivePrios() = getActivePrios()@pre
	// \post getSizePrio(i)@pre = 1 \imp getActivePrios() = getActivePrios()@pre \less i
	// \post getSizePrio(i) = getSizePrio(i)@pre-1
	// \post \forall j:int \with j \in getActivePrios(P)@pre \less i { getSizePrio(j) = getSizePrio(j)@pre }
	// \post \forall k:int \with k>=1 \and k<= getSizePrio(i)@pre-1 { getElemPrio(i,k) = getElemPrio(i,k)@pre
	// \post \forall j:int \with j \in getActivePrios()@pre \less i {
	// 				 \forall k:int \with k>=1 \and k<=getSizePrio(j)@pre { 
	//						 getElemPrio(j,k) = getElemPrio(j,k)@pre }}
	
	// \pre getSize(i)>0
	public void remove();
	// \post remove() = removePrio(maxPrio()@pre)@pre

}
