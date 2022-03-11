package e.d;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import androidx.biometric.R$array;
import androidx.biometric.R$string;
import e.b.a.m;
import e.r.t;
/* loaded from: classes.dex */
public class h implements t<d> {
    public final /* synthetic */ e a;

    public h(e eVar) {
        this.a = eVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0096, code lost:
        if (r10 != false) goto L_0x009b;
     */
    @Override // e.r.t
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void a(d dVar) {
        boolean z;
        boolean z2;
        d dVar2 = dVar;
        if (dVar2 != null) {
            e eVar = this.a;
            int i2 = dVar2.a;
            CharSequence charSequence = dVar2.b;
            int i3 = 0;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    z = true;
                    break;
                case 6:
                default:
                    z = false;
                    break;
            }
            if (!z) {
                i2 = 8;
            }
            Context k2 = eVar.k();
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 29) {
                if ((i2 == 7 || i2 == 9) && k2 != null && w.d(k2) && m.e.N0(eVar.X.c())) {
                    eVar.M0();
                    this.a.X.k(null);
                }
            }
            if (eVar.L0()) {
                if (charSequence == null) {
                    charSequence = m.e.m0(eVar.k(), i2);
                }
                if (i2 == 5) {
                    int i5 = eVar.X.f1272k;
                    if (i5 == 0 || i5 == 3) {
                        eVar.N0(i2, charSequence);
                    }
                    eVar.I0();
                } else {
                    if (eVar.X.v) {
                        eVar.N0(i2, charSequence);
                        eVar.I0();
                    } else {
                        eVar.P0(charSequence);
                        Handler handler = eVar.W;
                        n nVar = new n(eVar, i2, charSequence);
                        Context k3 = eVar.k();
                        if (k3 != null) {
                            String str = Build.MODEL;
                            if (i4 != 28) {
                                z2 = false;
                            } else {
                                z2 = m.e.R0(k3, str, R$array.hide_fingerprint_instantly_prefixes);
                            }
                        }
                        i3 = 2000;
                        handler.postDelayed(nVar, (long) i3);
                    }
                    eVar.X.v = true;
                }
            } else {
                if (charSequence == null) {
                    charSequence = eVar.F(R$string.default_error_msg) + " " + i2;
                }
                eVar.N0(i2, charSequence);
                eVar.I0();
            }
            this.a.X.k(null);
        }
    }
}
