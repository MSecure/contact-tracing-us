package f.d.a.f;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import j.d;
import j.k.b.c;
import j.k.b.e;
import j.k.b.f;
/* loaded from: classes.dex */
public final class b extends LinkMovementMethod {
    public static final j.b a;
    public static final C0135b b = new C0135b(null);

    /* loaded from: classes.dex */
    public static final class a extends f implements j.k.a.a<b> {
        public static final a c = new a();

        public a() {
            super(0);
        }

        @Override // j.k.a.a
        public b a() {
            return new b();
        }
    }

    /* renamed from: f.d.a.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0135b {
        public C0135b(c cVar) {
        }
    }

    static {
        a aVar = a.c;
        e.c(aVar, "initializer");
        a = new d(aVar, null, 2);
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        e.c(textView, "widget");
        e.c(spannable, "buffer");
        e.c(motionEvent, "event");
        try {
            return super.onTouchEvent(textView, spannable, motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }
}
