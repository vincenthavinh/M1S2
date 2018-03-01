package fileprio;

import java.util.ArrayList;
import java.util.Set;

public abstract class FilesPrioDecorator<T> implements FilesPrioService<T> {

	private FilesPrioService<T> delegate;
	
	protected FilesPrioDecorator(FilesPrioService<T> delegate){
		this.delegate = delegate;
	}

	public int getSize() {
		return delegate.getSize();
	}

	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	public ArrayList<Integer> getActivePrios() {
		return delegate.getActivePrios();
	}

	public boolean isActive(int i) {
		return delegate.isActive(i);
	}

	public int getMaxPrio() {
		return delegate.getMaxPrio();
	}

	public int getSizePrio(int i) {
		return delegate.getSizePrio(i);
	}

	public T getPrio(int i) {
		return delegate.getPrio(i);
	}

	public T getElem() {
		return delegate.getElem();
	}

	public T getElemPrio(int i, int k) {
		return delegate.getElemPrio(i, k);
	}

	public void init() {
		delegate.init();
	}

	public void putPrio(int i, T e) {
		delegate.putPrio(i, e);
	}

	public void put(T e) {
		delegate.put(e);
	}

	public void removePrio(int i) {
		delegate.removePrio(i);
	}

	public void remove() {
		delegate.remove();
	}
	
}
