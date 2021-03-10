package com.aman.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.servlet.Filter;

@SpringBootApplication
@ComponentScan(basePackages = "com.aman.graphql")
public class GraphqlApplication {


	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	/**
	 * Register the {@link OpenEntityManagerInViewFilter} so that the
	 * GraphQL-Servlet can handle lazy loads during execution.
	 *
	 * @return
	 */
	@Bean
	public Filter OpenFilter() {
		return new OpenEntityManagerInViewFilter();
	}
}
