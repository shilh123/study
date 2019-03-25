package design.singleton;

public class SingletonStaticInnerClass {
	private SingletonStaticInnerClass() {
	};

	private static class SingletonInstances {
		private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
	}

	public static SingletonStaticInnerClass getInstance() {
		return SingletonInstances.INSTANCE;
	}
}
