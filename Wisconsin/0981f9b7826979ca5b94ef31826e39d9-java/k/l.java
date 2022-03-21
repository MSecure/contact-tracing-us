package k;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public final class l {
    public static final Logger a = Logger.getLogger(l.class.getName());

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static r b(Socket socket) {
        if (socket != null) {
            k kVar = new k(socket);
            OutputStream outputStream = socket.getOutputStream();
            if (outputStream != null) {
                return new a(kVar, new i(kVar, outputStream));
            }
            throw new IllegalArgumentException("out == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static s c(Socket socket) {
        if (socket != null) {
            k kVar = new k(socket);
            InputStream inputStream = socket.getInputStream();
            if (inputStream != null) {
                return new b(kVar, new j(kVar, inputStream));
            }
            throw new IllegalArgumentException("in == null");
        }
        throw new IllegalArgumentException("socket == null");
    }
}
