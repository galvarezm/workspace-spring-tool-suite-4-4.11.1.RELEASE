package cl.apiux.springboot.app.service.oauth.security.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import cl.apiux.springboot.app.service.oauth.services.IUserService;
import cl.apiux.springboot.app.user.common.models.entity.User;
import feign.FeignException;

@Component
public class AuthenticationSuccessErrorHandler  implements AuthenticationEventPublisher {

	private Logger log = LoggerFactory.getLogger(AuthenticationSuccessErrorHandler.class);

	@Autowired
	private IUserService usuarioService;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		
		if(authentication.getDetails() instanceof WebAuthenticationDetails) {
			return;
		}
		
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String mensaje = "Success Login: " + user.getUsername();
		System.out.println(mensaje);
		log.info(mensaje);

		User usuario = usuarioService.findByUsername(authentication.getName());
		
		if(usuario.getIntents() != null && usuario.getIntents() > 0) {
			usuario.setIntents(0);
			usuarioService.update(usuario, usuario.getId());
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		String mensaje = "Error en el Login: " + exception.getMessage();
		log.error(mensaje);
		System.out.println(mensaje);

		try {
			
			StringBuilder errors = new StringBuilder();
			errors.append(mensaje);
			
			User usuario = usuarioService.findByUsername(authentication.getName());
			if (usuario.getIntents() == null) {
				usuario.setIntents(0);
			}
			
			log.info("Intentos actual es de: " + usuario.getIntents());
			
			usuario.setIntents(usuario.getIntents()+1);
			
			log.info("Intentos después es de: " + usuario.getIntents());
			
			errors.append(" - Intentos del login: " + usuario.getIntents());
			
			String errorMaxIntentos = String.format("El usuario %s des-habilitado por máximos intentos.", usuario.getUsername());
			log.error(errorMaxIntentos);
			errors.append(" - " + errorMaxIntentos);
			usuario.setEnabled(false);
			usuarioService.update(usuario, usuario.getId());
			
		} catch (FeignException e) {
			log.error(String.format("El usuario %s no existe en el sistema", authentication.getName()));
		}

	}

}
