package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class pruebasjpa {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		context.close();
	}

}
