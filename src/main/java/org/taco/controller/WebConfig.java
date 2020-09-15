package org.taco.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Special simple Controller type: View-Controller
 * (page 55)
 *
 * Useful to extend Configuration-classes for each type configuration (Web, Data, Security,...)
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	// @Override not used anymore somehow ?!
	public void addViewController(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
}
