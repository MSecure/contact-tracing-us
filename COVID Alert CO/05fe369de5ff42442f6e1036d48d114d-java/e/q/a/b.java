package e.q.a;

import e.b.a.m;
import e.e.i;
import e.p.e0;
import e.p.f0;
import e.p.g0;
import e.p.l;
import e.p.s;
import e.p.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Objects;

public class b extends a {
    public final l a;
    public final C0044b b;

    public static class a<D> extends s<D> {
        @Override // androidx.lifecycle.LiveData
        public void h() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void i() {
            throw null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: e.p.t<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void k(t<? super D> tVar) {
            super.k(tVar);
        }

        @Override // androidx.lifecycle.LiveData, e.p.s
        public void l(D d2) {
            super.l(d2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            m.h.e(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: e.q.a.b$b  reason: collision with other inner class name */
    public static class C0044b extends e0 {

        /* renamed from: d  reason: collision with root package name */
        public static final f0.b f1554d = new a();
        public i<a> c = new i<>();

        /* renamed from: e.q.a.b$b$a */
        public static class a implements f0.b {
            @Override // e.p.f0.b
            public <T extends e0> T a(Class<T> cls) {
                return new C0044b();
            }
        }

        @Override // e.p.e0
        public void a() {
            if (this.c.h() <= 0) {
                i<a> iVar = this.c;
                int i2 = iVar.f1025e;
                Object[] objArr = iVar.f1024d;
                for (int i3 = 0; i3 < i2; i3++) {
                    objArr[i3] = null;
                }
                iVar.f1025e = 0;
                iVar.b = false;
                return;
            }
            Objects.requireNonNull(this.c.i(0));
            throw null;
        }
    }

    public b(l lVar, g0 g0Var) {
        this.a = lVar;
        f0.b bVar = C0044b.f1554d;
        String canonicalName = C0044b.class.getCanonicalName();
        if (canonicalName != null) {
            String c = f.a.a.a.a.c("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            e0 e0Var = g0Var.a.get(c);
            if (!C0044b.class.isInstance(e0Var)) {
                e0Var = bVar instanceof f0.c ? ((f0.c) bVar).c(c, C0044b.class) : ((C0044b.a) bVar).a(C0044b.class);
                e0 put = g0Var.a.put(c, e0Var);
                if (put != null) {
                    put.a();
                }
            } else if (bVar instanceof f0.e) {
                ((f0.e) bVar).b(e0Var);
            }
            this.b = (C0044b) e0Var;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // e.q.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        C0044b bVar = this.b;
        if (bVar.c.h() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (bVar.c.h() > 0) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(bVar.c.f(0));
                printWriter.print(": ");
                printWriter.println(bVar.c.i(0).toString());
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
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        m.h.e(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
