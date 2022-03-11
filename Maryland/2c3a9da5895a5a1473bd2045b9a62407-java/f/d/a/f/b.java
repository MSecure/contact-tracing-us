package f.d.a.f;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import j.d;
import j.j.b.c;
import j.j.b.e;
import j.j.b.f;

public final class b extends LinkMovementMethod {
    public static final j.b a;
    public static final C0133b b = new C0133b(null);

    public static final class a extends f implements j.j.a.a<b> {
        public static final a c = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // j.j.a.a
        public b a() {
            return new b();
        }
    }

    /* renamed from: f.d.a.f.b$b  reason: collision with other inner class name */
    public static final class C0133b {
        public C0133b(c cVar) {
        }
    }

    static {
        a aVar = a.c;
        e.c(aVar, "initializer");
        a = new d(aVar, null, 2);
    }

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
