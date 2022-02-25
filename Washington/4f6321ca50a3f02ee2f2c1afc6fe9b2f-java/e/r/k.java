package e.r;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.navigation.common.R$styleable;
import e.e.i;
import e.r.j;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class k extends j implements Iterable<j> {

    /* renamed from: j  reason: collision with root package name */
    public final i<j> f1753j = new i<>();

    /* renamed from: k  reason: collision with root package name */
    public int f1754k;

    /* renamed from: l  reason: collision with root package name */
    public String f1755l;

    public class a implements Iterator<j> {
        public int b = -1;
        public boolean c = false;

        public a() {
        }

        public boolean hasNext() {
            return this.b + 1 < k.this.f1753j.h();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public j next() {
            if (hasNext()) {
                this.c = true;
                i<j> iVar = k.this.f1753j;
                int i2 = this.b + 1;
                this.b = i2;
                return iVar.i(i2);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.c) {
                k.this.f1753j.i(this.b).c = null;
                i<j> iVar = k.this.f1753j;
                int i2 = this.b;
                Object[] objArr = iVar.f1200d;
                Object obj = objArr[i2];
                Object obj2 = i.f1199f;
                if (obj != obj2) {
                    objArr[i2] = obj2;
                    iVar.b = true;
                }
                this.b = i2 - 1;
                this.c = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
    }

    public k(q<? extends k> qVar) {
        super(qVar);
    }

    @Override // java.lang.Iterable
    public final Iterator<j> iterator() {
        return new a();
    }

    @Override // e.r.j
    public j.a j(i iVar) {
        j.a j2 = super.j(iVar);
        a aVar = new a();
        while (aVar.hasNext()) {
            j.a j3 = ((j) aVar.next()).j(iVar);
            if (j3 != null && (j2 == null || j3.compareTo(j2) > 0)) {
                j2 = j3;
            }
        }
        return j2;
    }

    @Override // e.r.j
    public void k(Context context, AttributeSet attributeSet) {
        super.k(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.NavGraphNavigator);
        int resourceId = obtainAttributes.getResourceId(R$styleable.NavGraphNavigator_startDestination, 0);
        this.f1754k = resourceId;
        this.f1755l = null;
        this.f1755l = j.i(context, resourceId);
        obtainAttributes.recycle();
    }

    public final void m(j jVar) {
        int i2 = jVar.f1744d;
        if (i2 != 0) {
            j d2 = this.f1753j.d(i2);
            if (d2 != jVar) {
                if (jVar.c == null) {
                    if (d2 != null) {
                        d2.c = null;
                    }
                    jVar.c = this;
                    this.f1753j.g(jVar.f1744d, jVar);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
            return;
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    public final j n(int i2) {
        return o(i2, true);
    }

    public final j o(int i2, boolean z) {
        k kVar;
        j e2 = this.f1753j.e(i2, null);
        if (e2 != null) {
            return e2;
        }
        if (!z || (kVar = this.c) == null) {
            return null;
        }
        return kVar.n(i2);
    }

    @Override // e.r.j
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        j n = n(this.f1754k);
        if (n == null) {
            str = this.f1755l;
            if (str == null) {
                sb.append("0x");
                str = Integer.toHexString(this.f1754k);
            }
        } else {
            sb.append("{");
            sb.append(n.toString());
            str = "}";
        }
        sb.append(str);
        return sb.toString();
    }
}
