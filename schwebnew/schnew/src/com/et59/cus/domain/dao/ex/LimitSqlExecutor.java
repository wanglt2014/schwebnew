package com.et59.cus.domain.dao.ex;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.engine.execution.SqlExecutor;
import com.ibatis.sqlmap.engine.mapping.statement.RowHandlerCallback;
import com.ibatis.sqlmap.engine.scope.StatementScope;

public class LimitSqlExecutor extends SqlExecutor {

    private static final Logger log = Logger.getLogger(LimitSqlExecutor.class);
    
    private Dialect dialect;

    private boolean enableLimit = true;

    public Dialect getDialect() {
        return dialect;
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public boolean isEnableLimit() {
        return enableLimit;
    }

    public void setEnableLimit(boolean enableLimit) {
        this.enableLimit = enableLimit;
    }

    @Override
    public void executeQuery(StatementScope request, Connection conn, String sql,
            Object[] parameters, int skipResults, int maxResults,
            RowHandlerCallback callback) throws SQLException {
        if ((skipResults != NO_SKIPPED_RESULTS || maxResults != NO_MAXIMUM_RESULTS)
                && supportsLimit()) {
            sql = dialect.getLimitString(sql, skipResults, maxResults);
            if(log.isDebugEnabled()){
            	log.debug("sql----------->:"+sql);
            }
            skipResults = NO_SKIPPED_RESULTS;
            maxResults = NO_MAXIMUM_RESULTS;            
        }
        super.executeQuery(request, conn, sql, parameters, skipResults,
                maxResults, callback);
    }

    public boolean supportsLimit() {
        if (enableLimit && dialect != null) {
            return dialect.supportsLimit();
        }
        return false;
    }

}