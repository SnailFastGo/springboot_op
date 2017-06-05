package com.myspringboot.configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.Settings.Builder;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class ElasticsearchConfiguration {
	
	private final static Logger logger = LoggerFactory.getLogger(ElasticsearchConfiguration.class);
	@Autowired
	private Environment env;
	
	@Bean
	public TransportClient initESClient() throws NumberFormatException, UnknownHostException{
		String ip = env.getProperty("spring.es.ip");
		String port = env.getProperty("spring.es.port");
		String clusterName = env.getProperty("spring.es.cluster_name");
		
		Builder builder = Settings.builder().put("cluster.name", clusterName).put("client.transport.sniff", true);
		Settings esSettings = builder.build();
		TransportClient client = new PreBuiltTransportClient(esSettings);
		client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), Integer.parseInt(port)));
		logger.info("ES Client 初始化成功, ip : {}, port : {}, cluster_name : {}", ip, port, clusterName);
		return client;
	}
	
}
