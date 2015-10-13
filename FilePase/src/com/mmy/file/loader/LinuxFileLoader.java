package com.mmy.file.loader;

import java.io.File;

/**
 * Linux����ϵͳ�ļ�������
 *   �ļ���ַ�е�б��Ϊ������б�ܣ�����Ҫ�滻
 * @author tarena-mmy
 *
 */
public class LinuxFileLoader implements FileLoader{
	
	/**
	 * Ҫ���ص��ļ��ĵ�ַ
	 */
	private String filePath;
	
	public LinuxFileLoader(String filePath){
		this.filePath = filePath;
	}

	@Override
	public File loadFile() {
		return new File(filePath);
	}

}
