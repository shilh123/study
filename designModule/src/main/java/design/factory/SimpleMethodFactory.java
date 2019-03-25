package design.factory;

/**
 * 
 * @author Shilh 工厂方法模式
 */

public class SimpleMethodFactory {
	public static void main(String[] args) {
		Proider proider = new ProiderMail();
		Proider proider1 = new ProiderSms();
		Sender sender = proider.produce();
		Sender sender1 = proider1.produce();
		sender.sender();
		sender1.sender();
	}
}

/**
 * 
 * @author Shilh 两个实现sender方法类
 */
class SendMail implements Sender {

	public void sender() {
		// TODO Auto-generated method stub
		System.out.println("this is many send mail function factory");
	}
}

class SendSms implements Sender {

	public void sender() {
		// TODO Auto-generated method stub
		System.out.println("this is many send sms function factory");

	}

}

/**
 * 
 * @author Shilh <br/>
 *         <p>
 *         建立一个工厂接口
 *         </p>
 */
interface Proider {
	public Sender produce();
}

class ProiderMail implements Proider {

	public Sender produce() {
		// TODO Auto-generated method stub
		return new SendMail();
	}

}

class ProiderSms implements Proider {

	public Sender produce() {
		// TODO Auto-generated method stub
		return new SendSms();
	}

}
