package in.sp.service;

import in.sp.beans.User;

public interface ServicesPro {

	public int registerUser(User user);
	public User getUser(String name,String pass);
}
