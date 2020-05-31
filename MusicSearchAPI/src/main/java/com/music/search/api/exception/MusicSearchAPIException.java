package com.music.search.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MusicSearchAPIException extends ResponseStatusException {

	private static final long serialVersionUID = 2507142308145419812L;

	public MusicSearchAPIException(HttpStatus status, String reason) {
		super(status, reason);
	}

}
