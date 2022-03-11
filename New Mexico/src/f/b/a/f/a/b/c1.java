package f.b.a.f.a.b;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class c1 extends OutputStream {
    public final d2 b = new d2();
    public final File c;

    /* renamed from: d  reason: collision with root package name */
    public final y2 f3200d;

    /* renamed from: e  reason: collision with root package name */
    public long f3201e;

    /* renamed from: f  reason: collision with root package name */
    public long f3202f;

    /* renamed from: g  reason: collision with root package name */
    public FileOutputStream f3203g;

    /* renamed from: h  reason: collision with root package name */
    public e3 f3204h;

    public c1(File file, y2 y2Var) {
        this.c = file;
        this.f3200d = y2Var;
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        write(new byte[]{(byte) i2}, 0, 1);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        int i4;
        while (i3 > 0) {
            if (this.f3201e == 0 && this.f3202f == 0) {
                int a = this.b.a(bArr, i2, i3);
                if (a != -1) {
                    i2 += a;
                    i3 -= a;
                    e3 b = this.b.b();
                    this.f3204h = b;
                    if (b.d()) {
                        this.f3201e = 0;
                        this.f3200d.k(this.f3204h.f(), 0, this.f3204h.f().length);
                        this.f3202f = (long) this.f3204h.f().length;
                    } else if (!this.f3204h.h() || this.f3204h.g()) {
                        byte[] f2 = this.f3204h.f();
                        this.f3200d.k(f2, 0, f2.length);
                        this.f3201e = this.f3204h.b();
                    } else {
                        this.f3200d.i(this.f3204h.f());
                        File file = new File(this.c, this.f3204h.c());
                        file.getParentFile().mkdirs();
                        this.f3201e = this.f3204h.b();
                        this.f3203g = new FileOutputStream(file);
                    }
                } else {
                    return;
                }
            }
            if (!this.f3204h.g()) {
                if (this.f3204h.d()) {
                    this.f3200d.d(this.f3202f, bArr, i2, i3);
                    this.f3202f += (long) i3;
                    i4 = i3;
                } else if (this.f3204h.h()) {
                    i4 = (int) Math.min((long) i3, this.f3201e);
                    this.f3203g.write(bArr, i2, i4);
                    long j2 = this.f3201e - ((long) i4);
                    this.f3201e = j2;
                    if (j2 == 0) {
                        this.f3203g.close();
                    }
                } else {
                    i4 = (int) Math.min((long) i3, this.f3201e);
                    int length = this.f3204h.f().length;
                    this.f3200d.d((((long) length) + this.f3204h.b()) - this.f3201e, bArr, i2, i4);
                    this.f3201e -= (long) i4;
                }
                i2 += i4;
                i3 -= i4;
            }
        }
    }
}
