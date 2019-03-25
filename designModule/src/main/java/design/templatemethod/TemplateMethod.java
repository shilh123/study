package design.templatemethod;

/**
 * 模板方法模式(template method)
 * 
 * @author Shilh
 *
 */
public class TemplateMethod {
	public static void main(String[] args) {
		String exp = "8+8";
		AbstractCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
		System.out.println(result);

		String exp1 = "8*8";
		AbstractCalculator cal1 = new Multpily();
		int result1 = cal1.calculate(exp1, "\\*");
		System.out.println(result1);
	}
}

abstract class AbstractCalculator {
	public final int calculate(String exp, String opt) {
		int array[] = split(exp, opt);
		return calculate(array[0], array[1]);
	}

	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	abstract protected int calculate(int i, int j);

	protected int[] split(String exp, String opt) {
		String array[] = exp.split(opt);
		int arrayInt[] = new int[2];
		arrayInt[0] = Integer.parseInt(array[0]);
		arrayInt[1] = Integer.parseInt(array[1]);
		return arrayInt;
	}
}

class Plus extends AbstractCalculator {

	@Override
	protected int calculate(int i, int j) {
		// TODO Auto-generated method stub
		return i + j;
	}

}

class Multpily extends AbstractCalculator {

	@Override
	protected int calculate(int i, int j) {
		// TODO Auto-generated method stub
		return i * j;
	}

}
