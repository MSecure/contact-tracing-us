package com.google.android.apps.exposurenotification.privateanalytics;

import android.util.Log;
import f.b.a.a.a.r.r;
import f.b.a.a.a.s.c;
import f.b.a.a.a.s.d;
import f.b.a.a.a.s.h;

public class PrioJni implements r {
    static {
        System.loadLibrary("prioclient");
    }

    public static native byte[] createPackets(byte[] bArr);

    @Override // f.b.a.a.a.r.r
    public d a(c cVar) {
        try {
            d parseFrom = d.parseFrom(createPackets(cVar.toByteArray()));
            String str = "Response Status: " + parseFrom.getResponseStatus().getStatusCode();
            if (parseFrom.getResponseStatus().getStatusCode() != h.c.OK) {
                Log.w("PrioJni", "Error when creating packets: " + parseFrom.getResponseStatus().getErrorDetails());
            }
            return parseFrom;
        } catch (Exception unused) {
            Log.w("PrioJni", "Unable to parse responseBytes");
            return null;
        }
    }
}
