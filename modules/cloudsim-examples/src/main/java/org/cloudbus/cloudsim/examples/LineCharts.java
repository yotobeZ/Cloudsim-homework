package org.cloudbus.cloudsim.examples;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class LineCharts extends JFrame {
	/**
	*
	*/

	//static PolicyGUI pol1;
	static long testlength = 0;
	ChartPanel frame1;
	static double time0 = 0;
	//static double sum = 0, sum1 = 0, sum2 = 0;
	static double[] time = new double[100];
	static double[] time1 = new double[100];
	static double[] time2 = new double[100];
	// time为默认策略不同任务长度运行时间数组，time1为顺序策略，time2为贪心策略
	static String[] type = new String[20];

	static int i = 0, j = 0, k = 0;
	// static int[] xxx;
	static boolean a = false, b = false, c = false;
	static DefaultCategoryDataset linedataset;
	private static final long serialVersionUID = 1L;
	//final static CloudSimExample6 c6 = new CloudSimExample6();

	public LineCharts(String s) {
		super(s);
		setContentPane(createDemoLine());
	}

	public static void main(String[] args) {
		LineCharts fjc = new LineCharts("折线图");
		fjc.pack();
		RefineryUtilities.centerFrameOnScreen(fjc);
		fjc.setSize(800, 600);
		fjc.setVisible(true);
	linedataset=null;
		fjc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}

	// 生成显示图表的面板
	public static JPanel createDemoLine() {
		JFreeChart jfreechart = createChart(createDataset());
		return new ChartPanel(jfreechart);
		
	}

	// 生成图表主对象JFreeChart
	public static JFreeChart createChart(DefaultCategoryDataset linedataset) {
		// 定义图表对象
		JFreeChart chart = ChartFactory.createLineChart("不同调度策略时间消耗曲线图", // 折线图名称
				"任务长度", // 横坐标名称
				"时间（秒）", // 纵坐标名称
				linedataset, // 数据
				PlotOrientation.VERTICAL, // 水平显示图像
				true, // include legend
				true, // tooltips
				false // urls
		);
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);
		CategoryPlot plot = chart.getCategoryPlot();

		CategoryAxis categoryAxis = plot.getDomainAxis();
		//  横轴上的 Lable 45度倾斜
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

		plot.setRangeGridlinesVisible(true); // 是否显示格子线
		plot.setBackgroundAlpha(0.3f); // 设置背景透明度
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		rangeAxis.setUpperMargin(0.20);
		rangeAxis.setLabelAngle(Math.PI / 2.0);
		return chart;
	}

	// 生成数据
	public static DefaultCategoryDataset createDataset() {

		if (PolicyGUI.policy == 1) {
i=0;
			for (testlength = 1000; testlength <= 20000; testlength += 1000) {
				/*
				 * for (int x = 0; x < 100; x++) { CloudSimExample6.main(null);
				 * time0 = c6.m; sum += time0;
				 * 
				 * } time[i] = sum / 100; i++; }
				 */
				CloudSimExample6.main(null);
				time[i] = CloudSimExample6.getMaxTime();
				i++;
			}
		//	PolicyGUI.policy = 0;
		}
		if (PolicyGUI.policy1 == 1) {
			a = true;j=0;
			for (testlength = 1000; testlength <= 20000; testlength += 1000) {
				/*
				 * for (int x = 0; x < 100; x++) { a = true;
				 * CloudSimExample6.main(null); time0 = c6.m; sum1 += time0;
				 * 
				 * }
				 * 
				 * time1[j] = sum1 / 100; j++; }
				 */

				CloudSimExample6.main(null);
				time1[j] = CloudSimExample6.getMaxTime();
				j++;
			}
			a = false;
			//PolicyGUI.policy1 = 0;
		}
		if (PolicyGUI.policy2 == 1) {
			b = true;k=0;
			for (testlength = 1000; testlength <= 20000; testlength += 1000) {
				/*
				 * for (int x = 0; x < 100; x++) { b = true;
				 * CloudSimExample6.main(null); time0 = c6.m; sum2 += time0;
				 * 
				 * } time2[k] = sum2 / 100; k++; }
				 */

				CloudSimExample6.main(null);
				time2[k] = CloudSimExample6.getMaxTime();
				k++;
			}
			b = false;
		//	PolicyGUI.policy2 = 0;
		}
		linedataset = new DefaultCategoryDataset();
		// 各曲线名称
		String series1 = "默认调度策略";
		String series2 = "顺序分配策略";
		String series3 = "贪心策略";
		// 横轴名称(列名称)
		/*
		 * type[0]="0"; xxx[0]=0; for(int i=1;i<21;i++){ xxx[i]=xxx[i-1]+1000;
		 * type[i]="xxx[i]"; }
		 */
		type[0] = "1000";
		type[1] = "2000";
		type[2] = "3000";
		type[3] = "4000";
		type[4] = "5000";
		type[5] = "6000";
		type[6] = "7000";
		type[7] = "8000";
		type[8] = "9000";
		type[9] = "10000";
		type[10] = "11000";
		type[11] = "12000";
		type[12] = "13000";
		type[13] = "14000";
		type[14] = "15000";
		type[15] = "16000";
		type[16] = "17000";
		type[17] = "18000";
		type[18] = "19000";
		type[19] = "20000";

		if (time != null) {
			for (int i = 0; i < 20; i++) {
				linedataset.addValue(time[i], series1, type[i]);
			}
			
		}
		time=new double[20];
		if (time1 != null) {
			for (int j = 0; j < 20; j++) {
				linedataset.addValue(time1[j], series2, type[j]);
			}
			
		}
		time1=new double[20];
		if (time2 != null) {
			for (int k = 0; k < 20; k++) {
				linedataset.addValue(time2[k], series3, type[k]);
			}
			
		}
		time2=new double[20];
		return linedataset;
		
	}

}
