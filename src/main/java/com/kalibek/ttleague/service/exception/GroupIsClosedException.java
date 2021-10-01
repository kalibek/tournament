package com.kalibek.ttleague.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Group is already closed")
public class GroupIsClosedException extends RuntimeException {

}
