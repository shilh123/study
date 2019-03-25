package design.strategy;

import sun.launcher.resources.launcher;

/**
 * 策略模式（strategy）
 * 
 * @author Shilh
 *
 */
public class Strategy {
	public static void main(String[] args) {
		String exp = "2+8";
		ICalculator cal = new Plus();
		int result = cal.calculate(exp);
		System.out.println(result);
		String exp2 = "2*8";
		ICalculator cal1 = new Multiply();
		int result1 = cal1.calculate(exp2);
		System.out.println(result1);

		String exp3 = "2-8";
		ICalculator cal3 = new Minus();
		int result2 = cal3.calculate(exp3);
		System.out.println(result2);
	}
}

/**
 * 
 * @author Shilh 创建一个同意接口
 */

interface ICalculator {
	public int calculate(String exp);
}

abstract class AbstractCalculator {
	public int[] split(String exp, String opt) {
		String array[] = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}

/**
 * 
 * @author Shilh 创建三个实现类
 */
class Plus extends AbstractCalculator implements ICalculator {

	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}

}

class Minus extends AbstractCalculator implements ICalculator {

	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "-");
		return arrayInt[0] - arrayInt[1];
	}

}

class Multiply extends AbstractCalculator implements ICalculator {

	public int calculate(String exp) {
		// TODO Auto-generated method stub
		int arrayInt[] = split(exp, "\\*");

		return arrayInt[0] * arrayInt[1];
	}

}