package e.b.i;

import e.b.i.i;
import java.util.Locale;

public enum l {
    Data {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char k = aVar.k();
            if (k != 0) {
                if (k == '&') {
                    lVar = l.CharacterReferenceInData;
                } else if (k == '<') {
                    lVar = l.TagOpen;
                } else if (k != 65535) {
                    kVar.f(aVar.e());
                    return;
                } else {
                    kVar.g(new i.f());
                    return;
                }
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            kVar.e(aVar.d());
        }
    },
    CharacterReferenceInData {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.b(kVar, l.Data);
        }
    },
    Rcdata {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char k = aVar.k();
            if (k != 0) {
                if (k == '&') {
                    lVar = l.CharacterReferenceInRcdata;
                } else if (k == '<') {
                    lVar = l.RcdataLessthanSign;
                } else if (k != 65535) {
                    kVar.f(aVar.e());
                    return;
                } else {
                    kVar.g(new i.f());
                    return;
                }
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            aVar.a();
            kVar.e(65533);
        }
    },
    CharacterReferenceInRcdata {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.b(kVar, l.Rcdata);
        }
    },
    Rawtext {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.d(kVar, aVar, this, l.RawtextLessthanSign);
        }
    },
    ScriptData {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.d(kVar, aVar, this, l.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            char k = aVar.k();
            if (k == 0) {
                kVar.k(this);
                aVar.a();
                kVar.e(65533);
            } else if (k != 65535) {
                kVar.f(aVar.g(0));
            } else {
                kVar.g(new i.f());
            }
        }
    },
    TagOpen {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            l lVar2;
            char k = aVar.k();
            if (k == '!') {
                lVar = l.MarkupDeclarationOpen;
            } else if (k == '/') {
                lVar = l.EndTagOpen;
            } else if (k != '?') {
                if (aVar.r()) {
                    kVar.d(true);
                    lVar2 = l.TagName;
                } else {
                    kVar.k(this);
                    kVar.e('<');
                    lVar2 = l.Data;
                }
                kVar.f4914c = lVar2;
                return;
            } else {
                kVar.c();
                lVar = l.BogusComment;
            }
            kVar.f4912a.a();
            kVar.f4914c = lVar;
        }
    },
    EndTagOpen {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            l lVar2;
            if (aVar.l()) {
                kVar.i(this);
                kVar.f("</");
                lVar = l.Data;
            } else if (aVar.r()) {
                kVar.d(false);
                lVar = l.TagName;
            } else {
                boolean p = aVar.p('>');
                kVar.k(this);
                if (p) {
                    lVar2 = l.Data;
                } else {
                    kVar.c();
                    lVar2 = l.BogusComment;
                }
                kVar.f4912a.a();
                kVar.f4914c = lVar2;
                return;
            }
            kVar.f4914c = lVar;
        }
    },
    TagName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            aVar.b();
            int i = aVar.f4869e;
            int i2 = aVar.f4867c;
            char[] cArr = aVar.f4865a;
            int i3 = i;
            while (i3 < i2 && (r12 = cArr[i3]) != 0 && r12 != ' ' && r12 != '/' && r12 != '<' && r12 != '>' && r12 != '\t' && r12 != '\n' && r12 != '\f' && r12 != '\r') {
                i3++;
            }
            aVar.f4869e = i3;
            kVar.i.n(i3 > i ? a.c(aVar.f4865a, aVar.h, i, i3 - i) : "");
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != ' ') {
                    if (d2 != '/') {
                        if (d2 == '<') {
                            aVar.v();
                            kVar.k(this);
                        } else if (d2 != '>') {
                            if (d2 == 65535) {
                                kVar.i(this);
                                lVar = l.Data;
                            } else if (!(d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r')) {
                                kVar.i.m(d2);
                                return;
                            }
                        }
                        kVar.h();
                        lVar = l.Data;
                    } else {
                        lVar = l.SelfClosingStartTag;
                    }
                    kVar.f4914c = lVar;
                    return;
                }
                lVar = l.BeforeAttributeName;
                kVar.f4914c = lVar;
                return;
            }
            kVar.i.n(l.u0);
        }
    },
    RcdataLessthanSign {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            if (aVar.p('/')) {
                i.h(kVar.h);
                l lVar2 = l.RCDATAEndTagOpen;
                kVar.f4912a.a();
                kVar.f4914c = lVar2;
                return;
            }
            if (aVar.r() && kVar.o != null) {
                StringBuilder g = c.a.a.a.a.g("</");
                g.append(kVar.o);
                String sb = g.toString();
                if (!(aVar.s(sb.toLowerCase(Locale.ENGLISH)) > -1 || aVar.s(sb.toUpperCase(Locale.ENGLISH)) > -1)) {
                    i.AbstractC0117i d2 = kVar.d(false);
                    d2.q(kVar.o);
                    kVar.i = d2;
                    kVar.h();
                    aVar.v();
                    lVar = l.Data;
                    kVar.f4914c = lVar;
                }
            }
            kVar.f("<");
            lVar = l.Rcdata;
            kVar.f4914c = lVar;
        }
    },
    RCDATAEndTagOpen {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            if (aVar.r()) {
                kVar.d(false);
                kVar.i.m(aVar.k());
                kVar.h.append(aVar.k());
                l lVar = l.RCDATAEndTagName;
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.f("</");
            kVar.f4914c = l.Rcdata;
        }
    },
    RCDATAEndTagName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            if (aVar.r()) {
                String f = aVar.f();
                kVar.i.n(f);
                kVar.h.append(f);
                return;
            }
            char d2 = aVar.d();
            if (d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r' || d2 == ' ') {
                if (kVar.l()) {
                    lVar = l.BeforeAttributeName;
                }
                l(kVar, aVar);
                return;
            } else if (d2 != '/') {
                if (d2 == '>' && kVar.l()) {
                    kVar.h();
                    lVar = l.Data;
                }
                l(kVar, aVar);
                return;
            } else {
                if (kVar.l()) {
                    lVar = l.SelfClosingStartTag;
                }
                l(kVar, aVar);
                return;
            }
            kVar.f4914c = lVar;
        }

        public final void l(k kVar, a aVar) {
            StringBuilder g = c.a.a.a.a.g("</");
            g.append(kVar.h.toString());
            kVar.f(g.toString());
            aVar.v();
            kVar.f4914c = l.Rcdata;
        }
    },
    RawtextLessthanSign {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            if (aVar.p('/')) {
                i.h(kVar.h);
                l lVar = l.RawtextEndTagOpen;
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.e('<');
            kVar.f4914c = l.Rawtext;
        }
    },
    RawtextEndTagOpen {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.f(kVar, aVar, l.RawtextEndTagName, l.Rawtext);
        }
    },
    RawtextEndTagName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.g(kVar, aVar, l.Rawtext);
        }
    },
    ScriptDataLessthanSign {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 == '!') {
                kVar.f("<!");
                lVar = l.ScriptDataEscapeStart;
            } else if (d2 != '/') {
                kVar.f("<");
                if (d2 != 65535) {
                    aVar.v();
                    lVar = l.ScriptData;
                } else {
                    kVar.i(this);
                    lVar = l.Data;
                }
            } else {
                i.h(kVar.h);
                lVar = l.ScriptDataEndTagOpen;
            }
            kVar.f4914c = lVar;
        }
    },
    ScriptDataEndTagOpen {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.f(kVar, aVar, l.ScriptDataEndTagName, l.ScriptData);
        }
    },
    ScriptDataEndTagName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.g(kVar, aVar, l.ScriptData);
        }
    },
    ScriptDataEscapeStart {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            if (aVar.p('-')) {
                kVar.e('-');
                l lVar = l.ScriptDataEscapeStartDash;
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.f4914c = l.ScriptData;
        }
    },
    ScriptDataEscapeStartDash {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            if (aVar.p('-')) {
                kVar.e('-');
                l lVar = l.ScriptDataEscapedDashDash;
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.f4914c = l.ScriptData;
        }
    },
    ScriptDataEscaped {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            if (aVar.l()) {
                kVar.i(this);
                kVar.f4914c = l.Data;
                return;
            }
            char k = aVar.k();
            if (k != 0) {
                if (k == '-') {
                    kVar.e('-');
                    lVar = l.ScriptDataEscapedDash;
                } else if (k != '<') {
                    kVar.f(aVar.h('-', '<', 0));
                    return;
                } else {
                    lVar = l.ScriptDataEscapedLessthanSign;
                }
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            aVar.a();
            kVar.e(65533);
        }
    },
    ScriptDataEscapedDash {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            if (aVar.l()) {
                kVar.i(this);
                kVar.f4914c = l.Data;
                return;
            }
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '-') {
                    kVar.e(d2);
                    lVar = l.ScriptDataEscapedDashDash;
                } else if (d2 == '<') {
                    lVar = l.ScriptDataEscapedLessthanSign;
                }
                kVar.f4914c = lVar;
            }
            kVar.k(this);
            d2 = 65533;
            kVar.e(d2);
            lVar = l.ScriptDataEscaped;
            kVar.f4914c = lVar;
        }
    },
    ScriptDataEscapedDashDash {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            if (aVar.l()) {
                kVar.i(this);
                kVar.f4914c = l.Data;
                return;
            }
            char d2 = aVar.d();
            if (d2 == 0) {
                kVar.k(this);
                kVar.e(65533);
            } else if (d2 != '-') {
                if (d2 != '<') {
                    kVar.e(d2);
                    if (d2 == '>') {
                        lVar = l.ScriptData;
                    }
                } else {
                    lVar = l.ScriptDataEscapedLessthanSign;
                }
                kVar.f4914c = lVar;
            } else {
                kVar.e(d2);
                return;
            }
            lVar = l.ScriptDataEscaped;
            kVar.f4914c = lVar;
        }
    },
    ScriptDataEscapedLessthanSign {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            if (aVar.r()) {
                i.h(kVar.h);
                kVar.h.append(aVar.k());
                kVar.f("<" + aVar.k());
                lVar = l.ScriptDataDoubleEscapeStart;
            } else if (aVar.p('/')) {
                i.h(kVar.h);
                lVar = l.ScriptDataEscapedEndTagOpen;
            } else {
                kVar.e('<');
                kVar.f4914c = l.ScriptDataEscaped;
                return;
            }
            kVar.f4912a.a();
            kVar.f4914c = lVar;
        }
    },
    ScriptDataEscapedEndTagOpen {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            if (aVar.r()) {
                kVar.d(false);
                kVar.i.m(aVar.k());
                kVar.h.append(aVar.k());
                l lVar = l.ScriptDataEscapedEndTagName;
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.f("</");
            kVar.f4914c = l.ScriptDataEscaped;
        }
    },
    ScriptDataEscapedEndTagName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.g(kVar, aVar, l.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.i(kVar, aVar, l.ScriptDataDoubleEscaped, l.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char k = aVar.k();
            if (k != 0) {
                if (k == '-') {
                    kVar.e(k);
                    lVar = l.ScriptDataDoubleEscapedDash;
                } else if (k == '<') {
                    kVar.e(k);
                    lVar = l.ScriptDataDoubleEscapedLessthanSign;
                } else if (k != 65535) {
                    kVar.f(aVar.h('-', '<', 0));
                    return;
                } else {
                    kVar.i(this);
                    kVar.f4914c = l.Data;
                    return;
                }
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            aVar.a();
            kVar.e(65533);
        }
    },
    ScriptDataDoubleEscapedDash {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '-') {
                    kVar.e(d2);
                    lVar = l.ScriptDataDoubleEscapedDashDash;
                } else if (d2 == '<') {
                    kVar.e(d2);
                    lVar = l.ScriptDataDoubleEscapedLessthanSign;
                } else if (d2 == 65535) {
                    kVar.i(this);
                    lVar = l.Data;
                }
                kVar.f4914c = lVar;
            }
            kVar.k(this);
            d2 = 65533;
            kVar.e(d2);
            lVar = l.ScriptDataDoubleEscaped;
            kVar.f4914c = lVar;
        }
    },
    ScriptDataDoubleEscapedDashDash {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 == 0) {
                kVar.k(this);
                d2 = 65533;
            } else if (d2 != '-') {
                if (d2 == '<') {
                    kVar.e(d2);
                    lVar = l.ScriptDataDoubleEscapedLessthanSign;
                } else if (d2 == '>') {
                    kVar.e(d2);
                    lVar = l.ScriptData;
                } else if (d2 == 65535) {
                    kVar.i(this);
                    lVar = l.Data;
                }
                kVar.f4914c = lVar;
            } else {
                kVar.e(d2);
                return;
            }
            kVar.e(d2);
            lVar = l.ScriptDataDoubleEscaped;
            kVar.f4914c = lVar;
        }
    },
    ScriptDataDoubleEscapedLessthanSign {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            if (aVar.p('/')) {
                kVar.e('/');
                i.h(kVar.h);
                l lVar = l.ScriptDataDoubleEscapeEnd;
                kVar.f4912a.a();
                kVar.f4914c = lVar;
                return;
            }
            kVar.f4914c = l.ScriptDataDoubleEscaped;
        }
    },
    ScriptDataDoubleEscapeEnd {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l.i(kVar, aVar, l.ScriptDataEscaped, l.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 == 0) {
                aVar.v();
                kVar.k(this);
                kVar.i.r();
            } else if (d2 != ' ') {
                if (!(d2 == '\"' || d2 == '\'')) {
                    if (d2 != '/') {
                        if (d2 != 65535) {
                            if (d2 != '\t' && d2 != '\n' && d2 != '\f' && d2 != '\r') {
                                switch (d2) {
                                    case '<':
                                        aVar.v();
                                        kVar.k(this);
                                        kVar.h();
                                        break;
                                    case '=':
                                        break;
                                    case '>':
                                        kVar.h();
                                        break;
                                    default:
                                        kVar.i.r();
                                        aVar.v();
                                        break;
                                }
                            } else {
                                return;
                            }
                        } else {
                            kVar.i(this);
                        }
                        lVar = l.Data;
                    } else {
                        lVar = l.SelfClosingStartTag;
                    }
                    kVar.f4914c = lVar;
                }
                kVar.k(this);
                kVar.i.r();
                kVar.i.i(d2);
            } else {
                return;
            }
            lVar = l.AttributeName;
            kVar.f4914c = lVar;
        }
    },
    AttributeName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            i.AbstractC0117i iVar;
            l lVar;
            String i = aVar.i(l.s0);
            i.AbstractC0117i iVar2 = kVar.i;
            String str = iVar2.f4904d;
            if (str != null) {
                i = str.concat(i);
            }
            iVar2.f4904d = i;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != ' ') {
                    if (!(d2 == '\"' || d2 == '\'')) {
                        if (d2 != '/') {
                            if (d2 != 65535) {
                                if (!(d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r')) {
                                    switch (d2) {
                                        case '<':
                                            break;
                                        case '=':
                                            lVar = l.BeforeAttributeValue;
                                            break;
                                        case '>':
                                            kVar.h();
                                            break;
                                        default:
                                            iVar = kVar.i;
                                            break;
                                    }
                                }
                            } else {
                                kVar.i(this);
                            }
                            lVar = l.Data;
                        } else {
                            lVar = l.SelfClosingStartTag;
                        }
                        kVar.f4914c = lVar;
                        return;
                    }
                    kVar.k(this);
                    iVar = kVar.i;
                }
                lVar = l.AfterAttributeName;
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            iVar = kVar.i;
            d2 = 65533;
            iVar.i(d2);
        }
    },
    AfterAttributeName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            i.AbstractC0117i iVar;
            char d2 = aVar.d();
            if (d2 == 0) {
                kVar.k(this);
                iVar = kVar.i;
                d2 = 65533;
            } else if (d2 != ' ') {
                if (!(d2 == '\"' || d2 == '\'')) {
                    if (d2 != '/') {
                        if (d2 != 65535) {
                            if (d2 != '\t' && d2 != '\n' && d2 != '\f' && d2 != '\r') {
                                switch (d2) {
                                    case '<':
                                        break;
                                    case '=':
                                        lVar = l.BeforeAttributeValue;
                                        break;
                                    case '>':
                                        kVar.h();
                                        break;
                                    default:
                                        kVar.i.r();
                                        aVar.v();
                                        lVar = l.AttributeName;
                                        break;
                                }
                            } else {
                                return;
                            }
                        } else {
                            kVar.i(this);
                        }
                        lVar = l.Data;
                    } else {
                        lVar = l.SelfClosingStartTag;
                    }
                    kVar.f4914c = lVar;
                }
                kVar.k(this);
                kVar.i.r();
                iVar = kVar.i;
            } else {
                return;
            }
            iVar.i(d2);
            lVar = l.AttributeName;
            kVar.f4914c = lVar;
        }
    },
    BeforeAttributeValue {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            i.AbstractC0117i iVar;
            char d2 = aVar.d();
            if (d2 == 0) {
                kVar.k(this);
                iVar = kVar.i;
                d2 = 65533;
            } else if (d2 != ' ') {
                if (d2 != '\"') {
                    if (d2 != '`') {
                        if (d2 == 65535) {
                            kVar.i(this);
                        } else if (d2 != '\t' && d2 != '\n' && d2 != '\f' && d2 != '\r') {
                            if (d2 != '&') {
                                if (d2 != '\'') {
                                    switch (d2) {
                                        case '>':
                                            kVar.k(this);
                                            break;
                                    }
                                } else {
                                    lVar = l.AttributeValue_singleQuoted;
                                }
                            }
                            aVar.v();
                            lVar = l.AttributeValue_unquoted;
                        } else {
                            return;
                        }
                        kVar.h();
                        lVar = l.Data;
                    }
                    kVar.k(this);
                    iVar = kVar.i;
                } else {
                    lVar = l.AttributeValue_doubleQuoted;
                }
                kVar.f4914c = lVar;
            } else {
                return;
            }
            iVar.j(d2);
            lVar = l.AttributeValue_unquoted;
            kVar.f4914c = lVar;
        }
    },
    AttributeValue_doubleQuoted {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            i.AbstractC0117i iVar;
            l lVar;
            String i = aVar.i(l.r0);
            if (i.length() > 0) {
                kVar.i.k(i);
            } else {
                kVar.i.g = true;
            }
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '\"') {
                    lVar = l.AfterAttributeValue_quoted;
                } else if (d2 == '&') {
                    int[] b2 = kVar.b('\"', true);
                    i.AbstractC0117i iVar2 = kVar.i;
                    if (b2 != null) {
                        iVar2.l(b2);
                        return;
                    } else {
                        iVar2.j('&');
                        return;
                    }
                } else if (d2 != 65535) {
                    iVar = kVar.i;
                } else {
                    kVar.i(this);
                    lVar = l.Data;
                }
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            iVar = kVar.i;
            d2 = 65533;
            iVar.j(d2);
        }
    },
    AttributeValue_singleQuoted {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            i.AbstractC0117i iVar;
            l lVar;
            String i = aVar.i(l.q0);
            if (i.length() > 0) {
                kVar.i.k(i);
            } else {
                kVar.i.g = true;
            }
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == 65535) {
                    kVar.i(this);
                    lVar = l.Data;
                } else if (d2 == '&') {
                    int[] b2 = kVar.b('\'', true);
                    i.AbstractC0117i iVar2 = kVar.i;
                    if (b2 != null) {
                        iVar2.l(b2);
                        return;
                    } else {
                        iVar2.j('&');
                        return;
                    }
                } else if (d2 != '\'') {
                    iVar = kVar.i;
                } else {
                    lVar = l.AfterAttributeValue_quoted;
                }
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            iVar = kVar.i;
            d2 = 65533;
            iVar.j(d2);
        }
    },
    AttributeValue_unquoted {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            i.AbstractC0117i iVar;
            l lVar;
            String i = aVar.i(l.t0);
            if (i.length() > 0) {
                kVar.i.k(i);
            }
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != ' ') {
                    if (!(d2 == '\"' || d2 == '`')) {
                        if (d2 == 65535) {
                            kVar.i(this);
                        } else if (!(d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r')) {
                            if (d2 == '&') {
                                int[] b2 = kVar.b('>', true);
                                i.AbstractC0117i iVar2 = kVar.i;
                                if (b2 != null) {
                                    iVar2.l(b2);
                                    return;
                                } else {
                                    iVar2.j('&');
                                    return;
                                }
                            } else if (d2 != '\'') {
                                switch (d2) {
                                    case '>':
                                        kVar.h();
                                        break;
                                    case '<':
                                    case '=':
                                        kVar.k(this);
                                        break;
                                }
                                iVar = kVar.i;
                            }
                        }
                        lVar = l.Data;
                        kVar.f4914c = lVar;
                        return;
                    }
                    kVar.k(this);
                    iVar = kVar.i;
                }
                lVar = l.BeforeAttributeName;
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            iVar = kVar.i;
            d2 = 65533;
            iVar.j(d2);
        }
    },
    AfterAttributeValue_quoted {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (!(d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r' || d2 == ' ')) {
                if (d2 != '/') {
                    if (d2 == '>') {
                        kVar.h();
                    } else if (d2 != 65535) {
                        aVar.v();
                        kVar.k(this);
                    } else {
                        kVar.i(this);
                    }
                    lVar = l.Data;
                } else {
                    lVar = l.SelfClosingStartTag;
                }
                kVar.f4914c = lVar;
            }
            lVar = l.BeforeAttributeName;
            kVar.f4914c = lVar;
        }
    },
    SelfClosingStartTag {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 == '>') {
                kVar.i.i = true;
                kVar.h();
            } else if (d2 != 65535) {
                aVar.v();
                kVar.k(this);
                lVar = l.BeforeAttributeName;
                kVar.f4914c = lVar;
            } else {
                kVar.i(this);
            }
            lVar = l.Data;
            kVar.f4914c = lVar;
        }
    },
    BogusComment {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            aVar.v();
            kVar.n.j(aVar.g('>'));
            char d2 = aVar.d();
            if (d2 == '>' || d2 == 65535) {
                kVar.g(kVar.n);
                kVar.f4914c = l.Data;
            }
        }
    },
    MarkupDeclarationOpen {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            if (aVar.n("--")) {
                kVar.n.g();
                lVar = l.CommentStart;
            } else if (aVar.o("DOCTYPE")) {
                lVar = l.Doctype;
            } else if (aVar.n("[CDATA[")) {
                i.h(kVar.h);
                lVar = l.CdataSection;
            } else {
                kVar.k(this);
                kVar.c();
                l lVar2 = l.BogusComment;
                kVar.f4912a.a();
                kVar.f4914c = lVar2;
                return;
            }
            kVar.f4914c = lVar;
        }
    },
    CommentStart {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != '-') {
                    if (d2 == '>') {
                        kVar.k(this);
                    } else if (d2 != 65535) {
                        aVar.v();
                    } else {
                        kVar.i(this);
                    }
                    kVar.g(kVar.n);
                    lVar = l.Data;
                } else {
                    lVar = l.CommentStartDash;
                }
                kVar.f4914c = lVar;
            }
            kVar.k(this);
            kVar.n.i(65533);
            lVar = l.Comment;
            kVar.f4914c = lVar;
        }
    },
    CommentStartDash {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != '-') {
                    if (d2 == '>') {
                        kVar.k(this);
                    } else if (d2 != 65535) {
                        kVar.n.i(d2);
                    } else {
                        kVar.i(this);
                    }
                    kVar.g(kVar.n);
                    lVar = l.Data;
                } else {
                    lVar = l.CommentStartDash;
                }
                kVar.f4914c = lVar;
            }
            kVar.k(this);
            kVar.n.i(65533);
            lVar = l.Comment;
            kVar.f4914c = lVar;
        }
    },
    Comment {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            char k = aVar.k();
            if (k == 0) {
                kVar.k(this);
                aVar.a();
                kVar.n.i(65533);
            } else if (k == '-') {
                l lVar = l.CommentEndDash;
                kVar.f4912a.a();
                kVar.f4914c = lVar;
            } else if (k != 65535) {
                kVar.n.j(aVar.h('-', 0));
            } else {
                kVar.i(this);
                kVar.g(kVar.n);
                kVar.f4914c = l.Data;
            }
        }
    },
    CommentEndDash {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '-') {
                    lVar = l.CommentEnd;
                } else if (d2 != 65535) {
                    i.d dVar = kVar.n;
                    dVar.i('-');
                    dVar.i(d2);
                } else {
                    kVar.i(this);
                    kVar.g(kVar.n);
                    lVar = l.Data;
                }
                kVar.f4914c = lVar;
            }
            kVar.k(this);
            i.d dVar2 = kVar.n;
            dVar2.i('-');
            dVar2.i(65533);
            lVar = l.Comment;
            kVar.f4914c = lVar;
        }
    },
    CommentEnd {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '!') {
                    kVar.k(this);
                    lVar = l.CommentEndBang;
                } else if (d2 != '-') {
                    if (d2 != '>') {
                        if (d2 != 65535) {
                            kVar.k(this);
                            i.d dVar = kVar.n;
                            dVar.j("--");
                            dVar.i(d2);
                        } else {
                            kVar.i(this);
                        }
                    }
                    kVar.g(kVar.n);
                    lVar = l.Data;
                } else {
                    kVar.k(this);
                    kVar.n.i('-');
                    return;
                }
                kVar.f4914c = lVar;
            }
            kVar.k(this);
            i.d dVar2 = kVar.n;
            dVar2.j("--");
            dVar2.i(65533);
            lVar = l.Comment;
            kVar.f4914c = lVar;
        }
    },
    CommentEndBang {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != '-') {
                    if (d2 != '>') {
                        if (d2 != 65535) {
                            i.d dVar = kVar.n;
                            dVar.j("--!");
                            dVar.i(d2);
                        } else {
                            kVar.i(this);
                        }
                    }
                    kVar.g(kVar.n);
                    lVar = l.Data;
                } else {
                    kVar.n.j("--!");
                    lVar = l.CommentEndDash;
                }
                kVar.f4914c = lVar;
            }
            kVar.k(this);
            i.d dVar2 = kVar.n;
            dVar2.j("--!");
            dVar2.i(65533);
            lVar = l.Comment;
            kVar.f4914c = lVar;
        }
    },
    Doctype {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (!(d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r' || d2 == ' ')) {
                if (d2 != '>') {
                    if (d2 != 65535) {
                        kVar.k(this);
                    } else {
                        kVar.i(this);
                    }
                }
                kVar.k(this);
                kVar.m.g();
                i.e eVar = kVar.m;
                eVar.f = true;
                kVar.g(eVar);
                lVar = l.Data;
                kVar.f4914c = lVar;
            }
            lVar = l.BeforeDoctypeName;
            kVar.f4914c = lVar;
        }
    },
    BeforeDoctypeName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            if (aVar.r()) {
                kVar.m.g();
                kVar.f4914c = l.DoctypeName;
                return;
            }
            char d2 = aVar.d();
            if (d2 == 0) {
                kVar.k(this);
                kVar.m.g();
                kVar.m.f4898b.append((char) 65533);
            } else if (d2 == ' ') {
                return;
            } else {
                if (d2 == 65535) {
                    kVar.i(this);
                    kVar.m.g();
                    i.e eVar = kVar.m;
                    eVar.f = true;
                    kVar.g(eVar);
                    lVar = l.Data;
                    kVar.f4914c = lVar;
                } else if (d2 != '\t' && d2 != '\n' && d2 != '\f' && d2 != '\r') {
                    kVar.m.g();
                    kVar.m.f4898b.append(d2);
                } else {
                    return;
                }
            }
            lVar = l.DoctypeName;
            kVar.f4914c = lVar;
        }
    },
    DoctypeName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            StringBuilder sb;
            l lVar;
            i.e eVar;
            if (aVar.r()) {
                kVar.m.f4898b.append(aVar.f());
                return;
            }
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != ' ') {
                    if (d2 == '>') {
                        eVar = kVar.m;
                    } else if (d2 == 65535) {
                        kVar.i(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    } else if (!(d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r')) {
                        sb = kVar.m.f4898b;
                    }
                    kVar.g(eVar);
                    lVar = l.Data;
                    kVar.f4914c = lVar;
                    return;
                }
                lVar = l.AfterDoctypeName;
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            sb = kVar.m.f4898b;
            d2 = 65533;
            sb.append(d2);
        }
    },
    AfterDoctypeName {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            l lVar2;
            if (aVar.l()) {
                kVar.i(this);
                i.e eVar = kVar.m;
                eVar.f = true;
                kVar.g(eVar);
                kVar.f4914c = l.Data;
            } else if (aVar.q('\t', '\n', '\r', '\f', ' ')) {
                aVar.a();
            } else {
                if (aVar.p('>')) {
                    kVar.g(kVar.m);
                    lVar = l.Data;
                } else {
                    if (aVar.o("PUBLIC")) {
                        kVar.m.f4899c = "PUBLIC";
                        lVar2 = l.AfterDoctypePublicKeyword;
                    } else if (aVar.o("SYSTEM")) {
                        kVar.m.f4899c = "SYSTEM";
                        lVar2 = l.AfterDoctypeSystemKeyword;
                    } else {
                        kVar.k(this);
                        kVar.m.f = true;
                        lVar = l.BogusDoctype;
                    }
                    kVar.f4914c = lVar2;
                    return;
                }
                kVar.f4912a.a();
                kVar.f4914c = lVar;
            }
        }
    },
    AfterDoctypePublicKeyword {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r' || d2 == ' ') {
                lVar = l.BeforeDoctypePublicIdentifier;
            } else if (d2 == '\"') {
                kVar.k(this);
                lVar = l.DoctypePublicIdentifier_doubleQuoted;
            } else if (d2 != '\'') {
                if (d2 == '>') {
                    kVar.k(this);
                } else if (d2 != 65535) {
                    kVar.k(this);
                    kVar.m.f = true;
                    lVar = l.BogusDoctype;
                } else {
                    kVar.i(this);
                }
                i.e eVar = kVar.m;
                eVar.f = true;
                kVar.g(eVar);
                lVar = l.Data;
            } else {
                kVar.k(this);
                lVar = l.DoctypePublicIdentifier_singleQuoted;
            }
            kVar.f4914c = lVar;
        }
    },
    BeforeDoctypePublicIdentifier {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 != '\t' && d2 != '\n' && d2 != '\f' && d2 != '\r' && d2 != ' ') {
                if (d2 == '\"') {
                    lVar = l.DoctypePublicIdentifier_doubleQuoted;
                } else if (d2 != '\'') {
                    if (d2 == '>') {
                        kVar.k(this);
                    } else if (d2 != 65535) {
                        kVar.k(this);
                        kVar.m.f = true;
                        lVar = l.BogusDoctype;
                    } else {
                        kVar.i(this);
                    }
                    i.e eVar = kVar.m;
                    eVar.f = true;
                    kVar.g(eVar);
                    lVar = l.Data;
                } else {
                    lVar = l.DoctypePublicIdentifier_singleQuoted;
                }
                kVar.f4914c = lVar;
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            StringBuilder sb;
            l lVar;
            i.e eVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != '\"') {
                    if (d2 == '>') {
                        kVar.k(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    } else if (d2 != 65535) {
                        sb = kVar.m.f4900d;
                    } else {
                        kVar.i(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    }
                    kVar.g(eVar);
                    lVar = l.Data;
                } else {
                    lVar = l.AfterDoctypePublicIdentifier;
                }
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            sb = kVar.m.f4900d;
            d2 = 65533;
            sb.append(d2);
        }
    },
    DoctypePublicIdentifier_singleQuoted {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            StringBuilder sb;
            l lVar;
            i.e eVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != '\'') {
                    if (d2 == '>') {
                        kVar.k(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    } else if (d2 != 65535) {
                        sb = kVar.m.f4900d;
                    } else {
                        kVar.i(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    }
                    kVar.g(eVar);
                    lVar = l.Data;
                } else {
                    lVar = l.AfterDoctypePublicIdentifier;
                }
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            sb = kVar.m.f4900d;
            d2 = 65533;
            sb.append(d2);
        }
    },
    AfterDoctypePublicIdentifier {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            i.e eVar;
            char d2 = aVar.d();
            if (d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r' || d2 == ' ') {
                lVar = l.BetweenDoctypePublicAndSystemIdentifiers;
            } else if (d2 == '\"') {
                kVar.k(this);
                lVar = l.DoctypeSystemIdentifier_doubleQuoted;
            } else if (d2 != '\'') {
                if (d2 == '>') {
                    eVar = kVar.m;
                } else if (d2 != 65535) {
                    kVar.k(this);
                    kVar.m.f = true;
                    lVar = l.BogusDoctype;
                } else {
                    kVar.i(this);
                    eVar = kVar.m;
                    eVar.f = true;
                }
                kVar.g(eVar);
                lVar = l.Data;
            } else {
                kVar.k(this);
                lVar = l.DoctypeSystemIdentifier_singleQuoted;
            }
            kVar.f4914c = lVar;
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            i.e eVar;
            char d2 = aVar.d();
            if (d2 != '\t' && d2 != '\n' && d2 != '\f' && d2 != '\r' && d2 != ' ') {
                if (d2 == '\"') {
                    kVar.k(this);
                    lVar = l.DoctypeSystemIdentifier_doubleQuoted;
                } else if (d2 != '\'') {
                    if (d2 == '>') {
                        eVar = kVar.m;
                    } else if (d2 != 65535) {
                        kVar.k(this);
                        kVar.m.f = true;
                        lVar = l.BogusDoctype;
                    } else {
                        kVar.i(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    }
                    kVar.g(eVar);
                    lVar = l.Data;
                } else {
                    kVar.k(this);
                    lVar = l.DoctypeSystemIdentifier_singleQuoted;
                }
                kVar.f4914c = lVar;
            }
        }
    },
    AfterDoctypeSystemKeyword {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r' || d2 == ' ') {
                lVar = l.BeforeDoctypeSystemIdentifier;
            } else if (d2 == '\"') {
                kVar.k(this);
                lVar = l.DoctypeSystemIdentifier_doubleQuoted;
            } else if (d2 != '\'') {
                if (d2 == '>') {
                    kVar.k(this);
                } else if (d2 != 65535) {
                    kVar.k(this);
                    i.e eVar = kVar.m;
                    eVar.f = true;
                    kVar.g(eVar);
                    return;
                } else {
                    kVar.i(this);
                }
                i.e eVar2 = kVar.m;
                eVar2.f = true;
                kVar.g(eVar2);
                lVar = l.Data;
            } else {
                kVar.k(this);
                lVar = l.DoctypeSystemIdentifier_singleQuoted;
            }
            kVar.f4914c = lVar;
        }
    },
    BeforeDoctypeSystemIdentifier {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            char d2 = aVar.d();
            if (d2 != '\t' && d2 != '\n' && d2 != '\f' && d2 != '\r' && d2 != ' ') {
                if (d2 == '\"') {
                    lVar = l.DoctypeSystemIdentifier_doubleQuoted;
                } else if (d2 != '\'') {
                    if (d2 == '>') {
                        kVar.k(this);
                    } else if (d2 != 65535) {
                        kVar.k(this);
                        kVar.m.f = true;
                        lVar = l.BogusDoctype;
                    } else {
                        kVar.i(this);
                    }
                    i.e eVar = kVar.m;
                    eVar.f = true;
                    kVar.g(eVar);
                    lVar = l.Data;
                } else {
                    lVar = l.DoctypeSystemIdentifier_singleQuoted;
                }
                kVar.f4914c = lVar;
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            StringBuilder sb;
            l lVar;
            i.e eVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != '\"') {
                    if (d2 == '>') {
                        kVar.k(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    } else if (d2 != 65535) {
                        sb = kVar.m.f4901e;
                    } else {
                        kVar.i(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    }
                    kVar.g(eVar);
                    lVar = l.Data;
                } else {
                    lVar = l.AfterDoctypeSystemIdentifier;
                }
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            sb = kVar.m.f4901e;
            d2 = 65533;
            sb.append(d2);
        }
    },
    DoctypeSystemIdentifier_singleQuoted {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            StringBuilder sb;
            l lVar;
            i.e eVar;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 != '\'') {
                    if (d2 == '>') {
                        kVar.k(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    } else if (d2 != 65535) {
                        sb = kVar.m.f4901e;
                    } else {
                        kVar.i(this);
                        eVar = kVar.m;
                        eVar.f = true;
                    }
                    kVar.g(eVar);
                    lVar = l.Data;
                } else {
                    lVar = l.AfterDoctypeSystemIdentifier;
                }
                kVar.f4914c = lVar;
                return;
            }
            kVar.k(this);
            sb = kVar.m.f4901e;
            d2 = 65533;
            sb.append(d2);
        }
    },
    AfterDoctypeSystemIdentifier {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            l lVar;
            i.e eVar;
            char d2 = aVar.d();
            if (d2 != '\t' && d2 != '\n' && d2 != '\f' && d2 != '\r' && d2 != ' ') {
                if (d2 == '>') {
                    eVar = kVar.m;
                } else if (d2 != 65535) {
                    kVar.k(this);
                    lVar = l.BogusDoctype;
                    kVar.f4914c = lVar;
                } else {
                    kVar.i(this);
                    eVar = kVar.m;
                    eVar.f = true;
                }
                kVar.g(eVar);
                lVar = l.Data;
                kVar.f4914c = lVar;
            }
        }
    },
    BogusDoctype {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            char d2 = aVar.d();
            if (d2 == '>' || d2 == 65535) {
                kVar.g(kVar.m);
                kVar.f4914c = l.Data;
            }
        }
    },
    CdataSection {
        @Override // e.b.i.l
        public void k(k kVar, a aVar) {
            String str;
            int s = aVar.s("]]>");
            if (s != -1) {
                str = a.c(aVar.f4865a, aVar.h, aVar.f4869e, s);
                aVar.f4869e += s;
            } else {
                int i = aVar.f4867c;
                int i2 = aVar.f4869e;
                if (i - i2 < 3) {
                    str = aVar.j();
                } else {
                    int i3 = (i - 3) + 1;
                    str = a.c(aVar.f4865a, aVar.h, i2, i3 - i2);
                    aVar.f4869e = i3;
                }
            }
            kVar.h.append(str);
            if (aVar.n("]]>") || aVar.l()) {
                kVar.g(new i.b(kVar.h.toString()));
                kVar.f4914c = l.Data;
            }
        }
    };
    
    public static final char[] q0 = {0, '&', '\''};
    public static final char[] r0 = {0, '\"', '&'};
    public static final char[] s0 = {0, '\t', '\n', '\f', '\r', ' ', '\"', '\'', '/', '<', '=', '>'};
    public static final char[] t0 = {0, '\t', '\n', '\f', '\r', ' ', '\"', '&', '\'', '<', '=', '>', '`'};
    public static final String u0 = String.valueOf((char) 65533);

    /* access modifiers changed from: public */
    l(k kVar) {
    }

    public static void b(k kVar, l lVar) {
        int[] b2 = kVar.b(null, false);
        if (b2 == null) {
            kVar.e('&');
        } else {
            kVar.f(new String(b2, 0, b2.length));
        }
        kVar.f4914c = lVar;
    }

    public static void d(k kVar, a aVar, l lVar, l lVar2) {
        char k2 = aVar.k();
        if (k2 == 0) {
            kVar.k(lVar);
            aVar.a();
            kVar.e(65533);
        } else if (k2 == '<') {
            kVar.f4912a.a();
            kVar.f4914c = lVar2;
        } else if (k2 != 65535) {
            int i2 = aVar.f4869e;
            int i3 = aVar.f4867c;
            char[] cArr = aVar.f4865a;
            int i4 = i2;
            while (i4 < i3) {
                char c2 = cArr[i4];
                if (c2 == 0 || c2 == '<') {
                    break;
                }
                i4++;
            }
            aVar.f4869e = i4;
            kVar.f(i4 > i2 ? a.c(aVar.f4865a, aVar.h, i2, i4 - i2) : "");
        } else {
            kVar.g(new i.f());
        }
    }

    public static void f(k kVar, a aVar, l lVar, l lVar2) {
        if (aVar.r()) {
            kVar.d(false);
            kVar.f4914c = lVar;
            return;
        }
        kVar.f("</");
        kVar.f4914c = lVar2;
    }

    public static void g(k kVar, a aVar, l lVar) {
        l lVar2;
        if (aVar.r()) {
            String f2 = aVar.f();
            kVar.i.n(f2);
            kVar.h.append(f2);
            return;
        }
        boolean z2 = false;
        boolean z3 = true;
        if (kVar.l() && !aVar.l()) {
            char d2 = aVar.d();
            if (d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r' || d2 == ' ') {
                lVar2 = BeforeAttributeName;
            } else if (d2 == '/') {
                lVar2 = SelfClosingStartTag;
            } else if (d2 != '>') {
                kVar.h.append(d2);
                z2 = true;
                z3 = z2;
            } else {
                kVar.h();
                lVar2 = Data;
            }
            kVar.f4914c = lVar2;
            z3 = z2;
        }
        if (z3) {
            StringBuilder g2 = c.a.a.a.a.g("</");
            g2.append(kVar.h.toString());
            kVar.f(g2.toString());
            kVar.f4914c = lVar;
        }
    }

    public static void i(k kVar, a aVar, l lVar, l lVar2) {
        if (aVar.r()) {
            String f2 = aVar.f();
            kVar.h.append(f2);
            kVar.f(f2);
            return;
        }
        char d2 = aVar.d();
        if (d2 == '\t' || d2 == '\n' || d2 == '\f' || d2 == '\r' || d2 == ' ' || d2 == '/' || d2 == '>') {
            if (kVar.h.toString().equals("script")) {
                kVar.f4914c = lVar;
            } else {
                kVar.f4914c = lVar2;
            }
            kVar.e(d2);
            return;
        }
        aVar.v();
        kVar.f4914c = lVar2;
    }

    public abstract void k(k kVar, a aVar);
}
