package c.b.a.a.g.b;

import c.b.a.a.g.b.m4;

public final class p4 implements d1<m4.b> {
    /* Return type fixed from 'c.b.a.a.g.b.c1' to match base method */
    @Override // c.b.a.a.g.b.d1
    public final m4.b a(int i) {
        if (i == 100) {
            return m4.b.COMBINED;
        }
        switch (i) {
            case 0:
                return m4.b.UNKNOWN_MOBILE_SUBTYPE;
            case 1:
                return m4.b.GPRS;
            case 2:
                return m4.b.EDGE;
            case 3:
                return m4.b.UMTS;
            case 4:
                return m4.b.CDMA;
            case 5:
                return m4.b.EVDO_0;
            case 6:
                return m4.b.EVDO_A;
            case 7:
                return m4.b.RTT;
            case 8:
                return m4.b.HSDPA;
            case 9:
                return m4.b.HSUPA;
            case 10:
                return m4.b.HSPA;
            case 11:
                return m4.b.IDEN;
            case 12:
                return m4.b.EVDO_B;
            case 13:
                return m4.b.LTE;
            case 14:
                return m4.b.EHRPD;
            case 15:
                return m4.b.HSPAP;
            case 16:
                return m4.b.GSM;
            case 17:
                return m4.b.TD_SCDMA;
            case 18:
                return m4.b.IWLAN;
            case 19:
                return m4.b.LTE_CA;
            default:
                return null;
        }
    }
}
