package e.q.a;

import e.b.a.m;
import e.e.i;
import e.p.a0;
import e.p.b0;
import e.p.c0;
import e.p.j;
import e.p.q;
import e.p.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Objects;

public class b extends a {
    public final j a;
    public final C0045b b;

    public static class a<D> extends q<D> {
        @Override // androidx.lifecycle.LiveData
        public void h() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void i() {
            throw null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: e.p.r<? super D> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void k(r<? super D> rVar) {
            super.k(rVar);
        }

        @Override // androidx.lifecycle.LiveData, e.p.q
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
    public static class C0045b extends a0 {

        /* renamed from: d  reason: collision with root package name */
        public static final b0.b f1724d = new a();
        public i<a> c = new i<>();

        /* renamed from: e.q.a.b$b$a */
        public static class a implements b0.b {
            @Override // e.p.b0.b
            public <T extends a0> T a(Class<T> cls) {
                return new C0045b();
            }
        }

        @Override // e.p.a0
        public void a() {
            if (this.c.h() <= 0) {
                i<a> iVar = this.c;
                int i2 = iVar.f1202e;
                Object[] objArr = iVar.f1201d;
                for (int i3 = 0; i3 < i2; i3++) {
                    objArr[i3] = null;
                }
                iVar.f1202e = 0;
                iVar.b = false;
                return;
            }
            Objects.requireNonNull(this.c.i(0));
            throw null;
        }
    }

    public b(j jVar, c0 c0Var) {
        this.a = jVar;
        b0.b bVar = C0045b.f1724d;
        String canonicalName = C0045b.class.getCanonicalName();
        if (canonicalName != null) {
            String t = f.a.a.a.a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            a0 a0Var = c0Var.a.get(t);
            if (!C0045b.class.isInstance(a0Var)) {
                a0Var = bVar instanceof b0.c ? ((b0.c) bVar).c(t, C0045b.class) : ((C0045b.a) bVar).a(C0045b.class);
                a0 put = c0Var.a.put(t, a0Var);
                if (put != null) {
                    put.a();
                }
            } else if (bVar instanceof b0.e) {
                ((b0.e) bVar).b(a0Var);
            }
            this.b = (C0045b) a0Var;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // e.q.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        C0045b bVar = this.b;
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
