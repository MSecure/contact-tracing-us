package f.b.a.d.a;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import f.b.a.a.a.u.q;
import f.b.a.d.a.d0;
import f.b.a.d.a.i0.b;
import f.b.a.d.a.i0.c;
import f.b.b.c.a;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import l.b.a.e;
import l.b.a.v.c;
import l.b.a.v.d;

public class r implements z {

    /* renamed from: d  reason: collision with root package name */
    public static final c f2769d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f2770e = a.a;
    public final Context a;
    public final String b;
    public final d0 c;

    static {
        Locale locale = Locale.US;
        c cVar = c.f4371h;
        d dVar = new d();
        dVar.h("yyyyMMdd");
        f2769d = dVar.r(locale).h(l.b.a.r.f4321g);
    }

    public r(Context context, String str, d0.a aVar) {
        this.a = context;
        this.b = str;
        this.c = aVar.a("PAPrioDeviceAttestation");
    }

    public static byte[] b(String... strArr) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        for (String str : strArr) {
            instance.update(str.getBytes());
        }
        return instance.digest();
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Override // f.b.a.d.a.z
    public boolean a(String str, Map<String, Object> map, f.b.a.d.a.i0.d dVar, b bVar, long j2) {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load(null, null);
        a aVar = f2770e;
        c cVar = f2769d;
        String c2 = aVar.c(b("ENPA::alias", this.b, str, cVar.b(e.y())));
        if (instance.containsAlias(c2)) {
            ((q) this.c).a.g("Cancelling: private analytic already shared today for this metric.");
            return false;
        }
        e v = e.y().m(j2, l.b.a.x.b.HOURS).h(30, l.b.a.x.b.MINUTES);
        byte[] b2 = b("ENPA::attestation", this.b, str, cVar.b(e.y()));
        Context context = this.a;
        KeyPairGenerator instance2 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        try {
            KeyGenParameterSpec.Builder keyValidityEnd = new KeyGenParameterSpec.Builder(c2, 12).setDigests("SHA-256").setAttestationChallenge(b2).setKeyValidityEnd(new Date(v.G()));
            if (Build.VERSION.SDK_INT >= 28 && context.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                keyValidityEnd.setIsStrongBoxBacked(true);
            }
            instance2.initialize(keyValidityEnd.build());
            KeyPair generateKeyPair = instance2.generateKeyPair();
            Map map2 = (Map) map.get("payload");
            c.b g2 = f.b.a.d.a.i0.c.g();
            g2.copyOnWrite();
            f.b.a.d.a.i0.c.c((f.b.a.d.a.i0.c) g2.instance, (String) map2.get("uuid"));
            g2.copyOnWrite();
            f.b.a.d.a.i0.c.f((f.b.a.d.a.i0.c) g2.instance, dVar);
            int intValue = ((Integer) map2.get("schemaVersion")).intValue();
            g2.copyOnWrite();
            f.b.a.d.a.i0.c.d((f.b.a.d.a.i0.c) g2.instance, intValue);
            g2.copyOnWrite();
            f.b.a.d.a.i0.c.e((f.b.a.d.a.i0.c) g2.instance, bVar);
            PrivateKey privateKey = generateKeyPair.getPrivate();
            Signature instance3 = Signature.getInstance("SHA256withECDSA");
            instance3.initSign(privateKey);
            instance3.update(((f.b.a.d.a.i0.c) g2.build()).toByteArray());
            map.put("signature", aVar.c(instance3.sign()));
            Certificate[] certificateChain = instance.getCertificateChain(c2);
            ArrayList arrayList = new ArrayList(certificateChain.length);
            for (Certificate certificate : certificateChain) {
                arrayList.add(f2770e.c(certificate.getEncoded()));
            }
            map.put("certificateChain", arrayList);
            return true;
        } catch (ArithmeticException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
