package com.myspringboot.configuration;

import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.myspringboot.repository.neo4j")
@EnableTransactionManagement
public class Neo4jConfig extends Neo4jConfiguration {
	private final static Logger logger = LoggerFactory.getLogger(Neo4jConfig.class);
	@Autowired
	private Environment env;

	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		//读取application.yml文件neo4j的配置信息
		String username = env.getProperty("spring.data.neo4j.username");
		String password = env.getProperty("spring.data.neo4j.password");
		String uri = env.getProperty("spring.data.neo4j.uri");
		logger.info("username: " + username + "  password: " + password + "  uri:" + uri);
		org.neo4j.ogm.config.Configuration config = new org.neo4j.ogm.config.Configuration();
		config.driverConfiguration().setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
				.setURI(uri)
				.setCredentials(username, password);
		return config;
	}

	@Override
	public SessionFactory getSessionFactory() {
		/**
		 * 如果不指定节点映射的java bean路径，保存时会报如下警告，导致无法将节点插入Neo4j中 ... is not an
		 * instance of a persistable class
		 */
		return new SessionFactory(getConfiguration(), "com.myspringboot.entity.neo4j");
	}
}
