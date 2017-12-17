package hicham.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hicham.auth.user.User;
import hicham.auth.user.UserRepository;

@RestController
public class RestWelcomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value= "/rest",method= RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam(value="t1") String name
			, @RequestParam(value="t2") String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}


}
