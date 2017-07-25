package oz.en.greeter;

import oz.greeter.GreeterStrategy;

public class Greeter implements GreeterStrategy {

	public String generateGreeting(){
		return "Hello";
	}
}
