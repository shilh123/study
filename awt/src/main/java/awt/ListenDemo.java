/** 
 * Project Name:awt 
 * File Name:ListenDemo.java 
 * Package Name:awt 
 * Date:2019年3月28日下午1:58:21 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.MonitorInfo;

/**
 * ClassName:ListenDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 下午1:58:21 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class ListenDemo {
	public static void main(String[] args) {
		new Frame2();
	}
}

class Frame2 extends Frame {

	/**
	 * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 1L;

	public Frame2() {
		// TODO Auto-generated constructor stub
		super("Event Listener");
		Button button1 = new Button("button");
		Button button2 = new Button("button");
		button1.setActionCommand("button1");
		button2.setActionCommand("button2");
		button1.addActionListener(new Monitor());
		button2.addActionListener(new Monitor());
		add(button1,BorderLayout.NORTH);
		add(button2,BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

}

class Monitor implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button button = (Button) e.getSource();
		String actionCommand = button.getActionCommand();
		if (actionCommand.equals("button1")) {
			System.out.println("you plus button1");
		} else if (actionCommand.contentEquals("button2")) {
			System.out.println("you plus button2");
		}
	}

}
