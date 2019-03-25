package design.iterator;

/**
 * 迭代子模式（Iterator）
 * 
 * @author Shilh
 *
 */
public class IteratorDemo {
	public static void main(String[] args) {
		String[] string = { "Q", "A", "P", "B", "C", "E", "F", "Z", "Y", "W" };
		Collection collection = new MyCollection(string);
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}

interface Collection {
	public Iterator iterator();

	public Object get(int i);

	public int size();
}

interface Iterator {
	public Object previous();

	public Object next();

	public boolean hasNext();

	public Object first();
}

class MyCollection implements Collection {
	private String[] string;

	public MyCollection(String[] string) {
		// TODO Auto-generated constructor stub
		this.string = string;
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new Myiterator(this);
	}

	public Object get(int i) {
		// TODO Auto-generated method stub
		return string[i];
	}

	public int size() {
		// TODO Auto-generated method stub
		return string.length;
	}

}

class Myiterator implements Iterator {
	private Collection collection;
	private int pos = -1;

	public Myiterator(Collection collection) {
		// TODO Auto-generated constructor stub
		this.collection = collection;
	}

	public Object previous() {
		// TODO Auto-generated method stub
		if (pos > 0) {
			pos--;
		}
		return collection.get(pos);
	}

	public Object next() {
		// TODO Auto-generated method stub
		if (pos < collection.size() - 1) {
			pos++;
		}
		return collection.get(pos);
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (pos < collection.size() - 1)
			return true;
		else
			return false;
	}

	public Object first() {
		// TODO Auto-generated method stub
		pos = 0;
		return collection.get(pos);
	}

}