package com.rgurgen.customermanagement.service;

import com.rgurgen.customermanagement.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
