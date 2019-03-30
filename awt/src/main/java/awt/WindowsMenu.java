/** 
 * Project Name:awt 
 * File Name:WindowsLisener.java 
 * Package Name:awt 
 * Date:2019年3月29日上午10:23:54 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package awt;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

/**
 * ClassName:WindowsLisener <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2019年3月29日 上午10:23:54 <br/>
 * 
 * @author Shilh
 * @version
 * @since JDK 1.8
 * @see
 */

public class WindowsMenu {
	private Frame f = new Frame("测试");
	private TextArea textArea = new TextArea(6, 40);
	private MenuBar menuBar = new MenuBar();
	
	public static void main(String[] args) {
		new WindowsMenu().init();
	}

	public void init() {
		//菜单
		f.setMenuBar(menuBar);
		Menu file = new Menu("File");
		
		MenuItem newItem = new MenuItem("New");
		file.add(newItem);
		MenuItem saveItem = new MenuItem("Save");
		file.add(saveItem);
		MenuItem exitItem = new MenuItem("Exit");
		file.add(exitItem);
		
		
		f.addWindowListener((WindowListener) new MyListener());
		f.add(textArea);
		f.pack();
		f.setVisible(true);
	}

	class MyListener implements WindowListener {

		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			textArea.append("用户关闭窗口!\n");
			System.exit(0);

		}

		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			textArea.append("窗口被关闭!\n");
		}

		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

			textArea.append("窗口最小化!\n");
		}

		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub

			textArea.append("窗口被恢复！\n");
		}

		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			textArea.append("窗口被激活");
		}

		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			textArea.append("窗口失去焦点!\n");

		}

	}

}
