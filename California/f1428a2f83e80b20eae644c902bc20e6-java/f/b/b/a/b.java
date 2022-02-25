package f.b.b.a;

import f.b.b.a.r;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class b<T> implements Iterator<T> {
    public a b = a.NOT_READY;
    public T c;

    public enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:604)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:486)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:194)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r4 >= r5) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r1.f2864e.a(r1.f2863d.charAt(r4)) == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        if (r5 <= r4) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        r9 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0072, code lost:
        if (r1.f2864e.a(r1.f2863d.charAt(r9)) == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        r5 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0078, code lost:
        if (r1.f2865f == false) goto L_0x007d;
     */
    public final boolean hasNext() {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: f.b.b.a.b.hasNext():boolean");
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.b = a.NOT_READY;
            T t = this.c;
            this.c = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
