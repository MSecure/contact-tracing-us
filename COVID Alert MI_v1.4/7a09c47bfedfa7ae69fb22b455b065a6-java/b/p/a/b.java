package b.p.a;

import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import b.o.i;
import b.o.p;
import b.o.q;
import b.o.x;
import b.o.y;
import b.o.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public final i f2264a;

    /* renamed from: b  reason: collision with root package name */
    public final c f2265b;

    public static class a<D> extends p<D> {

        /* renamed from: a  reason: collision with root package name */
        public i f2266a;

        /* renamed from: b  reason: collision with root package name */
        public C0043b<D> f2267b;

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            throw null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: b.o.q<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void removeObserver(q<? super D> qVar) {
            super.removeObserver(qVar);
            this.f2266a = null;
            this.f2267b = null;
        }

        @Override // androidx.lifecycle.LiveData, b.o.p
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
            i.j.d(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: b.p.a.b$b  reason: collision with other inner class name */
    public static class C0043b<D> implements q<D> {
    }

    public static class c extends x {

        /* renamed from: b  reason: collision with root package name */
        public static final y.b f2268b = new a();

        /* renamed from: a  reason: collision with root package name */
        public b.e.i<a> f2269a = new b.e.i<>();

        public static class a implements y.b {
            @Override // b.o.y.b
            public <T extends x> T a(Class<T> cls) {
                return new c();
            }
        }

        @Override // b.o.x
        public void onCleared() {
            super.onCleared();
            if (this.f2269a.h() > 0) {
                this.f2269a.i(0);
                throw null;
            }
            b.e.i<a> iVar = this.f2269a;
            int i = iVar.f1418e;
            Object[] objArr = iVar.f1417d;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            iVar.f1418e = 0;
            iVar.f1415b = false;
        }
    }

    public b(b.o.i iVar, z zVar) {
        this.f2264a = iVar;
        y.b bVar = c.f2268b;
        String canonicalName = c.class.getCanonicalName();
        if (canonicalName != null) {
            String q = c.a.a.a.a.q("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            x xVar = zVar.f2263a.get(q);
            if (!c.class.isInstance(xVar)) {
                xVar = bVar instanceof y.c ? ((y.c) bVar).c(q, c.class) : ((c.a) bVar).a(c.class);
                x put = zVar.f2263a.put(q, xVar);
                if (put != null) {
                    put.onCleared();
                }
            } else if (bVar instanceof y.e) {
                ((y.e) bVar).b(xVar);
            }
            this.f2265b = (c) xVar;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // b.p.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        c cVar = this.f2265b;
        if (cVar.f2269a.h() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (cVar.f2269a.h() > 0) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(cVar.f2269a.f(0));
                printWriter.print(": ");
                printWriter.println(cVar.f2269a.i(0).toString());
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
        StringBuilder sb = new StringBuilder((int) RecyclerView.a0.FLAG_IGNORE);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        i.j.d(this.f2264a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
