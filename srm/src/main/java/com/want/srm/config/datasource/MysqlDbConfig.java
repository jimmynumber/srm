package com.want.srm.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@MapperScan(
        basePackages ="com.want.srm.dao",
        sqlSessionTemplateRef = "mysqlSessionTemplate"
)
public class MysqlDbConfig {

	    @Value("${spring.datasource.druid.url}")
	    private String url;
	    @Value("${spring.datasource.druid.username}")
	    private String user;
	    @Value("${spring.datasource.druid.password}")
	    private String password;
	    @Value("${spring.datasource.druid.driver-class-name}")
	    private String driverClass;

	    @Bean(name = "mysqlDataSource")
	    @Primary
	    public DataSource mysqlDataSource(){
	        DruidDataSource dataSource = new DruidDataSource();
	        dataSource.setUrl(url);
	        dataSource.setUsername(user);
	        dataSource.setPassword(password);
	        dataSource.setDriverClassName(driverClass);
	        return dataSource;
	    }
	    
//	    @Value("${spring.datasource.jndi-name}")
//	    private String jndiName;
//	    
//	    @Bean(name = "mysqlDataSource")
//	    @Primary
//	    public DataSource mysqlDataSource() throws IllegalArgumentException, NamingException {
//	        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
//	        lookup.setResourceRef(true);
//	        return lookup.getDataSource(jndiName);
//	    }
	    
	    @Bean(name = "mysqlTransactionManager")
	    @Primary
	    public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
	        return new DataSourceTransactionManager(dataSource);
	    }
	    
	    @Bean(name = "mysqlSessionFactory")
	    @Primary
	    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
	        final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
	        bean.setDataSource(dataSource);
	        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mappers/*.xml"));
	        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
	        configuration.setMapUnderscoreToCamelCase(true);
	        configuration.setCallSettersOnNulls(true);
	        configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
	        bean.setConfiguration(configuration);
	        return bean.getObject();
	    }
	    
	    @Bean(name = "mysqlSessionTemplate")
	    @Primary
	    public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
	        return new SqlSessionTemplate(sqlSessionFactory);
	    }
	    
}
