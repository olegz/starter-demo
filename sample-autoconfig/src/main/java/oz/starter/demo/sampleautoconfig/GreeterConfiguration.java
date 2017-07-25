package oz.starter.demo.sampleautoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import oz.greeter.GreeterStrategy;

@Configuration
@EnableConfigurationProperties
public class GreeterConfiguration {

	@Autowired
	private ApplicationContext context;

	@ConditionalOnClass(name="oz.en.greeter.Greeter")
	@Bean
	public GreeterStrategy enGreeter() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("Creating English Greeter  " + context.getBean(GreeterStrategy.class));
		return (GreeterStrategy)Class.forName("oz.en.greeter.Greeter").newInstance();
	}

	@Bean
	@ConditionalOnClass(name="oz.fr.greeter.Greeter")
	@Primary
	public GreeterStrategy frGreeter() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("Creating French Greeter");
		return (GreeterStrategy)Class.forName("oz.fr.greeter.Greeter").newInstance();
	}
}
