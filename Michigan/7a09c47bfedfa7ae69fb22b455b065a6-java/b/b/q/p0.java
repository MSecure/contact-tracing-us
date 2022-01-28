package b.b.q;

import com.google.android.gms.nearby.messages.BleSignal;

public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public int f904a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f905b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f906c = BleSignal.UNKNOWN_TX_POWER;

    /* renamed from: d  reason: collision with root package name */
    public int f907d = BleSignal.UNKNOWN_TX_POWER;

    /* renamed from: e  reason: collision with root package name */
    public int f908e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f909f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f910g = false;
    public boolean h = false;

    public void a(int i, int i2) {
        this.f906c = i;
        this.f907d = i2;
        this.h = true;
        if (this.f910g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f904a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f905b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f904a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f905b = i2;
        }
    }
}
