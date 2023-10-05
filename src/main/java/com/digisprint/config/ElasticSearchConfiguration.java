package com.digisprint.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@Configuration
public class ElasticSearchConfiguration
{
	
	@Value("${spring.wrapper.userName}")
	private String userName;
	
	@Value("${spring.wrapper.password}")
	private String password;
	
    @Bean
    public RestClient getRestClient() {
      	final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    	credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));

    		RestClientBuilder builder = RestClient.builder(
    		    new HttpHost("localhost", 9200)).setHttpClientConfigCallback(new HttpClientConfigCallback() {
    		        public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
    		            httpClientBuilder.disableAuthCaching(); 
    		            return httpClientBuilder
    		                .setDefaultCredentialsProvider(credentialsProvider);
    		        }
    		    });

       /* RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build(); */
        return builder.build();
    }
    
 @SuppressWarnings("deprecation")
	@Bean
    public RestHighLevelClient client() {
    	final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    	credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));

    	Header[] defaultHeaders = {new BasicHeader("Accept", "application/vnd.elasticsearch+json; compatible-with=7"),
				new BasicHeader("Content-Type", "application/vnd.elasticsearch+json; compatible-with=7")};
		
		
    		RestClientBuilder builder = RestClient.builder(
    		    new HttpHost("localhost", 9200)).setHttpClientConfigCallback(new HttpClientConfigCallback() {
    		        public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
    		            httpClientBuilder.disableAuthCaching(); 
    		            return httpClientBuilder
    		                .setDefaultCredentialsProvider(credentialsProvider);
    		        }
    		    });
    		builder.setDefaultHeaders(defaultHeaders);
        return new RestHighLevelClient(builder);
    }

    @Bean
    public  ElasticsearchTransport getElasticsearchTransport() {
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) ;
        return new RestClientTransport(getRestClient(), new JacksonJsonpMapper(mapper));
    }


    @Bean
    public ElasticsearchClient getElasticsearchClient(){
        ElasticsearchClient client = new ElasticsearchClient(getElasticsearchTransport());
        return client;
    }

}
