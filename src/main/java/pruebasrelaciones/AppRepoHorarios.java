package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.softnar.app.model.Horario;
import com.softnar.app.repository.HorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		HorariosRepository repo = context.getBean("horariosRepository",HorariosRepository.class);
		
		
		List<Horario> lista=repo.findAll();
		for(Horario h:lista) {
			System.out.println(h);
		}
		
		
	
		
		context.close();

	}

}
