package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import e.a0.b;
import java.util.Objects;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b bVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.a = (IconCompat) bVar.t(remoteActionCompat.a, 1);
        CharSequence charSequence = remoteActionCompat.b;
        if (bVar.j(2)) {
            charSequence = bVar.i();
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (bVar.j(3)) {
            charSequence2 = bVar.i();
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.f153d = (PendingIntent) bVar.o(remoteActionCompat.f153d, 4);
        boolean z = remoteActionCompat.f154e;
        if (bVar.j(5)) {
            z = bVar.g();
        }
        remoteActionCompat.f154e = z;
        boolean z2 = remoteActionCompat.f155f;
        if (bVar.j(6)) {
            z2 = bVar.g();
        }
        remoteActionCompat.f155f = z2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, b bVar) {
        Objects.requireNonNull(bVar);
        IconCompat iconCompat = remoteActionCompat.a;
        bVar.u(1);
        bVar.E(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        bVar.u(2);
        bVar.y(charSequence);
        CharSequence charSequence2 = remoteActionCompat.c;
        bVar.u(3);
        bVar.y(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.f153d;
        bVar.u(4);
        bVar.B(pendingIntent);
        boolean z = remoteActionCompat.f154e;
        bVar.u(5);
        bVar.w(z);
        boolean z2 = remoteActionCompat.f155f;
        bVar.u(6);
        bVar.w(z2);
    }
}
