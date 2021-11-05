package c.b.b.a;

import c.b.b.a.f;
import c.b.b.a.n;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class a<T> implements Iterator<T> {

    /* renamed from: b  reason: collision with root package name */
    public EnumC0074a f3310b = EnumC0074a.NOT_READY;

    /* renamed from: c  reason: collision with root package name */
    public T f3311c;

    /* renamed from: c.b.b.a.a$a  reason: collision with other inner class name */
    public enum EnumC0074a {
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
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006b, code lost:
        if (r4 >= r5) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
        if (r0.f3337e.a(r0.f3336d.charAt(r4)) == false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007b, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007e, code lost:
        if (r5 <= r4) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0080, code lost:
        r9 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        if (r0.f3337e.a(r0.f3336d.charAt(r9)) == false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0090, code lost:
        r5 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        if (r0.f == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0099, code lost:
        r7 = r0.h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x009b, code lost:
        if (r7 != 1) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009d, code lost:
        r5 = r0.f3336d.length();
        r0.g = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a5, code lost:
        if (r5 <= r4) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a7, code lost:
        r8 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b5, code lost:
        if (r0.f3337e.a(r0.f3336d.charAt(r8)) == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b7, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b9, code lost:
        r0.h = r7 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bc, code lost:
        r0 = (T) r0.f3336d.subSequence(r4, r5).toString();
     */
    public final boolean hasNext() {
        /*
        // Method dump skipped, instructions count: 221
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.b.a.a.hasNext():boolean");
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f3310b = EnumC0074a.NOT_READY;
            T t = this.f3311c;
            this.f3311c = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
