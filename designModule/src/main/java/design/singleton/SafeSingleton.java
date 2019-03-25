package design.singleton;
/**
 * 
 * @author Shilh
 *	饿汉式单例模式  线程安全模式(同步代码块)
 */
public class SafeSingleton {
	private static SafeSingleton instance = null;

	private SafeSingleton() {
	}

	public static SafeSingleton getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new SafeSingleton();
				}
			}
		}
		return instance;
	}

}
