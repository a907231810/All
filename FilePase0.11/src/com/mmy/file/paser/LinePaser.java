package com.mmy.file.paser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * �н�����
 * 	���������ı������õ�map������
 * 		���map�������Ѿ���������ͬ�ֻ��ŵ�ֵ����ӵ��Ǹ��ֻ������ڵļ�����
 * 		���map������û���Ǹ��ֻ��ž��½�һ��������ͬ�ֻ���һ��Ž�������
 * @author tarena-mmy
 *
 */
public class LinePaser {
	
	/**
	 * �������ݴ�����
	 * @param line �������������
	 * @param map ��Ŵ�����ɺ�Ľ��������
	 */
	public void linePase(String line,Map<String, List<String>> map){
		//��һ���ļ����ն��Ž��зָ�
		String[] strs= line.split(",");
		//��ʱ��¼һ���ֻ���
		String tempPhoneNumber = strs[0];
		//��ʱ��¼һ���ֻ��ŵ�������������
		List<String> list;
		//���map��������������ֻ���Ϊkey�ļ�ֵ�Ծͽ����ϵļ����ó��������������е�������ӵ�������
		//Ȼ���map���Ƴ�������ֻ���Ϊkey�ļ�ֵ�ԣ��������һ���ֻ���Ϊkey�������µļ���Ϊvalue�ļ�ֵ��
		if (map.containsKey(tempPhoneNumber)) {
			list = map.get(tempPhoneNumber);
			list.add(strs[1]+","+strs[2]);
			map.remove(tempPhoneNumber);
			map.put(tempPhoneNumber, list);
		}else{//���map������û��������ֻ���Ϊkey�ļ�ֵ�ԣ����½�һ�����ϣ���������ӵ������У�Ȼ���ֻ��źͼ�����ӵ�map��
			List<String> flows = new ArrayList<String>();
			flows.add(strs[1]+","+strs[2]);
			map.put(tempPhoneNumber,flows);
		}
	}

}
 