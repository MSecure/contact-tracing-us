package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import org.spongycastle.util.Arrays$Iterator;

public abstract class ASN1Set extends ASN1Primitive implements Object<ASN1Encodable> {
    public boolean isSorted;
    public Vector set;

    public ASN1Set() {
        this.set = new Vector();
        this.isSorted = false;
    }

    public static ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        if (obj instanceof ASN1SetParser) {
            return getInstance(((ASN1SetParser) obj).toASN1Primitive());
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("failed to construct set from byte[]: ");
                outline17.append(e.getMessage());
                throw new IllegalArgumentException(outline17.toString());
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1Set) {
                    return (ASN1Set) aSN1Primitive;
                }
            }
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("unknown object in getInstance: ");
            outline172.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline172.toString());
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Set)) {
            return false;
        }
        ASN1Set aSN1Set = (ASN1Set) aSN1Primitive;
        if (size() != aSN1Set.size()) {
            return false;
        }
        Enumeration objects = getObjects();
        Enumeration objects2 = aSN1Set.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Encodable next = getNext(objects);
            ASN1Encodable next2 = getNext(objects2);
            ASN1Primitive aSN1Primitive2 = next.toASN1Primitive();
            ASN1Primitive aSN1Primitive3 = next2.toASN1Primitive();
            if (aSN1Primitive2 != aSN1Primitive3 && !aSN1Primitive2.equals(aSN1Primitive3)) {
                return false;
            }
        }
        return true;
    }

    public final ASN1Encodable getNext(Enumeration enumeration) {
        ASN1Encodable aSN1Encodable = (ASN1Encodable) enumeration.nextElement();
        return aSN1Encodable == null ? DERNull.INSTANCE : aSN1Encodable;
    }

    public ASN1Encodable getObjectAt(int i) {
        return (ASN1Encodable) this.set.elementAt(i);
    }

    public Enumeration getObjects() {
        return this.set.elements();
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        Enumeration objects = getObjects();
        int size = size();
        while (objects.hasMoreElements()) {
            size = (size * 17) ^ getNext(objects).hashCode();
        }
        return size;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    public Iterator<ASN1Encodable> iterator() {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[size()];
        for (int i = 0; i != size(); i++) {
            aSN1EncodableArr[i] = getObjectAt(i);
        }
        return new Arrays$Iterator(aSN1EncodableArr);
    }

    public int size() {
        return this.set.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if ((r7[r12] & 255) < (r9[r12] & 255)) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        if (r11 == r7.length) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0068, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r11 == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        r4 = r15.set.elementAt(r8);
        r6 = r15.set;
        r6.setElementAt(r6.elementAt(r10), r8);
        r15.set.setElementAt(r4, r10);
        r6 = true;
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0083, code lost:
        r8 = r10;
     */
    public void sort() {
        boolean z;
        if (!this.isSorted) {
            this.isSorted = true;
            if (this.set.size() > 1) {
                int size = this.set.size() - 1;
                for (boolean z2 = true; z2; z2 = z) {
                    try {
                        byte[] encoded = ((ASN1Encodable) this.set.elementAt(0)).toASN1Primitive().getEncoded("DER");
                        int i = 0;
                        z = false;
                        int i2 = 0;
                        while (i2 != size) {
                            int i3 = i2 + 1;
                            try {
                                byte[] encoded2 = ((ASN1Encodable) this.set.elementAt(i3)).toASN1Primitive().getEncoded("DER");
                                int min = Math.min(encoded.length, encoded2.length);
                                int i4 = 0;
                                while (i4 != min) {
                                    if (encoded[i4] == encoded2[i4]) {
                                        i4++;
                                    }
                                }
                            } catch (IOException unused) {
                                throw new IllegalArgumentException("cannot encode object added to SET");
                            }
                        }
                        size = i;
                    } catch (IOException unused2) {
                        throw new IllegalArgumentException("cannot encode object added to SET");
                    }
                }
            }
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        if (this.isSorted) {
            DERSet dERSet = new DERSet();
            dERSet.set = this.set;
            return dERSet;
        }
        Vector vector = new Vector();
        for (int i = 0; i != this.set.size(); i++) {
            vector.addElement(this.set.elementAt(i));
        }
        DERSet dERSet2 = new DERSet();
        dERSet2.set = vector;
        dERSet2.sort();
        return dERSet2;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        DLSet dLSet = new DLSet();
        dLSet.set = this.set;
        return dLSet;
    }

    public String toString() {
        return this.set.toString();
    }

    public ASN1Set(ASN1Encodable aSN1Encodable) {
        Vector vector = new Vector();
        this.set = vector;
        this.isSorted = false;
        vector.addElement(aSN1Encodable);
    }

    public ASN1Set(ASN1EncodableVector aSN1EncodableVector, boolean z) {
        this.set = new Vector();
        this.isSorted = false;
        for (int i = 0; i != aSN1EncodableVector.size(); i++) {
            this.set.addElement(aSN1EncodableVector.get(i));
        }
        if (z) {
            sort();
        }
    }

    public static ASN1Set getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        if (z) {
            if (aSN1TaggedObject.explicit) {
                return (ASN1Set) aSN1TaggedObject.getObject();
            }
            throw new IllegalArgumentException("object implicit - explicit expected.");
        } else if (aSN1TaggedObject.explicit) {
            if (aSN1TaggedObject instanceof BERTaggedObject) {
                return new BERSet(aSN1TaggedObject.getObject());
            }
            return new DLSet(aSN1TaggedObject.getObject());
        } else if (aSN1TaggedObject.getObject() instanceof ASN1Set) {
            return (ASN1Set) aSN1TaggedObject.getObject();
        } else {
            if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) aSN1TaggedObject.getObject();
                if (aSN1TaggedObject instanceof BERTaggedObject) {
                    return new BERSet(aSN1Sequence.toArray());
                }
                return new DLSet(aSN1Sequence.toArray());
            }
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("unknown object in getInstance: ");
            outline17.append(aSN1TaggedObject.getClass().getName());
            throw new IllegalArgumentException(outline17.toString());
        }
    }

    public ASN1Set(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        this.set = new Vector();
        this.isSorted = false;
        for (int i = 0; i != aSN1EncodableArr.length; i++) {
            this.set.addElement(aSN1EncodableArr[i]);
        }
        if (z) {
            sort();
        }
    }
}
