package e.m.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.inputmethod.EditorInfo;
import e.b.a.m;
import e.m.a.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e {

    /* renamed from: j  reason: collision with root package name */
    public static final Object f1632j = new Object();

    /* renamed from: k  reason: collision with root package name */
    public static volatile e f1633k;
    public final ReadWriteLock a;
    public final Set<AbstractC0047e> b;
    public volatile int c = 3;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1634d;

    /* renamed from: e  reason: collision with root package name */
    public final b f1635e;

    /* renamed from: f  reason: collision with root package name */
    public final g f1636f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1637g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1638h;

    /* renamed from: i  reason: collision with root package name */
    public final d f1639i;

    public static final class a extends b {
        public volatile h b;
        public volatile k c;

        /* renamed from: e.m.a.e$a$a  reason: collision with other inner class name */
        public class C0046a extends h {
            public C0046a() {
            }

            @Override // e.m.a.e.h
            public void a(Throwable th) {
                a.this.a.f(th);
            }

            @Override // e.m.a.e.h
            public void b(k kVar) {
                a aVar = a.this;
                if (kVar == null) {
                    aVar.a.f(new IllegalArgumentException("metadataRepo cannot be null"));
                    return;
                }
                aVar.c = kVar;
                k kVar2 = aVar.c;
                i iVar = new i();
                e eVar = aVar.a;
                d dVar = eVar.f1639i;
                Objects.requireNonNull(eVar);
                aVar.b = new h(kVar2, iVar, dVar, false, null);
                aVar.a.g();
            }
        }

        public a(e eVar) {
            super(eVar);
        }

        @Override // e.m.a.e.b
        public void a() {
            try {
                this.a.f1636f.a(new C0046a());
            } catch (Throwable th) {
                this.a.f(th);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00bc */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:96:0x00d6 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x011e */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x010e */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0137 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.CharSequence] */
        /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[Catch:{ all -> 0x014d }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006f A[Catch:{ all -> 0x014d }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0146  */
        @Override // e.m.a.e.b
        public CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z) {
            SpannableString spannableString;
            int i5;
            i[] iVarArr;
            int i6 = i2;
            int i7 = i3;
            int i8 = i4;
            h hVar = this.b;
            Objects.requireNonNull(hVar);
            boolean z2 = charSequence instanceof l;
            if (z2) {
                ((l) charSequence).a();
            }
            if (!z2) {
                try {
                    if (!(charSequence instanceof Spannable)) {
                        spannableString = (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i6 + -1, i7 + 1, i.class) > i7) ? null : new SpannableString(charSequence);
                        if (!(spannableString == null || (iVarArr = (i[]) spannableString.getSpans(i6, i7, i.class)) == null || iVarArr.length <= 0)) {
                            for (i iVar : iVarArr) {
                                int spanStart = spannableString.getSpanStart(iVar);
                                int spanEnd = spannableString.getSpanEnd(iVar);
                                if (spanStart != i7) {
                                    spannableString.removeSpan(iVar);
                                }
                                i6 = Math.min(spanStart, i6);
                                i7 = Math.max(spanEnd, i7);
                            }
                        }
                        if (i6 != i7) {
                            if (i6 < charSequence.length()) {
                                if (!(i8 == Integer.MAX_VALUE || spannableString == null)) {
                                    i8 -= ((i[]) spannableString.getSpans(0, spannableString.length(), i.class)).length;
                                }
                                h.b bVar = new h.b(hVar.b.c, false, null);
                                int codePointAt = Character.codePointAt(charSequence, i6);
                                int i9 = 0;
                                Spannable spannable = spannableString;
                                loop1:
                                while (true) {
                                    int i10 = codePointAt;
                                    i5 = i6;
                                    while (i6 < i7 && i9 < i8) {
                                        int a = bVar.a(i10);
                                        if (a == 1) {
                                            i6 = Character.charCount(Character.codePointAt(charSequence, i5)) + i5;
                                            if (i6 < i7) {
                                                i10 = Character.codePointAt(charSequence, i6);
                                            }
                                            i5 = i6;
                                        } else if (a == 2) {
                                            i6 += Character.charCount(i10);
                                            if (i6 < i7) {
                                                i10 = Character.codePointAt(charSequence, i6);
                                            }
                                        } else if (a == 3) {
                                            if (z || !hVar.b(charSequence, i5, i6, bVar.f1642d.b)) {
                                                if (spannable == null) {
                                                    spannable = new SpannableString(charSequence);
                                                }
                                                g gVar = bVar.f1642d.b;
                                                Objects.requireNonNull(hVar.a);
                                                spannable.setSpan(new m(gVar), i5, i6, 33);
                                                i9++;
                                            }
                                            codePointAt = i10;
                                            spannable = spannable;
                                        }
                                    }
                                }
                                if ((bVar.a == 2 && bVar.c.b != null && (bVar.f1644f > 1 || bVar.c())) && i9 < i8 && (z || !hVar.b(charSequence, i5, i6, bVar.c.b))) {
                                    if (spannable == null) {
                                        spannable = new SpannableString(charSequence);
                                    }
                                    g gVar2 = bVar.c.b;
                                    Objects.requireNonNull(hVar.a);
                                    spannable.setSpan(new m(gVar2), i5, i6, 33);
                                }
                                if (spannable == null) {
                                    spannable = charSequence;
                                }
                                if (z2) {
                                    ((l) charSequence).b();
                                }
                                return spannable;
                            }
                        }
                        if (z2) {
                            return charSequence;
                        }
                        ((l) charSequence).b();
                        return charSequence;
                    }
                } catch (Throwable th) {
                    if (z2) {
                        ((l) charSequence).b();
                    }
                    throw th;
                }
            }
            spannableString = (Spannable) charSequence;
            while (r12 < r11) {
            }
            if (i6 != i7) {
            }
            if (z2) {
            }
        }

        @Override // e.m.a.e.b
        public void c(EditorInfo editorInfo) {
            Bundle bundle = editorInfo.extras;
            e.m.a.n.b bVar = this.c.a;
            int a = bVar.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", a != 0 ? bVar.b.getInt(a + bVar.a) : 0);
            Bundle bundle2 = editorInfo.extras;
            Objects.requireNonNull(this.a);
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    public static class b {
        public final e a;

        public b(e eVar) {
            this.a = eVar;
        }

        public void a() {
            throw null;
        }

        public CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z) {
            throw null;
        }

        public void c(EditorInfo editorInfo) {
            throw null;
        }
    }

    public static abstract class c {
        public final g a;
        public int b = 0;
        public d c = new h.a();

        public c(g gVar) {
            m.e.q(gVar, "metadataLoader cannot be null.");
            this.a = gVar;
        }
    }

    public interface d {
    }

    /* renamed from: e.m.a.e$e  reason: collision with other inner class name */
    public static abstract class AbstractC0047e {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    public static class f implements Runnable {
        public final List<AbstractC0047e> b;
        public final Throwable c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1640d;

        public f(Collection<AbstractC0047e> collection, int i2, Throwable th) {
            m.e.q(collection, "initCallbacks cannot be null");
            this.b = new ArrayList(collection);
            this.f1640d = i2;
            this.c = th;
        }

        public void run() {
            int size = this.b.size();
            int i2 = 0;
            if (this.f1640d != 1) {
                while (i2 < size) {
                    this.b.get(i2).a(this.c);
                    i2++;
                }
                return;
            }
            while (i2 < size) {
                this.b.get(i2).b();
                i2++;
            }
        }
    }

    public interface g {
        void a(h hVar);
    }

    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(k kVar);
    }

    public static class i {
    }

    public e(c cVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock;
        Objects.requireNonNull(cVar);
        this.f1637g = -16711936;
        this.f1636f = cVar.a;
        int i2 = cVar.b;
        this.f1638h = i2;
        this.f1639i = cVar.c;
        this.f1634d = new Handler(Looper.getMainLooper());
        this.b = new e.e.c(0);
        a aVar = new a(this);
        this.f1635e = aVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i2 == 0) {
            try {
                this.c = 0;
            } catch (Throwable th) {
                this.a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            aVar.a();
        }
    }

    public static e a() {
        e eVar;
        synchronized (f1632j) {
            eVar = f1633k;
            m.e.u(eVar != null, "EmojiCompat is not initialized. Please call EmojiCompat.init() first");
        }
        return eVar;
    }

    public static boolean c() {
        return f1633k != null;
    }

    public int b() {
        this.a.readLock().lock();
        try {
            return this.c;
        } finally {
            this.a.readLock().unlock();
        }
    }

    public final boolean d() {
        return b() == 1;
    }

    public void e() {
        boolean z = true;
        if (this.f1638h != 1) {
            z = false;
        }
        m.e.u(z, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!d()) {
            this.a.writeLock().lock();
            try {
                if (this.c != 0) {
                    this.c = 0;
                    this.a.writeLock().unlock();
                    this.f1635e.a();
                }
            } finally {
                this.a.writeLock().unlock();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void f(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.f1634d.post(new f(arrayList, this.c, th));
        } catch (Throwable th2) {
            this.a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public void g() {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 1;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.f1634d.post(new f(arrayList, this.c, null));
        } catch (Throwable th) {
            this.a.writeLock().unlock();
            throw th;
        }
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, 0, charSequence == null ? 0 : charSequence.length(), Integer.MAX_VALUE, 0);
    }

    public CharSequence i(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        m.e.u(d(), "Not initialized yet");
        m.e.m(i2, "start cannot be negative");
        m.e.m(i3, "end cannot be negative");
        m.e.m(i4, "maxEmojiCount cannot be negative");
        m.e.i(i2 <= i3, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        m.e.i(i2 <= charSequence.length(), "start should be < than charSequence length");
        m.e.i(i3 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i2 == i3) {
            return charSequence;
        }
        return this.f1635e.b(charSequence, i2, i3, i4, i5 == 1);
    }

    public void j(AbstractC0047e eVar) {
        m.e.q(eVar, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            if (this.c != 1) {
                if (this.c != 2) {
                    this.b.add(eVar);
                }
            }
            Handler handler = this.f1634d;
            int i2 = this.c;
            m.e.q(eVar, "initCallback cannot be null");
            handler.post(new f(Arrays.asList(eVar), i2, null));
        } finally {
            this.a.writeLock().unlock();
        }
    }
}
