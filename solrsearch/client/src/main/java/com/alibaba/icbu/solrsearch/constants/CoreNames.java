package com.alibaba.icbu.solrsearch.constants;

/**
 * <pre>
 * desc: 
 * created: Mar 5, 2013 2:32:42 PM
 * author: xiangfeng
 * todo: 
 * history:
 * </pre>
 */
public enum CoreNames {
	/**
	 * default
	 */
	CORE1("core1"), CORE2("core2"), CORE3("core3");

	private String coreName;

	private CoreNames(String coreName) {
		this.coreName = coreName;
	}

	public String getCoreName() {
		return coreName;
	}

}
