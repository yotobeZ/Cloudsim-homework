package org.cloudbus.cloudsim.examples;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/*
 * Title:        CloudSim Toolkit
 * Description:  CloudSim (Cloud Simulation) Toolkit for Modeling and Simulation
 *               of Clouds
 * Licence:      GPL - http://www.gnu.org/copyleft/gpl.html
 *
 * Copyright (c) 2009, The University of Melbourne, Australia
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.DatacenterBroker;
import org.cloudbus.cloudsim.DatacenterCharacteristics;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.Pe;
import org.cloudbus.cloudsim.Storage;
import org.cloudbus.cloudsim.UtilizationModel;
import org.cloudbus.cloudsim.UtilizationModelFull;
import org.cloudbus.cloudsim.Vm;
import org.cloudbus.cloudsim.VmAllocationPolicySimple;
import org.cloudbus.cloudsim.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.provisioners.BwProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.provisioners.RamProvisionerSimple;

/**
 * A simple example showing how to create a datacenter with one host and run one
 * cloudlet on it.
 */
public class CloudSimExample1 {

	/** The cloudlet list. */
	private static List<Cloudlet> cloudletList;
//云任务队列
	/** The vmlist. */
	private static List<Vm> vmlist;
//虚拟机队列
	/**
	 * Creates main() to run this example.
	 *
	 * @param args
	 *            the args
	 */
	@SuppressWarnings("unused")
	static SelectGUI s1 = new SelectGUI();
	static ParameterGUI p1 = new ParameterGUI();
	//static int iram=p1.x3;;
//声明两个界面类的对象，实现方法和变量的调用
	public static void main(String[] args) {

		Log.printLine("Starting CloudSimExample1...");
//主程序开始运行
		try {
			// First step: Initialize the CloudSim package. It should be called
			// before creating any entities.
			//在创建新数据中心的实例之前必须初始化cloudsim包
			int num_user = 1; // number of cloud users
			//云用户的数量=1，因为建立的仅有一台主机的数据中心******************************************
			Calendar calendar = Calendar.getInstance();
			//调用日历
			boolean trace_flag = false; // mean trace events
			// mean trace events//设置标志位，也就是故障错误标志位，先设置为0
           

			// Initialize the CloudSim library
			//初始化cloudsim库***********************************************************
			CloudSim.init(num_user, calendar, trace_flag);

			// Second step: Create Datacenters
			// Datacenters are the resource providers in CloudSim. We need at
			// list one of them to run a CloudSim simulation
			//第二步：建立数据中心，在CloudSim中数据中心是资源提供者，我们需要至少一个来运行CloudSim的仿真
			Datacenter datacenter0 = createDatacenter("Datacenter_0");
			//创建一个名为"Datacenter_0"的数据中心datacenter0****************************************


			// Third step: Create Broker
			 //第三步：创建代理，Broker是经纪人的意思，这里意为代理

			DatacenterBroker broker = createBroker();
			int brokerId = broker.getId();
			//代理标识号

			// Fourth step: Create one virtual machine
			//第四步：创建一台虚拟机
			vmlist = new ArrayList<Vm>();
			//首先需要有一个虚拟机队列来存储创建的虚拟机

			// VM description
			// 对虚拟机进行参数描述，声明，包括虚拟机ID、
			// MIPS（million instructions per second
			// 百万条指令/秒，即运算能力）、镜像大小、虚拟机内存大小、带宽、CPU数量、虚拟机名称。
			int vmid = 0;
			int mips = p1.x1;
			// int mips = 1000;
			// ***********************************************************1
			long size = 10000; // image size (MB) 10000
			int ram = 512; // vm memory (MB)512
			long bw = 1000;
			int pesNumber = 1; // number of cpus
			String vmm = "Xen"; // VMM name

			// create VM
			Vm vm = new Vm(vmid, brokerId, mips, pesNumber, ram, bw, size, vmm, new CloudletSchedulerTimeShared());

			// add the VM to the vmList
			//将创建好的虚拟机添加到虚拟机队列中去
			vmlist.add(vm);

			// submit vm list to the broker
			//将虚拟机队列提交给代理
			broker.submitVmList(vmlist);

			// Fifth step: Create one Cloudlet
			//第五步：创建一个云任务，过程同上创建虚拟机，先定义一个队列，然后声明参数，创建之后添加到队列中，然后将云任务队列提交给代理
			cloudletList = new ArrayList<Cloudlet>();

			// Cloudlet properties
			// 声明云任务参数：任务ID、长度、文件大小、输出大小、使用模式。
			int id = 0;
			long length = p1.x2;//400000
			long fileSize = 300;// 300
			long outputSize = 300;// 300
			UtilizationModel utilizationModel = new UtilizationModelFull();
// a Cloudlet always utilize all the available CPU capacity.
			Cloudlet cloudlet = new Cloudlet(id, length, pesNumber, fileSize, outputSize, utilizationModel,
					utilizationModel, utilizationModel);
			cloudlet.setUserId(brokerId);
			cloudlet.setVmId(vmid);

			// add the cloudlet to the list
			cloudletList.add(cloudlet);

			// submit cloudlet list to the broker
			broker.submitCloudletList(cloudletList);

			// Sixth step: Starts the simulation
			CloudSim.startSimulation();

			CloudSim.stopSimulation();

			// Final step: Print results when simulation is over
			//最后一步：当仿真结束时打印结果（结果包括：云任务队列、）
			List<Cloudlet> newList = broker.getCloudletReceivedList();
			printCloudletList(newList);

			Log.printLine("CloudSimExample1 finished!");
			Log.printLine("张诗惠 2015213514");
		} catch (Exception e) {
			e.printStackTrace();
			Log.printLine("Unwanted errors happen");
		}
	}

	/**
	 * Creates the datacenter.
	 *
	 * @param name
	 *            the name
	 *
	 * @return the datacenter
	 */
	private static Datacenter createDatacenter(String name) {

		// Here are the steps needed to create a PowerDatacenter:
		// 1. We need to create a list to store
		// our machine
		//这里是创建数据中心的步骤：
        //1、我们需要创建一个队列来存储我们的机器
		List<Host> hostList = new ArrayList<Host>();

		// 2. A Machine contains one or more PEs or CPUs/Cores.
		// In this example, it will have only one core.
		//2、一台机器包括一个或多个内核或CPU
		List<Pe> peList = new ArrayList<Pe>();
		//创建一个队列进行存储，并定义了MIPS。

		int mips = 1000;// 1000

		// 3. Create PEs and add these into a list.
		//3、创建PE，并将它们添加到队列中去，pe（PEid，MIPS速度）
		peList.add(new Pe(0, new PeProvisionerSimple(mips))); // need to store
																// Pe id and
																// MIPS Rating

		// 4. Create Host with its id and list of PEs and add them to the list
		// of machines
		//4、用ID和PE列表创建host，并将其添加到机器列表中
		// 下面是声明了host的参数：hostID、内存、存储容量、带宽。
		int hostId = 0;
		int ram = 1024; // host memory (MB)
		long storage = 1000000; // host storage
		int bw = 10000;// 10000

		hostList.add(new Host(hostId, new RamProvisionerSimple(ram), new BwProvisionerSimple(bw), storage, peList,
				new VmSchedulerTimeShared(peList))); // This is our machine
//机器创建完成
		// 5. Create a DatacenterCharacteristics object that stores the
		// properties of a data center: architecture, OS, list of
		// Machines, allocation policy: time- or space-shared, time zone
		// and its price (G$/Pe time unit).
		// 创建数据中心特征对象来存储数据中心的参数特征：结构、操作系统、机器列表、分配策略（时间或空间共享）、
		// 时间区域、花费（以G和pe为单位，Pe是CPU单元）、内存花费、存储操作花费、带宽花费
		String arch = "x86"; // system architecture
		String os = "Linux"; // operating system
		String vmm = "Xen";
		double time_zone = 10.0; // time zone this resource located
		double cost = 3.0; // the cost of using processing in this resource
		double costPerMem = 0.05; // the cost of using memory in this resource
		double costPerStorage = 0.001; // the cost of using storage in this
										// resource0.001
		double costPerBw = 0.0; // the cost of using bw in this resource
		LinkedList<Storage> storageList = new LinkedList<Storage>(); // we are
																		// not
																		// adding
																		// SAN
		// devices by now

		DatacenterCharacteristics characteristics = new DatacenterCharacteristics(arch, os, vmm, hostList, time_zone,
				cost, costPerMem, costPerStorage, costPerBw);

		// 6. Finally, we need to create a PowerDatacenter object.
		Datacenter datacenter = null;
		try {
			datacenter = new Datacenter(name, characteristics, new VmAllocationPolicySimple(hostList), storageList, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return datacenter;
	}

	// We strongly encourage users to develop their own broker policies, to
	// submit vms and cloudlets according
	// to the specific rules of the simulated scenario
	/**
	 * Creates the broker.
	 *
	 * @return the datacenter broker
	 */
	//创建代理
	private static DatacenterBroker createBroker() {
		DatacenterBroker broker = null;
		try {
			broker = new DatacenterBroker("Broker");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return broker;
	}

	/**
	 * Prints the Cloudlet objects.
	 *
	 * @param list
	 *            list of Cloudlets
	 */
	//创建云任务列表
	private static void printCloudletList(List<Cloudlet> list) {
		int size = list.size();
		Cloudlet cloudlet;

		String indent = "    ";
		Log.printLine();
		try {
			File writename = new File(s1.getpath());
			// File writename = new File("E:\Desktop\大三
			// 上学期学习资料\云计算\cloudsim\result.txt");
			writename.createNewFile();//  创建新文件  
			BufferedWriter out = new BufferedWriter(new FileWriter(writename, true));
			out.write("\r\n========== OUTPUT ==========\r\n");//  \r\n即为换行  
			out.write("Cloudlet ID" + indent + "STATUS" + indent + "Data center ID" + indent + "VM ID" + indent + "Time"
					+ indent + "Start Time" + indent + "Finish Time");
			DecimalFormat dft = new DecimalFormat("###.##");
			for (int i = 0; i < size; i++) {
				cloudlet = list.get(i);
				out.write("\r\n" + indent + indent + cloudlet.getCloudletId() + indent + indent + indent);

				if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS) {
					out.write("SUCCESS");

					out.write(indent + indent + cloudlet.getResourceId() + indent + indent + indent + indent + indent
							+ cloudlet.getVmId() + indent + indent + indent + dft.format(cloudlet.getActualCPUTime())
							+ indent + indent + dft.format(cloudlet.getExecStartTime()) + indent + indent + indent
							+ dft.format(cloudlet.getFinishTime()) + "\r\n");
				}
			}
			out.flush();//  把缓存区内容压入文件  
			out.close();//  最后记得关闭文件  

		} catch (Exception e) {
			e.printStackTrace();
		}

		Log.printLine("========== OUTPUT ==========");
		Log.printLine("Cloudlet ID" + indent + "STATUS" + indent + "Data center ID" + indent + "VM ID" + indent + "Time"
				+ indent + "Start Time" + indent + "Finish Time");
		//输出参数：云任务ID、状态、数据中心ID、虚拟机ID、时间、开始时间、结束时间

		//循环整个云任务列表，输出十进制格式的参数数据

		DecimalFormat dft = new DecimalFormat("###.##");
		for (int i = 0; i < size; i++) {
			cloudlet = list.get(i);
			Log.print(indent + cloudlet.getCloudletId() + indent + indent);

			if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS) {
				Log.print("SUCCESS");

				Log.printLine(indent + indent + cloudlet.getResourceId() + indent + indent + indent + cloudlet.getVmId()
						+ indent + indent + dft.format(cloudlet.getActualCPUTime()) + indent + indent
						+ dft.format(cloudlet.getExecStartTime()) + indent + indent
						+ dft.format(cloudlet.getFinishTime()));
			}
		}

	}
}/*
	 * Log.printLine("========== OUTPUT ==========");
	 * Log.printLine("Cloudlet ID" + indent + "STATUS" + indent +
	 * "Data center ID" + indent + "VM ID" + indent + "Time" + indent +
	 * "Start Time" + indent + "Finish Time");
	 * 
	 * DecimalFormat dft = new DecimalFormat("###.##"); for (int i = 0; i <
	 * size; i++) { cloudlet = list.get(i); Log.print(indent +
	 * cloudlet.getCloudletId() + indent + indent);
	 * 
	 * if (cloudlet.getCloudletStatus() == Cloudlet.SUCCESS) {
	 * Log.print("SUCCESS");
	 * 
	 * Log.printLine(indent + indent + cloudlet.getResourceId() + indent +
	 * indent + indent + cloudlet.getVmId() + indent + indent +
	 * dft.format(cloudlet.getActualCPUTime()) + indent + indent +
	 * dft.format(cloudlet.getExecStartTime()) + indent + indent +
	 * dft.format(cloudlet.getFinishTime())); } }
	 */
