package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class BEROctetString extends ASN1OctetString {
    public ASN1OctetString[] octs;

    /* JADX WARNING: Illegal instructions before constructor call */
    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr) {
        super(r0.toByteArray());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != aSN1OctetStringArr.length; i++) {
            try {
                byteArrayOutputStream.write(((DEROctetString) aSN1OctetStringArr[i]).string);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(aSN1OctetStringArr[i].getClass().getName() + " found in input should only contain DEROctetString");
            } catch (IOException e) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("exception converting octets ");
                outline17.append(e.toString());
                throw new IllegalArgumentException(outline17.toString());
            }
        }
        this.octs = aSN1OctetStringArr;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.write(36);
        aSN1OutputStream.write(128);
        Enumeration objects = getObjects();
        while (objects.hasMoreElements()) {
            aSN1OutputStream.writeObject((ASN1Encodable) objects.nextElement());
        }
        aSN1OutputStream.write(0);
        aSN1OutputStream.write(0);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        Enumeration objects = getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            i += ((ASN1Encodable) objects.nextElement()).toASN1Primitive().encodedLength();
        }
        return i + 2 + 2;
    }

    public Enumeration getObjects() {
        if (this.octs != null) {
            return new Enumeration() {
                /* class org.spongycastle.asn1.BEROctetString.AnonymousClass1 */
                public int counter = 0;

                public boolean hasMoreElements() {
                    return this.counter < BEROctetString.this.octs.length;
                }

                @Override // java.util.Enumeration
                public Object nextElement() {
                    ASN1OctetString[] aSN1OctetStringArr = BEROctetString.this.octs;
                    int i = this.counter;
                    this.counter = i + 1;
                    return aSN1OctetStringArr[i];
                }
            };
        }
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            byte[] bArr = this.string;
            if (i >= bArr.length) {
                return vector.elements();
            }
            int i2 = i + RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
            int length = (i2 > bArr.length ? bArr.length : i2) - i;
            byte[] bArr2 = new byte[length];
            System.arraycopy(this.string, i, bArr2, 0, length);
            vector.addElement(new DEROctetString(bArr2));
            i = i2;
        }
    }

    @Override // org.spongycastle.asn1.ASN1OctetString
    public byte[] getOctets() {
        return this.string;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    public BEROctetString(byte[] bArr) {
        super(bArr);
    }
}
