package cl.apiux.springboot.app.service.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import cl.apiux.springboot.app.service.oauth.services.IUserService;
import cl.apiux.springboot.app.user.common.models.entity.User;

@Component
public class InfoAditionalToken implements TokenEnhancer {

	@Autowired
	private IUserService usuarioService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		User usuario = usuarioService.findByUsername(authentication.getName());
		info.put("nombre", usuario.getName());
		info.put("apellido", usuario.getLastName());
		info.put("correo", usuario.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
