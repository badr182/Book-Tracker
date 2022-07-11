package com.betterReads.dataLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.betterReads.dataLoader.author.Author;
import com.betterReads.dataLoader.author.AuthorRepository;
import com.betterReads.dataLoader.connection.DataStaxAstraProperties;

@SpringBootApplication
public class DataLoaderApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(DataLoaderApplication.class, args);
	}
	
    

}
