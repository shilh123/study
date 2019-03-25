package design.adapter;

/**
 * 
 * @author Shilh  接口的适配器模式
 */
public class AdapterInterface {
	public static void main(String[] args) {
		AdapterIn1 adapterIn1 = new AdapterIn1();
		adapterIn1.method1();
		adapterIn1.method2();

		AdapterIn adapterIn2 = new AdapterIn();
		adapterIn2.method1();
		adapterIn2.method2();
	}
}

interface AdapterInter {
	public void method1();

	public void method2();
}

abstract class Wrappter2 implements AdapterInter {
	public void method1() {
	}

	public void method2() {
	}
}

class AdapterIn extends Wrappter2 {
	public void method1() {
		System.out.println("the sourceable interface's first Sub1!");
	}
}

class AdapterIn1 extends Wrappter2 {
	public void method2() {
		System.out.println("the sourceable interface's second Sub2!");
	}
}
