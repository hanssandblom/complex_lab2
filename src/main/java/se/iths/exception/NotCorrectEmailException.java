package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NotCorrectEmailException extends WebApplicationException {
    public NotCorrectEmailException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
                .entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}
