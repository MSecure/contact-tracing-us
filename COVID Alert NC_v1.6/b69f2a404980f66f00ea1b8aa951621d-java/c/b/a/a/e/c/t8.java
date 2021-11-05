package c.b.a.a.e.c;

import c.b.a.a.c.n.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class t8 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InputStream f2739b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OutputStream f2740c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f2741d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OutputStream f2742e;
    public final /* synthetic */ u8 f;

    public t8(u8 u8Var, InputStream inputStream, OutputStream outputStream, long j, OutputStream outputStream2) {
        this.f = u8Var;
        this.f2739b = inputStream;
        this.f2740c = outputStream;
        this.f2741d = j;
        this.f2742e = outputStream2;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075 A[SYNTHETIC, Splitter:B:37:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0083 A[SYNTHETIC, Splitter:B:42:0x0083] */
    public final void run() {
        Throwable th;
        InputStream inputStream;
        OutputStream outputStream;
        this.f.f2757b = this.f2739b;
        boolean z = false;
        try {
            c.E(this.f2739b, this.f2740c, false, 65536);
            InputStream inputStream2 = this.f2739b;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused) {
                }
            }
            u8.a(this.f2742e, false, this.f2741d);
            OutputStream outputStream2 = this.f2740c;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException unused2) {
                }
            }
            this.f.f2757b = null;
        } catch (IOException unknown) {
            try {
                if (!this.f.f2758c) {
                    String.format("Exception copying stream for Payload %d", Long.valueOf(this.f2741d));
                } else {
                    String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.f2741d));
                }
                InputStream inputStream3 = this.f2739b;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException unused3) {
                    }
                }
                u8.a(this.f2742e, true, this.f2741d);
                OutputStream outputStream3 = this.f2740c;
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (IOException unused4) {
                    }
                }
                this.f.f2757b = null;
            } catch (Throwable th2) {
                z = true;
                th = th2;
                inputStream = this.f2739b;
                if (inputStream != null) {
                }
                u8.a(this.f2742e, z, this.f2741d);
                outputStream = this.f2740c;
                if (outputStream != null) {
                }
                this.f.f2757b = null;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = this.f2739b;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            u8.a(this.f2742e, z, this.f2741d);
            outputStream = this.f2740c;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused6) {
                }
            }
            this.f.f2757b = null;
            throw th;
        }
    }
}
