package c.b.a.b.q;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class b extends FloatingActionButton.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4489a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f4490b;

    public class a extends FloatingActionButton.a {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public void b(FloatingActionButton floatingActionButton) {
            BottomAppBar.w(b.this.f4490b);
        }
    }

    public b(BottomAppBar bottomAppBar, int i) {
        this.f4490b = bottomAppBar;
        this.f4489a = i;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(this.f4490b.F(this.f4489a));
        floatingActionButton.n(new a(), true);
    }
}
