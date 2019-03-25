package design.responsibility;

/**
 * 责任链模式（Chain of Responsibility）
 * 此处强调一点就是，链接上的请求可以是一条链，可以是一个树，还可以是一个环，
 * 模式本身不约束这个，需要我们自己去实现，同时，在一个时刻，
 * 命令只允许由一个对象传给另一个对象，而不允许传给多个对象。
 * 
 * @author Shilh
 *
 */
public class Responsibility {
	public static void main(String[] args) {
		MyHandler h1 = new MyHandler("wanglin");
		MyHandler h2 = new MyHandler("zhanghao");
		MyHandler h3 = new MyHandler("liyuan");
		h1.setHandler(h2);
		h2.setHandler(h3);
		h1.operator();
	}
}

interface InterfaceHandler {
	public void operator();
}

abstract class AbstractHandler {
	private InterfaceHandler interfaceHandler;

	public InterfaceHandler getHandler() {
		return interfaceHandler;
	}

	public void setHandler(InterfaceHandler interfaceHandler) {
		this.interfaceHandler = interfaceHandler;
	}
}

class MyHandler extends AbstractHandler implements InterfaceHandler {
	private String name;

	public MyHandler(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public void operator() {
		// TODO Auto-generated method stub
		System.out.println(name + " hello!");
		if (getHandler() != null) {
			getHandler().operator();
		}
	}

}
