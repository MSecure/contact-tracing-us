package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    public byte[] string;

    public ASN1OctetString(byte[] bArr) {
        if (bArr != null) {
            this.string = bArr;
            return;
        }
        throw new NullPointerException("string cannot be null");
    }

    public static ASN1OctetString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1OctetString)) {
            return (ASN1OctetString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("failed to construct OCTET STRING from byte[]: ");
                outline15.append(e.getMessage());
                throw new IllegalArgumentException(outline15.toString());
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1OctetString) {
                    return (ASN1OctetString) aSN1Primitive;
                }
            }
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("illegal object in getInstance: ");
            outline152.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline152.toString());
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1OctetString)) {
            return false;
        }
        return PathParser.areEqual(this.string, ((ASN1OctetString) aSN1Primitive).string);
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return this;
    }

    @Override // org.spongycastle.asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.string);
    }

    public byte[] getOctets() {
        return this.string;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return PathParser.hashCode(getOctets());
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DEROctetString(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DEROctetString(this.string);
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("#");
        outline15.append(Strings.fromByteArray(Hex.encode(this.string)));
        return outline15.toString();
    }
}
