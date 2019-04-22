package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Noticia;
import com.softnar.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		//Recuperar varios registros por Id [metodo findAllById del repository]
		
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(5);
		ids.add(6);
		Iterable<Noticia> it = repo.findAllById(ids);
		for(Noticia n: it) {
			System.out.println(n);
		}

	}

}
