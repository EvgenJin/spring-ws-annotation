package com.evg.ws.todoWs.repository;

/**
 *
 * @author evgenJin
 */
import com.evgenjin.xjc.ObjectFactory;
import com.evgenjin.xjc.Priority;
import com.evgenjin.xjc.TodoObject;
import java.util.Date;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class TodoRepository {


	private static final Map<String, TodoObject> tasks = new HashMap<>();
//        ObjectFactory factory = new ObjectFactory();
//        TodoObject todoe = factory.createTodoObject();
//        todoe.s
//        Date date_task = new Date();
//        XMLGregorianCalendar date_gr = new XMLGregorianCalendar();
	@PostConstruct
	public void initData() throws DatatypeConfigurationException {
            Date date_now = new Date();
//            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(date_now.toString());

		TodoObject todo = new TodoObject();
                todo.setId("1");
                todo.setPriority(Priority.LOW);
                todo.setDiscription("dddiiiisssccccrrrriiiipppptionnn");
                todo.setTitle("new task 4 u");
//                todo.setDate(xmlGregorianCalendar);
//		spain.setName("Spain");
//		spain.setCapital("Madrid");
//		spain.setCurrency(Currency.EUR);
//		spain.setPopulation(46704314);

		tasks.put(todo.getId(), todo);


	}

	public TodoObject findCountry(String id) {
		Assert.notNull(id, "The country's name must not be null");
                Assert.hasText(id, "The country");
		return tasks.get(id);
	}
}
