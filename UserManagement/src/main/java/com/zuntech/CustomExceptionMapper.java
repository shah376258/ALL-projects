package com.zuntech;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<CustomException> {

	@Override
	public Response toResponse(CustomException ex) {
		return Response.status(Response.Status.OK)
				.entity("{\"errorCode\":\"" + ex.getErrorCode() + "\",\"errorMessage\":\"" + ex.getErrorMessage() + "\"}")
                .type(MediaType.APPLICATION_JSON)
                .build();
	}

}
