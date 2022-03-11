package k;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public final class k extends c {
    public final /* synthetic */ Socket c;

    public k(Socket socket) {
        this.c = socket;
    }

    @Override // k.c
    public IOException d(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
