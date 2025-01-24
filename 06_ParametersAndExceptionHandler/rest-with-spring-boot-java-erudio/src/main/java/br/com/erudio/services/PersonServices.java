package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service //faz o spring boot entender que esse objeto sera injetado atraves de um autowired
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		logger.info("Finding All People");
		List<Person> persons = new ArrayList<>(); // declaramos uma listagem de pessoas
		for(int i = 0; i < 8; i++) { //iteramos num array que vai de 0 a 8
			Person person = mockPerson(i); // mocka uma pessoa para cada item do array
			persons.add(person); //adiciona a pessoa a listagem
		}
		return persons ;
	}
	
	public Person findById(String id) {
		logger.info("Finding one Person!");
		Person person =  new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Rafael");
		person.setLastName("Andrade");
		person.setAdress("Franca - São Paulo - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {
		logger.info("Creating one person");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person");
	}
	
	private Person mockPerson(int i) {
		Person person =  new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Last Name" + i);
		person.setAdress("Some Adress in Brazil" + i);
		person.setGender("Male");
		return person;
	}
}
