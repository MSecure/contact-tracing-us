package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import e.y.a;
import e.y.c;
import java.util.Objects;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        c cVar = remoteActionCompat.a;
        if (aVar.i(1)) {
            cVar = aVar.o();
        }
        remoteActionCompat.a = (IconCompat) cVar;
        CharSequence charSequence = remoteActionCompat.b;
        if (aVar.i(2)) {
            charSequence = aVar.h();
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (aVar.i(3)) {
            charSequence2 = aVar.h();
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.f149d = (PendingIntent) aVar.m(remoteActionCompat.f149d, 4);
        boolean z = remoteActionCompat.f150e;
        if (aVar.i(5)) {
            z = aVar.f();
        }
        remoteActionCompat.f150e = z;
        boolean z2 = remoteActionCompat.f151f;
        if (aVar.i(6)) {
            z2 = aVar.f();
        }
        remoteActionCompat.f151f = z2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        Objects.requireNonNull(aVar);
        IconCompat iconCompat = remoteActionCompat.a;
        aVar.p(1);
        aVar.w(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        aVar.p(2);
        aVar.s(charSequence);
        CharSequence charSequence2 = remoteActionCompat.c;
        aVar.p(3);
        aVar.s(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.f149d;
        aVar.p(4);
        aVar.u(pendingIntent);
        boolean z = remoteActionCompat.f150e;
        aVar.p(5);
        aVar.q(z);
        boolean z2 = remoteActionCompat.f151f;
        aVar.p(6);
        aVar.q(z2);
    }
}
