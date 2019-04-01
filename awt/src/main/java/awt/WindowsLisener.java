/** 
 * Project Name:awt 
 * File Name:WindowsLisener.java 
 * Package Name:awt 
 * Date:2019年3月29日上午10:23:54 
 * Copyright (c) 2019, chenzhou1025@126.com All Rights Reserved. 
 * 
 */

package awt;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
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

public class WindowsLisener {
	private TextArea textArea = new TextArea(6, 40);

	public static void main(String[] args) {
		new WindowsLisener().init();
	}

	public void init() {
		// 菜单
		Frame f = new Frame("Menu Test");
		MenuBar mb = new MenuBar();
		f.setMenuBar(mb);
		Menu file = new Menu("File");
		mb.add(file);
		MenuItem newItem = new MenuItem("New");
		file.add(newItem);
		MenuItem saveItem = new MenuItem("Save");
		file.add(saveItem);
		MenuItem exitItem = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_X));
		file.add(exitItem);
		Menu edit = new Menu("Edit");
		mb.add(edit);
		CheckboxMenuItem autoWrap = new CheckboxMenuItem("Auto wrap");
		edit.add(autoWrap);
		edit.addSeparator();
		MenuItem copyItem = new MenuItem("Copy");
		edit.add(copyItem);
		MenuItem pasteItem = new MenuItem("Paste");
		edit.add(pasteItem);
		edit.add(new MenuItem("-"));
		Menu format = new Menu("Format");
		edit.add(format);
		MenuItem commentItem = new MenuItem("Comment", new MenuShortcut(KeyEvent.VK_SLASH, true));
		format.add(commentItem);
		MenuItem cancelItem = new MenuItem("Cancel comment");
		format.add(cancelItem);
		TextArea ta = new TextArea(6, 40);
		f.add(ta);

		ActionListener menuListener = e -> {
			String cmd = e.getActionCommand();
			ta.append("Click '" + cmd + "' menu item.\n");
			if (cmd.equals("Exit")) {
				System.exit(0);
			}
		};
		newItem.addActionListener(menuListener);
		saveItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		// autoWrap.addActionListener(menuListener); // CheckboxMenuItem不触发ActionEvent！！
		copyItem.addActionListener(menuListener);
		pasteItem.addActionListener(menuListener);
		commentItem.addActionListener(menuListener);
		cancelItem.addActionListener(menuListener);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				// super.windowClosing(e);
				System.exit(0);
			}
		});

//		f.pack();
//		f.setVisible(true);

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
