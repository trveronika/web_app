package hu.unideb.inf.zoo_animals.service;

import hu.unideb.inf.zoo_animals.dao.request.SignUpRequest;
import hu.unideb.inf.zoo_animals.dao.request.SigninRequest;
import hu.unideb.inf.zoo_animals.dao.response.JwtAuthenticationResponse;


public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
