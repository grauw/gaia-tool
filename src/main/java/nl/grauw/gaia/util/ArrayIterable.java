package nl.grauw.gaia.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Read-only array Iterable.
 */
public class ArrayIterable<T> implements Iterable<T> {
	
	private T[] array;
	int start;
	int end;
	
	/**
	 * Constructs an array iterable.
	 * @param array The array to iterate over.
	 */
	public ArrayIterable(T[] array) {
		this(array, 0);
	}
	
	/**
	 * Constructs an array iterable.
	 * @param array The array to iterate over.
	 */
	public ArrayIterable(T[] array, int start) {
		this(array, start, Integer.MAX_VALUE);
	}
	
	/**
	 * Constructs an array iterable.
	 * @param array The array to iterate over.
	 * @param start Iteration start position (inclusive).
	 * @param end Iteration stop position (exclusive).
	 */
	public ArrayIterable(T[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = Math.min(array.length, end);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ArrayIterator();
	}
	
	/**
	 * Iterator for the array.
	 */
	private class ArrayIterator implements Iterator<T> {
		
		private int position = start;
		
		@Override
		public boolean hasNext() {
			return position < end;
		}
		
		@Override
		public T next() {
			if (position >= end)
				throw new NoSuchElementException();
			return array[position++];
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
