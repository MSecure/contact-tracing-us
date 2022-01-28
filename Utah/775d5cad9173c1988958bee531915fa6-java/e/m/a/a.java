package e.m.a;

import android.os.Handler;
import androidx.emoji2.text.EmojiCompatInitializer;
import e.b.a.m;
import e.m.a.e;
import e.m.a.j;
import java.util.Objects;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ EmojiCompatInitializer.b b;
    public final /* synthetic */ e.h c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Handler f1631d;

    public /* synthetic */ a(EmojiCompatInitializer.b bVar, e.h hVar, Handler handler) {
        this.b = bVar;
        this.c = hVar;
        this.f1631d = handler;
    }

    public final void run() {
        EmojiCompatInitializer.b bVar = this.b;
        e.h hVar = this.c;
        Handler handler = this.f1631d;
        Objects.requireNonNull(bVar);
        try {
            j D = m.e.D(bVar.a);
            if (D != null) {
                j.b bVar2 = (j.b) D.a;
                synchronized (bVar2.f1648d) {
                    bVar2.f1649e = handler;
                }
                D.a.a(new f(bVar, hVar));
                return;
            }
            throw new RuntimeException("EmojiCompat font provider not available on this device.");
        } catch (Throwable th) {
            hVar.a(th);
            bVar.b();
        }
    }
}
