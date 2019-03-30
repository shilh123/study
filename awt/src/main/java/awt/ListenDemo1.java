/** 
 * Project Name:awt 
 * File Name:ListenDemo1.java 
 * Package Name:awt 
 * Date:2019年3月29日上午9:32:41 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClassName:ListenDemo1 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午9:32:41 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class ListenDemo1 {
	private Frame frame = new Frame();
	private TextArea textArea = new TextArea(6, 40);
	private Button b1 = new Button("button1");
	private Button b2 = new Button("button2");

	private void init() {
		FirstListener f1 = new FirstListener();
		b1.addActionListener(f1);
		FirstListener2 f2 = new FirstListener2();
		b2.addActionListener(f2);

		frame.add(textArea);
		Panel panel = new Panel();
		panel.add(b1);
		panel.add(b2);
		frame.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);

	}

	class FirstListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			textArea.append("第一个事件监听器被触发,事件源是:" + e.getActionCommand() + "\n");
		}
	}

	class FirstListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			textArea.append("第二个事件监听器被触发,事件源是:" + e.getActionCommand() + "\n");
		}
	}

	public static void main(String[] args) {
		new ListenDemo1().init();
	}
}
