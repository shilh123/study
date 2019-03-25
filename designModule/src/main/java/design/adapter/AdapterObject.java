package design.adapter;

public class AdapterObject {
	public static void main(String[] args) {
		Sources sources = new Sources();
		Targetable targetable = new Wrapper(sources);
		targetable.method1();
		targetable.method2();
	}
}

class Wrapper implements Targetable {
	private Sources srouce;

	public Wrapper(Sources sources) {
		// TODO Auto-generated constructor stub
		this.srouce = sources;
	}

	public void method1() {
		// TODO Auto-generated method stub
		srouce.method1();
	}

	public void method2() {
		// TODO Auto-generated method stub

		System.out.println("this is the targetable method!");
	}

}