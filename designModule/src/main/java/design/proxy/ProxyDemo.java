package design.proxy;

public class ProxyDemo {
	public static void main(String[] args) {
		Proxy proxy = new ProxyClass1();
		proxy.method();
	}
}

interface Proxy {
	public void method();
}

class ProxyClass implements Proxy {

	public void method() {
		// TODO Auto-generated method stub
		System.out.println("111111111111");

	}
}

class ProxyClass1 implements Proxy {
	private ProxyClass proxyClass;

	public ProxyClass1() {
		this.proxyClass = new ProxyClass();
	}

	public void method() {
		// TODO Auto-generated method stub
		before();
		proxyClass.method();
		after();

	}

	private void after() {
		// TODO Auto-generated method stub
		System.out.println("this is after");
	}

	private void before() {
		// TODO Auto-generated method stub
		System.out.println("this is before");

	}

}