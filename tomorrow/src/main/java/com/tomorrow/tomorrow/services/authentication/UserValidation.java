package com.tomorrow.tomorrow.services.authentication;

import com.tomorrow.tomorrow.entities.User;

public interface UserValidation {

    User loginAuthentication(String login, String password);
}
