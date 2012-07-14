package it.albx79.diaspora.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A property whose value is a list. 
 * @author albx
 *
 * @param <T> the type of the elements in the list
 */
public class ListProp<T> extends Property<ListObserver<T>> {
	
	private final ArrayList<T> data = new ArrayList<T>();
	
	public ListProp(T... elements) {
		data.addAll(Arrays.asList(elements));
	}
	
	public List<T> all() {
		return Collections.unmodifiableList(data);
	}
	
	public void add(T element) {
		add(data.size(), element);
	}

	public void add(int position, T element) {
		data.add(position, element);
		for (ListObserver<T> o : mObservers)
			o.onElementAdded(element);
	}
	
	public void remove(int idx) {
		T elem = data.remove(idx);
		for (ListObserver<T> o : mObservers)
			o.onElementRemoved(elem);
	}
	
	public void remove(T elem) throws NoSuchElementException {
		int idx = data.indexOf(elem);
		if (idx >= 0)
			remove(idx);
		else
			throw new NoSuchElementException("This list doesn't contain "+elem);
	}
}
