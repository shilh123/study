package design.adapter;

/**
 * 
 * @author Shilh
 * 
 *         	有一个Source类，拥有一个方法，待适配，目标接口是Targetable，
 *         	通过Adapter类，将Source的功能扩展到Targetable里F
 */
public class AdapterClass {
	public static void main(String[] args) {
		Targetable targetable = new Adapter1();
		targetable.method1();
		targetable.method2();
	}
}

class Sources {
	public void method1() {
		System.out.println("this is original method!");
	}
}

interface Targetable {
	public void method1();

	public void method2();
}

class Adapter1 extends Sources implements Targetable {

	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is the targetable method!");

	}

}