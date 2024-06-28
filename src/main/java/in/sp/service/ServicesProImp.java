package in.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.beans.User;
import in.sp.repo.UserRepository;

@Service
public class ServicesProImp implements ServicesPro{

	 @Autowired
	    private UserRepository userRepository;
	 @Override
	 public int registerUser(User user) {
	        // Add logic to hash the password before saving (optional)
	        return userRepository.save(user);
	    }
	 @Override
	 public User getUser(String name,String pass) {
		 User u =userRepository.findByName(name);
		 if(u==null) return null;
		 if(u.getPass().equals(pass)) return u;
		 return null;
	 }
}
