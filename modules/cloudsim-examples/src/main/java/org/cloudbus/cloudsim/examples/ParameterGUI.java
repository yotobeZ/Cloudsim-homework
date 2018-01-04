package org.cloudbus.cloudsim.examples;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class ParameterGUI {
	final static CloudSimExample1 c1=new CloudSimExample1();
	final static CloudSimExample2 c2=new CloudSimExample2();
	//final static CloudSimExample6 c6=new CloudSimExample6();
	static int x1,x2,x3;
	static SelectGUI s1;
	//final static CloudSimExample6 c6=new CloudSimExample6();
	public static void main(String[] args) {
	final JFrame f2 = new JFrame("CloudSim-Example-Parameter");
	f2.setLayout(null);
	
   
   JLabel l6 = new JLabel("CloudSim-Example-Parameter",JLabel.CENTER);
   //文字颜色
   l6.setForeground(Color.black);
   l6.setBounds(160, 25, 250, 30);
   l6.setFont(new Font("宋体", Font.BOLD , 16));
   f2.add(l6);
 JLabel l2 = new JLabel("VM-mips :",JLabel.LEFT);
   l2.setBounds(50,70,155,30);
   f2.add(l2);
   final TextField px1=new TextField(10);
   px1.setBounds(200,70,120,30);
   f2.add(px1);
   
  JLabel l3 = new JLabel("Cloudlet-length :",JLabel.LEFT);
   l3.setBounds(50,120,155,30);
   f2.add(l3); 
   final TextField px2=new TextField(10);
   px2.setBounds(200,120,120,30);
   f2.add(px2);
   
  /* JLabel l4 = new JLabel("Ram(vm&host) :",JLabel.LEFT);
   l4.setBounds(50,170,155,30);
   f2.add(l4);
   final TextField px3=new TextField(10);
   px3.setBounds(200,170,120,30);
   f2.add(px3);*/
   
  JButton b1 = new JButton("RUN");        
   b1.setBounds(210, 220, 80, 30);// 指定位置和大小
  // f2.add(b1);
   f2.add(b1,BorderLayout.SOUTH);
   b1.addActionListener(new ActionListener() {          
       public void actionPerformed(ActionEvent e) { 
    	   //获取上一界面下拉栏的值，判断与哪个相等再运行 
    	 x1=Integer.parseInt(px1.getText());  
    	 x2=Integer.parseInt(px2.getText()); 
    	// x3=Integer.parseInt(px3.getText()); 
    	 f2.setVisible(false); 
     switch (SelectGUI.example){
    	 case 1:CloudSimExample1.main(null);break;
    	 case 2:CloudSimExample2.main(null);break;
    	case 6:CloudSimExample6.main(null);break;
    	// default: ;
    	   }
        
       
       }
   });

   f2. setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE  );
	 f2.setSize(500, 380);
// 主窗体设置位置,窗口置于屏幕中央
	f2.setLocationRelativeTo(null); 
   f2.setVisible(true);
   
}
	/* public int parameterh() 
	 	{
	     	  
	     	   return x1;
	        }   */
}