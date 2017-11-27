package org.home.apapacy;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Resource;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="helloWorld")
	private org.home.apapacy.beans.HelloBean helloBean;
	
	@Resource(name="personDAO")
	private org.home.apapacy.dao.PersonDAO persons;
	
	@Autowired
	private org.home.apapacy.dao.DocumentDAO documents;
	
	@Autowired
	private org.home.apapacy.dao.CustomerDAO customers;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Callable<String> home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("bean", this.helloBean );
		final org.home.apapacy.models.PersonModel person = new org.home.apapacy.models.PersonModel();
		person.setName("Joe");
		person.setCountry("usa");
		person.setMemo("test");
		return new Callable<String>() {
			    public String call() throws Exception {
					persons.addPerson(person);
					return "home";
			    }
			  };
		
	}
	
	@RequestMapping(value = "/couch", method = RequestMethod.GET)
	public Callable<String> couch(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("bean", this.helloBean );
		final org.home.apapacy.models.Document document = new org.home.apapacy.models.Document("New Document");
		document.setClientId(16);
		return new Callable<String>() {
			    public String call() throws Exception {
					documents.add(document);
					return "home";
			    }
			  };
		
	}

	@RequestMapping(value = "/mongo", method = RequestMethod.GET)
	public Callable<String> mongo(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("bean", this.helloBean );
		final org.home.apapacy.models.CustomerModel customer = new org.home.apapacy.models.CustomerModel("m-r", "X");
		return new Callable<String>() {
			    public String call() throws Exception {
					customers.save(customer);
					return "home";
			    }
			  };
		
	}

	
	
}
