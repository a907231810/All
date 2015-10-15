package com.mmy.file.compute;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mmy.conf.Configurer;
import com.mmy.file.loader.AutoFileLoader;
import com.mmy.file.paser.FilePaser;

/**
 * �ļ����ݴ����� 
 * 	���ļ��������н������������ݽ�������
 * 
 * @author tarena-mmy
 * 
 */
public class FileCompute {

	/**
	 * 
	 * ����ÿ���ֻ��ŵ����������������������һ���µ�map������
	 * @param map ʢ�Ž�����ݵ�����
	 */
	public Map<String,Long> computeAllFlow(Map<String, List<String>> map) {
		//����һ�������������
		Map<String, Long> tempMap = new HashMap<String, Long>();
		//ѭ������ÿ���ֻ��ŵ�������
		for (String key : map.keySet()) {
			//�����ֻ��Ż�ȡ��Ӧ������������¼�ļ���
			List<String> list = map.get(key);
			//����һ����ʱ���������ڼ�¼ĳ���ֻ��ŵ�����������
			long allFlow = 0L;
			//�Լ��������м�¼�����ۼ�
			for (int i = 0; i < list.size(); i++) {
				//��Ϊ������¼�мȰ������������ְ�����������������ͨ�����Ž���ָ��
				String [] flows = list.get(i).split(",");
				//���ַ������͵�����������ͨ��long���͵İ�װ��ת����long���͵����������������ҽ����ۼ�
				allFlow = allFlow+Long.parseLong(flows[0])+Long.parseLong(flows[1]);
			}
			tempMap.put(key, allFlow);			
		}		
		return tempMap;
	}

	public static void main(String[] args) {
		FilePaser filePaser = new FilePaser();
		FileCompute compute = new FileCompute();
		File file = new AutoFileLoader(new Configurer()).getFile();
		Map<String, List<String>> map = filePaser.pase(file);
		System.out.println(map.size());
		Map<String,Long> sdfsdf = compute.computeAllFlow(map);
		
	}

}
