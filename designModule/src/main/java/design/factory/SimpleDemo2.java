
package design.factory;

/**
 * 
 * @author Shilh 多方法方法工厂类/静态工厂类
 */
public class SimpleDemo2 {
	public static void main(String[] args) {
		Senders senders = new Senders();
		Sender sender = senders.mailSender();
		sender.sender();
		Sender sender1 = senders.msmSender();
		sender1.sender();
		System.out.println("=============");
		SendersStatic sendersStatic = new SendersStatic();
		sendersStatic.mailSender().sender();
		sendersStatic.msmSender().sender();

	}
}

class Mails implements Sender {

	public void sender() {
		// TODO Auto-generated method stub
		System.out.println("this is many send mail function factory");
	}
}

class Smss implements Sender {

	public void sender() {
		// TODO Auto-generated method stub
		System.out.println("this is many send sms function factory");

	}

}

class Senders {
	public Sender mailSender() {
		return new Mails();
	}

	public Sender msmSender() {
		return new Smss();
	}
}

class SendersStatic {
	public static Sender mailSender() {
		return new Mails();
	}

	public static Sender msmSender() {
		return new Smss();
	}
}
