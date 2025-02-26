import java.util.Arrays;

public class List<T> implements ListInterface<T> {
	private T [] list;
	private int numOfEntries;
	private boolean integrityOK;
	private static final int default_capacity = 25;
	private static final int max_capacity = 1000;
	
	public List() {
		this(default_capacity);
	}
	
	public List(int initialCapacity) {
		integrityOK = false;
		
		if (initialCapacity < default_capacity) {
			initialCapacity = default_capacity;
		}else {
			checkCapacity(initialCapacity);
		}
		
		@SuppressWarnings("unchecked")
		T[] tempList = (T[])new Object[initialCapacity];
		list = tempList;
		numOfEntries = 0;
		integrityOK = true;
	}

	@Override
	public void add(T newEntry) {
		// TODO Auto-generated method stub
		ensureCapacity();
		list[numOfEntries] = newEntry;
		numOfEntries++;
		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		// TODO Auto-generated method stub
		if((newPosition >= 1) && (newPosition <= numOfEntries +1)) {
			if(newPosition <= numOfEntries) {
				makeRoom(newPosition);
				list[newPosition -1] = newEntry;
				numOfEntries++;
			}else {
				throw new IndexOutOfBoundsException("Is out of bounds");
			}
		}
	}

	@Override
	public T remove(int givenPosition) {
		if ((givenPosition >= 1)&&(givenPosition <= numOfEntries)) {
		T result = list[givenPosition];
		
		if(givenPosition < numOfEntries) {
			removeGap(givenPosition);
			list[numOfEntries] = null;
			numOfEntries--;
			
		}
		return result;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal position");
		}
	}

	@Override
	public void clear() {
		while (!isEmpty()) {
			remove(numOfEntries);
		}
		
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return numOfEntries;
	}

	@Override
	public boolean replace(int givenPosition, T newEntry) {
		boolean isReplaced = true;
		if((givenPosition >= 1) && (givenPosition <= numOfEntries)) {
			list[givenPosition - 1] = newEntry;
		}else {
			isReplaced = false;
		}
		return isReplaced;
	}

	@Override
	public T getEntry(int givenPosition) {
		T result = null;
		if((givenPosition >= 1)&& (givenPosition <= numOfEntries)) {
			result = list[givenPosition - 1];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numOfEntries == 0;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numOfEntries];
		for (int index = 0; index < numOfEntries; index++) {
			result[index] = list[index + 1];
		}
		return result;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		int index = 1;
		while(!found && (index <= numOfEntries)) {
			if(anEntry.equals(list[index])) {
				found = true;
				index++;
			}
		}
		return found;
	}
	private void makeRoom(int givenPosition) {
		int newIndex = givenPosition;
		int lastIndex = numOfEntries;
		for(int index = lastIndex; index >= newIndex; index--) {
			list[index + 1 ] = list[index];
		}
		
	}
	private void ensureCapacity() {
		int capacity = list.length -1;
		if(numOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list, newCapacity + 1);
		}
	}
	private void removeGap(int givenPosition) {
		int removeIndex = givenPosition;
		for(int index = removeIndex; index < numOfEntries; index++) {
			list[index] = list[index + 1];
		}
	}
	
	
	private void checkCapacity(int capacity) {
		if(capacity > max_capacity) {
			throw new IllegalStateException("Capacity exeeds "+ max_capacity);
		}
	}
}
