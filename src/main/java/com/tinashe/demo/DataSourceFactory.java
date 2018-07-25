//package com.tinashe.demo;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.slf4j.LoggerFactory;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.sql.DataSource;
//
//public class DataSourceFactory {
//    public DataSourceFactory() {
//    }
//    public static DataSource buildHikariDataSource(HikariDataSourceProperties config) {
//        String MS_SQL_SERVER_SUB_PROTOCOL = "jdbc:sqlserver://";
//        org.slf4j.Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);
//        logger.trace("buildHikariDataSource");
//        String connectionURL = config.getUrl();
//        if(StringUtils.startsWithIgnoreCase(connectionURL, "jdbc:sqlserver://")) {
//            connectionURL = StringUtils.appendIfMissingIgnoreCase(connectionURL, ";integratedSecurity=true", new CharSequence[0]);
//            connectionURL = StringUtils.appendIfMissingIgnoreCase(connectionURL, ";sendStringParametersAsUnicode=false", new CharSequence[0]);
//            config.setUrl(connectionURL);
//        }
//
//        return new HikariDataSource(config);
//    }
//}
