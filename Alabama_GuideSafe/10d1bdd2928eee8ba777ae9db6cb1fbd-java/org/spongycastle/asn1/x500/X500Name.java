package org.spongycastle.asn1.x500;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.style.AbstractX500NameStyle;
import org.spongycastle.asn1.x500.style.BCStyle;

public class X500Name extends ASN1Object implements ASN1Choice {
    public static AbstractX500NameStyle defaultStyle = BCStyle.INSTANCE;
    public int hashCodeValue;
    public boolean isHashCodeCalculated;
    public RDN[] rdns;
    public AbstractX500NameStyle style = defaultStyle;

    public X500Name(ASN1Sequence aSN1Sequence) {
        RDN rdn;
        this.rdns = new RDN[aSN1Sequence.size()];
        Enumeration objects = aSN1Sequence.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            RDN[] rdnArr = this.rdns;
            int i2 = i + 1;
            Object nextElement = objects.nextElement();
            if (nextElement instanceof RDN) {
                rdn = (RDN) nextElement;
            } else {
                rdn = nextElement != null ? new RDN(ASN1Set.getInstance(nextElement)) : null;
            }
            rdnArr[i] = rdn;
            i = i2;
        }
    }

    public static X500Name getInstance(ASN1TaggedObject aSN1TaggedObject) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, true));
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X500Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (toASN1Primitive().equals(((ASN1Encodable) obj).toASN1Primitive())) {
            return true;
        }
        try {
            return this.style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((ASN1Encodable) obj).toASN1Primitive())));
        } catch (Exception unused) {
            return false;
        }
    }

    public RDN[] getRDNs() {
        RDN[] rdnArr = this.rdns;
        int length = rdnArr.length;
        RDN[] rdnArr2 = new RDN[length];
        System.arraycopy(rdnArr, 0, rdnArr2, 0, length);
        return rdnArr2;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeCalculated) {
            return this.hashCodeValue;
        }
        this.isHashCodeCalculated = true;
        if (this.style != null) {
            RDN[] rDNs = getRDNs();
            int i = 0;
            for (int i2 = 0; i2 != rDNs.length; i2++) {
                if (rDNs[i2].isMultiValued()) {
                    AttributeTypeAndValue[] typesAndValues = rDNs[i2].getTypesAndValues();
                    for (int i3 = 0; i3 != typesAndValues.length; i3++) {
                        i = (i ^ typesAndValues[i3].type.hashCode()) ^ MoreExecutors.canonicalize(MoreExecutors.valueToString(typesAndValues[i3].value)).hashCode();
                    }
                } else {
                    i = (i ^ rDNs[i2].getFirst().type.hashCode()) ^ MoreExecutors.canonicalize(MoreExecutors.valueToString(rDNs[i2].getFirst().value)).hashCode();
                }
            }
            this.hashCodeValue = i;
            return i;
        }
        throw null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.rdns);
    }

    public String toString() {
        BCStyle bCStyle = (BCStyle) this.style;
        if (bCStyle != null) {
            StringBuffer stringBuffer = new StringBuffer();
            RDN[] rDNs = getRDNs();
            boolean z = true;
            for (RDN rdn : rDNs) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append(',');
                }
                Hashtable hashtable = bCStyle.defaultSymbols;
                if (rdn.isMultiValued()) {
                    AttributeTypeAndValue[] typesAndValues = rdn.getTypesAndValues();
                    boolean z2 = true;
                    for (int i = 0; i != typesAndValues.length; i++) {
                        if (z2) {
                            z2 = false;
                        } else {
                            stringBuffer.append('+');
                        }
                        MoreExecutors.appendTypeAndValue(stringBuffer, typesAndValues[i], hashtable);
                    }
                } else if (rdn.getFirst() != null) {
                    MoreExecutors.appendTypeAndValue(stringBuffer, rdn.getFirst(), hashtable);
                }
            }
            return stringBuffer.toString();
        }
        throw null;
    }

    public static X500Name getInstance(Object obj) {
        if (obj instanceof X500Name) {
            return (X500Name) obj;
        }
        if (obj != null) {
            return new X500Name(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
