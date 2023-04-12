package com.example.demo.config;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@Profile("!local")
public class MongoConfig implements MongoClientSettingsBuilderCustomizer {

    @Value("${custom.data.mongodb.user}")
    private String mongoUser;
    
    @Value("${custom.data.mongodb.password}")
    private String mongoPwd;
    
    @Value("${custom.data.mongodb.dbAuth}")
    private String dbAuth;
    
    @Override
    public void customize(MongoClientSettings.Builder builder) {
    	// Descifrar mongoPwd, ya que está cifrada con jCryptoShadow 
    	// mongoPwd 
    	
        MongoClientSettings settings = builder
        		//.applyConnectionString(new ConnectionString("mongodb://admin:****@10.0.202.78:27017/?authSource=admin"))
        		 .credential(MongoCredential.createCredential(mongoUser, 
        				 dbAuth, 
                 		mongoPwd.toCharArray()))
        		.build();
        
        // Comprobar que todo haya id bien
        MongoClient mongoClient = MongoClients.create(settings);
        mongoClient.listDatabaseNames().forEach((Consumer<String>) System.out::println);
    }      
}
