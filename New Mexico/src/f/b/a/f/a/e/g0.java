package f.b.a.f.a.e;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import f.b.a.f.a.b.k;
import f.b.a.f.a.b.s;
/* loaded from: classes.dex */
public abstract class g0 extends w implements h0 {
    public g0() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    @Override // f.b.a.f.a.e.w
    public final boolean p(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (i2) {
            case 2:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) x.a(parcel, Bundle.CREATOR);
                k kVar = (k) this;
                kVar.b.f3289d.c(kVar.a);
                s.f3287g.d("onStartDownload(%d)", Integer.valueOf(readInt));
                break;
            case 3:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) x.a(parcel, Bundle.CREATOR);
                k kVar2 = (k) this;
                kVar2.b.f3289d.c(kVar2.a);
                s.f3287g.d("onCancelDownload(%d)", Integer.valueOf(readInt2));
                break;
            case 4:
                int readInt3 = parcel.readInt();
                Bundle bundle3 = (Bundle) x.a(parcel, Bundle.CREATOR);
                k kVar3 = (k) this;
                kVar3.b.f3289d.c(kVar3.a);
                s.f3287g.d("onGetSession(%d)", Integer.valueOf(readInt3));
                break;
            case 5:
                n(parcel.createTypedArrayList(Bundle.CREATOR));
                break;
            case 6:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundle4 = (Bundle) x.a(parcel, creator);
                Bundle bundle5 = (Bundle) x.a(parcel, creator);
                k kVar4 = (k) this;
                kVar4.b.f3289d.c(kVar4.a);
                s.f3287g.d("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle4.getString("module_name"), bundle4.getString("slice_id"), Integer.valueOf(bundle4.getInt("chunk_number")), Integer.valueOf(bundle4.getInt("session_id")));
                break;
            case 7:
                B((Bundle) x.a(parcel, Bundle.CREATOR));
                break;
            case 8:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                Bundle bundle6 = (Bundle) x.a(parcel, creator2);
                Bundle bundle7 = (Bundle) x.a(parcel, creator2);
                k kVar5 = (k) this;
                kVar5.b.f3289d.c(kVar5.a);
                s.f3287g.d("onNotifyModuleCompleted(%s, sessionId=%d)", bundle6.getString("module_name"), Integer.valueOf(bundle6.getInt("session_id")));
                break;
            case 9:
            default:
                return false;
            case 10:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundle8 = (Bundle) x.a(parcel, creator3);
                k kVar6 = (k) this;
                kVar6.b.f3289d.c(kVar6.a);
                s.f3287g.d("onNotifySessionFailed(%d)", Integer.valueOf(((Bundle) x.a(parcel, creator3)).getInt("session_id")));
                break;
            case 11:
                Parcelable.Creator creator4 = Bundle.CREATOR;
                v((Bundle) x.a(parcel, creator4), (Bundle) x.a(parcel, creator4));
                break;
            case 12:
                Parcelable.Creator creator5 = Bundle.CREATOR;
                h((Bundle) x.a(parcel, creator5), (Bundle) x.a(parcel, creator5));
                break;
            case 13:
                Parcelable.Creator creator6 = Bundle.CREATOR;
                Bundle bundle9 = (Bundle) x.a(parcel, creator6);
                Bundle bundle10 = (Bundle) x.a(parcel, creator6);
                k kVar7 = (k) this;
                kVar7.b.f3289d.c(kVar7.a);
                s.f3287g.d("onRequestDownloadInfo()", new Object[0]);
                break;
            case 14:
                Parcelable.Creator creator7 = Bundle.CREATOR;
                Bundle bundle11 = (Bundle) x.a(parcel, creator7);
                Bundle bundle12 = (Bundle) x.a(parcel, creator7);
                k kVar8 = (k) this;
                kVar8.b.f3289d.c(kVar8.a);
                s.f3287g.d("onRemoveModule()", new Object[0]);
                break;
            case 15:
                Bundle bundle13 = (Bundle) x.a(parcel, Bundle.CREATOR);
                k kVar9 = (k) this;
                kVar9.b.f3289d.c(kVar9.a);
                s.f3287g.d("onCancelDownloads()", new Object[0]);
                break;
        }
        return true;
    }
}
