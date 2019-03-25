package design.bridge;

public class Bridge {
	public static void main(String[] args) {
		BridgeAbstract bridgeAbstract = new BridgeClass3();
		BridgeInterface bridgeInterface = new BridgeClass1();
		BridgeInterface bridgeInterface2 = new BridgeClass2();
		bridgeAbstract.setBridge(bridgeInterface);
		bridgeAbstract.method();
		bridgeAbstract.setBridge(bridgeInterface2);
		bridgeInterface2.method();

	}
}

interface BridgeInterface {
	public void method();
}

class BridgeClass1 implements BridgeInterface {

	public void method() {
		// TODO Auto-generated method stub
		System.out.println("This is frist sub!");
	}
}

class BridgeClass2 implements BridgeInterface {

	public void method() {
		// TODO Auto-generated method stub
		System.out.println("This is second sub!");
	}

}

abstract class BridgeAbstract {
	private BridgeInterface bridgeInterface;

	public void method() {
		bridgeInterface.method();
	}

	public BridgeInterface getBridge() {
		return bridgeInterface;
	}

	public void setBridge(BridgeInterface bridgeInterface) {
		this.bridgeInterface = bridgeInterface;
	}

}

class BridgeClass3 extends BridgeAbstract {
	public void method() {
		getBridge().method();
	}
}
