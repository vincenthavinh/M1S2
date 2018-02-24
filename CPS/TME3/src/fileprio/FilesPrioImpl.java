package fileprio;

import java.util.Set;

public class FilesPrioImpl<T> implements FilesPrioService {
	private int size;
	private boolean empty;
	private Set<Integer> activePrios;
	private boolean active;
	private int maxPrio;
	private int sizePrio;
	private T elem;
	private T elemPrio;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
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
	public Set getActivePrios() {
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
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object getPrio(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getElem() {
		return elem;
	}
	@Override
	public Object getElemPrio(int i, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void putPrio(int i, Object e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void put(Object e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removePrio(int i) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
