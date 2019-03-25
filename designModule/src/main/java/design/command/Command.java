package design.command;

/**
 * 命令模式（Command） 命令模式很好理解， 举个例子，司令员下令让士兵去干件事情， 从整个事情的角度来考虑，司令员的作用是，发出口令，口令经过传递，
 * 传到了士兵耳朵里，士兵去执行。 这个过程好在，三者相互解耦，任何一方都不用去依赖其他人，只需要做好自己的事儿就行，
 * 司令员要的是结果，不会去关注到底士兵是怎么实现的
 * 
 * 
 * 命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开，熟悉Struts的同学应该知道，
 * Struts其实就是一种将请求和呈现分离的技术，其中必然涉及命令模式的思想
 * @author Shilh
 *
 */
public class Command {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		CommandInterface cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
}

interface CommandInterface {
	public void exe();
}

class MyCommand implements CommandInterface {
	private Receiver receiver;

	public MyCommand(Receiver receiver) {
		// TODO Auto-generated constructor stub
		this.receiver = receiver;
	}

	public void exe() {
		// TODO Auto-generated method stub
		receiver.action();

	}

}

class Receiver {
	public void action() {
		System.out.println("command received!");
	}
}

class Invoker {
	private CommandInterface command;

	public Invoker(CommandInterface command) {
		// TODO Auto-generated constructor stub
		this.command = command;
	}

	public void action() {
		command.exe();
	}
}
