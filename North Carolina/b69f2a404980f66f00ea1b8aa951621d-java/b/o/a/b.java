package b.o.a;

import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import b.n.i;
import b.n.p;
import b.n.q;
import b.n.x;
import b.n.y;
import b.n.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final i f1428a;

    /* renamed from: b  reason: collision with root package name */
    public final c f1429b;

    public static class a<D> extends p<D> {

        /* renamed from: a  reason: collision with root package name */
        public i f1430a;

        /* renamed from: b  reason: collision with root package name */
        public C0033b<D> f1431b;

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            throw null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: b.n.q<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(q<? super D> qVar) {
            super.removeObserver(qVar);
            this.f1430a = null;
            this.f1431b = null;
        }

        @Override // androidx.lifecycle.LiveData, b.n.p
        public void setValue(D d2) {
            super.setValue(d2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            i.j.f(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: b.o.a.b$b  reason: collision with other inner class name */
    public static class C0033b<D> implements q<D> {
    }

    public static class c extends x {

        /* renamed from: b  reason: collision with root package name */
        public static final y.b f1432b = new a();

        /* renamed from: a  reason: collision with root package name */
        public b.e.i<a> f1433a = new b.e.i<>(10);

        public static class a implements y.b {
            @Override // b.n.y.b
            public <T extends x> T a(Class<T> cls) {
                return new c();
            }
        }

        @Override // b.n.x
        public void onCleared() {
            super.onCleared();
            if (this.f1433a.i() > 0) {
                this.f1433a.j(0);
                throw null;
            }
            b.e.i<a> iVar = this.f1433a;
            int i = iVar.f833e;
            Object[] objArr = iVar.f832d;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            iVar.f833e = 0;
            iVar.f830b = false;
        }
    }

    public b(b.n.i iVar, z zVar) {
        this.f1428a = iVar;
        y.b bVar = c.f1432b;
        String canonicalName = c.class.getCanonicalName();
        if (canonicalName != null) {
            String o = c.a.a.a.a.o("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            x xVar = zVar.f1427a.get(o);
            if (!c.class.isInstance(xVar)) {
                xVar = bVar instanceof y.c ? ((y.c) bVar).c(o, c.class) : ((c.a) bVar).a(c.class);
                x put = zVar.f1427a.put(o, xVar);
                if (put != null) {
                    put.onCleared();
                }
            } else if (bVar instanceof y.e) {
                ((y.e) bVar).b(xVar);
            }
            this.f1429b = (c) xVar;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // b.o.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        c cVar = this.f1429b;
        if (cVar.f1433a.i() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (cVar.f1433a.i() > 0) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(cVar.f1433a.f(0));
                printWriter.print(": ");
                printWriter.println(cVar.f1433a.j(0).toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(0);
                printWriter.print(" mArgs=");
                printWriter.println((Object) null);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println((Object) null);
                throw null;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) RecyclerView.d0.FLAG_IGNORE);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        i.j.f(this.f1428a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
