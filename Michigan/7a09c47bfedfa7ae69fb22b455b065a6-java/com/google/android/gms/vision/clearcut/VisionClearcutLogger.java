package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import b.x.t;
import c.b.a.a.c.a;
import c.b.a.a.g.h.b1;
import c.b.a.a.g.h.e1;
import c.b.a.a.g.h.s1;
import c.b.a.a.g.h.t1;
import c.b.a.a.g.h.v;
import java.io.IOException;

@Keep
public class VisionClearcutLogger {
    public final a zzcd;
    public boolean zzce = true;

    public VisionClearcutLogger(Context context) {
        this.zzcd = new a(context, "VISION", null);
    }

    public final void zzb(int i, v vVar) {
        if (vVar != null) {
            try {
                int d2 = vVar.d();
                byte[] bArr = new byte[d2];
                b1 A = b1.A(bArr);
                vVar.f(A);
                if (A.E() != 0) {
                    throw new IllegalStateException("Did not write as much data as expected.");
                } else if (i < 0 || i > 3) {
                    Object[] objArr = {Integer.valueOf(i)};
                    if (Log.isLoggable("Vision", 4)) {
                        String.format("Illegal event code: %d", objArr);
                    }
                } else {
                    try {
                        if (this.zzce) {
                            a aVar = this.zzcd;
                            if (aVar != null) {
                                a.C0061a aVar2 = new a.C0061a(bArr, null);
                                aVar2.f2906g.f3462g = i;
                                aVar2.a();
                                return;
                            }
                            throw null;
                        }
                        v.a aVar3 = (v.a) ((t1.a) v.zzrx.g(5, null, null));
                        try {
                            e1 e1Var = e1.f3868c;
                            if (e1Var == null) {
                                synchronized (e1.class) {
                                    e1Var = e1.f3868c;
                                    if (e1Var == null) {
                                        e1Var = s1.a(e1.class);
                                        e1.f3868c = e1Var;
                                    }
                                }
                            }
                            aVar3.g(bArr, 0, d2, e1Var);
                            Object[] objArr2 = {aVar3.toString()};
                            if (Log.isLoggable("Vision", 6)) {
                                String.format("Would have logged:\n%s", objArr2);
                            }
                        } catch (Exception e2) {
                            t.g1(e2, "Parsing error", new Object[0]);
                        }
                    } catch (Exception e3) {
                        c.b.a.a.g.h.a.f3836a.a(e3);
                        t.g1(e3, "Failed to log", new Object[0]);
                    }
                }
            } catch (IOException e4) {
                String name = v.class.getName();
                StringBuilder sb = new StringBuilder(name.length() + 62 + 10);
                sb.append("Serializing ");
                sb.append(name);
                sb.append(" to a ");
                sb.append("byte array");
                sb.append(" threw an IOException (should never happen).");
                throw new RuntimeException(sb.toString(), e4);
            }
        } else {
            throw null;
        }
    }
}
