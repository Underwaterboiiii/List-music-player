
public interface ListInterface<T> {
	public void add(T newEntry);
	public void add(int newPosition, T newEntry);
	public T remove (int givenPosition);
	public void clear();
	public int getLength();
	public boolean replace(int givenPosition, T newEntry);
	public T getEntry(int givenPosition);
	public boolean isEmpty();
	public T[] toArray();
	public boolean contains(T anEntry);
}
