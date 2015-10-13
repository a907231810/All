package com.mmy.file.loader;

import java.io.File;

/**
 * Winodws����ϵͳ���ļ�������
 *   �ļ�·���еĵ�б����Ҫת����˫б��
 * @author tarena-mmy
 *
 */
public class WindowsFileLoader implements FileLoader{

	/**
	 * Ҫ���ص��ļ��ĵ�ַ
	 */
	private String filePath;
	
	public WindowsFileLoader(String filePath){
		this.filePath = filePath;
	}
	
	/**
	 * ��windows����ϵͳ�е�Ŀ¼�ϵĵ�"\"ת�����ܱ�javaʶ���˫"\\"
	 */
	public File loadFile() {
		return new File(filePath.replace("\\", "\\\\"));
	}

}
