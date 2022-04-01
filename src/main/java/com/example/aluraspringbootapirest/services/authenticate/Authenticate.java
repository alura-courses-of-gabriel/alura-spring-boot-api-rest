package com.example.aluraspringbootapirest.services.authenticate;

import com.example.aluraspringbootapirest.services.Service;
import com.example.aluraspringbootapirest.services.tokenmanagement.GenerateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@org.springframework.stereotype.Service
public class Authenticate implements Service {

    @Autowired
    private GenerateToken generateToken;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Object execute(Object object) {
        AuthenticateInput input = (AuthenticateInput) object;
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(input.username(), input.password());
        Authentication autenticador = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = (String) this.generateToken.execute(autenticador);
        return new AuthenticateOutput(token);
    }
}
