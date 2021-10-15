package c.b.c.a.m0;

import b.x.t;
import c.b.c.a.m0.b0;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class a0<T_WRAPPER extends b0<T_ENGINE>, T_ENGINE> {

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f5095d = Logger.getLogger(a0.class.getName());

    /* renamed from: e  reason: collision with root package name */
    public static final List<Provider> f5096e;

    /* renamed from: f  reason: collision with root package name */
    public static final a0<b0.a, Cipher> f5097f = new a0<>(new b0.a());

    /* renamed from: g  reason: collision with root package name */
    public static final a0<b0.d, Mac> f5098g = new a0<>(new b0.d());
    public static final a0<b0.f, Signature> h = new a0<>(new b0.f());
    public static final a0<b0.e, MessageDigest> i = new a0<>(new b0.e());
    public static final a0<b0.c, KeyPairGenerator> j = new a0<>(new b0.c());
    public static final a0<b0.b, KeyFactory> k = new a0<>(new b0.b());

    /* renamed from: a  reason: collision with root package name */
    public T_WRAPPER f5099a;

    /* renamed from: b  reason: collision with root package name */
    public List<Provider> f5100b = f5096e;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5101c = true;

    static {
        if (t.S1()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f5095d.info(String.format("Provider %s not available", str));
                }
            }
            f5096e = arrayList;
        } else {
            f5096e = new ArrayList();
        }
    }

    public a0(T_WRAPPER t_wrapper) {
        this.f5099a = t_wrapper;
    }

    public T_ENGINE a(String str) {
        Exception exc = null;
        for (Provider provider : this.f5100b) {
            try {
                return (T_ENGINE) this.f5099a.a(str, provider);
            } catch (Exception e2) {
                if (exc == null) {
                    exc = e2;
                }
            }
        }
        if (this.f5101c) {
            return (T_ENGINE) this.f5099a.a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
