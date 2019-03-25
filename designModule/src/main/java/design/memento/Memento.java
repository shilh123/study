package design.memento;

/**
 * 备忘录模式（Memento）
 * 
 * @author Shilh
 *
 */
public class Memento {
	public static void main(String[] args) {
		Original original = new Original("egg");
		Storage storage = new Storage(original.createMemento());
		System.out.println("init status:" + original.getValue());
		original.setValue("niu");
		System.out.println("modified status:" + original.getValue());
		original.restoreMemento(storage.getMementoDemo());
		System.out.println("�ָ���״̬:" + original.getValue());
	}
}

class Original {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Original(String value) {
		super();
		this.value = value;
	}

	public MementoDemo createMemento() {
		return new MementoDemo(value);
	}

	public void restoreMemento(MementoDemo mementoDemo) {
		this.value = mementoDemo.getValue();
	}

}

class MementoDemo {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MementoDemo(String value) {
		super();
		this.value = value;
	}

}

class Storage {
	private MementoDemo mementoDemo;

	public MementoDemo getMementoDemo() {
		return mementoDemo;
	}

	public void setMementoDemo(MementoDemo mementoDemo) {
		this.mementoDemo = mementoDemo;
	}

	public Storage(MementoDemo mementoDemo) {
		super();
		this.mementoDemo = mementoDemo;
	}

}
