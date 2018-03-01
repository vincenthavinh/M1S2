package fileprio;

import java.util.ArrayList;

public class FilesPrioImplBug<T> implements FilesPrioService {
	private int size;
	private boolean empty;
	private ArrayList<Integer> activePrios;
	private ArrayList<Object> objects;
	private boolean active;
	private int maxPrio;
	private int sizePrio;
	private T elem;
	private T elemPrio;
	
	@Override
	public void init() {
		this.size=0;
		//Choisi arbitrairement
		this.maxPrio=10;
		this.empty=true;
		activePrios = new ArrayList<Integer>();
	}
	@Override
	public int getSize() {
		return size;
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
		return active;
	}
	@Override
	public int getMaxPrio() {
		return maxPrio;
	}
	@Override
	public int getSizePrio(int i) {
		//count prio i in fileprio
		int sizep=0;
		for(int z=0;z<activePrios.size();z++) {
			if(activePrios.get(z)==i) {
				sizep++;
			}
		}
		return sizep;
	}
	@Override
	public Object getPrio(int i) {
		//premier element de prio i
		int rankp=0;
		for(int z=0;z<activePrios.size();z++) {
			if(activePrios.get(z)==i) {
				rankp=z;
				break;
			}
		}
		return rankp;
	}
	@Override
	public Object getElem() {
		return elem;
	}
	@Override
	public Object getElemPrio(int i, int k) {
		//k ieme de prio i 
		ArrayList<Object> objectstmp = new ArrayList<Object>();
		for(int z=0;z<activePrios.size();z++) {
			if(activePrios.get(z)==i) {
				objectstmp.add(objects.get(z));
			}
		}
		return objectstmp.get(k);
	}
	@Override
	public void putPrio(int i, Object e) {
		activePrios.add(i);
		objects.add(e);
		empty=false;
	}
	@Override
	public void put(Object e) {
		putPrio(maxPrio, e);
		
	}
	@Override
	public void removePrio(int i) {
		for(int z=0;z<activePrios.size();z++) {
			if(activePrios.get(z)==i) {
				activePrios.remove(z);
			}
		}
		if(activePrios.size()==0) empty=true;
	}
	@Override
	public void remove() {
		//On retire les elements de priorité max
		removePrio(maxPrio);		
	}

}
