package com.mmy.file.compute;

import java.util.List;

/**
 * �������ֻ�����ʹ������ĸ�ʽ�������
 * @author tarena-mmy
 *
 */
public class FlowPrinter {
	/**
	 * ���մ�ǰ�����˳�����List������ÿ���ֻ��ŵ�������ʹ�����
	 * @param list �����������������
	 */
	public void printFlowList(List<String> list){
		int temp = 1;
		for (int i = 0; i < list.size(); i++) {
			System.out.println("��������"+ temp++ +"�����ֻ���Ϊ"+list.get(i)+"\t������Ϊ��"+list.get(++i));
		}
	}

}
