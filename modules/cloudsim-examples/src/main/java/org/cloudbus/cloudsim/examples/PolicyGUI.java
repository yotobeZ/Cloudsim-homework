package org.cloudbus.cloudsim.examples;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PolicyGUI {

	/*final static CloudSimExample1 c1 = new CloudSimExample1();
	
	final static CloudSimExample2 c2=new CloudSimExample2();
	final static CloudSimExample3 c3=new CloudSimExample3();
	final static CloudSimExample4 c4=new CloudSimExample4();
	final static CloudSimExample5 c5=new CloudSimExample5();
	final static CloudSimExample6 c6 = new CloudSimExample6();*/
	
	static int x1, x2, x3;
	//static boolean a = false, b = false, c = false;

	
	static int example=0,policy=0,policy1=0,policy2=0;

	
	public static void main(String[] args) {
		JFrame f1 = new JFrame("Scheduling Policy");
		f1.setLayout(null);

		 String[] examples = new String[] { "CloudSimExample1",  "CloudSimExample2", "CloudSimExample3", 
	        		"CloudSimExample4", "CloudSimExample5", "CloudSimExample6", "CloudSimExample7", "CloudSimExample8" };
	        
	        JLabel l2 = new JLabel("CloudSim-Examples :",JLabel.LEFT);
	        l2.setBounds(33,50,155,30);
	        f1.add(l2);
	        final JComboBox exa = new JComboBox(examples);
	        exa.setBounds(200, 50,155, 30);        
	        f1.add(exa);
	        
	       final JCheckBox bCheckBox3 = new JCheckBox("默认分配策略");
			// 设置 为 默认被选中
			bCheckBox3.setSelected(true);
			bCheckBox3.setBounds(50, 100, 130, 30);
	        
		final JCheckBox bCheckBox = new JCheckBox("顺序分配策略");
		bCheckBox.setBounds(50, 150, 130, 30);

		final JCheckBox bCheckBox2 = new JCheckBox("贪心策略");
		bCheckBox2.setBounds(50, 200, 130, 30);
		// 判断 是否 被 选中
		// System.out.println(bCheckBox2.isSelected());
		f1.add(bCheckBox3);
		f1.add(bCheckBox);
		f1.add(bCheckBox2);
		
        JButton b1 = new JButton("RUN");
		b1.setBounds(210, 250, 80, 30);// 指定位置和大小
		// f2.add(b1);
		f1.add(b1, BorderLayout.SOUTH);

		 b1.addActionListener(new ActionListener() {
	            // 当按钮被点击时，就会触发 ActionEvent事件
	           // actionPerformed 方法就会被执行
	    	   //此处改为弹出与例子对应的调参界面
	           public void actionPerformed(ActionEvent e) {
	           	/*if(exa.getSelectedItem().equals("CloudSimExample1")){
	           		
	           		CloudSimExample1.main(null);
	           		//c1.main(null);
	        //main方法由新弹出的窗口触发
	           		example=1;
	       
	           	}
	           	if(exa.getSelectedItem().equals("CloudSimExample2")){
	           		ParameterGUI p1=new ParameterGUI();
	           		p1.main(null);
	           		example=2;
	           	}
	           	if(exa.getSelectedItem().equals("CloudSimExample3")){
	           		c3.main(null);
	           		
	           	}
	           	if(exa.getSelectedItem().equals("CloudSimExample4")){
	           		c4.main(null);
	           	}
	           	if(exa.getSelectedItem().equals("CloudSimExample5")){
	           		c5.main(null);
	           	}*/
	           	if(exa.getSelectedItem().equals("CloudSimExample6")){
	           		if (bCheckBox3.isSelected()) {
						policy=1;
						//CloudSimExample6.main(null);
						
					}
	           		if (bCheckBox.isSelected()) {
	           			policy1=1;
						//a = true;
						//CloudSimExample6.main(null);
						//a=false;
					}
					if (bCheckBox2.isSelected()) {
						policy2=1;
						//b = true;
						//CloudSimExample6.main(null);
						//b=false;
					}
					LineCharts lc=new LineCharts(null);
					lc.main(null);
					policy=0;policy1=0;policy2=0;
	           		
	           	}
	           	
	              //case switch 选出前一个文本框内容比对，相等哪个就调用哪个 
	           }
	       });
		

		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setSize(500, 380);
		// 主窗体设置位置,窗口置于屏幕中央
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);

	}

}
