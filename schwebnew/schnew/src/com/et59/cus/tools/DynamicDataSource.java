package com.et59.cus.tools;    
   
import java.sql.SQLFeatureNotSupportedException;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 多数据源支持   
 * @author harries
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {    
   
    static Logger log = Logger.getLogger(DynamicDataSource.class);    
    @Override   
    protected Object determineCurrentLookupKey() {    
        return DbContextHolder.getDbType();    
   }
	public java.util.logging.Logger getParentLogger()
			throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}    
   
}   
