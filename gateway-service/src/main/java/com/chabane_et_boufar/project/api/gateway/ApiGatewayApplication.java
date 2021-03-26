package com.chabane_et_boufar.project.api.gateway;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {

		HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
		WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


}
