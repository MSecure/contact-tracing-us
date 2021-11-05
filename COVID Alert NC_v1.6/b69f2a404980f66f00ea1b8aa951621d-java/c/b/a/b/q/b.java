package c.b.a.b.q;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class b extends FloatingActionButton.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3177a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3178b;

    public class a extends FloatingActionButton.a {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public void b(FloatingActionButton floatingActionButton) {
            BottomAppBar.v(b.this.f3178b);
        }
    }

    public b(BottomAppBar bottomAppBar, int i) {
        this.f3178b = bottomAppBar;
        this.f3177a = i;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(this.f3178b.E(this.f3177a));
        floatingActionButton.n(new a(), true);
    }
}
