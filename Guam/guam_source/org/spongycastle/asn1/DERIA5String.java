package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.IOException;
import org.spongycastle.util.Strings;

public class DERIA5String extends ASN1Primitive implements ASN1String {
    public final byte[] string;

    public DERIA5String(byte[] bArr) {
        this.string = bArr;
    }

    public static DERIA5String getInstance(Object obj) {
        if (obj == null || (obj instanceof DERIA5String)) {
            return (DERIA5String) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERIA5String) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline3(e, GeneratedOutlineSupport.outline15("encoding error in getInstance: ")));
            }
        } else {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("illegal object in getInstance: ");
            outline15.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline15.toString());
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERIA5String)) {
            return false;
        }
        return PathParser.areEqual(this.string, ((DERIA5String) aSN1Primitive).string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(22, this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        return Strings.fromByteArray(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return PathParser.hashCode(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }

    public static DERIA5String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERIA5String)) {
            return getInstance(object);
        }
        return new DERIA5String(((ASN1OctetString) object).getOctets());
    }
}
