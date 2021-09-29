package com.kalibek.ttleague.security.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${openapi.authenticationAuthorization.base-path:/api/v1.0.0}")
public class AuthApiController implements AuthApi {


}
