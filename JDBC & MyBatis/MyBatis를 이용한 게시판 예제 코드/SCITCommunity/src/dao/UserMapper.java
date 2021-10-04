package dao;

import vo.User;

public interface UserMapper {
	public int signup(User usr);
	public String login(User usr);
}