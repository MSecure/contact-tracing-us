package f.b.a.d.a;

import android.os.StrictMode;
import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.b.f.a.a0;
import f.b.b.f.a.b0;
import f.b.b.f.a.w;
import f.b.b.f.a.x;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class t {
    public static final StrictMode.ThreadPolicy a;
    public static final StrictMode.ThreadPolicy b;
    public static w c;

    /* renamed from: d  reason: collision with root package name */
    public static w f2871d;

    /* renamed from: e  reason: collision with root package name */
    public static x f2872e;

    static {
        StrictMode.ThreadPolicy build = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
        a = build;
        StrictMode.ThreadPolicy build2 = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        b = build2;
        c = b.d1(Executors.newFixedThreadPool(4, a("Background", 10, build2)));
        f2871d = b.d1(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors() - 2), a("Lightweight", 0, build)));
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(4, a("Scheduled", 10, build2));
        f2872e = newScheduledThreadPool instanceof x ? (x) newScheduledThreadPool : new a0(newScheduledThreadPool);
    }

    public static ThreadFactory a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        Boolean bool = Boolean.TRUE;
        String x = a.x(str, " #%d");
        String.format(Locale.ROOT, x, 0);
        return new b0(new ThreadFactory(threadPolicy, i2) { // from class: f.b.a.d.a.h
            public final /* synthetic */ StrictMode.ThreadPolicy b;
            public final /* synthetic */ int c;

            {
                this.b = r1;
                this.c = r2;
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: RETURN  
                      (wrap: java.lang.Thread : 0x000b: CONSTRUCTOR  (r2v0 java.lang.Thread A[REMOVE]) = 
                      (wrap: f.b.a.d.a.g : 0x0008: CONSTRUCTOR  (r3v0 f.b.a.d.a.g A[REMOVE]) = 
                      (wrap: android.os.StrictMode$ThreadPolicy : 0x0000: IGET  (r0v0 android.os.StrictMode$ThreadPolicy A[REMOVE]) = (r4v0 'this' f.b.a.d.a.h A[IMMUTABLE_TYPE, THIS]) f.b.a.d.a.h.b android.os.StrictMode$ThreadPolicy)
                      (wrap: int : 0x0002: IGET  (r1v0 int A[REMOVE]) = (r4v0 'this' f.b.a.d.a.h A[IMMUTABLE_TYPE, THIS]) f.b.a.d.a.h.c int)
                      (r5v0 'runnable' java.lang.Runnable)
                     call: f.b.a.d.a.g.<init>(android.os.StrictMode$ThreadPolicy, int, java.lang.Runnable):void type: CONSTRUCTOR)
                     call: java.lang.Thread.<init>(java.lang.Runnable):void type: CONSTRUCTOR)
                     in method: f.b.a.d.a.h.newThread(java.lang.Runnable):java.lang.Thread, file: classes.dex
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
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.d.a.g, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:709)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:328)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    android.os.StrictMode$ThreadPolicy r0 = r4.b
                    int r1 = r4.c
                    java.lang.Thread r2 = new java.lang.Thread
                    f.b.a.d.a.g r3 = new f.b.a.d.a.g
                    r3.<init>(r0, r1, r5)
                    r2.<init>(r3)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.d.a.h.newThread(java.lang.Runnable):java.lang.Thread");
            }
        }, x, x != null ? new AtomicLong(0) : null, bool, null, null);
    }
}
