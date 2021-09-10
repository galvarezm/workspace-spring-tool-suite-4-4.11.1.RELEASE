package cl.apiux.springboot.app.service.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.apiux.springboot.app.service.oauth.clients.IUserFeignClient;
import feign.FeignException;

@Service
public class UserService implements IUserService, UserDetailsService {

	private Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private IUserFeignClient client;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			cl.apiux.springboot.app.user.common.models.entity.User usuario = client.findByUsername(username);

			List<GrantedAuthority> authorities = usuario.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role.getName()))
					.peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());
			log.info("Usuario autenticado: " + username);
			return (UserDetails) new User(
				usuario.getUsername(), 
				usuario.getPassword(), 
				usuario.getEnabled(), 
				true, 
				true, 
				true, 
				authorities
			);
		} catch (FeignException e) {
			String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
			log.error(error);
			throw new UsernameNotFoundException(error);
		}
	}

	@Override
	public cl.apiux.springboot.app.user.common.models.entity.User findByUsername(String username) {
		return client.findByUsername(username);
	}

	@Override
	public cl.apiux.springboot.app.user.common.models.entity.User update(cl.apiux.springboot.app.user.common.models.entity.User usuario, Integer id) {
		return client.update(usuario, id);
	}

}
