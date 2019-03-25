package design.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 观察者模式(observer)
 * 
 * @author Shilh
 *
 */
public class Observer {
	public static void main(String[] args) {
		Subject sub = new MySubject();
		sub.add(new ObserverClass1());
		sub.add(new ObserverClass2());
		sub.operation();
	}
}

interface ObserverInterface {
	public void update();
}

class ObserverClass1 implements ObserverInterface {

	public void update() {
		// TODO Auto-generated method stub
		System.out.println("observer1 has received");
	}

}

class ObserverClass2 implements ObserverInterface {

	public void update() {
		// TODO Auto-generated method stub
		System.out.println("observer2 has received");
	}

}

interface Subject {
	public void add(ObserverInterface observerInterface);

	public void del(ObserverInterface observerInterface);

	public void notifyObserver();

	public void operation();
}

abstract class AbstractSubject implements Subject {
	private Vector<ObserverInterface> vector = new Vector<ObserverInterface>();

	public void add(ObserverInterface observerInterface) {
		vector.add(observerInterface);
	}

	public void del(ObserverInterface observerInterface) {
		vector.remove(observerInterface);
	}

	public void notifyObserver() {
		Enumeration<ObserverInterface> enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			enumeration.nextElement().update();
		}
	}
}

class MySubject extends AbstractSubject {

	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("===========");
		notifyObserver();
	}

}