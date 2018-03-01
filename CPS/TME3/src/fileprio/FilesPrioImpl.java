package fileprio;

import java.util.ArrayList;

public class FilesPrioImpl<T> implements FilesPrioService<T> {
	private int size;
	private boolean empty;
	private ArrayList<Integer> activePrios;
	private ArrayList<T> elems;
	private int maxPrio;
	
	public FilesPrioImpl() {
		
	}
	
	public FilesPrioImpl(FilesPrioImpl f) {
		this.size = f.getSize();
		this.empty = f.isEmpty();
		this.activePrios = new ArrayList<Integer>();
		for(int i=0; i< f.getActivePrios().size(); i++) {
			this.activePrios.set(i, (Integer) f.getActivePrios().get(i));
		}
		this.maxPrio = f.getMaxPrio();
	}

	@Override
	public void init() {
		this.size=0;
		this.maxPrio=0;
		this.empty=true;
		activePrios = new ArrayList<Integer>();
		elems = new ArrayList<T>();
	}
	
	@Override
	public int getSize() {
		return activePrios.size();
	}
	
	@Override
	public boolean isEmpty() {
		return empty;
	}
	
	@Override
	public ArrayList<Integer> getActivePrios() {
		return activePrios;
	}
	
	@Override
	public boolean isActive(int i) {
		return this.getActivePrios().contains(i);
	}
	
	@Override
	public int getMaxPrio() {
		int max = 0;
		for(int i : activePrios) {
			if(i>max) max=i;
		}
		return max;
	}
	
	@Override
	public int getSizePrio(int i) {
		//count prio i in fileprio
		int sizep=0;
		for(int z : activePrios) {
			if(z == i) {
				sizep++;
			}
		}
		return sizep;
	}
	
	@Override
	public T getPrio(int i) {
		int pos = this.activePrios.indexOf(i);
		T prio = elems.get(pos);
		return prio;
	}
	
	@Override
	public T getElem() {
		return getPrio(this.activePrios.indexOf(this.getMaxPrio()));
	}
	
	@Override
	public T getElemPrio(int i, int k) {
		int compteur = 0;
		int pos = -1;
		for(int j=0; j< activePrios.size(); j++) {
			if(activePrios.get(j) == i) compteur++;
			if( compteur == k) {
				pos = j;
				break;
			}
		}
		T elemprio = elems.get(pos);
		return elemprio;
	}
	
	@Override
	public void putPrio(int i, T e) {
		activePrios.add(i);
		elems.add(e);
		empty=false;
	}
	
	@Override
	public void put(T e) {
		putPrio(maxPrio, e);
		
	}
	@Override
	public void removePrio(int i) {
		int pos = this.activePrios.indexOf(i);
		elems.remove(pos);
		activePrios.remove(pos);
		
		if(activePrios.size()==0) empty=true;
	}
	
	@Override
	public void remove() {
		removePrio(maxPrio);		
	}

}
