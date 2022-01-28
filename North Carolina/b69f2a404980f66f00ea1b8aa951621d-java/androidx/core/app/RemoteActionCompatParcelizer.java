package androidx.core.app;

import android.app.PendingIntent;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import b.x.a;
import b.x.b;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        Object obj = remoteActionCompat.f132a;
        if (aVar.h(1)) {
            obj = aVar.k();
        }
        remoteActionCompat.f132a = (IconCompat) obj;
        remoteActionCompat.f133b = aVar.g(remoteActionCompat.f133b, 2);
        remoteActionCompat.f134c = aVar.g(remoteActionCompat.f134c, 3);
        remoteActionCompat.f135d = (PendingIntent) aVar.j(remoteActionCompat.f135d, 4);
        remoteActionCompat.f136e = aVar.f(remoteActionCompat.f136e, 5);
        remoteActionCompat.f = aVar.f(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        if (aVar != null) {
            IconCompat iconCompat = remoteActionCompat.f132a;
            aVar.l(1);
            aVar.o(iconCompat);
            CharSequence charSequence = remoteActionCompat.f133b;
            aVar.l(2);
            b bVar = (b) aVar;
            TextUtils.writeToParcel(charSequence, bVar.f1883e, 0);
            CharSequence charSequence2 = remoteActionCompat.f134c;
            aVar.l(3);
            TextUtils.writeToParcel(charSequence2, bVar.f1883e, 0);
            aVar.n(remoteActionCompat.f135d, 4);
            boolean z = remoteActionCompat.f136e;
            aVar.l(5);
            bVar.f1883e.writeInt(z ? 1 : 0);
            boolean z2 = remoteActionCompat.f;
            aVar.l(6);
            bVar.f1883e.writeInt(z2 ? 1 : 0);
            return;
        }
        throw null;
    }
}
