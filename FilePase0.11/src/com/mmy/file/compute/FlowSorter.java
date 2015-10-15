package com.mmy.file.compute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ������������
 * 
 * @author tarena-mmy
 * 
 */
public class FlowSorter {

	/**
	 * �Դ���õĽ�����ݽ�������
	 * 
	 * @param map
	 *            ʢ�Ž�����ݵ�����
	 * @return ��һ��˳��Ľ��
	 */
	public List<String> sortFlowList(Map<String, Long> map) {
		// ����������е����ݷ��õ������У��ȴ���������
		long[] allFlows = new long[map.size()];
		int tmp = 0;
		for (String key : map.keySet()) {
			allFlows[tmp] = map.get(key);
			tmp++;
		}

		// ð������
		for (int i = 0; i < allFlows.length - 1; i++) {
			for (int j = 0; j < allFlows.length - i - 1; j++) {
				if (allFlows[j] < allFlows[j + 1]) {
					long temp = allFlows[j];
					allFlows[j] = allFlows[j + 1];
					allFlows[j + 1] = temp;
				}
			}
		}

		//��������Ľ��
		List<String> list = new ArrayList<>();
		for (int i = 0; i < allFlows.length; i++) {
			for (String key : map.keySet()) {
				if (allFlows[i] == map.get(key)) {
					list.add(key);
					list.add(allFlows[i] + "");
				}
			}
		}
		return list;
	}

}
