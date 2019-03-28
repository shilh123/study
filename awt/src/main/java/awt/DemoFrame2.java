/** 
 * Project Name:awt 
 * File Name:Demo.java 
 * Package Name:awt 
 * Date:2019年3月28日上午9:14:33 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

/**
 * ClassName:Demo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月28日 上午9:14:33 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class DemoFrame2 {
	public static void main(String[] args) {
		Frame frame = new Frame("Demo Frame");
		// 对frame进行布局设置(设置成为2行1列
		frame.setLayout(new GridLayout(2, 1));
		Panel panel = new Panel();
		panel.setLayout(new BorderLayout());
		Button button1 = new Button("Button1");
		Button button2 = new Button("Button2");
		Button button3 = new Button("Button3");
		Button button4 = new Button("Button4");
		Button button5 = new Button("Button5");
		panel.add(button2, BorderLayout.EAST);
		panel.add(button1, BorderLayout.WEST);

		panel.add(button3, BorderLayout.CENTER);

		Panel panel2 = new Panel();
//		panel2.setLayout(new BorderLayout());
		panel2.add(button5, BorderLayout.EAST);
		panel2.add(button4, BorderLayout.CENTER);

		Panel panel3 = new Panel();
		panel3.setLayout(new GridLayout(2, 2));
		for (int i = 1; i <= 4; i++) {
			panel3.add(new Button("button" + i));
		}
		Button button6 = new Button("button6");
		Button button7 = new Button("button7");
		panel2.add(button6, BorderLayout.EAST);
		panel2.add(panel3, BorderLayout.CENTER);
		panel2.add(button7, BorderLayout.WEST);

		frame.add(panel);
		frame.add(panel2);
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
