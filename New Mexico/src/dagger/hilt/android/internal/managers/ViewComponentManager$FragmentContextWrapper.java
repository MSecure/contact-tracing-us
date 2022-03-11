package dagger.hilt.android.internal.managers;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import e.o.a.m;
import e.r.h;
import e.r.j;
import e.r.l;
import java.util.Objects;
/* loaded from: classes.dex */
public final class ViewComponentManager$FragmentContextWrapper extends ContextWrapper {
    public m a;
    public LayoutInflater b;
    public LayoutInflater c;

    /* renamed from: d  reason: collision with root package name */
    public final j f651d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewComponentManager$FragmentContextWrapper(Context context, m mVar) {
        super(context);
        Objects.requireNonNull(context);
        AnonymousClass1 r2 = new j() { // from class: dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper.1
            @Override // e.r.j
            public void d(l lVar, h.a aVar) {
                if (aVar == h.a.ON_DESTROY) {
                    ViewComponentManager$FragmentContextWrapper viewComponentManager$FragmentContextWrapper = ViewComponentManager$FragmentContextWrapper.this;
                    viewComponentManager$FragmentContextWrapper.a = null;
                    viewComponentManager$FragmentContextWrapper.b = null;
                    viewComponentManager$FragmentContextWrapper.c = null;
                }
            }
        };
        this.f651d = r2;
        this.b = null;
        Objects.requireNonNull(mVar);
        this.a = mVar;
        mVar.O.a(r2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            if (this.b == null) {
                this.b = (LayoutInflater) getBaseContext().getSystemService("layout_inflater");
            }
            this.c = this.b.cloneInContext(this);
        }
        return this.c;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public ViewComponentManager$FragmentContextWrapper(LayoutInflater layoutInflater, m mVar) {
        super(r0);
        Objects.requireNonNull(layoutInflater);
        Context context = layoutInflater.getContext();
        Objects.requireNonNull(context);
        AnonymousClass1 r0 = new j() { // from class: dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper.1
            @Override // e.r.j
            public void d(l lVar, h.a aVar) {
                if (aVar == h.a.ON_DESTROY) {
                    ViewComponentManager$FragmentContextWrapper viewComponentManager$FragmentContextWrapper = ViewComponentManager$FragmentContextWrapper.this;
                    viewComponentManager$FragmentContextWrapper.a = null;
                    viewComponentManager$FragmentContextWrapper.b = null;
                    viewComponentManager$FragmentContextWrapper.c = null;
                }
            }
        };
        this.f651d = r0;
        this.b = layoutInflater;
        Objects.requireNonNull(mVar);
        this.a = mVar;
        mVar.O.a(r0);
    }
}
