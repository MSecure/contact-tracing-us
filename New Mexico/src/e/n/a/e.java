package e.n.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.inputmethod.EditorInfo;
import e.b.a.m;
import e.n.a.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes.dex */
public class e {

    /* renamed from: j */
    public static final Object f1717j = new Object();

    /* renamed from: k */
    public static volatile e f1718k;
    public final ReadWriteLock a;
    public volatile int c;

    /* renamed from: e */
    public final b f1720e;

    /* renamed from: f */
    public final g f1721f;

    /* renamed from: h */
    public final int f1723h;

    /* renamed from: i */
    public final d f1724i;

    /* renamed from: g */
    public final int f1722g = -16711936;

    /* renamed from: d */
    public final Handler f1719d = new Handler(Looper.getMainLooper());
    public final Set<AbstractC0051e> b = new e.f.c(0);

    /* loaded from: classes.dex */
    public static final class a extends b {
        public volatile h b;
        public volatile k c;

        /* renamed from: e.n.a.e$a$a */
        /* loaded from: classes.dex */
        public class C0050a extends h {
            public C0050a() {
                a.this = r1;
            }

            @Override // e.n.a.e.h
            public void a(Throwable th) {
                a.this.a.f(th);
            }

            @Override // e.n.a.e.h
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
                d dVar = eVar.f1724i;
                Objects.requireNonNull(eVar);
                aVar.b = new h(kVar2, iVar, dVar, false, null);
                aVar.a.g();
            }
        }

        public a(e eVar) {
            super(eVar);
        }

        @Override // e.n.a.e.b
        public void a() {
            try {
                this.a.f1721f.a(new C0050a());
            } catch (Throwable th) {
                this.a.f(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:88:0x014c, code lost:
            return r17;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0053 A[Catch: all -> 0x014d, TryCatch #0 {all -> 0x014d, blocks: (B:7:0x001c, B:10:0x0021, B:12:0x0025, B:14:0x0034, B:16:0x003c, B:19:0x0042, B:21:0x004c, B:23:0x004f, B:25:0x0053, B:27:0x005f, B:28:0x0062, B:30:0x006f, B:36:0x007e, B:37:0x008c, B:42:0x00a4, B:49:0x00b2, B:52:0x00be, B:53:0x00c3, B:55:0x00d9, B:57:0x00e0, B:58:0x00e5, B:60:0x00f0, B:63:0x00f7, B:65:0x00fb, B:67:0x0101, B:69:0x0105, B:76:0x0114, B:79:0x0120, B:80:0x0126), top: B:93:0x001c }] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00e5 A[Catch: all -> 0x014d, TryCatch #0 {all -> 0x014d, blocks: (B:7:0x001c, B:10:0x0021, B:12:0x0025, B:14:0x0034, B:16:0x003c, B:19:0x0042, B:21:0x004c, B:23:0x004f, B:25:0x0053, B:27:0x005f, B:28:0x0062, B:30:0x006f, B:36:0x007e, B:37:0x008c, B:42:0x00a4, B:49:0x00b2, B:52:0x00be, B:53:0x00c3, B:55:0x00d9, B:57:0x00e0, B:58:0x00e5, B:60:0x00f0, B:63:0x00f7, B:65:0x00fb, B:67:0x0101, B:69:0x0105, B:76:0x0114, B:79:0x0120, B:80:0x0126), top: B:93:0x001c }] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0120 A[Catch: all -> 0x014d, TryCatch #0 {all -> 0x014d, blocks: (B:7:0x001c, B:10:0x0021, B:12:0x0025, B:14:0x0034, B:16:0x003c, B:19:0x0042, B:21:0x004c, B:23:0x004f, B:25:0x0053, B:27:0x005f, B:28:0x0062, B:30:0x006f, B:36:0x007e, B:37:0x008c, B:42:0x00a4, B:49:0x00b2, B:52:0x00be, B:53:0x00c3, B:55:0x00d9, B:57:0x00e0, B:58:0x00e5, B:60:0x00f0, B:63:0x00f7, B:65:0x00fb, B:67:0x0101, B:69:0x0105, B:76:0x0114, B:79:0x0120, B:80:0x0126), top: B:93:0x001c }] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x013c  */
        /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.CharSequence] */
        @Override // e.n.a.e.b
        /* Code decompiled incorrectly, please refer to instructions dump */
        public CharSequence b(CharSequence charSequence, int i2, int i3, int i4, boolean z) {
            SpannableString spannableString;
            h.b bVar;
            int codePointAt;
            SpannableString spannableString2;
            int i5;
            int i6;
            int a;
            i[] iVarArr;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            h hVar = this.b;
            Objects.requireNonNull(hVar);
            boolean z2 = charSequence instanceof l;
            if (z2) {
                ((l) charSequence).a();
            }
            if (!z2) {
                try {
                    if (!(charSequence instanceof Spannable)) {
                        spannableString = (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i7 + -1, i8 + 1, i.class) > i8) ? null : new SpannableString(charSequence);
                        if (!(spannableString == null || (iVarArr = (i[]) spannableString.getSpans(i7, i8, i.class)) == null || iVarArr.length <= 0)) {
                            for (i iVar : iVarArr) {
                                int spanStart = spannableString.getSpanStart(iVar);
                                int spanEnd = spannableString.getSpanEnd(iVar);
                                if (spanStart != i8) {
                                    spannableString.removeSpan(iVar);
                                }
                                i7 = Math.min(spanStart, i7);
                                i8 = Math.max(spanEnd, i8);
                            }
                        }
                        if (i7 != i8 && i7 < charSequence.length()) {
                            if (!(i9 == Integer.MAX_VALUE || spannableString == null)) {
                                i9 -= ((i[]) spannableString.getSpans(0, spannableString.length(), i.class)).length;
                            }
                            bVar = new h.b(hVar.b.c, false, null);
                            codePointAt = Character.codePointAt(charSequence, i7);
                            int i10 = 0;
                            spannableString2 = spannableString;
                            loop1: while (true) {
                                i5 = codePointAt;
                                i6 = i7;
                                while (i7 < i8 && i10 < i9) {
                                    a = bVar.a(i5);
                                    if (a != 1) {
                                        i7 = Character.charCount(Character.codePointAt(charSequence, i6)) + i6;
                                        if (i7 < i8) {
                                            i5 = Character.codePointAt(charSequence, i7);
                                        }
                                        i6 = i7;
                                    } else if (a == 2) {
                                        i7 += Character.charCount(i5);
                                        if (i7 < i8) {
                                            i5 = Character.codePointAt(charSequence, i7);
                                        }
                                    } else if (a == 3) {
                                        if (z || !hVar.b(charSequence, i6, i7, bVar.f1727d.b)) {
                                            if (spannableString2 == null) {
                                                spannableString2 = new SpannableString(charSequence);
                                            }
                                            g gVar = bVar.f1727d.b;
                                            Objects.requireNonNull(hVar.a);
                                            spannableString2.setSpan(new m(gVar), i6, i7, 33);
                                            i10++;
                                        }
                                        codePointAt = i5;
                                        spannableString2 = spannableString2;
                                    }
                                }
                            }
                            if (((bVar.a == 2 || bVar.c.b == null || (bVar.f1729f <= 1 && !bVar.c())) ? false : true) && i10 < i9 && (z || !hVar.b(charSequence, i6, i7, bVar.c.b))) {
                                if (spannableString2 == null) {
                                    spannableString2 = new SpannableString(charSequence);
                                }
                                g gVar2 = bVar.c.b;
                                Objects.requireNonNull(hVar.a);
                                spannableString2.setSpan(new m(gVar2), i6, i7, 33);
                            }
                            if (spannableString2 == null) {
                                spannableString2 = charSequence;
                            }
                            if (z2) {
                                ((l) charSequence).b();
                            }
                            return spannableString2;
                        }
                        return charSequence;
                    }
                } finally {
                    if (z2) {
                        ((l) charSequence).b();
                    }
                }
            }
            spannableString = (Spannable) charSequence;
            if (spannableString == null) {
                while (r12 < r11) {
                }
            }
            if (i7 != i8) {
                if (i9 == Integer.MAX_VALUE) {
                    i9 -= ((i[]) spannableString.getSpans(0, spannableString.length(), i.class)).length;
                }
                bVar = new h.b(hVar.b.c, false, null);
                codePointAt = Character.codePointAt(charSequence, i7);
                int i102 = 0;
                spannableString2 = spannableString;
                loop1: while (true) {
                    i5 = codePointAt;
                    i6 = i7;
                    while (i7 < i8) {
                        a = bVar.a(i5);
                        if (a != 1) {
                        }
                    }
                    codePointAt = i5;
                    spannableString2 = spannableString2;
                }
                if ((bVar.a == 2 || bVar.c.b == null || (bVar.f1729f <= 1 && !bVar.c())) ? false : true) {
                    if (spannableString2 == null) {
                    }
                    g gVar22 = bVar.c.b;
                    Objects.requireNonNull(hVar.a);
                    spannableString2.setSpan(new m(gVar22), i6, i7, 33);
                }
                if (spannableString2 == null) {
                }
                if (z2) {
                }
                return spannableString2;
            }
            return charSequence;
        }

        @Override // e.n.a.e.b
        public void c(EditorInfo editorInfo) {
            Bundle bundle = editorInfo.extras;
            e.n.a.n.b bVar = this.c.a;
            int a = bVar.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", a != 0 ? bVar.b.getInt(a + bVar.a) : 0);
            Bundle bundle2 = editorInfo.extras;
            Objects.requireNonNull(this.a);
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    public static abstract class c {
        public final g a;
        public int b = 0;
        public d c = new h.a();

        public c(g gVar) {
            m.e.q(gVar, "metadataLoader cannot be null.");
            this.a = gVar;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* renamed from: e.n.a.e$e */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0051e {
        public void a(Throwable th) {
        }

        public void b() {
        }
    }

    /* loaded from: classes.dex */
    public static class f implements Runnable {
        public final List<AbstractC0051e> b;
        public final Throwable c;

        /* renamed from: d */
        public final int f1725d;

        public f(Collection<AbstractC0051e> collection, int i2, Throwable th) {
            m.e.q(collection, "initCallbacks cannot be null");
            this.b = new ArrayList(collection);
            this.f1725d = i2;
            this.c = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.b.size();
            int i2 = 0;
            if (this.f1725d != 1) {
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

    /* loaded from: classes.dex */
    public interface g {
        void a(h hVar);
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public abstract void a(Throwable th);

        public abstract void b(k kVar);
    }

    /* loaded from: classes.dex */
    public static class i {
    }

    public e(c cVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock;
        this.c = 3;
        Objects.requireNonNull(cVar);
        this.f1721f = cVar.a;
        int i2 = cVar.b;
        this.f1723h = i2;
        this.f1724i = cVar.c;
        a aVar = new a(this);
        this.f1720e = aVar;
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
        synchronized (f1717j) {
            eVar = f1718k;
            m.e.u(eVar != null, "EmojiCompat is not initialized. Please call EmojiCompat.init() first");
        }
        return eVar;
    }

    public static boolean c() {
        return f1718k != null;
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
        if (this.f1723h != 1) {
            z = false;
        }
        m.e.u(z, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!d()) {
            this.a.writeLock().lock();
            try {
                if (this.c != 0) {
                    this.c = 0;
                    this.a.writeLock().unlock();
                    this.f1720e.a();
                }
            } finally {
                this.a.writeLock().unlock();
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public void f(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.f1719d.post(new f(arrayList, this.c, th));
        } catch (Throwable th2) {
            this.a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Finally extract failed */
    public void g() {
        ArrayList arrayList = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 1;
            arrayList.addAll(this.b);
            this.b.clear();
            this.a.writeLock().unlock();
            this.f1719d.post(new f(arrayList, this.c, null));
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
        return this.f1720e.b(charSequence, i2, i3, i4, i5 == 1);
    }

    public void j(AbstractC0051e eVar) {
        m.e.q(eVar, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            if (!(this.c == 1 || this.c == 2)) {
                this.b.add(eVar);
            }
            Handler handler = this.f1719d;
            int i2 = this.c;
            m.e.q(eVar, "initCallback cannot be null");
            handler.post(new f(Arrays.asList(eVar), i2, null));
        } finally {
            this.a.writeLock().unlock();
        }
    }
}
