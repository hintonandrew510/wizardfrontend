package web.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import web.client.model.Role;
import web.client.model.User;
import web.client.repository.RoleRepository;
import web.client.repository.UserRepository;



@Controller // This means that this class is a Controller

public class UserController {
	// @Autowired
	// private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private RoleRepository roleRepository;

	 @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
	 public ModelAndView login() {
	  ModelAndView model = new ModelAndView();
	  
	  model.setViewName("/login");
	  return model;
	 }
	 
	 
	 @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
	 public ModelAndView signup() {
	  ModelAndView model = new ModelAndView();
	  User user = new User();
	  model.addObject("user", user);
	  model.setViewName("/signup");
	  
	  return model;
	 }
	 
	
	
	@GetMapping(path = "/addUser") // Map ONLY GET Requests
	public ModelAndView add(@RequestParam String name, @RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		ModelAndView model = new ModelAndView();
		
		User userExists = userRepository.findByName(name);
		
		User n = new User();
		n.setName(name);
		n.setEnabled(true);
		//n.setActive(1);
	//	String passwordEncrypted = bCryptPasswordEncoder.encode(password);
		//n.setPassword(passwordEncrypted);
		Role role = roleRepository.findByRole("ADMIN");
		Set<Role> roles = new HashSet<Role>(Arrays.asList(role));
        n.setRoles(roles);
		userRepository.save(n);
		model.addObject("msg", "User has been registered successfully!");
		   model.addObject("user", n);
		   model.setViewName("redirect:/allUsers");

		return model;
	}
	
	
	
	@GetMapping(path = "/updateUser") // Map ONLY GET Requests
	public String update(@RequestParam(name = "ID", required = true) Integer id, @RequestParam(name ="name", required=true) String name) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setId(id);

		userRepository.save(n);

		return "redirect:/allUsers";
	}

	

	@GetMapping(path = "/detailUser") // Map ONLY GET Requests
	public String detail(@RequestParam(name = "ID", required = true) Integer id, Model model) {
		User user = userRepository.findById(id).get();

		model.addAttribute("user", user);

		return "detailUserPage";
	}

	@GetMapping(path = "/allUsersJSON")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@GetMapping(path = "/allUsers")
	public String getAll(Model model) {
		
		//sort by name
		Sort sort = new Sort(Direction.ASC, "name");
		
		Iterable<User> users = userRepository.findAll(sort);
	
		
		model.addAttribute("users", users);

		return "users";

	}

}