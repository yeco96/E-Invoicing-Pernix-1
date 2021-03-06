package com.pernix.einvoicing.service.hacienda.oauth2;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HaciendaOAuth2Service implements OAuth2Service {

	@Value("${hacienda.accessTokenUri}")
    private String IDP_URI;
	
	@Value("${hacienda.clientId}")
    private String IDP_CLIENT_ID;
	
	@Value("${hacienda.credentials.username}")
    private String usuario;
    
	@Value("${hacienda.credentials.password}")
    private String password;

    private String accessToken = null;
    //private String refreshToken = null;

    private void getAccessHaciendaToken(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(IDP_URI + "/token");
        Form form = new Form();
        form.param("grant_type", "password")
                     .param("username", usuario)
                     .param("password", password)
                     .param("client_id", IDP_CLIENT_ID);

        Response response = target.request().post(Entity.form(form));
        @SuppressWarnings("unchecked")
		Map<String, String> responseJson = response.readEntity(HashMap.class);

        accessToken = responseJson.get("access_token");
        //refreshToken = responseJson.get("refresh_token");
    }


    @Override
    public String getAccessToken() {
        if(StringUtils.isEmpty(accessToken)){
            getAccessHaciendaToken();
        }
        return accessToken;
    }
}
