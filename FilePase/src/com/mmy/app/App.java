package com.mmy.app;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.mmy.conf.Configurer;
import com.mmy.file.compute.FileCompute;
import com.mmy.file.compute.FlowPrinter;
import com.mmy.file.compute.FlowSorter;
import com.mmy.file.loader.AutoFileLoader;
import com.mmy.file.paser.FilePaser;

/**
 * Ӧ�ó���������
 * @author tarena-mmy
 *
 */
public class App {
	
	public static void main(String[] args) {
		System.out.println("Ӧ�ó���ʼ����");
		long start = System.currentTimeMillis();
		//��������������ȡ�����ļ�����
		Configurer configurer = new Configurer();
		
//		//ʹ���ļ������������������ϵ���Ϣ�Զ�����������ļ�
//		FileTool.makeTestFile(configurer);
		
		//���������������Զ������������������ļ������õĲ���ϵͳ�Զ����������ļ�
		AutoFileLoader fileLoader = new AutoFileLoader(configurer);
		File dataFile = fileLoader.getFile();
		
		//�����ļ�������,��������õĲ����ļ�
		FilePaser filePaser = new FilePaser();
		Map<String, List<String>> map = filePaser.pase(dataFile);
		
		//�����ļ������ݴ�����,��������Ľ��
		FileCompute fileCompute = new FileCompute();
		Map<String, Long> tempMap = fileCompute.computeAllFlow(map);
		
		//������������������������õĽ����������
		FlowSorter flowSorter = new FlowSorter();
//		Map<String, Long> resultMap = flowSorter.sortFlow(tempMap);
		List<String> list = flowSorter.sortFlowList(tempMap);
		
		//�����������������������õĽ���������
		FlowPrinter flowPrinter = new FlowPrinter();
//		flowPrinter.printFlow(resultMap);
		flowPrinter.printFlowList(list);
		long stop = System.currentTimeMillis();
		System.out.println("�ܺ�ʱ��"+(stop-start)+"����");
	}

}
