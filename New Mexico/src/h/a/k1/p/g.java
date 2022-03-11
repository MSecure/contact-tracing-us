package h.a.k1.p;

import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;
import javax.net.ssl.SSLParameters;
/* loaded from: classes.dex */
public class g implements PrivilegedExceptionAction<Method> {
    @Override // java.security.PrivilegedExceptionAction
    public Method run() {
        return SSLParameters.class.getMethod("setApplicationProtocols", String[].class);
    }
}
