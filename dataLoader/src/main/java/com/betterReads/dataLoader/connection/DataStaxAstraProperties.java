package com.betterReads.dataLoader.connection;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {
	
	
	private File secureConnectBundle;
	
}
