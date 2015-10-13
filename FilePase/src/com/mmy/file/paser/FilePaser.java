package com.mmy.file.paser;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mmy.conf.Configurer;
import com.mmy.file.loader.AutoFileLoader;
import com.mmy.file.tool.FileTool;


/**
 * �ļ������� ������hadoop��mapper
 * 	�����ݽ�������õ�map�����У�����ͬ�ֻ��ŵ����ݷ�����һ��
 * @author tarena-mmy
 *
 */
public class FilePaser {
	//�����н���������
	LinePaser linePaser = new LinePaser();	
	/**
	 * ����һ��ָ���Ĵ洢��Ӳ���ϵ��ļ�
	 * @param file ָ�����ļ�
	 * @return һ���ڴ��е�map���͵����������������а�����Ӳ���ϵ��ļ��е����ݣ�
	 */
	public Map<String, List<String>> pase(File file){
		//ͨ��FileTool�������ȡ�ļ��е����ݣ��ַ�����ʽ��
		String fileContent = FileTool.getFileContent(file);
		//���ļ��е����ݰ����зָ������зָ�����������һ���ַ���������
		String[] strs = fileContent.split(System.lineSeparator());
		//����һ��map���͵���������������ʢ�Ž����õ����ݣ������ļ��������������ݴ���
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		//�����н�����ѭ�������ַ��������е����ݣ����õ�map������
		for (int i = 0; i < strs.length; i++) {
			linePaser.linePase(strs[i], map);
		}
		return map;
	}
	
	public static void main(String[] args) {
		File file = new AutoFileLoader(new Configurer()).getFile();
		FilePaser filePaser = new FilePaser();
		filePaser.pase(file);
	}
}
