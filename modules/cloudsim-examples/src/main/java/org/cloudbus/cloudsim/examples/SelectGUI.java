
package org.cloudbus.cloudsim.examples;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class SelectGUI {
	String path1;
	static String path;
	static int example = 0;

	// static ParameterGUI par1;
	public static void main(String[] args) {
		setLookAndFeel();
		// final CloudSimExample1 c1=new CloudSimExample1();
		final CloudSimExample2 c2 = new CloudSimExample2();
		final CloudSimExample3 c3 = new CloudSimExample3();
		final CloudSimExample4 c4 = new CloudSimExample4();
		final CloudSimExample5 c5 = new CloudSimExample5();
		final CloudSimExample7 c7 = new CloudSimExample7();
		final CloudSimExample8 c8 = new CloudSimExample8();

		// 主窗体

		final JFrame f = new JFrame("CloudSim");
		/*
		 * f.setSize(600, 400); // 主窗体设置位置,窗口置于屏幕中央
		 * f.setLocationRelativeTo(null);
		 */
		f.setLayout(null);

		JLabel l1 = new JLabel("Welcome To CloudSim! ", JLabel.CENTER);
		// 文字颜色
		l1.setForeground(Color.black);
		l1.setBounds(160, 25, 280, 30);
		l1.setFont(new Font("宋体", Font.BOLD, 16));
		f.add(l1);

		String[] examples = new String[] { "CloudSimExample1", "CloudSimExample2", "CloudSimExample3",
				"CloudSimExample4", "CloudSimExample5", "CloudSimExample6", "CloudSimExample7", "CloudSimExample8" };

		JLabel l2 = new JLabel("CloudSim-Examples :", JLabel.LEFT);
		l2.setBounds(33, 170, 155, 30);
		f.add(l2);
		final JComboBox exa = new JComboBox(examples);
		exa.setBounds(200, 170, 155, 30);
		f.add(exa);

		JButton b1 = new JButton("确定");
		b1.setBounds(400, 170, 80, 30);// 指定位置和大小
		f.add(b1);

		String[] nexamples = new String[] { "NetworkExamples1", "NetworkExamples2", "NetworkExamples3",
				"NetworkExamples4" };

		JLabel l3 = new JLabel("NetworkExamples :", JLabel.LEFT);
		l3.setBounds(33, 120, 155, 30);
		f.add(l3);
		final JComboBox exa1 = new JComboBox(nexamples);
		exa1.setBounds(200, 120, 155, 30);
		f.add(exa1);

		JButton b2 = new JButton("确定");
		b2.setBounds(400, 120, 80, 30);// 指定位置和大小
		f.add(b2);

		JLabel l5 = new JLabel("Allocation Policy :", JLabel.LEFT);
		// 文字颜色
		l5.setBounds(33, 220, 155, 30);
		f.add(l5);
		JButton b5 = new JButton("选择调度策略");
		b5.setBounds(200, 220, 280, 30);// 指定位置和大小
		f.add(b5);

		JLabel l4 = new JLabel("File-To-Save-Results :", JLabel.LEFT);
		// 文字颜色
		l4.setForeground(Color.black);
		l4.setBounds(33, 70, 155, 30);
		f.add(l4);

		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return ".txt";
			}

			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".txt");
			}
		});

		JButton bOpen = new JButton("选择输出文件位置");

		// JButton bSave = new JButton("确定");
		bOpen.setBounds(200, 70, 280, 30);
		// bSave.setBounds(400, 70, 80, 30);
		f.add(bOpen);
		// f.add(bSave);
		JMenuBar menuBar = new JMenuBar();
		JMenu j1 = new JMenu("help");
		JMenuItem menuitem1 = new JMenuItem("cloudsim 介绍");
		JMenuItem menuitem2 = new JMenuItem("cloudsim 使用说明");
		j1.add(menuitem2);
		j1.add(menuitem1);
		menuBar.add(j1);
		/*
		 * JButton bh=new JButton("help"); bOpen.setBounds(200, 70, 155, 30);
		 * //初始化一个菜单栏 JMenuBar menuBar = new JMenuBar(); //初始化菜单 JMenu menu3 =
		 * new JMenu("help"); //把菜单添加到菜单栏 menuBar.add(menu3);
		 */
		menuitem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame aFrame = new JFrame("cloudsim 使用说明");
				aFrame.setSize(400, 300);
				aFrame.setLocation(200, 200);

				aFrame.setLayout(null);
				JTextArea aTextArea = new JTextArea("       "
						+ "Recently, cloud computing emerged as the leading technology for delivering reliable, secure, fault-tolerant, sustainable, and scalable computational services, which are presented as Software, Infrastructure, or Platform as services (SaaS, IaaS, PaaS). "
						+ "Moreover, these services may be offered in private data centers (private clouds),"
						+ " may be commercially offered for clients (public clouds), or yet it is possible that"
						+ " both public and private clouds are combined in hybrid clouds. These already wide ecosystem "
						+ "of cloud architectures, along with the increasing demand for energy-efficient IT technologies, "
						+ "demand timely, repeatable, and controllable methodologies for evaluation of algorithms, applications,"
						+ " and policies before actual development of cloud products. Because utilization of real testbeds limits"
						+ " the experiments to the scale of the testbed and makes the reproduction of results an extremely difficult"
						+ " undertaking, alternative approaches for testing and experimentation leverage development of new Cloud te"
						+ "nologies. A suitable alternative is the utilization of simulations tools, which open the "
						+ "possibility of evaluating the hypothesis prior to software development in an environment where"
						+ " one can reproduce tests. Specifically in the case of Cloud computing, where access to the "
						+ "infrastructure incurs payments in real currency, simulation-based approaches offer significant benefits,"
						+ " as it allows Cloud customers to test their services in repeatable and controllable environment free of cost,"
						+ " and to tune the performance bottlenecks before deploying on real Clouds. At the provider side, simulation"
						+ " environments allow evaluation of different kinds of resource leasing scenarios under varying load and pricing"
						+ " distributions. Such studies could aid the providers in optimizing the resource access cost with focus on "
						+ "improving profits. In the absence of such simulation platforms, Cloud customers and providers have to rely"
						+ " either on theoretical and imprecise evaluations, or on try-and-error approaches that lead to inefficient"
						+ " service performance and revenue generation. The primary objective of this project is to provide a generalized, "
						+ "and extensible simulation framework that enables seamless modeling, simulation, and experimentation of emerging "
						+ "Cloud computing infrastructures and application services. By using CloudSim, researchers and industry-based developers"
						+ " can focus on specific system design issues that they want to investigate, without getting concerned about the low level"
						+ " details related to Cloud-based infrastructures and services.");
				aTextArea.setLineWrap(true);
				JScrollPane sp = new JScrollPane(aTextArea);

				aFrame.setContentPane(sp);
				aFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

				aFrame.setVisible(true);
				// JScrollPane scroll = new JScrollPane(aTextArea);
				// 把定义的JTextArea放到JScrollPane里面去 

				// f.add(scroll, BorderLayout.CENTER);
				/*
				 * aTextArea.setLineWrap(true); //激活自动换行功能
				 * aTextArea.setWrapStyleWord(true); // 激活断行不断字功能
				 */
				// JPanel panelOutput;

				/*
				 * panelOutput = new JPanel(); panelOutput.add(new
				 * JScrollPane(aTextArea));
				 */
				// aTextArea.setPreferredSize(new Dimension(500, 300));
				/*
				 * aFrame.add(aTextArea); aFrame.setVisible(true);
				 */
			}
		});
		// 设置菜单栏
		f.setJMenuBar(menuBar);

		/*
		 * f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); f.setSize(250,
		 * 150); f.setLocationRelativeTo(null);
		 * 
		 * f.setVisible(true);
		 */

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 400);
		// 主窗体设置位置,窗口置于屏幕中央
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		bOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * JFileChooser chooser = new JFileChooser();
				 * chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 * chooser.showOpenDialog(null); path =
				 * chooser.getSelectedFile().getPath();
				 */
				// System.out.println(path);

				int returnVal = fc.showOpenDialog(f);
				File file = fc.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					// JOptionPane.showMessageDialog(f, "计划打开文件:" +
					// file.getAbsolutePath());
					path = file.getPath();
					System.out.println(path);
				}

			}
		});

		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PolicyGUI po1=new PolicyGUI();
				po1.main(null);
				// 选择策略frame
			}
		});

		/*
		 * bSave.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { int returnVal
		 * = fc.showSaveDialog(f); File file = fc.getSelectedFile(); if
		 * (returnVal == JFileChooser.APPROVE_OPTION) {
		 * JOptionPane.showMessageDialog(f, "计划保存到文件:" +
		 * file.getAbsolutePath()); } } });
		 */

		// 给按钮 增加 监听 addItemListener((ItemListener) new Sine());
		b1.addActionListener(new ActionListener() {
			// 当按钮被点击时，就会触发 ActionEvent事件
			// actionPerformed 方法就会被执行
			// 此处改为弹出与例子对应的调参界面
			public void actionPerformed(ActionEvent e) {
				if (exa.getSelectedItem().equals("CloudSimExample1")) {
					example = 1;

					// c1.main(null);
					// main方法由新弹出的窗口触发
					ParameterGUI par1 = new ParameterGUI();
					par1.main(null);
				}
				if (exa.getSelectedItem().equals("CloudSimExample2")) {
					

					example = 2;ParameterGUI par2 = new ParameterGUI();
					par2.main(null);
				}
				if (exa.getSelectedItem().equals("CloudSimExample3")) {
					c3.main(null);

				}
				if (exa.getSelectedItem().equals("CloudSimExample4")) {
					c4.main(null);
				}
				if (exa.getSelectedItem().equals("CloudSimExample5")) {
					c5.main(null);
				}
				if (exa.getSelectedItem().equals("CloudSimExample6")) {
				example = 6;	ParameterGUI p6 = new ParameterGUI();
					p6.main(null);
					
					// c6.main(null);
				}
				if (exa.getSelectedItem().equals("CloudSimExample7")) {
					c7.main(null);
				}
				if (exa.getSelectedItem().equals("CloudSimExample8")) {
					c8.main(null);
				}
				// case switch 选出前一个文本框内容比对，相等哪个就调用哪个
			}
		});

	}

	private static void setLookAndFeel() {

		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			// javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
			// handle exception
		}

	}

	public String getpath() {
		path1 = path;
		return path1;
	}
}
