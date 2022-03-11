package f.b.a.a.a.t;

import android.os.StrictMode;
import f.a.a.a.a;
import f.b.b.f.a.b0;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class d0 {
    public static final StrictMode.ThreadPolicy a = new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    public static final StrictMode.ThreadPolicy b = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    public static ThreadFactory a(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        Boolean bool = Boolean.TRUE;
        String x = a.x(str, " #%d");
        String.format(Locale.ROOT, x, 0);
        return new b0(new ThreadFactory(threadPolicy, i2) { // from class: f.b.a.a.a.t.k
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
                      (wrap: f.b.a.a.a.t.j : 0x0008: CONSTRUCTOR  (r3v0 f.b.a.a.a.t.j A[REMOVE]) = 
                      (wrap: android.os.StrictMode$ThreadPolicy : 0x0000: IGET  (r0v0 android.os.StrictMode$ThreadPolicy A[REMOVE]) = (r4v0 'this' f.b.a.a.a.t.k A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.t.k.b android.os.StrictMode$ThreadPolicy)
                      (wrap: int : 0x0002: IGET  (r1v0 int A[REMOVE]) = (r4v0 'this' f.b.a.a.a.t.k A[IMMUTABLE_TYPE, THIS]) f.b.a.a.a.t.k.c int)
                      (r5v0 'runnable' java.lang.Runnable)
                     call: f.b.a.a.a.t.j.<init>(android.os.StrictMode$ThreadPolicy, int, java.lang.Runnable):void type: CONSTRUCTOR)
                     call: java.lang.Thread.<init>(java.lang.Runnable):void type: CONSTRUCTOR)
                     in method: f.b.a.a.a.t.k.newThread(java.lang.Runnable):java.lang.Thread, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.t.j, state: NOT_LOADED
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
                    f.b.a.a.a.t.j r3 = new f.b.a.a.a.t.j
                    r3.<init>(r0, r1, r5)
                    r2.<init>(r3)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.t.k.newThread(java.lang.Runnable):java.lang.Thread");
            }
        }, x, x != null ? new AtomicLong(0) : null, bool, null, null);
    }
}
