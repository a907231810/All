package com.mmy.file.loader;

import java.io.File;

/**
 * �ļ��������ӿ�
 * 	��Windows��Linux����ϵͳ�ľ���ʵ�� 
 *  �û�ʹ��ʱʹ���Զ���������������������ļ��������Ĳ���ϵͳ���Զ�ѡ����ʵļ����������ļ�����
 * @author tarena-mmy
 *
 */
public interface FileLoader {
	
	/**
	 * ��ȡһ���ļ�����
	 * @return
	 */
	public File loadFile();

}
