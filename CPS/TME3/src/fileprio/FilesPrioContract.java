package fileprio;

import java.util.Set;

public class FilesPrioContract<T> extends FilesPrioDecorator<T> {

		public FilesPrioContract(FilesPrioService<T> delegate) {
			super(delegate);
		}
		
		public void checkInvariants() {
			// \inv \min getSize() == \sum i:int \with i \in getActivePrios() { getSizePrio(i) }
			int sum = 0;
			for(Integer activePrio : getActivePrios()) {sum+= activePrio;}
			if(getSize() != sum) 
				throw new InvariantError("InvariantError: \\inv \\min getSize() == \\sum i:int \\with i \\in getActivePrios() { getSizePrio(i) }");
			
			// \inv \min isEmpty() == (getSize()==0)
			if(isEmpty() != (getSize()==0))
				throw new InvariantError("InvariantError: \\inv \\min isEmpty() == (getSize()==0)");
			
			// \inv \min isActive(i) ==  (i \in getActivePrios())
			for(int i=0; i< getSize(); i++ ) {
				if(isActive(i) != (getActivePrios().contains(i)))
					throw new InvariantError("InvariantError: \\inv \\min isActive(i) ==  (i \\in getActivePrios())");
			}
			
			// \keyword \max0 renvoie le max d'un ensemble ou zéro si l'ensemble est vide
			// \inv \min getMaxPrio() == \max0 getActivePrios()
			int max = 0;
			for(Integer i : getActivePrios()) {if(i>max) max=i;}
			if(getMaxPrio() != max)
				throw new InvariantError("InvariantError: \\inv \\min getMaxPrio() == \\max0 getActivePrios()");
			
			// \inv \min getPrio(i) == getElemPrio(i,1)
			for(Integer i : getActivePrios()) {
				if(getPrio(i) != getElemPrio(i, 1))
					throw new InvariantError("InvariantError: \\inv \\min getPrio(i) == getElemPrio(i,1)");
			}
			
			// \inv \min getElem() == getPrio(getMaxPrio())
			if(getElem() != getPrio(getMaxPrio()))
				throw new InvariantError("InvariantError: \\inv \\min getElem() == getPrio(getMaxPrio())");
			
			// \inv \forall i:int \with i \in getActivePrios() { getSizePrio(i)>0 }
			for(Integer i : getActivePrios()) {
				if(getSizePrio(i) <= 0)
					throw new InvariantError("InvariantError: \\inv \\forall i:int \\with i \\in getActivePrios() { getSizePrio(i)>0 }");
			}
			
			// \inv \forall i:int \with i \not \in getActivePrios() { getSizePrio(i) = 0 }
			for(int i=0; i<getSize(); i++) {
				if(isActive(i)==false && getSizePrio(i)!=0)
					throw new InvariantError("InvariantError: \\inv \\forall i:int \\with i \\not \\in getActivePrios() { getSizePrio(i) = 0 }");
			}
			
			// \inv \forall i:int \with i \in getActivePrios() {
			//				\forall k:int \with k>=1 \and k<=getSizePrio(i) {
			//						getElemPrio(i,k)!=null }}
			for(Integer i : getActivePrios()) {
				for(int k=1; k<=getSizePrio(i); k++) {
					if(getElemPrio(i, k)== null )
						throw new InvariantError("InvariantError: \\inv \\forall i:int \\with i \\in getActivePrios() {\n" + 
								"\\forall k:int \\with k>=1 \\and k<=getSizePrio(i) {\n" + 
								"getElemPrio(i,k)!=null }}");
				}
			}
		}

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
		// \pre getSizePrio(i) > 0
		public T getPrio(int i) {
			//preconditions
			if(getSizePrio(i) <= 0) throw new PreconditionError("PreconditionError: \\pre getSizePrio(i) > 0");
			
			return super.getPrio(i);
		}

		@Override
		// \pre getSize() > 0
		public T getElem() {
			
			/*preconditions*/
			if(getSize() <= 0) throw new PreconditionError("PreconditionError: \\pre getSize() > 0");
			
			return super.getElem();
		}

		@Override
		// \pre i \in getActivePrios() \and getSizePrio(i)>=k \and k>0
		public T getElemPrio(int i, int k) {
			
			/*preconditions*/
			if(getActivePrios().contains(i)==false || getSizePrio(i)<k || k<=0)
				throw new PreconditionError("PreconditionError: \\pre i \\in getActivePrios() \\and getSizePrio(i)>=k \\and k>0");
			
			return super.getElemPrio(i, k);
		}

		@Override
		public void init() {
			super.init();
		}

		@Override
		public void putPrio(int i, T e) {
			super.putPrio(i, e);
		}

		@Override
		public void put(T e) {
			super.put(e);
		}

		@Override
		public void removePrio(int i) {
			super.removePrio(i);
		}

		@Override
		public void remove() {
			super.remove();
		}
		
}
