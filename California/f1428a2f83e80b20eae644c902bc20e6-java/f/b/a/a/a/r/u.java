package f.b.a.a.a.r;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Log;
import f.b.a.a.a.s.f;
import f.b.a.a.a.s.g;
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
import l.b.a.q;
import l.b.a.u.c;
import l.b.a.u.d;
import l.b.a.w.b;

public class u {
    public static final c c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f2226d = a.a;
    public final Context a;
    public final f.b.a.a.a.h.s.a b;

    static {
        Locale locale = Locale.US;
        c cVar = c.f4112h;
        d dVar = new d();
        dVar.h("yyyyMMdd");
        c = dVar.r(locale).h(q.f4062g);
    }

    public u(Context context, f.b.a.a.a.h.s.a aVar) {
        this.a = context;
        this.b = aVar;
    }

    public static byte[] a(String... strArr) {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        for (String str : strArr) {
            instance.update(str.getBytes());
        }
        return instance.digest();
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public boolean c(String str, Map<String, Object> map, g gVar, f.b.a.a.a.s.d dVar, long j2) {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load(null, null);
        a aVar = f2226d;
        c cVar = c;
        String c2 = aVar.c(a("ENPA::alias", this.a.getPackageName(), str, cVar.b(this.b.b())));
        if (instance.containsAlias(c2)) {
            Log.w("PrioDeviceAttestation", "Cancelling: private analytic already shared today for this metric.");
            return false;
        }
        l.b.a.d u = this.b.b().m(j2, b.HOURS).h(30, b.MINUTES);
        byte[] a2 = a("ENPA::attestation", this.a.getPackageName(), str, cVar.b(this.b.b()));
        Context context = this.a;
        KeyPairGenerator instance2 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        try {
            KeyGenParameterSpec.Builder keyValidityEnd = new KeyGenParameterSpec.Builder(c2, 12).setDigests("SHA-256").setAttestationChallenge(a2).setKeyValidityEnd(new Date(u.D()));
            if (Build.VERSION.SDK_INT >= 28 && context.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore")) {
                keyValidityEnd.setIsStrongBoxBacked(true);
            }
            instance2.initialize(keyValidityEnd.build());
            KeyPair generateKeyPair = instance2.generateKeyPair();
            Map map2 = (Map) map.get("payload");
            PrivateKey privateKey = generateKeyPair.getPrivate();
            Signature instance3 = Signature.getInstance("SHA256withECDSA");
            instance3.initSign(privateKey);
            instance3.update(((f) f.newBuilder().setUuid((String) map2.get("uuid")).setPrioParams(gVar).setSchemaVersion(((Integer) map2.get("schemaVersion")).intValue()).setPacketsResponse(dVar).build()).toByteArray());
            map.put("signature", aVar.c(instance3.sign()));
            Certificate[] certificateChain = instance.getCertificateChain(c2);
            ArrayList arrayList = new ArrayList(certificateChain.length);
            for (Certificate certificate : certificateChain) {
                arrayList.add(f2226d.c(certificate.getEncoded()));
            }
            map.put("certificateChain", arrayList);
            return true;
        } catch (ArithmeticException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
