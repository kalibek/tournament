package com.kalibek.ttleague.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Series Not Found")
public class SeriesNotFoundException extends RuntimeException {

}
