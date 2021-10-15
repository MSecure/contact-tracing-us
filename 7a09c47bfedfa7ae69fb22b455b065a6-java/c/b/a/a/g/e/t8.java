package c.b.a.a.g.e;

import b.x.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class t8 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InputStream f3735b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OutputStream f3736c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f3737d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ OutputStream f3738e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ u8 f3739f;

    public t8(u8 u8Var, InputStream inputStream, OutputStream outputStream, long j, OutputStream outputStream2) {
        this.f3739f = u8Var;
        this.f3735b = inputStream;
        this.f3736c = outputStream;
        this.f3737d = j;
        this.f3738e = outputStream2;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0075 A[SYNTHETIC, Splitter:B:37:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0083 A[SYNTHETIC, Splitter:B:42:0x0083] */
    public final void run() {
        Throwable th;
        InputStream inputStream;
        OutputStream outputStream;
        this.f3739f.f3756b = this.f3735b;
        boolean z = false;
        try {
            t.O(this.f3735b, this.f3736c, false, 65536);
            InputStream inputStream2 = this.f3735b;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused) {
                }
            }
            u8.a(this.f3738e, false, this.f3737d);
            OutputStream outputStream2 = this.f3736c;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException unused2) {
                }
            }
            this.f3739f.f3756b = null;
        } catch (IOException unknown) {
            try {
                if (!this.f3739f.f3757c) {
                    String.format("Exception copying stream for Payload %d", Long.valueOf(this.f3737d));
                } else {
                    String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.f3737d));
                }
                InputStream inputStream3 = this.f3735b;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException unused3) {
                    }
                }
                u8.a(this.f3738e, true, this.f3737d);
                OutputStream outputStream3 = this.f3736c;
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (IOException unused4) {
                    }
                }
                this.f3739f.f3756b = null;
            } catch (Throwable th2) {
                z = true;
                th = th2;
                inputStream = this.f3735b;
                if (inputStream != null) {
                }
                u8.a(this.f3738e, z, this.f3737d);
                outputStream = this.f3736c;
                if (outputStream != null) {
                }
                this.f3739f.f3756b = null;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = this.f3735b;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused5) {
                }
            }
            u8.a(this.f3738e, z, this.f3737d);
            outputStream = this.f3736c;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException unused6) {
                }
            }
            this.f3739f.f3756b = null;
            throw th;
        }
    }
}
