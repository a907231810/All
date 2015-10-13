package com.mmy.file.tool;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

import com.mmy.conf.Configurer;
import com.mmy.var.AllParameter;

/**
 * �ļ�������
 * 
 * @author tarena-mmy
 * 
 */
public class FileTool {
	/**
	 * ��ȡָ���ļ��е�����
	 * 
	 * @param file
	 *            �������ļ�
	 * @return �ļ����ݵ��ַ���������ʽ
	 */
	public static String getFileContent(File file) {
		// ��ʾ�ڸ���Ŀ¼�£�ָ�����ļ�ȷʵ����
		if (file.exists()) {
			try {
				FileReader reader = new FileReader(file);
				char[] chars = new char[(int) file.length()];
				reader.read(chars);
				return new String(chars);
			} catch (Exception e) {
				System.out.println("��ȡ�ļ����ݳ����쳣��" + e.getMessage());
				return "";
			}
		}
		System.out.println("ָ��Ŀ¼���ļ�������");
		return "";
	}

	/**
	 * �Լ���������������ݵĲ����ļ� ���������ļ���ָ���ĵ�ַ�����ɺõĲ������ݷ��ý���ָ�����ļ���
	 * 
	 * @param conf
	 */
	public static void makeTestFile(Configurer conf) {
		//��¼���������ļ��Ŀ�ʼʱ�� ����1970��1��1�յ����ڵĺ���ֵ
		Long start = System.currentTimeMillis();
		
		//���������л�ȡҪ������ļ����ڵĵ�ַ
		String filePath = conf.getConfigContext().get(AllParameter.LOADFILEPATH);
		//����������ַ����һ��file����
		File file = new File(filePath);
		//���������ַ���ļ��Ѵ��ھͽ���ɾ��
		if (file.exists()) {
			//���ļ�ɾ��
			file.delete();
		} 
		
		//�����ļ�д�������������Լ����ɺõĲ�������д������ļ���
		try {
			FileWriter writer = new FileWriter(file);
			String temp = makeData(Long.parseLong(conf.getConfigContext().get(AllParameter.LINENUMS)));
			writer.write(temp);
			writer.close();
		} catch (Exception e) {
			System.out.println("д���ļ��쳣��"+e.getMessage());
		}
		
		//��¼���������ļ��Ľ���ʱ�� ����1970��1��1�յ����ڵĺ���ֵ
		Long stop = System.currentTimeMillis();
		//������������ļ������ѵ���ʱ��
		System.out.println("���������ļ�һ����ʱ��"+(stop-start)+"����");
	}

	/**
	 * ���������ļ��е�ָ������������������
	 * @param lineNums �����ļ���ָ������������ ����һ������һ��
	 * @return �������ݷ�����һ���һ�������ַ���
	 */
	private static String makeData(long lineNums) {
		//��¼�����������ݵĿ�ʼʱ�� ����1970��1��1�յ����ڵĺ���ֵ
		Long start = System.currentTimeMillis();
		//�����ֻ�������
		long[] phonenumbers = { 15012345671l, 15012345672l, 15012345673l,
				15012345674l, 15012345675l, 15012345676l, 15012345677l,
				15012345678l, 15012345679l, 15012345670l };
		//����һ������������� �Ե�ǰϵͳʱ�����ֵΪ����
		Random random = new Random(System.currentTimeMillis());
		//����һ��StringBuffer����
		StringBuffer buffer = new StringBuffer();
		//�ڴ����������ݵ�ʱ��������ʾ�û���ǰ�Ĵ�������
		long temp =1;
		if (lineNums>=10) {
			temp = lineNums/10;
		}
		//ѭ�������������ݲ�׷�ӵ�StringBuffer������
		for (int i = 0; i < lineNums; i++) {
			buffer.append(phonenumbers[random.nextInt(10)]+","+random.nextInt(512)+","+random.nextInt(512)+System.lineSeparator());
			if (i%temp==0) {
				System.out.println("�Ѿ�������"+i+"������");
			}
		}
		//��¼�����������ݵĽ���ʱ�� ����1970��1��1�յ����ڵĺ���ֵ
		Long stop = System.currentTimeMillis();
		//������������������ķѵ���ʱ��
		System.out.println("����"+lineNums+"����������һ����ʱ��"+(stop-start)+"����");
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		Configurer configurer = new Configurer();
		makeTestFile(configurer);
	}
	
}
