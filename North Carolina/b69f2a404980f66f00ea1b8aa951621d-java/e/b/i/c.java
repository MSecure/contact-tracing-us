package e.b.i;

import e.b.h.b;
import e.b.h.f;
import e.b.i.i;
import java.util.ArrayList;

public enum c {
    Initial {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (c.b(iVar)) {
                return true;
            }
            if (iVar.b()) {
                bVar.x((i.d) iVar);
            } else if (iVar.c()) {
                i.e eVar = (i.e) iVar;
                e.b.h.g gVar = new e.b.h.g(bVar.h.b(eVar.f4898b.toString()), eVar.f4900d.toString(), eVar.f4901e.toString());
                String str = eVar.f4899c;
                if (str != null) {
                    gVar.d("pubSysKey", str);
                }
                bVar.f4924d.B(gVar);
                if (eVar.f) {
                    bVar.f4924d.l = f.b.quirks;
                }
                bVar.k = c.BeforeHtml;
            } else {
                c cVar = c.BeforeHtml;
                bVar.k = cVar;
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            }
            return true;
        }
    },
    BeforeHtml {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (iVar.c()) {
                bVar.m(this);
                return false;
            } else if (iVar.b()) {
                bVar.x((i.d) iVar);
                return true;
            } else if (c.b(iVar)) {
                bVar.w((i.c) iVar);
                return true;
            } else {
                if (iVar.f()) {
                    i.h hVar = (i.h) iVar;
                    if (hVar.f4903c.equals("html")) {
                        bVar.v(hVar);
                        bVar.k = c.BeforeHead;
                        return true;
                    }
                }
                if (iVar.e() && e.b.g.b.d(((i.g) iVar).f4903c, x.f4878e)) {
                    return g(iVar, bVar);
                }
                if (!iVar.e()) {
                    return g(iVar, bVar);
                }
                bVar.m(this);
                return false;
            }
        }

        public final boolean g(i iVar, b bVar) {
            if (bVar != null) {
                e.b.h.i iVar2 = new e.b.h.i(h.a("html", bVar.h), null, null);
                bVar.C(iVar2);
                bVar.f4925e.add(iVar2);
                c cVar = c.BeforeHead;
                bVar.k = cVar;
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            }
            throw null;
        }
    },
    BeforeHead {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (c.b(iVar)) {
                bVar.w((i.c) iVar);
                return true;
            } else if (iVar.b()) {
                bVar.x((i.d) iVar);
                return true;
            } else if (iVar.c()) {
                bVar.m(this);
                return false;
            } else if (iVar.f() && ((i.h) iVar).f4903c.equals("html")) {
                return c.InBody.f(iVar, bVar);
            } else {
                if (iVar.f()) {
                    i.h hVar = (i.h) iVar;
                    if (hVar.f4903c.equals("head")) {
                        bVar.n = bVar.v(hVar);
                        bVar.k = c.InHead;
                        return true;
                    }
                }
                if (iVar.e() && e.b.g.b.d(((i.g) iVar).f4903c, x.f4878e)) {
                    bVar.g("head");
                    bVar.g = iVar;
                    return bVar.k.f(iVar, bVar);
                } else if (iVar.e()) {
                    bVar.m(this);
                    return false;
                } else {
                    bVar.g("head");
                    bVar.g = iVar;
                    return bVar.k.f(iVar, bVar);
                }
            }
        }
    },
    InHead {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            c cVar;
            if (c.b(iVar)) {
                bVar.w((i.c) iVar);
                return true;
            }
            int ordinal = iVar.f4893a.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    i.h hVar = (i.h) iVar;
                    String str = hVar.f4903c;
                    if (str.equals("html")) {
                        return c.InBody.f(iVar, bVar);
                    }
                    if (e.b.g.b.d(str, x.f4874a)) {
                        e.b.h.i y = bVar.y(hVar);
                        if (str.equals("base") && y.o("href") && !bVar.m) {
                            String a2 = y.a("href");
                            if (a2.length() != 0) {
                                bVar.f = a2;
                                bVar.m = true;
                                e.b.h.f fVar = bVar.f4924d;
                                if (fVar != null) {
                                    c.b.a.a.c.n.c.J1(a2);
                                    fVar.e().v(e.b.h.i.i, a2);
                                } else {
                                    throw null;
                                }
                            }
                        }
                    } else if (str.equals("meta")) {
                        bVar.y(hVar);
                    } else if (str.equals("title")) {
                        bVar.f4923c.f4914c = l.Rcdata;
                        bVar.l = bVar.k;
                        bVar.k = c.Text;
                        bVar.v(hVar);
                    } else if (e.b.g.b.d(str, x.f4875b)) {
                        c.d(hVar, bVar);
                    } else if (str.equals("noscript")) {
                        bVar.v(hVar);
                        cVar = c.InHeadNoscript;
                    } else if (str.equals("script")) {
                        bVar.f4923c.f4914c = l.ScriptData;
                        bVar.l = bVar.k;
                        bVar.k = c.Text;
                        bVar.v(hVar);
                    } else if (!str.equals("head")) {
                        return g(iVar, bVar);
                    } else {
                        bVar.m(this);
                        return false;
                    }
                    return true;
                } else if (ordinal == 2) {
                    String str2 = ((i.g) iVar).f4903c;
                    if (str2.equals("head")) {
                        bVar.G();
                        cVar = c.AfterHead;
                    } else if (e.b.g.b.d(str2, x.f4876c)) {
                        return g(iVar, bVar);
                    } else {
                        bVar.m(this);
                        return false;
                    }
                } else if (ordinal != 3) {
                    return g(iVar, bVar);
                } else {
                    bVar.x((i.d) iVar);
                    return true;
                }
                bVar.k = cVar;
                return true;
            }
            bVar.m(this);
            return false;
        }

        public final boolean g(i iVar, m mVar) {
            mVar.f("head");
            b bVar = (b) mVar;
            bVar.g = iVar;
            return bVar.k.f(iVar, bVar);
        }
    },
    InHeadNoscript {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            i.c cVar;
            if (iVar.c()) {
                bVar.m(this);
            } else if (iVar.f() && ((i.h) iVar).f4903c.equals("html")) {
                c cVar2 = c.InBody;
                bVar.g = iVar;
                return cVar2.f(iVar, bVar);
            } else if (iVar.e() && ((i.g) iVar).f4903c.equals("noscript")) {
                bVar.G();
                bVar.k = c.InHead;
            } else if (c.b(iVar) || iVar.b() || (iVar.f() && e.b.g.b.d(((i.h) iVar).f4903c, x.f))) {
                c cVar3 = c.InHead;
                bVar.g = iVar;
                return cVar3.f(iVar, bVar);
            } else {
                if (iVar.e() && ((i.g) iVar).f4903c.equals("br")) {
                    bVar.m(this);
                    cVar = new i.c();
                } else if ((!iVar.f() || !e.b.g.b.d(((i.h) iVar).f4903c, x.K)) && !iVar.e()) {
                    bVar.m(this);
                    cVar = new i.c();
                } else {
                    bVar.m(this);
                    return false;
                }
                cVar.f4894b = iVar.toString();
                bVar.w(cVar);
                return true;
            }
            return true;
        }
    },
    AfterHead {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            c cVar;
            if (c.b(iVar)) {
                bVar.w((i.c) iVar);
                return true;
            } else if (iVar.b()) {
                bVar.x((i.d) iVar);
                return true;
            } else if (iVar.c()) {
                bVar.m(this);
                return true;
            } else {
                if (iVar.f()) {
                    i.h hVar = (i.h) iVar;
                    String str = hVar.f4903c;
                    if (str.equals("html")) {
                        c cVar2 = c.InBody;
                        bVar.g = iVar;
                        return cVar2.f(iVar, bVar);
                    }
                    if (str.equals("body")) {
                        bVar.v(hVar);
                        bVar.t = false;
                        cVar = c.InBody;
                    } else if (str.equals("frameset")) {
                        bVar.v(hVar);
                        cVar = c.InFrameset;
                    } else if (e.b.g.b.d(str, x.g)) {
                        bVar.m(this);
                        e.b.h.i iVar2 = bVar.n;
                        bVar.f4925e.add(iVar2);
                        c cVar3 = c.InHead;
                        bVar.g = iVar;
                        cVar3.f(iVar, bVar);
                        bVar.L(iVar2);
                        return true;
                    } else if (str.equals("head")) {
                        bVar.m(this);
                        return false;
                    }
                    bVar.k = cVar;
                    return true;
                } else if (iVar.e() && !e.b.g.b.d(((i.g) iVar).f4903c, x.f4877d)) {
                    bVar.m(this);
                    return false;
                }
                g(iVar, bVar);
                return true;
            }
        }

        public final boolean g(i iVar, b bVar) {
            bVar.g("body");
            bVar.t = true;
            bVar.g = iVar;
            return bVar.k.f(iVar, bVar);
        }
    },
    InBody {
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x01ee, code lost:
            if (r34.f("body") != false) goto L_0x01f0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x022a, code lost:
            if (r34.a().f4846d.f4890c.equals(r4) == false) goto L_0x03a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x029c, code lost:
            r34.K(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x039f, code lost:
            if (r34.a().f4846d.f4890c.equals(r4) == false) goto L_0x03a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x03a1, code lost:
            r34.m(r32);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x03a4, code lost:
            r34.H(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:212:0x0421, code lost:
            if (r4.equals("isindex") != false) goto L_0x053a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x044d, code lost:
            if (r4.equals("input") != false) goto L_0x0595;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:413:0x0828, code lost:
            if (r2.y(r3).c("type").equalsIgnoreCase("hidden") == false) goto L_0x0889;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:497:0x0a0b, code lost:
            if (r2.q("p") != false) goto L_0x0a45;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:508:0x0a43, code lost:
            if (r2.q("p") != false) goto L_0x0a45;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:526:0x0a96, code lost:
            if (e.b.g.b.d(r4, e.b.i.c.x.q) != false) goto L_0x0a98;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f6, code lost:
            if (r4.equals("h6") != false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x019f, code lost:
            if (r34.a().f4846d.f4890c.equals(r4) == false) goto L_0x03a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x01bf, code lost:
            if (r34.a().f4846d.f4890c.equals(r4) == false) goto L_0x03a1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:168:0x0316  */
        /* JADX WARNING: Removed duplicated region for block: B:172:0x0323  */
        /* JADX WARNING: Removed duplicated region for block: B:178:0x0355 A[LOOP:4: B:177:0x0353->B:178:0x0355, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:181:0x036f  */
        /* JADX WARNING: Removed duplicated region for block: B:182:0x0371  */
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            boolean z;
            b bVar2;
            i.h hVar;
            u uVar;
            boolean z2;
            b bVar3;
            c cVar;
            b bVar4;
            i.h hVar2;
            e.b.h.i iVar2;
            int ordinal = iVar.f4893a.ordinal();
            if (ordinal != 0) {
                char c2 = 14;
                char c3 = 11;
                if (ordinal == 1) {
                    i.h hVar3 = (i.h) iVar;
                    String str = hVar3.f4903c;
                    int hashCode = str.hashCode();
                    switch (hashCode) {
                        case -1644953643:
                            if (str.equals("frameset")) {
                                c3 = 5;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1377687758:
                            if (str.equals("button")) {
                                c3 = '\b';
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1191214428:
                            if (str.equals("iframe")) {
                                c2 = 17;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1010136971:
                            if (str.equals("option")) {
                                c2 = '!';
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -1003243718:
                            if (str.equals("textarea")) {
                                c3 = 15;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -906021636:
                            if (str.equals("select")) {
                                c2 = 19;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case -80773204:
                            if (str.equals("optgroup")) {
                                c2 = ' ';
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 97:
                            if (str.equals("a")) {
                                c3 = 0;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3200:
                            if (str.equals("dd")) {
                                c2 = 30;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3216:
                            if (str.equals("dt")) {
                                c2 = 31;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3338:
                            if (str.equals("hr")) {
                                c3 = '\f';
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3453:
                            if (str.equals("li")) {
                                c3 = 2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3646:
                            if (str.equals("rp")) {
                                c2 = '\"';
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3650:
                            if (str.equals("rt")) {
                                c2 = '#';
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 111267:
                            if (str.equals("pre")) {
                                c2 = 28;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 114276:
                            if (str.equals("svg")) {
                                c2 = 21;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 118811:
                            if (str.equals("xmp")) {
                                c2 = 16;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3029410:
                            if (str.equals("body")) {
                                c3 = 4;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3148996:
                            if (str.equals("form")) {
                                c3 = 6;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3213227:
                            if (str.equals("html")) {
                                c3 = 3;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3344136:
                            if (str.equals("math")) {
                                c2 = 20;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3386833:
                            if (str.equals("nobr")) {
                                c3 = '\t';
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 3536714:
                            if (str.equals("span")) {
                                c3 = 1;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 100313435:
                            if (str.equals("image")) {
                                c3 = '\r';
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 100358090:
                            break;
                        case 110115790:
                            if (str.equals("table")) {
                                c2 = '\n';
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 181975684:
                            if (str.equals("listing")) {
                                c2 = 29;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 1973234167:
                            if (str.equals("plaintext")) {
                                c2 = 7;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        case 2091304424:
                            break;
                        case 2115613112:
                            if (str.equals("noembed")) {
                                c2 = 18;
                                c3 = c2;
                                break;
                            }
                            c3 = 65535;
                            break;
                        default:
                            switch (hashCode) {
                                case 3273:
                                    if (str.equals("h1")) {
                                        c3 = 22;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 3274:
                                    if (str.equals("h2")) {
                                        c3 = 23;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 3275:
                                    if (str.equals("h3")) {
                                        c3 = 24;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 3276:
                                    if (str.equals("h4")) {
                                        c3 = 25;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 3277:
                                    if (str.equals("h5")) {
                                        c3 = 26;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                case 3278:
                                    if (str.equals("h6")) {
                                        c3 = 27;
                                        break;
                                    }
                                    c3 = 65535;
                                    break;
                                default:
                                    c3 = 65535;
                                    break;
                            }
                    }
                    switch (c3) {
                        case 0:
                            bVar2 = bVar;
                            hVar = hVar3;
                            z = true;
                            if (bVar2.o("a") != null) {
                                bVar2.m(this);
                                bVar2.f("a");
                                e.b.h.i p = bVar2.p("a");
                                if (p != null) {
                                    bVar2.K(p);
                                    bVar2.L(p);
                                }
                            }
                            bVar.J();
                            bVar2.I(bVar2.v(hVar));
                            return z;
                        case 1:
                        case 20:
                        case 21:
                            bVar2 = bVar;
                            hVar = hVar3;
                            z = true;
                            bVar.J();
                            bVar2.v(hVar);
                            return z;
                        case 2:
                            bVar2 = bVar;
                            hVar = hVar3;
                            bVar2.t = false;
                            ArrayList<e.b.h.i> arrayList = bVar2.f4925e;
                            z = true;
                            int size = arrayList.size() - 1;
                            while (true) {
                                if (size > 0) {
                                    e.b.h.i iVar3 = arrayList.get(size);
                                    if (iVar3.f4846d.f4890c.equals("li")) {
                                        bVar2.f("li");
                                    } else if (!bVar2.E(iVar3) || e.b.g.b.d(iVar3.f4846d.f4890c, x.j)) {
                                        size--;
                                    }
                                }
                            }
                            break;
                        case 3:
                            bVar.m(this);
                            e.b.h.i iVar4 = bVar.f4925e.get(0);
                            if (hVar3.j == null) {
                                hVar3.j = new e.b.h.b();
                            }
                            e.b.h.b bVar5 = hVar3.j;
                            if (bVar5 != null) {
                                b.a aVar = new b.a();
                                while (aVar.hasNext()) {
                                    e.b.h.a aVar2 = (e.b.h.a) aVar.next();
                                    if (!iVar4.o(aVar2.f4825b)) {
                                        iVar4.e().w(aVar2);
                                    }
                                }
                                z = true;
                                return z;
                            }
                            throw null;
                        case 4:
                            bVar.m(this);
                            ArrayList<e.b.h.i> arrayList2 = bVar.f4925e;
                            if (arrayList2.size() != 1 && (arrayList2.size() <= 2 || arrayList2.get(1).f4846d.f4890c.equals("body"))) {
                                bVar.t = false;
                                e.b.h.i iVar5 = arrayList2.get(1);
                                if (hVar3.j == null) {
                                    hVar3.j = new e.b.h.b();
                                }
                                e.b.h.b bVar6 = hVar3.j;
                                if (bVar6 != null) {
                                    b.a aVar3 = new b.a();
                                    while (aVar3.hasNext()) {
                                        e.b.h.a aVar4 = (e.b.h.a) aVar3.next();
                                        if (!iVar5.o(aVar4.f4825b)) {
                                            iVar5.e().w(aVar4);
                                        }
                                    }
                                    z = true;
                                    return z;
                                }
                                throw null;
                            }
                            return false;
                        case 5:
                            bVar3 = bVar;
                            bVar3.m(this);
                            ArrayList<e.b.h.i> arrayList3 = bVar3.f4925e;
                            if (arrayList3.size() != 1 && ((arrayList3.size() <= 2 || arrayList3.get(1).f4846d.f4890c.equals("body")) && bVar3.t)) {
                                e.b.h.i iVar6 = arrayList3.get(1);
                                if (((e.b.h.i) iVar6.f4861b) != null) {
                                    iVar6.y();
                                }
                                for (int i = 1; arrayList3.size() > i; i = 1) {
                                    arrayList3.remove(arrayList3.size() - i);
                                }
                                bVar3.v(hVar3);
                                cVar = c.InFrameset;
                                bVar3.k = cVar;
                                z = true;
                                return z;
                            }
                            return false;
                        case 6:
                            uVar = this;
                            bVar2 = bVar;
                            if (bVar2.o == null) {
                                if (bVar2.q("p")) {
                                    bVar2.f("p");
                                }
                                bVar2.z(hVar3, true);
                                return true;
                            }
                            bVar2.m(uVar);
                            return false;
                        case 7:
                            if (bVar.q("p")) {
                                bVar.f("p");
                            }
                            bVar.v(hVar3);
                            bVar.f4923c.f4914c = l.PLAINTEXT;
                            z = true;
                            return z;
                        case '\b':
                            bVar2 = bVar;
                            if (bVar2.q("button")) {
                                bVar2.m(this);
                                bVar2.f("button");
                                bVar2.g = hVar3;
                                bVar2.k.f(hVar3, bVar2);
                                z = true;
                                return z;
                            }
                            bVar.J();
                            bVar2.v(hVar3);
                            z2 = false;
                            z = true;
                            bVar2.t = z2;
                            return z;
                        case '\t':
                            hVar = hVar3;
                            bVar2 = bVar;
                            bVar.J();
                            if (bVar2.r("nobr")) {
                                bVar2.m(this);
                                bVar2.f("nobr");
                                z = true;
                                bVar.J();
                                bVar2.I(bVar2.v(hVar));
                                return z;
                            }
                            z = true;
                            bVar2.I(bVar2.v(hVar));
                            return z;
                        case '\n':
                            bVar3 = bVar;
                            if (bVar3.f4924d.l != f.b.quirks && bVar3.q("p")) {
                                bVar3.f("p");
                            }
                            bVar3.v(hVar3);
                            bVar3.t = false;
                            cVar = c.InTable;
                            bVar3.k = cVar;
                            z = true;
                            return z;
                        case 11:
                            bVar2 = bVar;
                            bVar.J();
                            break;
                        case '\f':
                            bVar2 = bVar;
                            if (bVar2.q("p")) {
                                bVar2.f("p");
                            }
                            bVar2.y(hVar3);
                            z2 = false;
                            z = true;
                            bVar2.t = z2;
                            return z;
                        case '\r':
                            bVar2 = bVar;
                            hVar = hVar3;
                            if (bVar2.p("svg") == null) {
                                hVar.f4902b = "img";
                                hVar.f4903c = c.b.a.a.c.n.c.C1("img");
                                bVar2.g = hVar;
                                return bVar2.k.f(hVar, bVar2);
                            }
                            z = true;
                            bVar2.v(hVar);
                            return z;
                        case 14:
                            bVar.m(this);
                            if (bVar.o == null) {
                                bVar.g("form");
                                if (hVar3.j.q("action")) {
                                    bVar.o.D("action", hVar3.j.o("action"));
                                }
                                bVar.g("hr");
                                bVar.g("label");
                                String o = hVar3.j.q("prompt") ? hVar3.j.o("prompt") : "This is a searchable index. Enter search keywords: ";
                                i.c cVar2 = new i.c();
                                cVar2.f4894b = o;
                                bVar.g = cVar2;
                                bVar.k.f(cVar2, bVar);
                                e.b.h.b bVar7 = new e.b.h.b();
                                e.b.h.b bVar8 = hVar3.j;
                                if (bVar8 != null) {
                                    b.a aVar5 = new b.a();
                                    while (aVar5.hasNext()) {
                                        e.b.h.a aVar6 = (e.b.h.a) aVar5.next();
                                        if (!e.b.g.b.d(aVar6.f4825b, x.p)) {
                                            bVar7.w(aVar6);
                                        }
                                    }
                                    bVar7.v("name", "isindex");
                                    i.h hVar4 = bVar.i;
                                    if (bVar.g == hVar4) {
                                        hVar4 = new i.h();
                                    } else {
                                        hVar4.s();
                                    }
                                    hVar4.f4902b = "input";
                                    hVar4.j = bVar7;
                                    hVar4.f4903c = c.b.a.a.c.n.c.C1("input");
                                    bVar.g = hVar4;
                                    bVar.k.f(hVar4, bVar);
                                    bVar.f("label");
                                    bVar.g("hr");
                                    bVar.f("form");
                                    z = true;
                                    return z;
                                }
                                throw null;
                            }
                            return false;
                        case 15:
                            bVar3 = bVar;
                            bVar3.v(hVar3);
                            if (!hVar3.i) {
                                bVar3.f4923c.f4914c = l.Rcdata;
                                bVar3.l = bVar3.k;
                                bVar3.t = false;
                                cVar = c.Text;
                                bVar3.k = cVar;
                            }
                            z = true;
                            return z;
                        case 16:
                            bVar4 = bVar;
                            hVar2 = hVar3;
                            if (bVar4.q("p")) {
                                bVar4.f("p");
                            }
                            bVar.J();
                            bVar4.t = false;
                            c.d(hVar2, bVar4);
                            z = true;
                            return z;
                        case 17:
                            bVar4 = bVar;
                            hVar2 = hVar3;
                            bVar4.t = false;
                            c.d(hVar2, bVar4);
                            z = true;
                            return z;
                        case 18:
                            bVar4 = bVar;
                            hVar2 = hVar3;
                            c.d(hVar2, bVar4);
                            z = true;
                            return z;
                        case 19:
                            bVar3 = bVar;
                            bVar.J();
                            bVar3.v(hVar3);
                            bVar3.t = false;
                            c cVar3 = bVar3.k;
                            cVar = (cVar3.equals(c.InTable) || cVar3.equals(c.InCaption) || cVar3.equals(c.InTableBody) || cVar3.equals(c.InRow) || cVar3.equals(c.InCell)) ? c.InSelectInTable : c.InSelect;
                            bVar3.k = cVar;
                            z = true;
                            return z;
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                            bVar2 = bVar;
                            hVar = hVar3;
                            if (bVar2.q("p")) {
                                bVar2.f("p");
                            }
                            if (e.b.g.b.d(bVar.a().f4846d.f4890c, x.i)) {
                                bVar2.m(this);
                                bVar.G();
                            }
                            z = true;
                            bVar2.v(hVar);
                            return z;
                        case 28:
                        case 29:
                            bVar2 = bVar;
                            if (bVar2.q("p")) {
                                bVar2.f("p");
                            }
                            bVar2.v(hVar3);
                            bVar2.f4922b.n("\n");
                            z2 = false;
                            z = true;
                            bVar2.t = z2;
                            return z;
                        case 30:
                        case 31:
                            bVar2 = bVar;
                            bVar2.t = false;
                            ArrayList<e.b.h.i> arrayList4 = bVar2.f4925e;
                            int size2 = arrayList4.size() - 1;
                            while (true) {
                                if (size2 > 0) {
                                    e.b.h.i iVar7 = arrayList4.get(size2);
                                    if (e.b.g.b.d(iVar7.f4846d.f4890c, x.k)) {
                                        bVar2.f(iVar7.f4846d.f4890c);
                                    } else if (!bVar2.E(iVar7) || e.b.g.b.d(iVar7.f4846d.f4890c, x.j)) {
                                        size2--;
                                    }
                                }
                            }
                            if (bVar2.q("p")) {
                                hVar = hVar3;
                                z = true;
                                bVar2.f("p");
                                bVar2.v(hVar);
                                return z;
                            }
                            hVar = hVar3;
                            z = true;
                            bVar2.v(hVar);
                            return z;
                        case ' ':
                        case '!':
                            bVar2 = bVar;
                            if (bVar.a().f4846d.f4890c.equals("option")) {
                                bVar2.f("option");
                            }
                            hVar = hVar3;
                            z = true;
                            bVar.J();
                            bVar2.v(hVar);
                            return z;
                        case '\"':
                        case '#':
                            bVar2 = bVar;
                            if (bVar2.r("ruby")) {
                                bVar2.n(null);
                                if (!bVar.a().f4846d.f4890c.equals("ruby")) {
                                    bVar2.m(this);
                                    int size3 = bVar2.f4925e.size() - 1;
                                    while (size3 >= 0 && !bVar2.f4925e.get(size3).f4846d.f4890c.equals("ruby")) {
                                        bVar2.f4925e.remove(size3);
                                        size3--;
                                    }
                                }
                                hVar = hVar3;
                                z = true;
                                bVar2.v(hVar);
                                return z;
                            }
                            z = true;
                            return z;
                        default:
                            uVar = this;
                            bVar2 = bVar;
                            hVar = hVar3;
                            z = true;
                            if (e.b.g.b.d(str, x.n)) {
                                bVar.J();
                                bVar2.y(hVar);
                            } else if (e.b.g.b.d(str, x.h)) {
                                break;
                            } else if (e.b.g.b.d(str, x.g)) {
                                c cVar4 = c.InHead;
                                bVar2.g = iVar;
                                return cVar4.f(iVar, bVar2);
                            } else {
                                if (!e.b.g.b.d(str, x.l)) {
                                    if (e.b.g.b.d(str, x.m)) {
                                        bVar.J();
                                        bVar2.v(hVar);
                                        bVar.B();
                                    } else if (!e.b.g.b.d(str, x.o)) {
                                        break;
                                    } else {
                                        bVar2.y(hVar);
                                        return z;
                                    }
                                }
                                bVar.J();
                                bVar2.I(bVar2.v(hVar));
                                return z;
                            }
                            z2 = false;
                            bVar2.t = z2;
                            return z;
                    }
                } else if (ordinal == 2) {
                    i.g gVar = (i.g) iVar;
                    String str2 = gVar.f4903c;
                    int hashCode2 = str2.hashCode();
                    switch (hashCode2) {
                        case 112:
                            if (str2.equals("p")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3152:
                            if (str2.equals("br")) {
                                c2 = 15;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3200:
                            if (str2.equals("dd")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3216:
                            if (str2.equals("dt")) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3453:
                            if (str2.equals("li")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3029410:
                            if (str2.equals("body")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3148996:
                            if (str2.equals("form")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3213227:
                            if (str2.equals("html")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 3536714:
                            if (str2.equals("span")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1869063452:
                            if (str2.equals("sarcasm")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            switch (hashCode2) {
                                case 3273:
                                    if (str2.equals("h1")) {
                                        c2 = '\t';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3274:
                                    if (str2.equals("h2")) {
                                        c2 = '\n';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3275:
                                    if (str2.equals("h3")) {
                                        c2 = 11;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3276:
                                    if (str2.equals("h4")) {
                                        c2 = '\f';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3277:
                                    if (str2.equals("h5")) {
                                        c2 = '\r';
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 3278:
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                            return g(iVar, bVar);
                        case 2:
                            String[] strArr = b.y;
                            String[] strArr2 = b.x;
                            String[] strArr3 = bVar.w;
                            strArr3[0] = str2;
                            if (bVar.t(strArr3, strArr2, strArr)) {
                                bVar.n(str2);
                                break;
                            }
                            bVar.m(this);
                            return false;
                        case 3:
                            if (bVar.r("body")) {
                                bVar.k = c.AfterBody;
                                return true;
                            }
                            bVar.m(this);
                            return false;
                        case 4:
                            break;
                        case 5:
                            e.b.h.k kVar = bVar.o;
                            bVar.o = null;
                            if (kVar != null && bVar.r(str2)) {
                                bVar.n(null);
                                if (!bVar.a().f4846d.f4890c.equals(str2)) {
                                    bVar.m(this);
                                }
                                bVar.L(kVar);
                                return true;
                            }
                            bVar.m(this);
                            return false;
                        case 6:
                            if (bVar.q(str2)) {
                                bVar.n(str2);
                                break;
                            } else {
                                bVar.m(this);
                                bVar.g(str2);
                                bVar.g = gVar;
                                return bVar.k.f(gVar, bVar);
                            }
                        case 7:
                        case '\b':
                            if (bVar.r(str2)) {
                                bVar.n(str2);
                                break;
                            }
                            bVar.m(this);
                            return false;
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                        case 14:
                            if (bVar.t(x.i, b.x, null)) {
                                bVar.n(str2);
                                if (!bVar.a().f4846d.f4890c.equals(str2)) {
                                    bVar.m(this);
                                }
                                String[] strArr4 = x.i;
                                for (int size4 = bVar.f4925e.size() - 1; size4 >= 0; size4--) {
                                    bVar.f4925e.remove(size4);
                                    if (e.b.g.b.d(bVar.f4925e.get(size4).f4846d.f4890c, strArr4)) {
                                        return true;
                                    }
                                }
                                return true;
                            }
                            bVar.m(this);
                            return false;
                        case 15:
                            bVar.m(this);
                            bVar.g("br");
                            return false;
                        default:
                            if (e.b.g.b.d(str2, x.s)) {
                                String str3 = gVar.f4903c;
                                ArrayList<e.b.h.i> arrayList5 = bVar.f4925e;
                                int i2 = 0;
                                while (true) {
                                    if (i2 < 8) {
                                        e.b.h.i o2 = bVar.o(str3);
                                        if (o2 == null) {
                                            return g(iVar, bVar);
                                        }
                                        if (!bVar.D(bVar.f4925e, o2)) {
                                            bVar.m(this);
                                            break;
                                        } else if (!bVar.r(o2.f4846d.f4890c)) {
                                            bVar.m(this);
                                        } else {
                                            if (bVar.a() != o2) {
                                                bVar.m(this);
                                            }
                                            int size5 = arrayList5.size();
                                            int i3 = 0;
                                            boolean z3 = false;
                                            e.b.h.i iVar8 = null;
                                            while (true) {
                                                if (i3 >= size5 || i3 >= 64) {
                                                    iVar2 = null;
                                                } else {
                                                    iVar2 = arrayList5.get(i3);
                                                    if (iVar2 == o2) {
                                                        iVar8 = arrayList5.get(i3 - 1);
                                                        z3 = true;
                                                    } else if (z3 && bVar.E(iVar2)) {
                                                    }
                                                    i3++;
                                                }
                                            }
                                            iVar2 = null;
                                            if (iVar2 == null) {
                                                bVar.H(o2.f4846d.f4890c);
                                                break;
                                            } else {
                                                e.b.h.i iVar9 = iVar2;
                                                e.b.h.m mVar = iVar9;
                                                for (int i4 = 0; i4 < 3; i4++) {
                                                    if (bVar.F(iVar9)) {
                                                        iVar9 = bVar.h(iVar9);
                                                    }
                                                    if (!bVar.D(bVar.q, iVar9)) {
                                                        bVar.L(iVar9);
                                                    } else if (iVar9 == o2) {
                                                        if (!e.b.g.b.d(iVar8.f4846d.f4890c, x.t)) {
                                                            if (((e.b.h.i) mVar.f4861b) != null) {
                                                                mVar.y();
                                                            }
                                                            bVar.A(mVar);
                                                        } else {
                                                            if (((e.b.h.i) mVar.f4861b) != null) {
                                                                mVar.y();
                                                            }
                                                            iVar8.B(mVar);
                                                        }
                                                        e.b.h.i iVar10 = new e.b.h.i(o2.f4846d, bVar.f, null);
                                                        iVar10.e().c(o2.e());
                                                        for (e.b.h.m mVar2 : (e.b.h.m[]) iVar2.i().toArray(new e.b.h.m[0])) {
                                                            iVar10.B(mVar2);
                                                        }
                                                        iVar2.B(iVar10);
                                                        bVar.K(o2);
                                                        bVar.L(o2);
                                                        int lastIndexOf = bVar.f4925e.lastIndexOf(iVar2);
                                                        c.b.a.a.c.n.c.t1(lastIndexOf == -1);
                                                        bVar.f4925e.add(lastIndexOf + 1, iVar10);
                                                        i2++;
                                                    } else {
                                                        e.b.h.i iVar11 = new e.b.h.i(h.a(iVar9.s(), f.f4883d), bVar.f, null);
                                                        ArrayList<e.b.h.i> arrayList6 = bVar.q;
                                                        int lastIndexOf2 = arrayList6.lastIndexOf(iVar9);
                                                        c.b.a.a.c.n.c.t1(lastIndexOf2 != -1);
                                                        arrayList6.set(lastIndexOf2, iVar11);
                                                        ArrayList<e.b.h.i> arrayList7 = bVar.f4925e;
                                                        int lastIndexOf3 = arrayList7.lastIndexOf(iVar9);
                                                        c.b.a.a.c.n.c.t1(lastIndexOf3 != -1);
                                                        arrayList7.set(lastIndexOf3, iVar11);
                                                        if (((e.b.h.i) mVar.f4861b) != null) {
                                                            mVar.y();
                                                        }
                                                        iVar11.B(mVar);
                                                        iVar9 = iVar11;
                                                        mVar = iVar9;
                                                    }
                                                }
                                                if (!e.b.g.b.d(iVar8.f4846d.f4890c, x.t)) {
                                                }
                                                e.b.h.i iVar102 = new e.b.h.i(o2.f4846d, bVar.f, null);
                                                iVar102.e().c(o2.e());
                                                while (r9 < r8) {
                                                }
                                                iVar2.B(iVar102);
                                                bVar.K(o2);
                                                bVar.L(o2);
                                                int lastIndexOf4 = bVar.f4925e.lastIndexOf(iVar2);
                                                c.b.a.a.c.n.c.t1(lastIndexOf4 == -1);
                                                bVar.f4925e.add(lastIndexOf4 + 1, iVar102);
                                                i2++;
                                            }
                                        }
                                    }
                                }
                                return false;
                            }
                            if (e.b.g.b.d(str2, x.r)) {
                                if (bVar.r(str2)) {
                                    bVar.n(null);
                                    break;
                                }
                            } else {
                                if (e.b.g.b.d(str2, x.m)) {
                                    if (!bVar.r("name")) {
                                        if (bVar.r(str2)) {
                                            bVar.n(null);
                                            if (!bVar.a().f4846d.f4890c.equals(str2)) {
                                                bVar.m(this);
                                            }
                                            bVar.H(str2);
                                            bVar.i();
                                        }
                                    }
                                }
                                return g(iVar, bVar);
                            }
                            bVar.m(this);
                            return false;
                            return true;
                    }
                } else if (ordinal == 3) {
                    bVar.x((i.d) iVar);
                    return true;
                } else if (ordinal != 4) {
                    return true;
                } else {
                    i.c cVar5 = (i.c) iVar;
                    if (cVar5.f4894b.equals(c.y)) {
                        bVar.m(this);
                        return false;
                    } else if (!bVar.t || !c.b(cVar5)) {
                        bVar.J();
                        bVar.w(cVar5);
                        bVar.t = false;
                        return true;
                    } else {
                        bVar.J();
                        bVar.w(cVar5);
                        return true;
                    }
                }
            } else {
                bVar.m(this);
                return false;
            }
        }

        public boolean g(i iVar, b bVar) {
            String str = ((i.g) iVar).f4903c;
            ArrayList<e.b.h.i> arrayList = bVar.f4925e;
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e.b.h.i iVar2 = arrayList.get(size);
                if (iVar2.f4846d.f4890c.equals(str)) {
                    bVar.n(str);
                    if (!str.equals(bVar.a().f4846d.f4890c)) {
                        bVar.m(this);
                    }
                    bVar.H(str);
                } else if (bVar.E(iVar2)) {
                    bVar.m(this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }
    },
    Text {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (iVar.a()) {
                bVar.w((i.c) iVar);
                return true;
            } else if (iVar.d()) {
                bVar.m(this);
                bVar.G();
                c cVar = bVar.l;
                bVar.k = cVar;
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            } else if (!iVar.e()) {
                return true;
            } else {
                bVar.G();
                bVar.k = bVar.l;
                return true;
            }
        }
    },
    InTable {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            c cVar;
            if (iVar.a()) {
                bVar.r = new ArrayList();
                bVar.l = bVar.k;
                c cVar2 = c.InTableText;
                bVar.k = cVar2;
                bVar.g = iVar;
                return cVar2.f(iVar, bVar);
            } else if (iVar.b()) {
                bVar.x((i.d) iVar);
                return true;
            } else if (iVar.c()) {
                bVar.m(this);
                return false;
            } else if (iVar.f()) {
                i.h hVar = (i.h) iVar;
                String str = hVar.f4903c;
                if (str.equals("caption")) {
                    bVar.l();
                    bVar.B();
                    bVar.v(hVar);
                    cVar = c.InCaption;
                } else if (str.equals("colgroup")) {
                    bVar.l();
                    bVar.v(hVar);
                    cVar = c.InColumnGroup;
                } else if (str.equals("col")) {
                    bVar.g("colgroup");
                    bVar.g = iVar;
                    return bVar.k.f(iVar, bVar);
                } else if (e.b.g.b.d(str, x.u)) {
                    bVar.l();
                    bVar.v(hVar);
                    cVar = c.InTableBody;
                } else if (e.b.g.b.d(str, x.v)) {
                    bVar.g("tbody");
                    bVar.g = iVar;
                    return bVar.k.f(iVar, bVar);
                } else {
                    if (str.equals("table")) {
                        bVar.m(this);
                        if (bVar.f("table")) {
                            bVar.g = iVar;
                            return bVar.k.f(iVar, bVar);
                        }
                    } else if (e.b.g.b.d(str, x.w)) {
                        c cVar3 = c.InHead;
                        bVar.g = iVar;
                        return cVar3.f(iVar, bVar);
                    } else if (str.equals("input")) {
                        if (!hVar.j.o("type").equalsIgnoreCase("hidden")) {
                            return g(iVar, bVar);
                        }
                        bVar.y(hVar);
                    } else if (!str.equals("form")) {
                        return g(iVar, bVar);
                    } else {
                        bVar.m(this);
                        if (bVar.o != null) {
                            return false;
                        }
                        bVar.z(hVar, false);
                    }
                    return true;
                }
                bVar.k = cVar;
                return true;
            } else if (iVar.e()) {
                String str2 = ((i.g) iVar).f4903c;
                if (str2.equals("table")) {
                    if (!bVar.u(str2)) {
                        bVar.m(this);
                        return false;
                    }
                    bVar.H("table");
                    bVar.M();
                    return true;
                } else if (!e.b.g.b.d(str2, x.B)) {
                    return g(iVar, bVar);
                } else {
                    bVar.m(this);
                    return false;
                }
            } else if (!iVar.d()) {
                return g(iVar, bVar);
            } else {
                if (bVar.a().f4846d.f4890c.equals("html")) {
                    bVar.m(this);
                }
                return true;
            }
        }

        public boolean g(i iVar, b bVar) {
            bVar.m(this);
            if (e.b.g.b.d(bVar.a().f4846d.f4890c, x.C)) {
                bVar.u = true;
                c cVar = c.InBody;
                bVar.g = iVar;
                boolean f = cVar.f(iVar, bVar);
                bVar.u = false;
                return f;
            }
            c cVar2 = c.InBody;
            bVar.g = iVar;
            return cVar2.f(iVar, bVar);
        }
    },
    InTableText {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (iVar.f4893a == i.j.Character) {
                i.c cVar = (i.c) iVar;
                if (cVar.f4894b.equals(c.y)) {
                    bVar.m(this);
                    return false;
                }
                bVar.r.add(cVar.f4894b);
                return true;
            }
            if (bVar.r.size() > 0) {
                for (String str : bVar.r) {
                    if (!e.b.g.b.e(str)) {
                        bVar.m(this);
                        if (e.b.g.b.d(bVar.a().f4846d.f4890c, x.C)) {
                            bVar.u = true;
                            i.c cVar2 = new i.c();
                            cVar2.f4894b = str;
                            c cVar3 = c.InBody;
                            bVar.g = cVar2;
                            cVar3.f(cVar2, bVar);
                            bVar.u = false;
                        } else {
                            i.c cVar4 = new i.c();
                            cVar4.f4894b = str;
                            c cVar5 = c.InBody;
                            bVar.g = cVar4;
                            cVar5.f(cVar4, bVar);
                        }
                    } else {
                        i.c cVar6 = new i.c();
                        cVar6.f4894b = str;
                        bVar.w(cVar6);
                    }
                }
                bVar.r = new ArrayList();
            }
            c cVar7 = bVar.l;
            bVar.k = cVar7;
            bVar.g = iVar;
            return cVar7.f(iVar, bVar);
        }
    },
    InCaption {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (iVar.e()) {
                i.g gVar = (i.g) iVar;
                if (gVar.f4903c.equals("caption")) {
                    if (!bVar.u(gVar.f4903c)) {
                        bVar.m(this);
                        return false;
                    }
                    bVar.n(null);
                    if (!bVar.a().f4846d.f4890c.equals("caption")) {
                        bVar.m(this);
                    }
                    bVar.H("caption");
                    bVar.i();
                    bVar.k = c.InTable;
                    return true;
                }
            }
            if ((iVar.f() && e.b.g.b.d(((i.h) iVar).f4903c, x.A)) || (iVar.e() && ((i.g) iVar).f4903c.equals("table"))) {
                bVar.m(this);
                if (!bVar.f("caption")) {
                    return true;
                }
                bVar.g = iVar;
                return bVar.k.f(iVar, bVar);
            } else if (!iVar.e() || !e.b.g.b.d(((i.g) iVar).f4903c, x.L)) {
                c cVar = c.InBody;
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            } else {
                bVar.m(this);
                return false;
            }
        }
    },
    InColumnGroup {
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0088, code lost:
            if (r4.equals("html") == false) goto L_0x0095;
         */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0098  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00a3  */
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (c.b(iVar)) {
                bVar.w((i.c) iVar);
                return true;
            }
            int ordinal = iVar.f4893a.ordinal();
            if (ordinal != 0) {
                boolean z = false;
                if (ordinal == 1) {
                    i.h hVar = (i.h) iVar;
                    String str = hVar.f4903c;
                    int hashCode = str.hashCode();
                    if (hashCode != 98688) {
                        if (hashCode == 3213227) {
                        }
                    } else if (str.equals("col")) {
                        z = true;
                        if (z) {
                            c cVar = c.InBody;
                            bVar.g = iVar;
                            return cVar.f(iVar, bVar);
                        } else if (!z) {
                            return g(iVar, bVar);
                        } else {
                            bVar.y(hVar);
                        }
                    }
                    z = true;
                    if (z) {
                    }
                } else if (ordinal != 2) {
                    if (ordinal == 3) {
                        bVar.x((i.d) iVar);
                    } else if (ordinal != 5) {
                        return g(iVar, bVar);
                    } else {
                        if (bVar.a().f4846d.f4890c.equals("html")) {
                            return true;
                        }
                        return g(iVar, bVar);
                    }
                } else if (!((i.g) iVar).f4903c.equals("colgroup")) {
                    return g(iVar, bVar);
                } else {
                    if (bVar.a().f4846d.f4890c.equals("html")) {
                        bVar.m(this);
                        return false;
                    }
                    bVar.G();
                    bVar.k = c.InTable;
                }
            } else {
                bVar.m(this);
            }
            return true;
        }

        public final boolean g(i iVar, m mVar) {
            if (!mVar.f("colgroup")) {
                return true;
            }
            b bVar = (b) mVar;
            bVar.g = iVar;
            return bVar.k.f(iVar, bVar);
        }
    },
    InTableBody {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            c cVar;
            int ordinal = iVar.f4893a.ordinal();
            if (ordinal == 1) {
                i.h hVar = (i.h) iVar;
                String str = hVar.f4903c;
                if (str.equals("template")) {
                    bVar.v(hVar);
                    return true;
                } else if (str.equals("tr")) {
                    bVar.k();
                    bVar.v(hVar);
                    cVar = c.InRow;
                } else if (!e.b.g.b.d(str, x.x)) {
                    return e.b.g.b.d(str, x.D) ? i(iVar, bVar) : g(iVar, bVar);
                } else {
                    bVar.m(this);
                    bVar.g("tr");
                    bVar.g = hVar;
                    return bVar.k.f(hVar, bVar);
                }
            } else if (ordinal != 2) {
                return g(iVar, bVar);
            } else {
                String str2 = ((i.g) iVar).f4903c;
                if (e.b.g.b.d(str2, x.J)) {
                    if (!bVar.u(str2)) {
                        bVar.m(this);
                        return false;
                    }
                    bVar.k();
                    bVar.G();
                    cVar = c.InTable;
                } else if (str2.equals("table")) {
                    return i(iVar, bVar);
                } else {
                    if (!e.b.g.b.d(str2, x.E)) {
                        return g(iVar, bVar);
                    }
                    bVar.m(this);
                    return false;
                }
            }
            bVar.k = cVar;
            return true;
        }

        public final boolean g(i iVar, b bVar) {
            c cVar = c.InTable;
            bVar.g = iVar;
            return cVar.f(iVar, bVar);
        }

        public final boolean i(i iVar, b bVar) {
            if (bVar.u("tbody") || bVar.u("thead") || bVar.r("tfoot")) {
                bVar.k();
                bVar.f(bVar.a().f4846d.f4890c);
                bVar.g = iVar;
                return bVar.k.f(iVar, bVar);
            }
            bVar.m(this);
            return false;
        }
    },
    InRow {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (iVar.f()) {
                i.h hVar = (i.h) iVar;
                String str = hVar.f4903c;
                if (str.equals("template")) {
                    bVar.v(hVar);
                    return true;
                } else if (e.b.g.b.d(str, x.x)) {
                    bVar.j("tr", "template");
                    bVar.v(hVar);
                    bVar.k = c.InCell;
                    bVar.B();
                    return true;
                } else if (!e.b.g.b.d(str, x.F)) {
                    return g(iVar, bVar);
                } else {
                    if (!bVar.f("tr")) {
                        return false;
                    }
                    bVar.g = iVar;
                    return bVar.k.f(iVar, bVar);
                }
            } else if (!iVar.e()) {
                return g(iVar, bVar);
            } else {
                String str2 = ((i.g) iVar).f4903c;
                if (str2.equals("tr")) {
                    if (!bVar.u(str2)) {
                        bVar.m(this);
                        return false;
                    }
                    bVar.j("tr", "template");
                    bVar.G();
                    bVar.k = c.InTableBody;
                    return true;
                } else if (str2.equals("table")) {
                    if (!bVar.f("tr")) {
                        return false;
                    }
                    bVar.g = iVar;
                    return bVar.k.f(iVar, bVar);
                } else if (e.b.g.b.d(str2, x.u)) {
                    if (!bVar.u(str2)) {
                        bVar.m(this);
                        return false;
                    }
                    bVar.f("tr");
                    bVar.g = iVar;
                    return bVar.k.f(iVar, bVar);
                } else if (!e.b.g.b.d(str2, x.G)) {
                    return g(iVar, bVar);
                } else {
                    bVar.m(this);
                    return false;
                }
            }
        }

        public final boolean g(i iVar, b bVar) {
            c cVar = c.InTable;
            bVar.g = iVar;
            return cVar.f(iVar, bVar);
        }
    },
    InCell {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            String str = "th";
            if (iVar.e()) {
                String str2 = ((i.g) iVar).f4903c;
                if (e.b.g.b.d(str2, x.x)) {
                    if (!bVar.u(str2)) {
                        bVar.m(this);
                        bVar.k = c.InRow;
                        return false;
                    }
                    bVar.n(null);
                    if (!bVar.a().f4846d.f4890c.equals(str2)) {
                        bVar.m(this);
                    }
                    bVar.H(str2);
                    bVar.i();
                    bVar.k = c.InRow;
                    return true;
                } else if (e.b.g.b.d(str2, x.y)) {
                    bVar.m(this);
                    return false;
                } else if (!e.b.g.b.d(str2, x.z)) {
                    c cVar = c.InBody;
                    bVar.g = iVar;
                    return cVar.f(iVar, bVar);
                } else if (!bVar.u(str2)) {
                    bVar.m(this);
                    return false;
                } else {
                    if (bVar.u("td")) {
                        str = "td";
                    }
                    bVar.f(str);
                    bVar.g = iVar;
                    return bVar.k.f(iVar, bVar);
                }
            } else if (!iVar.f() || !e.b.g.b.d(((i.h) iVar).f4903c, x.A)) {
                c cVar2 = c.InBody;
                bVar.g = iVar;
                return cVar2.f(iVar, bVar);
            } else if (bVar.u("td") || bVar.u(str)) {
                if (bVar.u("td")) {
                    str = "td";
                }
                bVar.f(str);
                bVar.g = iVar;
                return bVar.k.f(iVar, bVar);
            } else {
                bVar.m(this);
                return false;
            }
        }
    },
    InSelect {
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
            if (r11.a().f4846d.f4890c.equals("html") == false) goto L_0x00ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a8, code lost:
            if (r11.a().f4846d.f4890c.equals("option") != false) goto L_0x00e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e4, code lost:
            if (r11.a().f4846d.f4890c.equals("optgroup") != false) goto L_0x00e6;
         */
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            int ordinal = iVar.f4893a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        String str = ((i.g) iVar).f4903c;
                        char c2 = 65535;
                        int hashCode = str.hashCode();
                        if (hashCode != -1010136971) {
                            if (hashCode != -906021636) {
                                if (hashCode == -80773204 && str.equals("optgroup")) {
                                    c2 = 0;
                                }
                            } else if (str.equals("select")) {
                                c2 = 2;
                            }
                        } else if (str.equals("option")) {
                            c2 = 1;
                        }
                        if (c2 != 0) {
                            if (c2 != 1) {
                                if (c2 != 2) {
                                    bVar.m(this);
                                    return false;
                                } else if (!bVar.s(str)) {
                                    bVar.m(this);
                                    return false;
                                } else {
                                    bVar.H(str);
                                    bVar.M();
                                }
                            }
                        } else if (bVar.a().f4846d.f4890c.equals("option") && bVar.h(bVar.a()) != null && bVar.h(bVar.a()).f4846d.f4890c.equals("optgroup")) {
                            bVar.f("option");
                        }
                        bVar.G();
                    } else if (ordinal == 3) {
                        bVar.x((i.d) iVar);
                    } else if (ordinal == 4) {
                        i.c cVar = (i.c) iVar;
                        if (cVar.f4894b.equals(c.y)) {
                            bVar.m(this);
                            return false;
                        }
                        bVar.w(cVar);
                    } else if (ordinal != 5) {
                        bVar.m(this);
                        return false;
                    }
                    bVar.m(this);
                } else {
                    i.h hVar = (i.h) iVar;
                    String str2 = hVar.f4903c;
                    if (str2.equals("html")) {
                        c cVar2 = c.InBody;
                        bVar.g = hVar;
                        return cVar2.f(hVar, bVar);
                    }
                    if (str2.equals("option")) {
                        if (bVar.a().f4846d.f4890c.equals("option")) {
                            bVar.f("option");
                        }
                    } else if (str2.equals("optgroup")) {
                        if (bVar.a().f4846d.f4890c.equals("option")) {
                            bVar.f("option");
                        }
                        if (bVar.a().f4846d.f4890c.equals("optgroup")) {
                            bVar.f("optgroup");
                        }
                    } else if (str2.equals("select")) {
                        bVar.m(this);
                        return bVar.f("select");
                    } else if (e.b.g.b.d(str2, x.H)) {
                        bVar.m(this);
                        if (!bVar.s("select")) {
                            return false;
                        }
                        bVar.f("select");
                        bVar.g = hVar;
                        return bVar.k.f(hVar, bVar);
                    } else if (str2.equals("script")) {
                        c cVar3 = c.InHead;
                        bVar.g = iVar;
                        return cVar3.f(iVar, bVar);
                    } else {
                        bVar.m(this);
                        return false;
                    }
                    bVar.v(hVar);
                }
                return true;
            }
            bVar.m(this);
            return false;
        }
    },
    InSelectInTable {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (!iVar.f() || !e.b.g.b.d(((i.h) iVar).f4903c, x.I)) {
                if (iVar.e()) {
                    i.g gVar = (i.g) iVar;
                    if (e.b.g.b.d(gVar.f4903c, x.I)) {
                        bVar.m(this);
                        if (!bVar.u(gVar.f4903c)) {
                            return false;
                        }
                        bVar.f("select");
                        bVar.g = iVar;
                        return bVar.k.f(iVar, bVar);
                    }
                }
                c cVar = c.InSelect;
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            }
            bVar.m(this);
            bVar.f("select");
            bVar.g = iVar;
            return bVar.k.f(iVar, bVar);
        }
    },
    AfterBody {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (c.b(iVar)) {
                bVar.w((i.c) iVar);
                return true;
            } else if (iVar.b()) {
                bVar.x((i.d) iVar);
                return true;
            } else if (iVar.c()) {
                bVar.m(this);
                return false;
            } else if (iVar.f() && ((i.h) iVar).f4903c.equals("html")) {
                c cVar = c.InBody;
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            } else if (!iVar.e() || !((i.g) iVar).f4903c.equals("html")) {
                if (iVar.d()) {
                    return true;
                }
                bVar.m(this);
                c cVar2 = c.InBody;
                bVar.k = cVar2;
                bVar.g = iVar;
                return cVar2.f(iVar, bVar);
            } else if (bVar.v) {
                bVar.m(this);
                return false;
            } else {
                bVar.k = c.AfterAfterBody;
                return true;
            }
        }
    },
    InFrameset {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            c cVar;
            if (c.b(iVar)) {
                bVar.w((i.c) iVar);
            } else if (iVar.b()) {
                bVar.x((i.d) iVar);
            } else if (iVar.c()) {
                bVar.m(this);
                return false;
            } else if (iVar.f()) {
                i.h hVar = (i.h) iVar;
                String str = hVar.f4903c;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1644953643:
                        if (str.equals("frameset")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3213227:
                        if (str.equals("html")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 97692013:
                        if (str.equals("frame")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1192721831:
                        if (str.equals("noframes")) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    cVar = c.InBody;
                } else if (c2 == 1) {
                    bVar.v(hVar);
                } else if (c2 == 2) {
                    bVar.y(hVar);
                } else if (c2 != 3) {
                    bVar.m(this);
                    return false;
                } else {
                    cVar = c.InHead;
                }
                bVar.g = hVar;
                return cVar.f(hVar, bVar);
            } else if (!iVar.e() || !((i.g) iVar).f4903c.equals("frameset")) {
                if (!iVar.d()) {
                    bVar.m(this);
                    return false;
                } else if (!bVar.a().f4846d.f4890c.equals("html")) {
                    bVar.m(this);
                }
            } else if (bVar.a().f4846d.f4890c.equals("html")) {
                bVar.m(this);
                return false;
            } else {
                bVar.G();
                if (!bVar.v && !bVar.a().f4846d.f4890c.equals("frameset")) {
                    bVar.k = c.AfterFrameset;
                }
            }
            return true;
        }
    },
    AfterFrameset {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            c cVar;
            if (c.b(iVar)) {
                bVar.w((i.c) iVar);
                return true;
            } else if (iVar.b()) {
                bVar.x((i.d) iVar);
                return true;
            } else if (iVar.c()) {
                bVar.m(this);
                return false;
            } else {
                if (iVar.f() && ((i.h) iVar).f4903c.equals("html")) {
                    cVar = c.InBody;
                } else if (iVar.e() && ((i.g) iVar).f4903c.equals("html")) {
                    bVar.k = c.AfterAfterFrameset;
                    return true;
                } else if (iVar.f() && ((i.h) iVar).f4903c.equals("noframes")) {
                    cVar = c.InHead;
                } else if (iVar.d()) {
                    return true;
                } else {
                    bVar.m(this);
                    return false;
                }
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            }
        }
    },
    AfterAfterBody {
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x0055 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x007a */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v2, types: [e.b.h.m] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00a6 A[EDGE_INSN: B:55:0x00a6->B:44:0x00a6 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            e.b.j.e eVar;
            if (iVar.b()) {
                bVar.x((i.d) iVar);
                return true;
            } else if (iVar.c() || (iVar.f() && ((i.h) iVar).f4903c.equals("html"))) {
                c cVar = c.InBody;
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            } else if (c.b(iVar)) {
                e.b.h.i H = bVar.H("html");
                bVar.w((i.c) iVar);
                bVar.f4925e.add(H);
                ArrayList<e.b.h.i> arrayList = bVar.f4925e;
                e.b.h.i iVar2 = null;
                if (H != null) {
                    c.b.a.a.c.n.c.H1("body");
                    e.b.j.d h = e.b.j.g.h("body");
                    e.b.j.e eVar2 = e.b.j.e.REMOVE;
                    e.b.j.e eVar3 = e.b.j.e.SKIP_CHILDREN;
                    e.b.j.e eVar4 = e.b.j.e.STOP;
                    e.b.j.e eVar5 = e.b.j.e.CONTINUE;
                    e.b.h.i iVar3 = H;
                    int i = 0;
                    while (iVar3 != null) {
                        if (iVar3 instanceof e.b.h.i) {
                            e.b.h.i iVar4 = (e.b.h.i) iVar3;
                            if (h.a(H, iVar4)) {
                                iVar2 = iVar4;
                                eVar = eVar4;
                                if (eVar == eVar4) {
                                    break;
                                } else if (eVar != eVar5 || iVar3.h() <= 0) {
                                    while (iVar3.r() == null && i > 0) {
                                        if (eVar == eVar5 || eVar == eVar3) {
                                            eVar = eVar5;
                                        }
                                        ?? r10 = iVar3.f4861b;
                                        i--;
                                        if (eVar == eVar2) {
                                            iVar3.y();
                                        }
                                        eVar = eVar5;
                                        iVar3 = r10;
                                    }
                                    if (eVar == eVar5 || eVar == eVar3) {
                                        eVar = eVar5;
                                    }
                                    if (iVar3 == H) {
                                        break;
                                    }
                                    e.b.h.m r = iVar3.r();
                                    if (eVar == eVar2) {
                                        iVar3.y();
                                    }
                                    iVar3 = r;
                                } else {
                                    iVar3 = iVar3.g(0);
                                    i++;
                                }
                            }
                        }
                        eVar = eVar5;
                        if (eVar == eVar4) {
                        }
                    }
                    arrayList.add(iVar2);
                    return true;
                }
                throw null;
            } else if (iVar.d()) {
                return true;
            } else {
                bVar.m(this);
                c cVar2 = c.InBody;
                bVar.k = cVar2;
                bVar.g = iVar;
                return cVar2.f(iVar, bVar);
            }
        }
    },
    AfterAfterFrameset {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            if (iVar.b()) {
                bVar.x((i.d) iVar);
                return true;
            } else if (iVar.c() || c.b(iVar) || (iVar.f() && ((i.h) iVar).f4903c.equals("html"))) {
                c cVar = c.InBody;
                bVar.g = iVar;
                return cVar.f(iVar, bVar);
            } else if (iVar.d()) {
                return true;
            } else {
                if (!iVar.f() || !((i.h) iVar).f4903c.equals("noframes")) {
                    bVar.m(this);
                    return false;
                }
                c cVar2 = c.InHead;
                bVar.g = iVar;
                return cVar2.f(iVar, bVar);
            }
        }
    },
    ForeignContent {
        @Override // e.b.i.c
        public boolean f(i iVar, b bVar) {
            return true;
        }
    };
    
    public static final String y = String.valueOf((char) 0);

    public static final class x {
        public static final String[] A = {"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] B = {"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] C = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] D = {"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
        public static final String[] E = {"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};
        public static final String[] F = {"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
        public static final String[] G = {"body", "caption", "col", "colgroup", "html", "td", "th"};
        public static final String[] H = {"input", "keygen", "textarea"};
        public static final String[] I = {"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] J = {"tbody", "tfoot", "thead"};
        public static final String[] K = {"head", "noscript"};
        public static final String[] L = {"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};

        /* renamed from: a  reason: collision with root package name */
        public static final String[] f4874a = {"base", "basefont", "bgsound", "command", "link"};

        /* renamed from: b  reason: collision with root package name */
        public static final String[] f4875b = {"noframes", "style"};

        /* renamed from: c  reason: collision with root package name */
        public static final String[] f4876c = {"body", "br", "html"};

        /* renamed from: d  reason: collision with root package name */
        public static final String[] f4877d = {"body", "html"};

        /* renamed from: e  reason: collision with root package name */
        public static final String[] f4878e = {"body", "br", "head", "html"};
        public static final String[] f = {"basefont", "bgsound", "link", "meta", "noframes", "style"};
        public static final String[] g = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};
        public static final String[] h = {"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
        public static final String[] i = {"h1", "h2", "h3", "h4", "h5", "h6"};
        public static final String[] j = {"address", "div", "p"};
        public static final String[] k = {"dd", "dt"};
        public static final String[] l = {"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
        public static final String[] m = {"applet", "marquee", "object"};
        public static final String[] n = {"area", "br", "embed", "img", "keygen", "wbr"};
        public static final String[] o = {"param", "source", "track"};
        public static final String[] p = {"action", "name", "prompt"};
        public static final String[] q = {"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] r = {"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        public static final String[] s = {"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
        public static final String[] t = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] u = {"tbody", "tfoot", "thead"};
        public static final String[] v = {"td", "th", "tr"};
        public static final String[] w = {"script", "style"};
        public static final String[] x = {"td", "th"};
        public static final String[] y = {"body", "caption", "col", "colgroup", "html"};
        public static final String[] z = {"table", "tbody", "tfoot", "thead", "tr"};
    }

    /* access modifiers changed from: public */
    c(k kVar) {
    }

    public static boolean b(i iVar) {
        if (iVar.a()) {
            return e.b.g.b.e(((i.c) iVar).f4894b);
        }
        return false;
    }

    public static void d(i.h hVar, b bVar) {
        bVar.f4923c.f4914c = l.Rawtext;
        bVar.l = bVar.k;
        bVar.k = Text;
        bVar.v(hVar);
    }

    public abstract boolean f(i iVar, b bVar);
}
