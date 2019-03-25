package design.interpreter;


/**
 *解释器模式（Interpreter） 解释器模式是我们暂时的最后一讲，
 * 一般主要应用在OOP开发中的编译器的开发中，所以适用面比较窄
 * 
 * @author Shilh
 *
 */
public class Interpreter {
	public static void main(String[] args) {
		int result = new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8));
		System.out.println(result);
	}
}

interface Expression {
	public int interpret(Context context);
}

class Plus implements Expression {

	public int interpret(Context context) {
		// TODO Auto-generated method stub
		return context.getNum1() + context.getNum2();
	}

}

class Minus implements Expression {

	public int interpret(Context context) {
		// TODO Auto-generated method stub
		return context.getNum1() - context.getNum2();
	}

}

class Context {
	private int num1;
	private int num2;

	public Context(int num1, int num2) {
		// TODO Auto-generated constructor stub
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

}
