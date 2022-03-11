package f.b.a.b.i;

import android.content.Context;
import f.b.a.b.b;
import f.b.a.b.g;
import f.b.a.b.i.b;
import f.b.a.b.i.i;
import f.b.a.b.i.s.e;
import f.b.a.b.i.s.h.l;
import f.b.a.b.i.s.h.p;
import f.b.a.b.i.u.a;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class m implements l {

    /* renamed from: e */
    public static volatile n f2626e;
    public final a a;
    public final a b;
    public final e c;

    /* renamed from: d */
    public final l f2627d;

    public m(a aVar, a aVar2, e eVar, l lVar, p pVar) {
        this.a = aVar;
        this.b = aVar2;
        this.c = eVar;
        this.f2627d = lVar;
        pVar.a.execute(new Runnable(pVar) { // from class: f.b.a.b.i.s.h.n
            public final p b;

            {
                this.b = r1;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
                  (wrap: f.b.a.b.i.t.b : 0x0002: IGET  (r1v0 f.b.a.b.i.t.b A[REMOVE]) = (r0v0 'pVar2' f.b.a.b.i.s.h.p) f.b.a.b.i.s.h.p.d f.b.a.b.i.t.b)
                  (wrap: f.b.a.b.i.s.h.o : 0x0006: CONSTRUCTOR  (r2v0 f.b.a.b.i.s.h.o A[REMOVE]) = (r0v0 'pVar2' f.b.a.b.i.s.h.p) call: f.b.a.b.i.s.h.o.<init>(f.b.a.b.i.s.h.p):void type: CONSTRUCTOR)
                 type: INTERFACE call: f.b.a.b.i.t.b.c(f.b.a.b.i.t.b$a):java.lang.Object in method: f.b.a.b.i.s.h.n.run():void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.b.i.s.h.o, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 10 more
                */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    r3 = this;
                    f.b.a.b.i.s.h.p r0 = r3.b
                    f.b.a.b.i.t.b r1 = r0.f2655d
                    f.b.a.b.i.s.h.o r2 = new f.b.a.b.i.s.h.o
                    r2.<init>(r0)
                    r1.c(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.b.i.s.h.n.run():void");
            }
        });
    }

    public static m a() {
        n nVar = f2626e;
        if (nVar != null) {
            return ((c) nVar).m.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f2626e == null) {
            synchronized (m.class) {
                if (f2626e == null) {
                    Objects.requireNonNull(context);
                    f2626e = new c(context, null);
                }
            }
        }
    }

    public g c(d dVar) {
        Set set;
        if (dVar instanceof d) {
            Objects.requireNonNull((f.b.a.b.h.a) dVar);
            set = Collections.unmodifiableSet(f.b.a.b.h.a.f2564f);
        } else {
            set = Collections.singleton(new b("proto"));
        }
        i.a a = i.a();
        Objects.requireNonNull(dVar);
        a.b("cct");
        b.C0078b bVar = (b.C0078b) a;
        bVar.b = ((f.b.a.b.h.a) dVar).b();
        return new j(set, bVar.a(), this);
    }
}
