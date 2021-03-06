package design.mediator;

/**
 * 
 * 
 * 
 中介者模式（Mediator）
 * 
 * 
 * 
 * 中介者模式也是用来降低类类之间的耦合的， 因为如果类类之间有依赖关系的话，不利于功能的拓展和维护，
 *  因为只要修改一个对象，其它关联的对象都得进行修改。
 * 如果使用中介者模式，只需关心和Mediator类的关系，具体类类之间的关系及调度交给Mediator就行， 
 * 有点像spring容器的作用
 * 
 * @author Shilh
 *
 */
public class Mediator {
	public static void main(String[] args) {
		MediatorInterface mediatorInterface = new MediatorClass();
		mediatorInterface.createMedator();
		mediatorInterface.workAll();
	}
}

interface MediatorInterface {
	public void createMedator();

	public void workAll();
}

class MediatorClass implements MediatorInterface {
	private User user1;
	private User user2;

	public User getUser() {
		return user1;
	}

	public User getUser2() {
		return user2;
	}

	public void createMedator() {
		// TODO Auto-generated method stub
		user1 = new User1(this);
		user2 = new User2(this);
	}

	public void workAll() {
		// TODO Auto-generated method stub
		user1.work();
		user2.work();
	}

}

abstract class User {
	private MediatorInterface mediatorInterface;

	public MediatorInterface getMethod() {
		return mediatorInterface;
	}

	public User(MediatorInterface mediatorInterface) {
		this.mediatorInterface = mediatorInterface;
	}

	public abstract void work();
}

class User1 extends User {

	public User1(MediatorInterface mediatorInterface) {
		super(mediatorInterface);
		// TODO Auto-generated constructor stub
	}

	public void work() {
		System.out.println("User1 ext");
	}

}

class User2 extends User {

	public User2(MediatorInterface mediatorInterface) {
		super(mediatorInterface);
		// TODO Auto-generated constructor stub
	}

	public void work() {
		System.out.println("User2 ext");
	}

}