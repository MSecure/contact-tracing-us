package androidx.core.app;

import android.app.PendingIntent;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import b.z.b;
import b.z.c;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b bVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f195a = (IconCompat) bVar.p(remoteActionCompat.f195a, 1);
        remoteActionCompat.f196b = bVar.h(remoteActionCompat.f196b, 2);
        remoteActionCompat.f197c = bVar.h(remoteActionCompat.f197c, 3);
        remoteActionCompat.f198d = (PendingIntent) bVar.l(remoteActionCompat.f198d, 4);
        remoteActionCompat.f199e = bVar.g(remoteActionCompat.f199e, 5);
        remoteActionCompat.f200f = bVar.g(remoteActionCompat.f200f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, b bVar) {
        if (bVar != null) {
            IconCompat iconCompat = remoteActionCompat.f195a;
            bVar.q(1);
            bVar.w(iconCompat);
            CharSequence charSequence = remoteActionCompat.f196b;
            bVar.q(2);
            c cVar = (c) bVar;
            TextUtils.writeToParcel(charSequence, cVar.f2791e, 0);
            CharSequence charSequence2 = remoteActionCompat.f197c;
            bVar.q(3);
            TextUtils.writeToParcel(charSequence2, cVar.f2791e, 0);
            bVar.u(remoteActionCompat.f198d, 4);
            boolean z = remoteActionCompat.f199e;
            bVar.q(5);
            cVar.f2791e.writeInt(z ? 1 : 0);
            boolean z2 = remoteActionCompat.f200f;
            bVar.q(6);
            cVar.f2791e.writeInt(z2 ? 1 : 0);
            return;
        }
        throw null;
    }
}
