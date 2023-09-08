package fr.eni.pizzaOnline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import fr.eni.pizzaOnline.converter.StringToTypeProduit;

	@Configuration
	public class ConverterConfig implements WebMvcConfigurer {

	@Autowired
	private StringToTypeProduit stringToTypeProduit;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(stringToTypeProduit);
	}
		
}


