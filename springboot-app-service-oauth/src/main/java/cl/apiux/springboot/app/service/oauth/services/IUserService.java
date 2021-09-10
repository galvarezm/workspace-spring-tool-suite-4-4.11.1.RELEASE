package cl.apiux.springboot.app.service.oauth.services;

import cl.apiux.springboot.app.user.common.models.entity.User;

public interface IUserService {

	public User findByUsername(String username);
	
	public User update(User usuario, Integer id);
	
}
