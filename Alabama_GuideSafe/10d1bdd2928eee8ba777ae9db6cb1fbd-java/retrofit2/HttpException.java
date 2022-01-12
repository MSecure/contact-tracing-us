package retrofit2;

import java.util.Objects;

public class HttpException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpException(Response<?> response) {
        super("HTTP " + response.code() + " " + response.rawResponse.message());
        Objects.requireNonNull(response, "response == null");
        response.code();
        response.rawResponse.message();
    }
}
