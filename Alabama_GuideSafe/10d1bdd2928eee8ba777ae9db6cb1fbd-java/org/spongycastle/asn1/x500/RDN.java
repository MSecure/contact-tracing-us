package org.spongycastle.asn1.x500;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Set;

public class RDN extends ASN1Object {
    public ASN1Set values;

    public RDN(ASN1Set aSN1Set) {
        this.values = aSN1Set;
    }

    public AttributeTypeAndValue getFirst() {
        if (this.values.size() == 0) {
            return null;
        }
        return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        int size = this.values.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i = 0; i != size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    public boolean isMultiValued() {
        return this.values.size() > 1;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }
}
