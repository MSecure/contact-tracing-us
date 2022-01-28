package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;

public class DERBitString extends ASN1BitString {
    public DERBitString(byte[] bArr) {
        super(bArr, 0);
    }

    public static DERBitString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBitString)) {
            return (DERBitString) obj;
        }
        if (obj instanceof DLBitString) {
            DLBitString dLBitString = (DLBitString) obj;
            return new DERBitString(dLBitString.data, dLBitString.padBits);
        } else if (obj instanceof byte[]) {
            try {
                return (DERBitString) ASN1Primitive.fromByteArray((byte[]) obj);
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
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] derForm = ASN1BitString.derForm(this.data, this.padBits);
        int length = derForm.length + 1;
        byte[] bArr = new byte[length];
        bArr[0] = (byte) this.padBits;
        System.arraycopy(derForm, 0, bArr, 1, length - 1);
        aSN1OutputStream.writeEncoded(3, bArr);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.data.length + 1) + 1 + this.data.length + 1;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public DERBitString(byte[] bArr, int i) {
        super(bArr, i);
    }

    public DERBitString(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.toASN1Primitive().getEncoded("DER"), 0);
    }

    public static DERBitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof DERBitString)) {
            return getInstance(object);
        }
        byte[] octets = ((ASN1OctetString) object).getOctets();
        if (octets.length >= 1) {
            byte b = octets[0];
            int length = octets.length - 1;
            byte[] bArr = new byte[length];
            if (length != 0) {
                System.arraycopy(octets, 1, bArr, 0, octets.length - 1);
            }
            return new DERBitString(bArr, b);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }
}
