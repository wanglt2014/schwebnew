package com.et59.cus.tools;

/**
 * 在调用service之前设置数据源 DbContextHolder.setDbType("2"); <jee:jndi-lookup id="ds0"
 * jndi-name="jdbc/ds0"/> <jee:jndi-lookup id="ds1" jndi-name="jdbc/ds1"/>
 * <jee:jndi-lookup id="ds2" jndi-name="jdbc/ds2"/> <map
 * key-type="java.lang.String"> <entry key="0" value-ref="ds0"/> <entry key="1"
 * value-ref="ds1"/> <entry key="2" value-ref="ds2"/> </map>
 */
public class DbContextHolder {
	@SuppressWarnings("rawtypes")
	private static final ThreadLocal contextHolder = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public static void setDbType(String dbType) {
		contextHolder.set(dbType);
	}

	public static String getDbType() {
		return (String) contextHolder.get();
	}

	public static void clearDbType() {
		contextHolder.remove();
	}
}
