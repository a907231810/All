package com.mmy.conf;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.mmy.file.tool.FileTool;
import com.mmy.var.AllParameter;

/**
 * Ӧ�ó���������� �����Ǵ������ļ��϶�ȡ��Ϣ������ȡ������Ϣ�ŵ��ڴ����Թ���������ʹ��
 * 
 * @author tarena-mmy
 * 
 */
public class Configurer {

	// ����������ݵ�����
	public Map<String, String> configContext = new HashMap<>();

	// �������Ĺ��췽��
	public Configurer() {
		// ����һ�� �ļ����� ���������ļ��ĵ�ַ
		File confFile = new File(AllParameter.CONFFILEPATH);
		// �����ļ����ڵ�����½��������ļ������ݵĶ�ȡ
		if (confFile.exists()) {
			//��ȡ�ļ��е�����
			String allConf = FileTool.getFileContent(confFile);
			// �������ļ��е����ݰ��ջ��з��ָ�ɶ���
			String[] confs = allConf.split(System.lineSeparator());
			// ��ÿ�����ݶ����ա�=�������з֣����зֺ������������ֺ�ֵ����map��
			for (int i = 0; i < confs.length; i++) {
				//��һ���ַ�����#��ͷʱΪע�ͣ�����#��ͷ�Ĳ���������������Ϣ
				if (confs[i].indexOf("#")!=0) {					
					String[] temp = confs[i].split("=");
					//������������ֺ��������ֵȥ�����ߵĿո���ٷ��õ�map��
					configContext.put(temp[0].trim(),temp[1].trim());
				}
			}
		} else {
			System.out.println("�����ļ�������");
		}
	}
	
	

	public Map<String, String> getConfigContext() {
		return configContext;
	}



	public static void main(String[] args) {
//		Configurer conf = new Configurer();
//		System.out.println(conf.map.get("FileLoaderPath"));
//		System.out.println(conf.map.get("OS"));
		
		//�����﷨
		System.out.println("#dddddd".indexOf("#"));
	}
}
