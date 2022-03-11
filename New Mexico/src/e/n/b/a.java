package e.n.b;

import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import e.b.a.m;
import e.n.a.e;
import java.util.Objects;
/* loaded from: classes.dex */
public final class a {
    public final b a;

    /* renamed from: e.n.b.a$a */
    /* loaded from: classes.dex */
    public static class C0052a extends b {
        public final EditText a;
        public final g b;

        public C0052a(EditText editText, boolean z) {
            this.a = editText;
            g gVar = new g(editText, z);
            this.b = gVar;
            editText.addTextChangedListener(gVar);
            if (b.b == null) {
                synchronized (b.a) {
                    if (b.b == null) {
                        b.b = new b();
                    }
                }
            }
            editText.setEditableFactory(b.b);
        }

        @Override // e.n.b.a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return new e(keyListener);
        }

        @Override // e.n.b.a.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.a, inputConnection, editorInfo);
        }

        @Override // e.n.b.a.b
        public void c(boolean z) {
            g gVar = this.b;
            if (gVar.f1742e != z) {
                if (gVar.f1741d != null) {
                    e a = e.a();
                    e.AbstractC0051e eVar = gVar.f1741d;
                    Objects.requireNonNull(a);
                    m.e.q(eVar, "initCallback cannot be null");
                    a.a.writeLock().lock();
                    try {
                        a.b.remove(eVar);
                    } finally {
                        a.a.writeLock().unlock();
                    }
                }
                gVar.f1742e = z;
                if (z) {
                    g.a(gVar.b, e.a().b());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public KeyListener a(KeyListener keyListener) {
            throw null;
        }

        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            throw null;
        }

        public void c(boolean z) {
            throw null;
        }
    }

    public a(EditText editText, boolean z) {
        m.e.q(editText, "editText cannot be null");
        this.a = new C0052a(editText, z);
    }
}
