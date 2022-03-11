package com.google.android.apps.exposurenotification.privateanalytics;

import android.util.Log;
import f.b.a.a.a.r.t;
import f.b.a.a.a.s.c;
import f.b.a.a.a.s.d;
import f.b.a.a.a.s.h;

public class PrioJni implements t {
    public static final b a = new b(null);

    public static class b {
        public boolean a = false;
        public boolean b = false;

        public b(a aVar) {
        }
    }

    public static native byte[] createPackets(byte[] bArr);

    @Override // f.b.a.a.a.r.t
    public d a(c cVar) {
        boolean z;
        h.b newBuilder = h.newBuilder();
        b bVar = a;
        synchronized (bVar) {
            if (!bVar.b) {
                bVar.b = true;
                try {
                    System.loadLibrary("prioclient");
                    bVar.a = true;
                } catch (NullPointerException | SecurityException | UnsatisfiedLinkError e2) {
                    bVar.a = false;
                    Log.e("PrioJni", "Prio native library load failed.", e2);
                }
            }
            z = bVar.a;
        }
        if (z) {
            try {
                d parseFrom = d.parseFrom(createPackets(cVar.toByteArray()));
                String str = "Response Status: " + parseFrom.getResponseStatus().getStatusCode();
                if (parseFrom.getResponseStatus().getStatusCode() != h.c.OK) {
                    Log.w("PrioJni", "Error when creating packets: " + parseFrom.getResponseStatus().getErrorDetails());
                }
                return parseFrom;
            } catch (Exception unused) {
                newBuilder.setStatusCode(h.c.UNKNOWN_FAILURE);
                newBuilder.setErrorDetails("Unable to parse responseBytes");
                Log.w("PrioJni", "Unable to parse responseBytes");
            }
        } else {
            newBuilder.setStatusCode(h.c.LIBRARY_UNAVAILABLE);
            newBuilder.setErrorDetails("Prio is not available.");
            Log.e("PrioJni", "Prio is not available.");
            return (d) d.newBuilder().setResponseStatus((h) newBuilder.build()).build();
        }
    }
}
