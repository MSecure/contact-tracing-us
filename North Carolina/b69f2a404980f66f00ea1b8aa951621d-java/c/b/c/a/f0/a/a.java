package c.b.c.a.f0.a;

import android.content.Context;
import c.b.a.a.c.n.c;
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
    public k f3453a;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public d f3454a = null;

        /* renamed from: b  reason: collision with root package name */
        public l f3455b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f3456c = null;

        /* renamed from: d  reason: collision with root package name */
        public c.b.c.a.a f3457d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3458e = true;
        public h f = null;
        public KeyStore g = null;
        public k h;

        public synchronized a a() {
            if (this.f3456c != null) {
                this.f3457d = c();
            }
            this.h = b();
            return new a(this, null);
        }

        public final k b() {
            try {
                c.b.c.a.a aVar = this.f3457d;
                if (aVar != null) {
                    try {
                        return k.f(j.c(this.f3454a, aVar));
                    } catch (b0 | GeneralSecurityException unused) {
                        a.b();
                    }
                }
                return k.f(j.a(z0.o(this.f3454a.a(), q.a())));
            } catch (FileNotFoundException unused2) {
                a.b();
                if (this.f != null) {
                    k kVar = new k((z0.b) z0.DEFAULT_INSTANCE.e());
                    h hVar = this.f;
                    synchronized (kVar) {
                        kVar.a(hVar.f3475a, false);
                        int i = a0.a(kVar.b().f3517a).keyInfo_.get(0).keyId_;
                        synchronized (kVar) {
                            for (int i2 = 0; i2 < ((z0) kVar.f3686a.f3674c).key_.size(); i2++) {
                                z0.c cVar = ((z0) kVar.f3686a.f3674c).key_.get(i2);
                                if (cVar.keyId_ == i) {
                                    if (cVar.s().equals(w0.ENABLED)) {
                                        z0.b bVar = kVar.f3686a;
                                        bVar.d();
                                        ((z0) bVar.f3674c).primaryKeyId_ = i;
                                        if (this.f3457d != null) {
                                            j b2 = kVar.b();
                                            l lVar = this.f3455b;
                                            c.b.c.a.a aVar2 = this.f3457d;
                                            z0 z0Var = b2.f3517a;
                                            byte[] a2 = aVar2.a(z0Var.toByteArray(), new byte[0]);
                                            try {
                                                if (z0.o(aVar2.b(a2, new byte[0]), q.a()).equals(z0Var)) {
                                                    n0.b bVar2 = (n0.b) n0.DEFAULT_INSTANCE.e();
                                                    i e2 = i.e(a2);
                                                    bVar2.d();
                                                    n0 n0Var = (n0) bVar2.f3674c;
                                                    if (n0Var != null) {
                                                        e2.getClass();
                                                        n0Var.encryptedKeyset_ = e2;
                                                        a1 a3 = a0.a(z0Var);
                                                        bVar2.d();
                                                        n0 n0Var2 = (n0) bVar2.f3674c;
                                                        if (n0Var2 != null) {
                                                            a3.getClass();
                                                            n0Var2.keysetInfo_ = a3;
                                                            e eVar = (e) lVar;
                                                            if (!eVar.f3466a.putString(eVar.f3467b, c.I0(((n0) bVar2.b()).toByteArray())).commit()) {
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
                                            e eVar2 = (e) this.f3455b;
                                            if (!eVar2.f3466a.putString(eVar2.f3467b, c.I0(b3.f3517a.toByteArray())).commit()) {
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
            if (this.g != null) {
                c.b bVar = new c.b();
                KeyStore keyStore = this.g;
                if (keyStore != null) {
                    bVar.f3463b = keyStore;
                    cVar = new c(bVar, null);
                } else {
                    throw new IllegalArgumentException("val cannot be null");
                }
            } else {
                cVar = new c();
            }
            boolean containsAlias = cVar.f3461b.containsAlias(c.b.c.a.m0.n0.b("android-keystore://", this.f3456c));
            if (!containsAlias) {
                try {
                    c.d(this.f3456c);
                } catch (GeneralSecurityException unused) {
                    return null;
                }
            }
            try {
                return cVar.a(this.f3456c);
            } catch (GeneralSecurityException | ProviderException e2) {
                if (!containsAlias) {
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.f3456c), e2);
            }
        }

        public b d(String str) {
            if (!str.startsWith("android-keystore://")) {
                throw new IllegalArgumentException("key URI must start with android-keystore://");
            } else if (this.f3458e) {
                this.f3456c = str;
                return this;
            } else {
                throw new IllegalArgumentException("cannot call withMasterKeyUri() after calling doNotUseKeystore()");
            }
        }

        public b e(Context context, String str, String str2) {
            if (context != null) {
                this.f3454a = new d(context, str, str2);
                this.f3455b = new e(context, str, str2);
                return this;
            }
            throw new IllegalArgumentException("need an Android context");
        }
    }

    public a(b bVar, C0085a aVar) {
        this.f3453a = bVar.h;
    }

    public static boolean a() {
        return true;
    }

    public static /* synthetic */ String b() {
        return "a";
    }
}
