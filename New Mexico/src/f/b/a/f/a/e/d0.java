package f.b.a.f.a.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;
/* loaded from: classes.dex */
public final class d0 extends v implements f0 {
    public d0(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.a.f.a.e.f0
    public final void M(String str, Bundle bundle, Bundle bundle2, h0 h0Var) {
        Parcel p = p();
        p.writeString(str);
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        p.writeInt(1);
        bundle2.writeToParcel(p, 0);
        p.writeStrongBinder(h0Var);
        z(11, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.a.f.a.e.f0
    public final void N(String str, Bundle bundle, h0 h0Var) {
        Parcel p = p();
        p.writeString(str);
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        p.writeStrongBinder(h0Var);
        z(5, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.a.f.a.e.f0
    public final void P(String str, Bundle bundle, Bundle bundle2, h0 h0Var) {
        Parcel p = p();
        p.writeString(str);
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        p.writeInt(1);
        bundle2.writeToParcel(p, 0);
        p.writeStrongBinder(h0Var);
        z(7, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.a.f.a.e.f0
    public final void i(String str, List<Bundle> list, Bundle bundle, h0 h0Var) {
        Parcel p = p();
        p.writeString(str);
        p.writeTypedList(list);
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        p.writeStrongBinder(h0Var);
        z(14, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.a.f.a.e.f0
    public final void o(String str, Bundle bundle, h0 h0Var) {
        Parcel p = p();
        p.writeString(str);
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        p.writeStrongBinder(h0Var);
        z(10, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.a.f.a.e.f0
    public final void t(String str, Bundle bundle, Bundle bundle2, h0 h0Var) {
        Parcel p = p();
        p.writeString(str);
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        p.writeInt(1);
        bundle2.writeToParcel(p, 0);
        p.writeStrongBinder(h0Var);
        z(9, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.a.f.a.e.f0
    public final void w(String str, Bundle bundle, Bundle bundle2, h0 h0Var) {
        Parcel p = p();
        p.writeString(str);
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        p.writeInt(1);
        bundle2.writeToParcel(p, 0);
        p.writeStrongBinder(h0Var);
        z(6, p);
    }
}
