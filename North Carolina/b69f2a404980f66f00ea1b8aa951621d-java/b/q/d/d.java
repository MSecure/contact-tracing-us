package b.q.d;

import android.os.Handler;
import android.os.Looper;
import b.q.d.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class d<T> {
    public static final Executor h = new c();

    /* renamed from: a  reason: collision with root package name */
    public final w f1468a;

    /* renamed from: b  reason: collision with root package name */
    public final c<T> f1469b;

    /* renamed from: c  reason: collision with root package name */
    public Executor f1470c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b<T>> f1471d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<T> f1472e;
    public List<T> f = Collections.emptyList();
    public int g;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f1473b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f1474c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f1475d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f1476e;

        /* renamed from: b.q.d.d$a$a  reason: collision with other inner class name */
        public class C0035a extends p.b {
            public C0035a() {
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: b.q.d.p$d<T> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // b.q.d.p.b
            public boolean a(int i, int i2) {
                Object obj = a.this.f1473b.get(i);
                Object obj2 = a.this.f1474c.get(i2);
                if (obj != null && obj2 != null) {
                    return d.this.f1469b.f1463c.areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: b.q.d.p$d<T> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // b.q.d.p.b
            public boolean b(int i, int i2) {
                Object obj = a.this.f1473b.get(i);
                Object obj2 = a.this.f1474c.get(i2);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                return d.this.f1469b.f1463c.areItemsTheSame(obj, obj2);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: b.q.d.p$d<T> */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // b.q.d.p.b
            public Object c(int i, int i2) {
                Object obj = a.this.f1473b.get(i);
                Object obj2 = a.this.f1474c.get(i2);
                if (obj != null && obj2 != null) {
                    return d.this.f1469b.f1463c.getChangePayload(obj, obj2);
                }
                throw new AssertionError();
            }
        }

        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ p.c f1478b;

            public b(p.c cVar) {
                this.f1478b = cVar;
            }

            public void run() {
                p.g gVar;
                int i;
                List<T> list;
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.g == aVar.f1475d) {
                    List<T> list2 = aVar.f1474c;
                    p.c cVar = this.f1478b;
                    Runnable runnable = aVar.f1476e;
                    List<T> list3 = dVar.f;
                    dVar.f1472e = list2;
                    dVar.f = Collections.unmodifiableList(list2);
                    w wVar = dVar.f1468a;
                    if (cVar != null) {
                        e eVar = wVar instanceof e ? (e) wVar : new e(wVar);
                        ArrayList arrayList = new ArrayList();
                        int i2 = cVar.f1551e;
                        int i3 = cVar.f;
                        int size = cVar.f1547a.size() - 1;
                        while (size >= 0) {
                            p.g gVar2 = cVar.f1547a.get(size);
                            int i4 = gVar2.f1561c;
                            int i5 = gVar2.f1559a + i4;
                            int i6 = gVar2.f1560b + i4;
                            if (i5 < i2) {
                                int i7 = i2 - i5;
                                if (!cVar.g) {
                                    eVar.a(i5, i7);
                                } else {
                                    int i8 = i7 - 1;
                                    while (i8 >= 0) {
                                        int i9 = i5 + i8;
                                        int i10 = cVar.f1548b[i9] & 31;
                                        if (i10 == 0) {
                                            list = list3;
                                            i = size;
                                            gVar = gVar2;
                                            int i11 = 1;
                                            eVar.a(i9, 1);
                                            Iterator it = arrayList.iterator();
                                            while (it.hasNext()) {
                                                ((p.e) it.next()).f1553b -= i11;
                                                i11 = 1;
                                            }
                                        } else if (i10 == 4 || i10 == 8) {
                                            int i12 = cVar.f1548b[i9] >> 5;
                                            list = list3;
                                            p.e b2 = p.c.b(arrayList, i12, false);
                                            i = size;
                                            gVar = gVar2;
                                            eVar.c(i9, b2.f1553b - 1);
                                            if (i10 == 4) {
                                                eVar.d(b2.f1553b - 1, 1, cVar.f1550d.c(i9, i12));
                                            }
                                        } else if (i10 == 16) {
                                            arrayList.add(new p.e(i9, i9, true));
                                            list = list3;
                                            i = size;
                                            gVar = gVar2;
                                        } else {
                                            StringBuilder h = c.a.a.a.a.h("unknown flag for pos ", i9, " ");
                                            h.append(Long.toBinaryString((long) i10));
                                            throw new IllegalStateException(h.toString());
                                        }
                                        i8--;
                                        runnable = runnable;
                                        dVar = dVar;
                                        list3 = list;
                                        size = i;
                                        gVar2 = gVar;
                                    }
                                }
                            }
                            p.g gVar3 = gVar2;
                            if (i6 < i3) {
                                int i13 = i3 - i6;
                                if (cVar.g) {
                                    while (true) {
                                        i13--;
                                        if (i13 < 0) {
                                            break;
                                        }
                                        int i14 = i6 + i13;
                                        int i15 = cVar.f1549c[i14] & 31;
                                        if (i15 == 0) {
                                            int i16 = 1;
                                            eVar.b(i5, 1);
                                            Iterator it2 = arrayList.iterator();
                                            while (it2.hasNext()) {
                                                ((p.e) it2.next()).f1553b += i16;
                                                i16 = 1;
                                            }
                                        } else if (i15 == 4 || i15 == 8) {
                                            int i17 = cVar.f1549c[i14] >> 5;
                                            eVar.c(p.c.b(arrayList, i17, true).f1553b, i5);
                                            if (i15 == 4) {
                                                eVar.d(i5, 1, cVar.f1550d.c(i17, i14));
                                            }
                                        } else if (i15 == 16) {
                                            arrayList.add(new p.e(i14, i5, false));
                                        } else {
                                            StringBuilder h2 = c.a.a.a.a.h("unknown flag for pos ", i14, " ");
                                            h2.append(Long.toBinaryString((long) i15));
                                            throw new IllegalStateException(h2.toString());
                                        }
                                    }
                                } else {
                                    eVar.b(i5, i13);
                                }
                            }
                            int i18 = i4 - 1;
                            while (i18 >= 0) {
                                int[] iArr = cVar.f1548b;
                                int i19 = gVar3.f1559a + i18;
                                if ((iArr[i19] & 31) == 2) {
                                    eVar.d(i19, 1, cVar.f1550d.c(i19, gVar3.f1560b + i18));
                                }
                                i18--;
                                gVar3 = gVar3;
                            }
                            i2 = gVar3.f1559a;
                            i3 = gVar3.f1560b;
                            size--;
                            runnable = runnable;
                            dVar = dVar;
                            list3 = list3;
                        }
                        eVar.e();
                        dVar.a(list3, runnable);
                        return;
                    }
                    throw null;
                }
            }
        }

        public a(List list, List list2, int i, Runnable runnable) {
            this.f1473b = list;
            this.f1474c = list2;
            this.f1475d = i;
            this.f1476e = runnable;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x009e, code lost:
            if (r6[r19 - 1] < r6[r19 + 1]) goto L_0x00b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0123, code lost:
            r21 = r3;
            r19 = r4;
            r20 = r9;
            r3 = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x012e, code lost:
            if (r3 > r5) goto L_0x01a5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0130, code lost:
            r4 = r3 + r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0134, code lost:
            if (r4 == (r5 + r15)) goto L_0x0151;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0138, code lost:
            if (r4 == (r10 + r15)) goto L_0x0147;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x013a, code lost:
            r7 = r1 + r4;
            r12 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0144, code lost:
            if (r8[r7 - 1] >= r8[r7 + 1]) goto L_0x0148;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0147, code lost:
            r12 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0148, code lost:
            r7 = r8[(r1 + r4) + r12] - 1;
            r9 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0151, code lost:
            r7 = r8[(r1 + r4) - 1];
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0158, code lost:
            r12 = r7 - r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x015a, code lost:
            if (r7 <= 0) goto L_0x0175;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x015c, code lost:
            if (r12 <= 0) goto L_0x0175;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x015e, code lost:
            r25 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x016c, code lost:
            if (r2.b((r11 + r7) - 1, (r13 + r12) - 1) == false) goto L_0x0177;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x016e, code lost:
            r7 = r7 - 1;
            r12 = r12 - 1;
            r11 = r25;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0175, code lost:
            r25 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0177, code lost:
            r11 = r1 + r4;
            r8[r11] = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x017b, code lost:
            if (r0 != false) goto L_0x01a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x017d, code lost:
            if (r4 < r10) goto L_0x01a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x017f, code lost:
            if (r4 > r5) goto L_0x01a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0185, code lost:
            if (r6[r11] < r8[r11]) goto L_0x01a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0187, code lost:
            r0 = new b.q.d.p.g();
            r3 = r8[r11];
            r0.f1559a = r3;
            r0.f1560b = r3 - r4;
            r0.f1561c = r6[r11] - r8[r11];
            r0.f1562d = r9;
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a0, code lost:
            r3 = r3 + 2;
            r11 = r25;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a5, code lost:
            r5 = r5 + 1;
            r7 = r7;
            r4 = r19;
            r9 = r20;
            r3 = r21;
            r12 = r12;
            r14 = r14;
         */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0233  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x024c  */
        public void run() {
            ArrayList arrayList;
            p.f fVar;
            ArrayList arrayList2;
            ArrayList arrayList3;
            p.g gVar;
            ArrayList arrayList4;
            ArrayList arrayList5;
            ArrayList arrayList6;
            p.f fVar2;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            boolean z;
            boolean z2;
            int i6;
            int i7;
            int i8;
            int i9;
            boolean z3;
            C0035a aVar = new C0035a();
            int size = a.this.f1473b.size();
            int size2 = a.this.f1474c.size();
            ArrayList arrayList7 = new ArrayList();
            ArrayList arrayList8 = new ArrayList();
            arrayList8.add(new p.f(0, size, 0, size2));
            int abs = Math.abs(size - size2) + size + size2;
            int i10 = abs * 2;
            int[] iArr = new int[i10];
            int[] iArr2 = new int[i10];
            ArrayList arrayList9 = new ArrayList();
            while (!arrayList8.isEmpty()) {
                p.f fVar3 = (p.f) arrayList8.remove(arrayList8.size() - 1);
                int i11 = fVar3.f1555a;
                int i12 = fVar3.f1556b;
                int i13 = fVar3.f1557c;
                int i14 = i12 - i11;
                int i15 = fVar3.f1558d - i13;
                if (i14 < 1 || i15 < 1) {
                    arrayList = arrayList9;
                    arrayList2 = arrayList7;
                    arrayList3 = arrayList8;
                    fVar = fVar3;
                    gVar = null;
                } else {
                    int i16 = i14 - i15;
                    int i17 = ((i14 + i15) + 1) / 2;
                    int i18 = (abs - i17) - 1;
                    arrayList3 = arrayList8;
                    int i19 = abs + i17 + 1;
                    Arrays.fill(iArr, i18, i19, 0);
                    Arrays.fill(iArr2, i18 + i16, i19 + i16, i14);
                    boolean z4 = i16 % 2 != 0;
                    int i20 = 0;
                    while (i20 <= i17) {
                        int i21 = -i20;
                        int i22 = i21;
                        while (true) {
                            if (i22 > i20) {
                                break;
                            }
                            if (i22 != i21) {
                                if (i22 != i20) {
                                    int i23 = abs + i22;
                                    arrayList = arrayList9;
                                    z3 = true;
                                    fVar = fVar3;
                                } else {
                                    arrayList = arrayList9;
                                    fVar = fVar3;
                                    z3 = true;
                                }
                                i6 = iArr[(abs + i22) - 1] + 1;
                                z2 = z3;
                                arrayList2 = arrayList7;
                                i7 = i6 - i22;
                                while (true) {
                                    if (i6 < i14 && i7 < i15) {
                                        i9 = i14;
                                        i8 = i15;
                                        if (!aVar.b(i11 + i6, i13 + i7)) {
                                            break;
                                        }
                                        i6++;
                                        i7++;
                                        i14 = i9;
                                        i15 = i8;
                                    } else {
                                        i9 = i14;
                                        i8 = i15;
                                    }
                                }
                                i9 = i14;
                                i8 = i15;
                                int i24 = abs + i22;
                                iArr[i24] = i6;
                                if (!z4 && i22 >= (i16 - i20) + 1 && i22 <= (i16 + i20) - 1 && iArr[i24] >= iArr2[i24]) {
                                    gVar = new p.g();
                                    int i25 = iArr2[i24];
                                    gVar.f1559a = i25;
                                    gVar.f1560b = i25 - i22;
                                    gVar.f1561c = iArr[i24] - iArr2[i24];
                                    gVar.f1562d = z2;
                                    z = false;
                                    break;
                                }
                                i22 += 2;
                                arrayList7 = arrayList2;
                                fVar3 = fVar;
                                arrayList9 = arrayList;
                                i14 = i9;
                                i15 = i8;
                            } else {
                                arrayList = arrayList9;
                                fVar = fVar3;
                            }
                            i6 = iArr[abs + i22 + 1];
                            z2 = false;
                            arrayList2 = arrayList7;
                            i7 = i6 - i22;
                            while (true) {
                                if (i6 < i14) {
                                    break;
                                }
                                break;
                                i6++;
                                i7++;
                                i14 = i9;
                                i15 = i8;
                            }
                            i9 = i14;
                            i8 = i15;
                            int i242 = abs + i22;
                            iArr[i242] = i6;
                            if (!z4) {
                            }
                            i22 += 2;
                            arrayList7 = arrayList2;
                            fVar3 = fVar;
                            arrayList9 = arrayList;
                            i14 = i9;
                            i15 = i8;
                        }
                        gVar.f1563e = z;
                    }
                    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
                }
                if (gVar != null) {
                    if (gVar.f1561c > 0) {
                        arrayList6 = arrayList2;
                        arrayList6.add(gVar);
                    } else {
                        arrayList6 = arrayList2;
                    }
                    gVar.f1559a += fVar.f1555a;
                    gVar.f1560b += fVar.f1557c;
                    if (arrayList.isEmpty()) {
                        fVar2 = new p.f();
                        arrayList5 = arrayList;
                    } else {
                        arrayList5 = arrayList;
                        fVar2 = (p.f) arrayList5.remove(arrayList.size() - 1);
                    }
                    fVar2.f1555a = fVar.f1555a;
                    fVar2.f1557c = fVar.f1557c;
                    if (gVar.f1563e) {
                        i5 = gVar.f1559a;
                    } else if (gVar.f1562d) {
                        i5 = gVar.f1559a - 1;
                    } else {
                        fVar2.f1556b = gVar.f1559a;
                        i = gVar.f1560b - 1;
                        fVar2.f1558d = i;
                        arrayList4 = arrayList3;
                        arrayList4.add(fVar2);
                        if (gVar.f1563e) {
                            int i26 = gVar.f1559a;
                            i3 = gVar.f1561c;
                            i4 = i26 + i3;
                        } else if (gVar.f1562d) {
                            int i27 = gVar.f1559a;
                            i3 = gVar.f1561c;
                            i4 = i27 + i3 + 1;
                        } else {
                            int i28 = gVar.f1559a;
                            int i29 = gVar.f1561c;
                            fVar.f1555a = i28 + i29;
                            i2 = gVar.f1560b + i29 + 1;
                            fVar.f1557c = i2;
                            arrayList4.add(fVar);
                        }
                        fVar.f1555a = i4;
                        i2 = gVar.f1560b + i3;
                        fVar.f1557c = i2;
                        arrayList4.add(fVar);
                    }
                    fVar2.f1556b = i5;
                    i = gVar.f1560b;
                    fVar2.f1558d = i;
                    arrayList4 = arrayList3;
                    arrayList4.add(fVar2);
                    if (gVar.f1563e) {
                    }
                    fVar.f1555a = i4;
                    i2 = gVar.f1560b + i3;
                    fVar.f1557c = i2;
                    arrayList4.add(fVar);
                } else {
                    arrayList4 = arrayList3;
                    arrayList6 = arrayList2;
                    arrayList5 = arrayList;
                    arrayList5.add(fVar);
                }
                arrayList7 = arrayList6;
                arrayList9 = arrayList5;
                arrayList8 = arrayList4;
            }
            Collections.sort(arrayList7, p.f1546a);
            d.this.f1470c.execute(new b(new p.c(aVar, arrayList7, iArr, iArr2, true)));
        }
    }

    public interface b<T> {
        void a(List<T> list, List<T> list2);
    }

    public static class c implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f1480b = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f1480b.post(runnable);
        }
    }

    public d(w wVar, c<T> cVar) {
        this.f1468a = wVar;
        this.f1469b = cVar;
        Executor executor = cVar.f1461a;
        this.f1470c = executor == null ? h : executor;
    }

    public final void a(List<T> list, Runnable runnable) {
        for (b<T> bVar : this.f1471d) {
            bVar.a(list, this.f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void b(List<T> list, Runnable runnable) {
        int i = this.g + 1;
        this.g = i;
        List<T> list2 = this.f1472e;
        if (list != list2) {
            List<T> list3 = this.f;
            if (list == null) {
                int size = list2.size();
                this.f1472e = null;
                this.f = Collections.emptyList();
                this.f1468a.a(0, size);
                a(list3, runnable);
            } else if (list2 == null) {
                this.f1472e = list;
                this.f = Collections.unmodifiableList(list);
                this.f1468a.b(0, list.size());
                a(list3, runnable);
            } else {
                this.f1469b.f1462b.execute(new a(list2, list, i, runnable));
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
