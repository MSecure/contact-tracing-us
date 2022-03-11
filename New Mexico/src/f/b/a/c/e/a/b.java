package f.b.a.c.e.a;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public class b implements IInterface {
    public final IBinder a;
    public final String b;

    public b(IBinder iBinder, String str) {
        this.a = iBinder;
        this.b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.a;
    }
}
