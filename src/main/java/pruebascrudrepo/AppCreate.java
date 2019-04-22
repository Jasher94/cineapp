package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

//Aplicacion para persistir (crear) en la tabla Noticias un objeto de tipo noticias

public class AppCreate {
	
	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximo Estreno: AAvengar EndaGame4");
		noticia.setDetalle("El Capitan america sobrea ataque, Thord quiere ejecutar a Thanos");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.save(noticia);
		
		context.close();
		}
	
}
