package oz.myboot.app.samplebootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oz.greeter.GreeterStrategy;

@SpringBootApplication
@RestController
public class SampleBootAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SampleBootAppApplication.class, args);
	}

	@Autowired
	private GreeterStrategy greeter;

	@RequestMapping("/")
	public String getGreeting(){
		return greeter.generateGreeting();
	}
}
