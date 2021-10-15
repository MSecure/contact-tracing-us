package c.b.c.a.f0.a;

import android.content.Context;
import b.x.t;
import c.b.c.a.a0;
import c.b.c.a.f0.a.c;
import c.b.c.a.h;
import c.b.c.a.i0.a1;
import c.b.c.a.i0.n0;
import c.b.c.a.i0.w0;
import c.b.c.a.i0.z0;
import c.b.c.a.j;
import c.b.c.a.j0.a.b0;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.q;
import c.b.c.a.k;
import c.b.c.a.l;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.ProviderException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public k f4803a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public d f4804a = null;

        /* renamed from: b  reason: collision with root package name */
        public l f4805b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f4806c = null;

        /* renamed from: d  reason: collision with root package name */
        public c.b.c.a.a f4807d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4808e = true;

        /* renamed from: f  reason: collision with root package name */
        public h f4809f = null;

        /* renamed from: g  reason: collision with root package name */
        public KeyStore f4810g = null;
        public k h;

        public synchronized a a() {
            if (this.f4806c != null) {
                this.f4807d = c();
            }
            this.h = b();
            return new a(this, null);
        }

        public final k b() {
            try {
                c.b.c.a.a aVar = this.f4807d;
                if (aVar != null) {
                    try {
                        return k.f(j.c(this.f4804a, aVar));
                    } catch (b0 | GeneralSecurityException unused) {
                        a.b();
                    }
                }
                return k.f(j.a(z0.o(this.f4804a.a(), q.a())));
            } catch (FileNotFoundException unused2) {
                a.b();
                if (this.f4809f != null) {
                    k kVar = new k((z0.b) z0.DEFAULT_INSTANCE.e());
                    h hVar = this.f4809f;
                    synchronized (kVar) {
                        kVar.a(hVar.f4827a, false);
                        int i = a0.a(kVar.b().f4884a).keyInfo_.get(0).keyId_;
                        synchronized (kVar) {
                            for (int i2 = 0; i2 < ((z0) kVar.f5077a.f5063c).key_.size(); i2++) {
                                z0.c cVar = ((z0) kVar.f5077a.f5063c).key_.get(i2);
                                if (cVar.keyId_ == i) {
                                    if (cVar.s().equals(w0.ENABLED)) {
                                        z0.b bVar = kVar.f5077a;
                                        bVar.d();
                                        ((z0) bVar.f5063c).primaryKeyId_ = i;
                                        if (this.f4807d != null) {
                                            j b2 = kVar.b();
                                            l lVar = this.f4805b;
                                            c.b.c.a.a aVar2 = this.f4807d;
                                            z0 z0Var = b2.f4884a;
                                            byte[] a2 = aVar2.a(z0Var.toByteArray(), new byte[0]);
                                            try {
                                                if (z0.o(aVar2.b(a2, new byte[0]), q.a()).equals(z0Var)) {
                                                    n0.b bVar2 = (n0.b) n0.DEFAULT_INSTANCE.e();
                                                    i e2 = i.e(a2);
                                                    bVar2.d();
                                                    n0 n0Var = (n0) bVar2.f5063c;
                                                    if (n0Var != null) {
                                                        e2.getClass();
                                                        n0Var.encryptedKeyset_ = e2;
                                                        a1 a3 = a0.a(z0Var);
                                                        bVar2.d();
                                                        n0 n0Var2 = (n0) bVar2.f5063c;
                                                        if (n0Var2 != null) {
                                                            a3.getClass();
                                                            n0Var2.keysetInfo_ = a3;
                                                            e eVar = (e) lVar;
                                                            if (!eVar.f4818a.putString(eVar.f4819b, t.h1(((n0) bVar2.b()).toByteArray())).commit()) {
                                                                throw new IOException("Failed to write to SharedPreferences");
                                                            }
                                                        } else {
                                                            throw null;
                                                        }
                                                    } else {
                                                        throw null;
                                                    }
                                                } else {
                                                    throw new GeneralSecurityException("cannot encrypt keyset");
                                                }
                                            } catch (b0 unused3) {
                                                throw new GeneralSecurityException("invalid keyset, corrupted key material");
                                            }
                                        } else {
                                            j b3 = kVar.b();
                                            e eVar2 = (e) this.f4805b;
                                            if (!eVar2.f4818a.putString(eVar2.f4819b, t.h1(b3.f4884a.toByteArray())).commit()) {
                                                throw new IOException("Failed to write to SharedPreferences");
                                            }
                                        }
                                        return kVar;
                                    } else {
                                        throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
                                    }
                                }
                            }
                            throw new GeneralSecurityException("key not found: " + i);
                        }
                    }
                }
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }

        public final c.b.c.a.a c() {
            c cVar;
            a.a();
            if (this.f4810g != null) {
                c.b bVar = new c.b();
                KeyStore keyStore = this.f4810g;
                if (keyStore != null) {
                    bVar.f4815b = keyStore;
                    cVar = new c(bVar, null);
                } else {
                    throw new IllegalArgumentException("val cannot be null");
                }
            } else {
                cVar = new c();
            }
            boolean containsAlias = cVar.f4813b.containsAlias(c.b.c.a.m0.n0.b("android-keystore://", this.f4806c));
            if (!containsAlias) {
                try {
                    c.d(this.f4806c);
                } catch (GeneralSecurityException unused) {
                    return null;
                }
            }
            try {
                return cVar.a(this.f4806c);
            } catch (GeneralSecurityException | ProviderException e2) {
                if (!containsAlias) {
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.f4806c), e2);
            }
        }

        public b d(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            } else if (this.f4808e) {
                this.f4806c = str;
                return this;
            } else {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
        }

        public b e(Context context, String str, String str2) {
            if (context != null) {
                this.f4804a = new d(context, str, str2);
                this.f4805b = new e(context, str, str2);
                return this;
            }
            throw new IllegalArgumentException("need an Android context");
        }
    }

    public a(b bVar, C0094a aVar) {
        this.f4803a = bVar.h;
    }

    public static boolean a() {
        return true;
    }

    public static /* synthetic */ String b() {
        return "a";
    }
}
