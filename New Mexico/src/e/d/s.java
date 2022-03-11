package e.d;

import android.security.identity.IdentityCredential;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;
/* loaded from: classes.dex */
public class s {
    public final Signature a;
    public final Cipher b;
    public final Mac c;

    /* renamed from: d  reason: collision with root package name */
    public final IdentityCredential f1264d;

    public s(IdentityCredential identityCredential) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.f1264d = identityCredential;
    }

    public s(Signature signature) {
        this.a = signature;
        this.b = null;
        this.c = null;
        this.f1264d = null;
    }

    public s(Cipher cipher) {
        this.a = null;
        this.b = cipher;
        this.c = null;
        this.f1264d = null;
    }

    public s(Mac mac) {
        this.a = null;
        this.b = null;
        this.c = mac;
        this.f1264d = null;
    }
}
