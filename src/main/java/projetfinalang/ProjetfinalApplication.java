package projetfinalang;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Person;

@SpringBootApplication
public class ProjetfinalApplication implements  CommandLineRunner{
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetfinalApplication.class, args);
	}
	/*@RestController
	class MonController{
		@GetMapping("/bonjour")
		public String direBonjour() {
			return "Bonjour tout le monde";
		}
	}
	
	
	@RestController
	class PersonController{
		@Autowired
		EntityManager em;
		@RequestMapping(value = "/person", method = RequestMethod.GET)
		//@PostMapping("/person")
		@Transactional
		public Person savePerson(@RequestParam(required=false)  String prenom) {
			//Configuration config = new AnnotationConfiguration().configure();
		Person p = new Person();
		p.setPrenom(prenom);
		em.persist(p);
		return p;
	}
	}*/
	@Autowired
	private JdbcTemplate jdbcTeplante;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT *FROM Personne";
		List<Person> person =jdbcTeplante.query(sql, BeanPropertyRowMapper.newInstance(Person.class));
		person.forEach(System.out:: println);
	}

	
	
	/* Configuration config = new Configuration().configure();
        ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory factory = config.buildSessionFactory(servReg);*/


}
