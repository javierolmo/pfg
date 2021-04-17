package com.javi.uned.pfgweb.rest;

import com.javi.uned.pfgweb.beans.LoginResponse;
import com.javi.uned.pfgweb.beans.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthenticationRESTTest {

    @Autowired
    private AuthenticationREST authenticationREST;

    @Test
    void loginCorrecto() throws Exception {
        User user = new User();
        user.setEmail("tester@gmail.com");
        user.setPassword("5885");
        LoginResponse response = authenticationREST.login(user);
        assert response.getData().getToken().length() > 0;
    }

    @Test
    void loginErroneo() {
        User user = new User();
        user.setEmail("tester@gmail.com");
        user.setPassword("wrong-password");
        try {
            LoginResponse loginResponse = authenticationREST.login(user);
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }
}