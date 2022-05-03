package javarush.tasks.java_core.level_7.task_13_general_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Solution implements List<Long>{

	private List<Long> original = new ArrayList<Long>();
	
	public Solution() {

	}

	@Override
	public synchronized boolean add(Long e) {
		return original.add(e);
	}

	@Override
	public synchronized void add(int arg0, Long arg1) {
		original.add(arg0, arg1);
	}

	@Override
	public synchronized boolean addAll(Collection<? extends Long> c) {
		return original.addAll(c);
	}

	@Override
	public synchronized boolean addAll(int arg0, Collection<? extends Long> arg1) {
		return original.addAll(arg0, arg1);
	}

	@Override
	public synchronized void clear() {
		original.clear();
		
	}

	@Override
	public synchronized boolean contains(Object o) {
		return original.contains(o);
	}

	@Override
	public synchronized boolean containsAll(Collection<?> c) {
		return original.containsAll(c);
	}

	@Override
	public synchronized Long get(int index) {
		return original.get(index);
	}

	@Override
	public synchronized int indexOf(Object o) {
		return original.indexOf(o);
	}

	@Override
	public synchronized boolean isEmpty() {
		return original.isEmpty();
	}

	@Override
	public synchronized Iterator<Long> iterator() {
		return original.iterator();
	}

	@Override
	public synchronized int lastIndexOf(Object o) {
		return original.lastIndexOf(o);
	}

	@Override
	public synchronized ListIterator<Long> listIterator() {
		return original.listIterator();
	}

	@Override
	public synchronized ListIterator<Long> listIterator(int index) {
		return original.listIterator(index);
	}

	@Override
	public synchronized boolean remove(Object o) {
		return original.remove(o);
	}

	@Override
	public synchronized Long remove(int index) {
		return original.remove(index);
	}

	@Override
	public synchronized boolean removeAll(Collection<?> c) {
		return original.removeAll(c);
	}

	@Override
	public synchronized boolean retainAll(Collection<?> c) {
		return original.retainAll(c);
	}

	@Override
	public synchronized Long set(int arg0, Long arg1) {
		return original.set(arg0, arg1);
	}

	@Override
	public synchronized int size() {
		return original.size();
	}

	@Override
	public synchronized List<Long> subList(int arg0, int arg1) {
		return original.subList(arg0, arg1);
	}

	@Override
	public synchronized Object[] toArray() {
		return original.toArray();
	}

	@Override
	public synchronized  <T> T[] toArray(T[] a) {
		return original.toArray(a);
	}

}
