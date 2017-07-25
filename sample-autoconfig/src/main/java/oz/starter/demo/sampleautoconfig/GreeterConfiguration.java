package oz.starter.demo.sampleautoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oz.greeter.GreeterStrategy;

@Configuration
public class GreeterConfiguration {

	@Bean
	@ConditionalOnClass(name="oz.en.greeter.Greeter")
	public GreeterStrategy enGreeter() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("Creating English Greeter");
		return (GreeterStrategy)Class.forName("oz.en.greeter.Greeter").newInstance();
	}
}
