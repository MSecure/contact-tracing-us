package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    public final InputStream _in;
    public final int _limit;
    public final byte[][] tmpBuffers;

    public ASN1StreamParser(InputStream inputStream) {
        int findLimit = StreamUtil.findLimit(inputStream);
        this._in = inputStream;
        this._limit = findLimit;
        this.tmpBuffers = new byte[11][];
    }

    public ASN1Encodable readObject() throws IOException {
        int read = this._in.read();
        if (read == -1) {
            return null;
        }
        InputStream inputStream = this._in;
        boolean z = false;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            IndefiniteLengthInputStream indefiniteLengthInputStream = (IndefiniteLengthInputStream) inputStream;
            indefiniteLengthInputStream._eofOn00 = false;
            indefiniteLengthInputStream.checkForEof();
        }
        int readTagNumber = ASN1InputStream.readTagNumber(this._in, read);
        if ((read & 32) != 0) {
            z = true;
        }
        int readLength = ASN1InputStream.readLength(this._in, this._limit);
        if (readLength >= 0) {
            DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this._in, readLength);
            if ((read & 64) != 0) {
                return new DERApplicationSpecific(z, readTagNumber, definiteLengthInputStream.toByteArray());
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(z, readTagNumber, new ASN1StreamParser(definiteLengthInputStream));
            }
            if (z) {
                if (readTagNumber == 4) {
                    return new BEROctetStringParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                if (readTagNumber == 8) {
                    return new DERExternalParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                if (readTagNumber == 16) {
                    return new DERSequenceParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                if (readTagNumber == 17) {
                    return new DERSetParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                throw new IOException(GeneratedOutlineSupport.outline6("unknown tag ", readTagNumber, " encountered"));
            } else if (readTagNumber == 4) {
                return new DEROctetStringParser(definiteLengthInputStream);
            } else {
                try {
                    return ASN1InputStream.createPrimitiveDERObject(readTagNumber, definiteLengthInputStream, this.tmpBuffers);
                } catch (IllegalArgumentException e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            }
        } else if (z) {
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this._in, this._limit), this._limit);
            if ((read & 64) != 0) {
                return new BERApplicationSpecificParser(readTagNumber, aSN1StreamParser);
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(true, readTagNumber, aSN1StreamParser);
            }
            if (readTagNumber == 4) {
                return new BEROctetStringParser(aSN1StreamParser);
            }
            if (readTagNumber == 8) {
                return new DERExternalParser(aSN1StreamParser);
            }
            if (readTagNumber == 16) {
                return new BERSequenceParser(aSN1StreamParser);
            }
            if (readTagNumber == 17) {
                return new BERSetParser(aSN1StreamParser);
            }
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("unknown BER object encountered: 0x");
            outline17.append(Integer.toHexString(readTagNumber));
            throw new ASN1Exception(outline17.toString());
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    public ASN1Primitive readTaggedObject(boolean z, int i) throws IOException {
        if (!z) {
            return new DERTaggedObject(false, i, new DEROctetString(((DefiniteLengthInputStream) this._in).toByteArray()));
        }
        ASN1EncodableVector readVector = readVector();
        if (this._in instanceof IndefiniteLengthInputStream) {
            if (readVector.size() == 1) {
                return new BERTaggedObject(true, i, readVector.get(0));
            }
            return new BERTaggedObject(false, i, BERFactory.createSequence(readVector));
        } else if (readVector.size() == 1) {
            return new DERTaggedObject(true, i, readVector.get(0));
        } else {
            return new DERTaggedObject(false, i, DERFactory.createSequence(readVector));
        }
    }

    public ASN1EncodableVector readVector() throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Encodable readObject = readObject();
            if (readObject == null) {
                return aSN1EncodableVector;
            }
            if (readObject instanceof InMemoryRepresentable) {
                aSN1EncodableVector.v.addElement(((InMemoryRepresentable) readObject).getLoadedObject());
            } else {
                aSN1EncodableVector.v.addElement(readObject.toASN1Primitive());
            }
        }
    }

    public ASN1StreamParser(InputStream inputStream, int i) {
        this._in = inputStream;
        this._limit = i;
        this.tmpBuffers = new byte[11][];
    }
}
