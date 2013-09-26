package com.alibaba.icbu.solrsearch.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ����properties������
 * 
 * <br/>
 * 
 * 
 * 
 * 
 * @author peterchan
 * 
 * @version 0.1
 */

public class PropertiesMgr {

	private static Logger logger = LoggerFactory.getLogger(PropertiesMgr.class);

	private static Properties properties = new Properties();

	/**
	 * 
	 * װ�ز��������ļ�
	 */

	static {

		try {

			properties.load(PropertiesMgr.class.getClassLoader()
					.getResourceAsStream("solrclient.properties"));

		} catch (IOException e) {

			logger.error("û�з���solrclient.propertis�ļ�������������ļ��Ƿ�����ڸ�Ŀ¼��"
					+ PropertiesMgr.class.getClassLoader());

		}

	}

	/**
	 * 
	 * ���ݸ����ļ�ֵ�ҳ������ļ��Ķ�Ӧֵ
	 * 
	 * @param key
	 *            ��
	 * 
	 * @return ֵ
	 */

	public static String getProperty(String key) {

		return (String) properties.getProperty(key);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(PropertiesMgr.getProperty("solrServerHome"));

	}
}
