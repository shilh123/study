package design.factory;

/**
 * 
 * @author Shilh
 *
 *         简单工厂模式 普通类型工厂模式
 *
 */
public class SimpleDemo1 {
	public static void main(String[] args) {
		SenderFactory senderFactory = new SenderFactory();
		Sender sender = senderFactory.senderFactory("mail");
		sender.sender();
		Sender sender1 = senderFactory.senderFactory("sms");
		sender1.sender();
	}
}

/**
 * 
 * @author Shilh 创建公共发送接口
 */
interface Sender {
	public void sender();
}

/**
 * 
 * @author Shilh 创建发送邮件类实现sender接口
 */
class Mail implements Sender {

	public void sender() {
		// TODO Auto-generated method stub
		System.out.println("This is send mail");
	}

}

/**
 * 
 * @author Shilh 创建发送短信类实现sender接口
 */
class Sms implements Sender {

	public void sender() {
		// TODO Auto-generated method stub
		System.out.println("This is send sms");
	}

}

/**
 * 
 * @author Shilh 创建工厂类
 */
class SenderFactory {
	public Sender senderFactory(String type) {
		if ("mail".equals(type)) {
			return new Mail();
		} else if ("sms".equals(type)) {
			return new Sms();
		} else {
			return null;
		}

	}
}
