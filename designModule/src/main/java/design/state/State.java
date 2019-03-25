package design.state;

public class State {
	public static void main(String[] args) {
		StateDemo state = new StateDemo();
		Context context = new Context(state);
		state.setValue("state1");
		context.method();

		state.setValue("state2");
		context.method();
	}
}

class StateDemo {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void method1() {
		System.out.println("111111111111");
	}

	public void method2() {
		System.out.println("2222222222222");
	}
}

class Context {
	private StateDemo stateDemo;

	public Context(StateDemo stateDemo) {
		super();
		this.stateDemo = stateDemo;
	}

	public StateDemo getStateDemo() {
		return stateDemo;
	}

	public void setStateDemo(StateDemo stateDemo) {
		this.stateDemo = stateDemo;
	}

	public void method() {
		if (stateDemo.getValue().equals("state1")) {
			stateDemo.method1();
		} else if (stateDemo.getValue().equals("state2")) {
			stateDemo.method2();
		}
	}
}
