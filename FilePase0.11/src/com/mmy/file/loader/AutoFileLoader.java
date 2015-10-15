package com.mmy.file.loader;

import java.io.File;

import com.mmy.conf.Configurer;
import com.mmy.var.AllParameter;

/**
 * �Զ����ļ�������
 * 	���������ļ������õĲ���ϵͳ����ѡ���ʺϲ���ϵͳ���ļ�������
 * @author tarena-mmy
 *
 */
public class AutoFileLoader {
	
	//�����ļ������õĲ���ϵͳ
	private String OS;
	//�����ļ�����Ҫ���ص������ļ��ĵ�ַ
	private String filePath;
	
	public AutoFileLoader(Configurer configurer){
		this.OS = configurer.getConfigContext().get(AllParameter.OS);
		this.filePath = configurer.getConfigContext().get(AllParameter.LOADFILEPATH);
	}
	
	/**
	 * ���������ļ������õĵ�ַ�Ͳ���ϵͳ��ȡ��ͬ���͵��ļ������������ļ�����
	 * @return
	 */
	public File getFile(){
		switch (OS) {
		case AllParameter.OS_WINDOWS:
			return new WindowsFileLoader(filePath).loadFile();
			
		case AllParameter.OS_Linux:
			return new LinuxFileLoader(filePath).loadFile();

		default:
			return null;
		}
	}

}
