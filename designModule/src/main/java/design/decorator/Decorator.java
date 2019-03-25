package design.decorator;


public class Decorator {
	public static void main(String[] args) {
		DecoratorInter decoratorInter = new DecoratorClass1();
		DecoratorInter decoratorInter2 = new DecoratorClass2(decoratorInter);
		decoratorInter2.method();
	}
}

interface DecoratorInter {
	public void method();
}

class DecoratorClass1 implements DecoratorInter {

	public void method() {
		// TODO Auto-generated method stub
		System.out.println("this is original class");
	}

}

class DecoratorClass2 implements DecoratorInter {
	private DecoratorInter decoratorClass;

	public DecoratorClass2(DecoratorInter decoratorClass) {
		// TODO Auto-generated constructor stub
		this.decoratorClass = decoratorClass;
	}

	public void method() {
		// TODO Auto-generated method stub
		System.out.println("111111111111111");
		decoratorClass.method();
		System.out.println("2222222222222222");

	}

}