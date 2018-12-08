package web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.client.model.Category;
import web.client.model.User;
import web.client.model.WebClient;
import web.client.repository.CategoryRepository;
import web.client.repository.UserRepository;
import web.client.repository.WebClientRepository;

@Controller    // This means that this class is a Controller

public class HomeController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private CategoryRepository mCategoryRepository;
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private WebClientRepository mWebClientRepository;

	@RequestMapping(path = "/home", method = RequestMethod.GET, produces = "text/html")
	 public String home( Model model) {
        Sort sort = new Sort(Direction.ASC, "name");
     
		
      //  User user = userRepository.findByName(auth.getName());
       // model.("userName", user.getName());
            

       Iterable<Category> categories = mCategoryRepository.findAll(sort);
		
		
		

		Iterable<WebClient> clients = mWebClientRepository.findAll(sort);
	
		model.addAttribute("categories", categories);

		model.addAttribute("clients", clients);
		int countClient = clients.spliterator().SIZED;

	       
	       
	        return "home";
	    }
	
	@GetMapping(path = "/test") 
	public String test() {
		return "test";
	}
}