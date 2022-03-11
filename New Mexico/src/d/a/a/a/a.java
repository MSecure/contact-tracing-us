package d.a.a.a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: d.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0008a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* renamed from: d.a.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0009a implements a {
            public IBinder a;

            public C0009a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // d.a.a.a.a
            public void H(String str, int i2, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(1, obtain, null, 1)) {
                        int i3 = AbstractBinderC0008a.a;
                    }
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }
    }

    void H(String str, int i2, String str2, Notification notification);
}
