package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class Extensions extends ASN1Object {
    public Hashtable extensions = new Hashtable();
    public Vector ordering = new Vector();

    public Extensions(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            Extension instance = Extension.getInstance(objects.nextElement());
            if (!this.extensions.containsKey(instance.extnId)) {
                this.extensions.put(instance.extnId, instance);
                this.ordering.addElement(instance.extnId);
            } else {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("repeated extension found: ");
                outline15.append(instance.extnId);
                throw new IllegalArgumentException(outline15.toString());
            }
        }
    }

    public static Extensions getInstance(Object obj) {
        if (obj instanceof Extensions) {
            return (Extensions) obj;
        }
        if (obj != null) {
            return new Extensions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Enumeration elements = this.ordering.elements();
        while (elements.hasMoreElements()) {
            Hashtable hashtable = this.extensions;
            aSN1EncodableVector.v.addElement((Extension) hashtable.get((ASN1ObjectIdentifier) elements.nextElement()));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
