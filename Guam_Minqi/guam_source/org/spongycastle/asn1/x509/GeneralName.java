package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x500.X500Name;

public class GeneralName extends ASN1Object implements ASN1Choice {
    public ASN1Encodable obj;
    public int tag;

    public GeneralName(X500Name x500Name) {
        this.obj = x500Name;
        this.tag = 4;
    }

    public static GeneralName getInstance(Object obj2) {
        ASN1Encodable aSN1Encodable;
        if (obj2 == null || (obj2 instanceof GeneralName)) {
            return (GeneralName) obj2;
        }
        if (obj2 instanceof ASN1TaggedObject) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj2;
            int i = aSN1TaggedObject.tagNo;
            int i2 = 0;
            switch (i) {
                case 0:
                    return new GeneralName(i, ASN1Sequence.getInstance(aSN1TaggedObject, false));
                case 1:
                    return new GeneralName(i, DERIA5String.getInstance(aSN1TaggedObject, false));
                case 2:
                    return new GeneralName(i, DERIA5String.getInstance(aSN1TaggedObject, false));
                case 3:
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline4("unknown tag: ", i));
                case 4:
                    return new GeneralName(i, X500Name.getInstance(aSN1TaggedObject));
                case 5:
                    return new GeneralName(i, ASN1Sequence.getInstance(aSN1TaggedObject, false));
                case 6:
                    return new GeneralName(i, DERIA5String.getInstance(aSN1TaggedObject, false));
                case 7:
                    ASN1Primitive object = aSN1TaggedObject.getObject();
                    if (object instanceof ASN1OctetString) {
                        aSN1Encodable = ASN1OctetString.getInstance(object);
                    } else {
                        ASN1Sequence instance = ASN1Sequence.getInstance(object);
                        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[instance.size()];
                        Enumeration objects = instance.getObjects();
                        while (objects.hasMoreElements()) {
                            aSN1OctetStringArr[i2] = (ASN1OctetString) objects.nextElement();
                            i2++;
                        }
                        aSN1Encodable = new BEROctetString(aSN1OctetStringArr);
                    }
                    return new GeneralName(i, aSN1Encodable);
                case 8:
                    return new GeneralName(i, ASN1ObjectIdentifier.getInstance(aSN1TaggedObject, false));
            }
        }
        if (obj2 instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj2));
            } catch (IOException unused) {
                throw new IllegalArgumentException("unable to parse encoded general name");
            }
        } else {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("unknown object in getInstance: ");
            outline15.append(obj2.getClass().getName());
            throw new IllegalArgumentException(outline15.toString());
        }
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        int i = this.tag;
        if (i == 4) {
            return new DERTaggedObject(true, i, this.obj);
        }
        return new DERTaggedObject(false, i, this.obj);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.tag);
        stringBuffer.append(": ");
        int i = this.tag;
        if (!(i == 1 || i == 2)) {
            if (i == 4) {
                stringBuffer.append(X500Name.getInstance(this.obj).toString());
            } else if (i != 6) {
                stringBuffer.append(this.obj.toString());
            }
            return stringBuffer.toString();
        }
        stringBuffer.append(DERIA5String.getInstance(this.obj).getString());
        return stringBuffer.toString();
    }

    public GeneralName(int i, ASN1Encodable aSN1Encodable) {
        this.obj = aSN1Encodable;
        this.tag = i;
    }
}
