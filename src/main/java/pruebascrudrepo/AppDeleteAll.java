package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.repository.NoticiasRepository;

public class AppDeleteAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);

		//Borrar todos los registros [metodo deleteAll del repository]
		//ALERTA ES UN METODO MUY PELIGROS!!!!!!!
		repo.deleteAll();
		context.close();
				

	}

}
