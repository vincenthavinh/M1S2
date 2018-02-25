package fileprio;

import java.util.Set;

public class FilesPrioContract<T> extends FilesPrioDecorator<T> {

		public FilesPrioContract(FilesPrioService<T> delegate) {
			super(delegate);
		}
		
		/* Invariants */

		public void checkInvariants() {
			// \inv \min getSize() == \sum i:int \with i \in getActivePrios() { getSizePrio(i) }
			int sum = 0;
			for(Integer activePrio : getActivePrios()) {sum+= activePrio;}
			if(getSize() != sum) 
				throw new InvariantError("\\inv \\min getSize() == \\sum i:int \\with i \\in getActivePrios() { getSizePrio(i) }");
			
			// \inv \min isEmpty() == (getSize()==0)
			if(isEmpty() != (getSize()==0))
				throw new InvariantError("\\inv \\min isEmpty() == (getSize()==0)");
			
			// \inv \min isActive(i) ==  (i \in getActivePrios())
			for(int i=0; i< getSize(); i++ ) {
				if(isActive(i) != (getActivePrios().contains(i)))
					throw new InvariantError("\\inv \\min isActive(i) ==  (i \\in getActivePrios())");
			}
			
			// \keyword \max0 renvoie le max d'un ensemble ou zéro si l'ensemble est vide
			// \inv \min getMaxPrio() == \max0 getActivePrios()
			int max = 0;
			for(Integer i : getActivePrios()) {if(i>max) max=i;}
			if(getMaxPrio() != max)
				throw new InvariantError("\\inv \\min getMaxPrio() == \\max0 getActivePrios()");
			
			// \inv \min getPrio(i) == getElemPrio(i,1)
			for(Integer i : getActivePrios()) {
				if(getPrio(i) != getElemPrio(i, 1))
					throw new InvariantError("\\inv \\min getPrio(i) == getElemPrio(i,1)");
			}
			
			// \inv \min getElem() == getPrio(getMaxPrio())
			if(getElem() != getPrio(getMaxPrio()))
				throw new InvariantError("\\inv \\min getElem() == getPrio(getMaxPrio())");
			
			// \inv \forall i:int \with i \in getActivePrios() { getSizePrio(i)>0 }
			for(Integer i : getActivePrios()) {
				if(getSizePrio(i) <= 0)
					throw new InvariantError("\\inv \\forall i:int \\with i \\in getActivePrios() { getSizePrio(i)>0 }");
			}
			
			// \inv \forall i:int \with i \not \in getActivePrios() { getSizePrio(i) = 0 }
			for(int i=0; i<getSize(); i++) {
				if(isActive(i)==false && getSizePrio(i)!=0)
					throw new InvariantError("\\inv \\forall i:int \\with i \\not \\in getActivePrios() { getSizePrio(i) = 0 }");
			}
			
			// \inv \forall i:int \with i \in getActivePrios() {
			//				\forall k:int \with k>=1 \and k<=getSizePrio(i) {
			//						getElemPrio(i,k)!=null }}
			for(Integer i : getActivePrios()) {
				for(int k=1; k<=getSizePrio(i); k++) {
					if(getElemPrio(i, k)== null )
						throw new InvariantError("\\inv \\forall i:int \\with i \\in getActivePrios() {\n" + 
								"\\forall k:int \\with k>=1 \\and k<=getSizePrio(i) {\n" + 
								"getElemPrio(i,k)!=null }}");
				}
			}
		}

		/* Observators*/
		
		@Override
		public int getSize() {
			return super.getSize();
		}

		@Override
		public boolean isEmpty() {
			return super.isEmpty();
		}

		@Override
		public Set<Integer> getActivePrios() {
			return super.getActivePrios();
		}

		@Override
		public boolean isActive(int i) {
			return super.isActive(i);
		}

		@Override
		public int getMaxPrio() {
			return super.getMaxPrio();
		}

		@Override
		public int getSizePrio(int i) {
			return super.getSizePrio(i);
		}

		@Override
		public T getPrio(int i) {
			
			/*preconditions*/
			
			// \pre getSizePrio(i) > 0
			if(getSizePrio(i) <= 0) throw new PreconditionError("\\pre getSizePrio(i) > 0");
			
			return super.getPrio(i);
		}

		@Override
		public T getElem() {
			
			/*preconditions*/
			
			// \pre getSize() > 0
			if(getSize() <= 0) throw new PreconditionError("\\pre getSize() > 0");
			
			return super.getElem();
		}

		@Override
		public T getElemPrio(int i, int k) {
			
			/*preconditions*/
			
			// \pre i \in getActivePrios() \and getSizePrio(i)>=k \and k>0
			if(getActivePrios().contains(i)==false || getSizePrio(i)<k || k<=0)
				throw new PreconditionError("\\pre i \\in getActivePrios() \\and getSizePrio(i)>=k \\and k>0");
			
			return super.getElemPrio(i, k);
		}

		/* Constructor */
		
		@Override
		public void init() {
			super.init();
			
			/*postconditions*/
			
			// \post getSize() == 0
			if(getSize() != 0) throw new PostconditionError("\\post getSize() ==  0");
		}

		/* Operators */
		
		@Override
		// TODO putPrio
		public void putPrio(int i, T e) {
			
			/*preconditions*/
			// \pre i>= 0 \and e!=null
			
			/*invariants*/
			checkInvariants();
			
			/*captures*/
			
			/*traitement*/
			super.putPrio(i, e);
			
			/*invariants*/
			checkInvariants();
			
			/*postconditions*/
			// \post isActive(i)@pre \imp getActivePrios() == getActivePrios()@pre  
			// \post \not isActive(i)@pre \imp getActivePrios() == getActivePrios()@pre \ union i
			// \post getSizePrio(i) == getSizePrio(i)@pre + 1
			// \post \forall j:int \with j \in getActivePrios()@pre \less i { getSizePrio(j) == getSizePrio(j)@pre }
			// \post \forall k:int \with k>=2 \and k<=getSizePrio(i)@pre+1 { getElemPrio(i,k) == getElemPrio(i,k-1)@pre }
			// \post \forall j:int \with j \in getActivePrios()@pre \less i {
			// 				 \forall k:int \with k>=1 \and k<=getSizePrio(j)@pre { 
			//						 getElemPrio(j,k) == getElemPrio(j,k)@pre }}
		}

		@Override
		// TODO put (work in progress)
		public void put(T e) {
			
			/*preconditions*/
			
			// \pre e!=null
			if(e==null) throw new PostconditionError("\\pre e!=null");
			
			/*invariants*/
			checkInvariants();
			
			/*captures*/
			/*COMMENT CAPTURER/CLONER LE FILEPRIOSERVICE DANS SON ETAT PRE PUT(E)?*/
			
			/*traitement*/
			super.put(e);
			
			/*invariants*/
			checkInvariants();
			
			/*postconditions*/
			
			// \post put(e) = putPrio(e,getMaxPrio()@pre)@pre
			/*COMMENT VERIF LES POSTCONDITIONS D'UNE OBSERVATION QUI EST UNE DEFINITION ?*/
		}

		@Override
		// TODO removePrio
		public void removePrio(int i) {

			/*preconditions*/
			// \pre getSizePrio(i) > 0
			
			/*invariants*/
			checkInvariants();
			
			/*captures*/
			
			/*traitement*/
			super.removePrio(i);

			/*invariants*/
			checkInvariants();
			
			/*postconditions*/
			// \post getSizePrio(i)@pre > 1 \imp getActivePrios() = getActivePrios()@pre
			// \post getSizePrio(i)@pre = 1 \imp getActivePrios() = getActivePrios()@pre \less i
			// \post getSizePrio(i) = getSizePrio(i)@pre-1
			// \post \forall j:int \with j \in getActivePrios(P)@pre \less i { getSizePrio(j) = getSizePrio(j)@pre }
			// \post \forall k:int \with k>=1 \and k<= getSizePrio(i)@pre-1 { getElemPrio(i,k) = getElemPrio(i,k)@pre
			// \post \forall j:int \with j \in getActivePrios()@pre \less i {
			// 				 \forall k:int \with k>=1 \and k<=getSizePrio(j)@pre { 
			//						 getElemPrio(j,k) = getElemPrio(j,k)@pre }}
		}

		@Override
		// TODO remove
		public void remove() {
			
			/*preconditions*/
			// \pre getSize(i)>0
			
			/*invariants*/
			checkInvariants();
			
			/*captures*/
			
			/*traitement*/
			super.remove();

			/*invariants*/
			checkInvariants();
			
			/*postconditions*/
			// \post remove() = removePrio(maxPrio()@pre)@pre
		}
		
}
