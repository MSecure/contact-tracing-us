package h.a.k1.p;

import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;
import javax.net.ssl.SSLParameters;

public class g implements PrivilegedExceptionAction<Method> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.security.PrivilegedExceptionAction
    public Method run() {
        return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
    }
}
