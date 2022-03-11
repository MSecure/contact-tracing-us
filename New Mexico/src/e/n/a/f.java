package e.n.a;

import androidx.emoji2.text.EmojiCompatInitializer;
import e.n.a.e;
/* loaded from: classes.dex */
public class f extends e.h {
    public final /* synthetic */ e.h a;
    public final /* synthetic */ EmojiCompatInitializer.b b;

    public f(EmojiCompatInitializer.b bVar, e.h hVar) {
        this.b = bVar;
        this.a = hVar;
    }

    @Override // e.n.a.e.h
    public void a(Throwable th) {
        try {
            this.a.a(th);
        } finally {
            this.b.b();
        }
    }

    @Override // e.n.a.e.h
    public void b(k kVar) {
        try {
            this.a.b(kVar);
        } finally {
            this.b.b();
        }
    }
}
