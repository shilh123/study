package design.singleton;
/**
 * 
 * @author Shilh
 *	��������ģʽ(��̬����) -----�̲߳���ȫ
 */
public class SingletonConstant {
	private static SingletonConstant instance = null;

	private SingletonConstant() {
		// TODO Auto-generated constructor stub
	}

	public static SingletonConstant getInstance() {
		if (instance == null)
			instance = new SingletonConstant();
		return instance;
	}

	public void getName() {
		System.out.println("I name is Singleton");
	}
}
