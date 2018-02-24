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
	
	public FilesPrioImpl(){}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set getActivePrios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isActive(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxPrio() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getElemPrio(int i, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putPrio(int i, Object e) {
		// TODO Auto-generated method stub
		
	};
	
//	public void putPrio(int i, T e){
//		//this.activePrios.
//	}
	
	

}
