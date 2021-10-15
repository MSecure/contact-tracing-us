package dagger.hilt.android.internal.managers;

import android.content.ContextWrapper;
import androidx.fragment.app.Fragment;
import b.o.f;
import b.o.g;
import b.o.i;

public final class ViewComponentManager$FragmentContextWrapper extends ContextWrapper {

    /* renamed from: dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper$1  reason: invalid class name */
    public class AnonymousClass1 implements g {
        @Override // b.o.g
        public void d(i iVar, f.a aVar) {
            if (aVar == f.a.ON_DESTROY) {
                ViewComponentManager$FragmentContextWrapper.a(null);
                throw null;
            }
        }
    }

    public static /* synthetic */ Fragment a(Fragment fragment) {
        throw null;
    }
}
