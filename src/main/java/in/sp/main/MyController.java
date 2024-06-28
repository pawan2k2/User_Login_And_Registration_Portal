package in.sp.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import in.sp.beans.User;
import in.sp.service.ServicesPro;
import in.sp.service.ServicesProImp;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {

	@Autowired
	private ServicesPro serve;
	
	
	@GetMapping("/regiOpen")
	public String openRegis() {
		return "register";
	}
	
	/*@PostMapping ("/submitForm")
	public String OpenProfile(HttpServletRequest req,Model model) {
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String city=req.getParameter("city");
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setCity(city);
		model.addAttribute("user", user);
		//model.addAttribute("model_name", name);
		//model.addAttribute("model_age", age);
		//model.addAttribute("model_city", city);
		
		return "profile";
	}*/
	
	@PostMapping ("/submitForm")
	public String OpenProfile(@ModelAttribute User user,Model model) {
		String name = user.getName();
		String password=user.getPass();
		User us=serve.getUser(name, password);
		if(us!=null) {
			model.addAttribute("error","User already registered");
			return "error";	
		}
		serve.registerUser(user);
	
		model.addAttribute("user", user);
		/*User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setCity(city);*/
		
		//model.addAttribute("model_name", name);
		//model.addAttribute("model_age", age);
		//model.addAttribute("model_city", city);)
		
		return "profile";
	}
	
	
	@GetMapping("/backTo")
	public String back() {
		return "login";
	}
	
	@PostMapping("/showDetail")
	public String showId(HttpServletRequest rq,Model model) {
		String name =rq.getParameter("name");
		String pass=rq.getParameter("pass");
		User us =serve.getUser(name, pass);
		if (us == null) {
            // Handle user not found or invalid password
            model.addAttribute("error", "User not found or invalid password");
            return "error"; // Create an error page
        }
		model.addAttribute("user", us);
		return "showDetail";
	}
	
}
