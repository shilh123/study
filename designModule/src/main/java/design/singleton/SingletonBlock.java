package design.singleton;

/**
 * 
 * @author Shilh 汉模式 --- 静态代码块模式--线程不安全
 */
public class SingletonBlock {
	private static SingletonBlock singletonBlock = null;

	private SingletonBlock() {
	}

	static {
		singletonBlock = new SingletonBlock();
	}

	public static SingletonBlock getInstance() {
		return getInstance();
	}
}
