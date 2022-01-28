package e.m.b;

import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import e.b.a.m;
import e.m.a.e;
import java.util.Objects;

public final class a {
    public final b a;

    /* renamed from: e.m.b.a$a  reason: collision with other inner class name */
    public static class C0048a extends b {
        public final EditText a;
        public final g b;

        public C0048a(EditText editText, boolean z) {
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

        @Override // e.m.b.a.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return new e(keyListener);
        }

        @Override // e.m.b.a.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.a, inputConnection, editorInfo);
        }

        @Override // e.m.b.a.b
        public void c(boolean z) {
            g gVar = this.b;
            if (gVar.f1657e != z) {
                if (gVar.f1656d != null) {
                    e a2 = e.a();
                    e.AbstractC0047e eVar = gVar.f1656d;
                    Objects.requireNonNull(a2);
                    m.e.q(eVar, "initCallback cannot be null");
                    a2.a.writeLock().lock();
                    try {
                        a2.b.remove(eVar);
                    } finally {
                        a2.a.writeLock().unlock();
                    }
                }
                gVar.f1657e = z;
                if (z) {
                    g.a(gVar.b, e.a().b());
                }
            }
        }
    }

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
        this.a = new C0048a(editText, z);
    }
}
