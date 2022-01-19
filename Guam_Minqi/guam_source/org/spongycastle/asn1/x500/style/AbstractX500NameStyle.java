package org.spongycastle.asn1.x500.style;

import com.horcrux.svg.PathParser;
import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.x500.AttributeTypeAndValue;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;

public abstract class AbstractX500NameStyle {
    public static Hashtable copyHashTable(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            Object nextElement = keys.nextElement();
            hashtable2.put(nextElement, hashtable.get(nextElement));
        }
        return hashtable2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070 A[LOOP:0: B:10:0x0037->B:35:0x0070, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006f A[SYNTHETIC] */
    public boolean areEqual(X500Name x500Name, X500Name x500Name2) {
        boolean z;
        RDN[] rDNs = x500Name.getRDNs();
        RDN[] rDNs2 = x500Name2.getRDNs();
        if (rDNs.length != rDNs2.length) {
            return false;
        }
        boolean z2 = (rDNs[0].getFirst() == null || rDNs2[0].getFirst() == null) ? false : !rDNs[0].getFirst().type.equals(rDNs2[0].getFirst().type);
        for (int i = 0; i != rDNs.length; i++) {
            RDN rdn = rDNs[i];
            if (z2) {
                for (int length = rDNs2.length - 1; length >= 0; length--) {
                    if (rDNs2[length] != null && rdnAreEqual(rdn, rDNs2[length])) {
                        rDNs2[length] = null;
                    }
                }
                z = false;
                if (!z) {
                    return false;
                }
            } else {
                for (int i2 = 0; i2 != rDNs2.length; i2++) {
                    if (rDNs2[i2] != null && rdnAreEqual(rdn, rDNs2[i2])) {
                        rDNs2[i2] = null;
                    }
                }
                z = false;
                if (!z) {
                }
            }
            z = true;
            if (!z) {
            }
        }
        return true;
    }

    public boolean rdnAreEqual(RDN rdn, RDN rdn2) {
        if (rdn.isMultiValued()) {
            if (!rdn2.isMultiValued()) {
                return false;
            }
            AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
            AttributeTypeAndValue[] typesAndValues2 = rdn2.getTypesAndValues();
            if (typesAndValues.length != typesAndValues2.length) {
                return false;
            }
            for (int i = 0; i != typesAndValues.length; i++) {
                if (!PathParser.atvAreEqual(typesAndValues[i], typesAndValues2[i])) {
                    return false;
                }
            }
            return true;
        } else if (!rdn2.isMultiValued()) {
            return PathParser.atvAreEqual(rdn.getFirst(), rdn2.getFirst());
        } else {
            return false;
        }
    }
}
