package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class ASN1InputStream extends FilterInputStream {
    public final boolean lazyEvaluate;
    public final int limit;
    public final byte[][] tmpBuffers;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ASN1InputStream(InputStream inputStream) {
        super(inputStream);
        int findLimit = StreamUtil.findLimit(inputStream);
        this.limit = findLimit;
        this.lazyEvaluate = false;
        this.tmpBuffers = new byte[11][];
    }

    public static ASN1Primitive createPrimitiveDERObject(int i, DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        int read;
        if (i == 10) {
            byte[] buffer = getBuffer(definiteLengthInputStream, bArr);
            if (buffer.length > 1) {
                return new ASN1Enumerated(buffer);
            }
            if (buffer.length != 0) {
                int i2 = buffer[0] & 255;
                ASN1Enumerated[] aSN1EnumeratedArr = ASN1Enumerated.cache;
                if (i2 >= aSN1EnumeratedArr.length) {
                    return new ASN1Enumerated(MoreExecutors.clone(buffer));
                }
                ASN1Enumerated aSN1Enumerated = aSN1EnumeratedArr[i2];
                if (aSN1Enumerated == null) {
                    aSN1Enumerated = new ASN1Enumerated(MoreExecutors.clone(buffer));
                    aSN1EnumeratedArr[i2] = aSN1Enumerated;
                }
                return aSN1Enumerated;
            }
            throw new IllegalArgumentException("ENUMERATED has zero length");
        } else if (i == 12) {
            return new DERUTF8String(definiteLengthInputStream.toByteArray());
        } else {
            if (i != 30) {
                switch (i) {
                    case 1:
                        return ASN1Boolean.fromOctetString(getBuffer(definiteLengthInputStream, bArr));
                    case 2:
                        return new ASN1Integer(definiteLengthInputStream.toByteArray(), false);
                    case 3:
                        int i3 = definiteLengthInputStream._remaining;
                        if (i3 >= 1) {
                            int read2 = definiteLengthInputStream.read();
                            int i4 = i3 - 1;
                            byte[] bArr2 = new byte[i4];
                            if (i4 != 0) {
                                if (Streams.readFully(definiteLengthInputStream, bArr2) != i4) {
                                    throw new EOFException("EOF encountered in middle of BIT STRING");
                                } else if (read2 > 0 && read2 < 8) {
                                    int i5 = i4 - 1;
                                    if (bArr2[i5] != ((byte) (bArr2[i5] & (255 << read2)))) {
                                        return new DLBitString(bArr2, read2);
                                    }
                                }
                            }
                            return new DERBitString(bArr2, read2);
                        }
                        throw new IllegalArgumentException("truncated BIT STRING detected");
                    case 4:
                        return new DEROctetString(definiteLengthInputStream.toByteArray());
                    case 5:
                        return DERNull.INSTANCE;
                    case 6:
                        return ASN1ObjectIdentifier.fromOctetString(getBuffer(definiteLengthInputStream, bArr));
                    default:
                        switch (i) {
                            case 18:
                                return new DERNumericString(definiteLengthInputStream.toByteArray());
                            case 19:
                                return new DERPrintableString(definiteLengthInputStream.toByteArray());
                            case 20:
                                return new DERT61String(definiteLengthInputStream.toByteArray());
                            case 21:
                                return new DERVideotexString(definiteLengthInputStream.toByteArray());
                            case 22:
                                return new DERIA5String(definiteLengthInputStream.toByteArray());
                            case 23:
                                return new ASN1UTCTime(definiteLengthInputStream.toByteArray());
                            case 24:
                                return new ASN1GeneralizedTime(definiteLengthInputStream.toByteArray());
                            case 25:
                                return new DERGraphicString(definiteLengthInputStream.toByteArray());
                            case 26:
                                return new DERVisibleString(definiteLengthInputStream.toByteArray());
                            case 27:
                                return new DERGeneralString(definiteLengthInputStream.toByteArray());
                            case 28:
                                return new DERUniversalString(definiteLengthInputStream.toByteArray());
                            default:
                                throw new IOException(GeneratedOutlineSupport.outline6("unknown tag ", i, " encountered"));
                        }
                }
            } else {
                int i6 = definiteLengthInputStream._remaining / 2;
                char[] cArr = new char[i6];
                for (int i7 = 0; i7 < i6; i7++) {
                    int read3 = definiteLengthInputStream.read();
                    if (read3 < 0 || (read = definiteLengthInputStream.read()) < 0) {
                        break;
                    }
                    cArr[i7] = (char) ((read3 << 8) | (read & 255));
                }
                return new DERBMPString(cArr);
            }
        }
    }

    public static byte[] getBuffer(DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        int i = definiteLengthInputStream._remaining;
        if (i >= bArr.length) {
            return definiteLengthInputStream.toByteArray();
        }
        byte[] bArr2 = bArr[i];
        if (bArr2 == null) {
            bArr2 = new byte[i];
            bArr[i] = bArr2;
        }
        Streams.readFully(definiteLengthInputStream, bArr2);
        return bArr2;
    }

    public static int readLength(InputStream inputStream, int i) throws IOException {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read <= 127) {
                return read;
            }
            int i2 = read & 127;
            if (i2 <= 4) {
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    int read2 = inputStream.read();
                    if (read2 >= 0) {
                        i3 = (i3 << 8) + read2;
                    } else {
                        throw new EOFException("EOF found reading length");
                    }
                }
                if (i3 < 0) {
                    throw new IOException("corrupted stream - negative length found");
                } else if (i3 < i) {
                    return i3;
                } else {
                    throw new IOException("corrupted stream - out of bounds length found");
                }
            } else {
                throw new IOException(GeneratedOutlineSupport.outline5("DER length more than 4 bytes: ", i2));
            }
        }
    }

    public static int readTagNumber(InputStream inputStream, int i) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = 0;
        int read = inputStream.read();
        if ((read & 127) != 0) {
            while (read >= 0 && (read & 128) != 0) {
                i3 = (i3 | (read & 127)) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return i3 | (read & 127);
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    public ASN1EncodableVector buildDEREncodableVector(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(definiteLengthInputStream);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Primitive readObject = aSN1InputStream.readObject();
            if (readObject == null) {
                return aSN1EncodableVector;
            }
            aSN1EncodableVector.v.addElement(readObject);
        }
    }

    public ASN1Primitive buildObject(int i, int i2, int i3) throws IOException {
        boolean z = (i & 32) != 0;
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this, i3);
        if ((i & 64) != 0) {
            return new DERApplicationSpecific(z, i2, definiteLengthInputStream.toByteArray());
        }
        if ((i & 128) != 0) {
            return new ASN1StreamParser(definiteLengthInputStream).readTaggedObject(z, i2);
        }
        if (!z) {
            return createPrimitiveDERObject(i2, definiteLengthInputStream, this.tmpBuffers);
        }
        if (i2 == 4) {
            ASN1EncodableVector buildDEREncodableVector = buildDEREncodableVector(definiteLengthInputStream);
            int size = buildDEREncodableVector.size();
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[size];
            for (int i4 = 0; i4 != size; i4++) {
                aSN1OctetStringArr[i4] = (ASN1OctetString) buildDEREncodableVector.get(i4);
            }
            return new BEROctetString(aSN1OctetStringArr);
        } else if (i2 == 8) {
            return new DERExternal(buildDEREncodableVector(definiteLengthInputStream));
        } else {
            if (i2 != 16) {
                if (i2 == 17) {
                    return DERFactory.createSet(buildDEREncodableVector(definiteLengthInputStream));
                }
                throw new IOException(GeneratedOutlineSupport.outline6("unknown tag ", i2, " encountered"));
            } else if (this.lazyEvaluate) {
                return new LazyEncodedSequence(definiteLengthInputStream.toByteArray());
            } else {
                return DERFactory.createSequence(buildDEREncodableVector(definiteLengthInputStream));
            }
        }
    }

    public ASN1Primitive readObject() throws IOException {
        int read = read();
        if (read > 0) {
            int readTagNumber = readTagNumber(this, read);
            boolean z = (read & 32) != 0;
            int readLength = readLength(this, this.limit);
            if (readLength >= 0) {
                try {
                    return buildObject(read, readTagNumber, readLength);
                } catch (IllegalArgumentException e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            } else if (z) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit);
                if ((read & 64) != 0) {
                    return new BERApplicationSpecific(readTagNumber, aSN1StreamParser.readVector());
                }
                if ((read & 128) != 0) {
                    return aSN1StreamParser.readTaggedObject(true, readTagNumber);
                }
                if (readTagNumber == 4) {
                    return new BEROctetStringParser(aSN1StreamParser).getLoadedObject();
                }
                if (readTagNumber == 8) {
                    try {
                        return new DERExternal(aSN1StreamParser.readVector());
                    } catch (IllegalArgumentException e2) {
                        throw new ASN1Exception(e2.getMessage(), e2);
                    }
                } else if (readTagNumber == 16) {
                    return new BERSequence(aSN1StreamParser.readVector());
                } else {
                    if (readTagNumber == 17) {
                        return new BERSet(aSN1StreamParser.readVector());
                    }
                    throw new IOException("unknown BER object encountered");
                }
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public ASN1InputStream(byte[] bArr) {
        super(r0);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        int length = bArr.length;
        this.limit = length;
        this.lazyEvaluate = false;
        this.tmpBuffers = new byte[11][];
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public ASN1InputStream(byte[] bArr, boolean z) {
        super(r0);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        int length = bArr.length;
        this.limit = length;
        this.lazyEvaluate = z;
        this.tmpBuffers = new byte[11][];
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ASN1InputStream(InputStream inputStream, boolean z) {
        super(inputStream);
        int findLimit = StreamUtil.findLimit(inputStream);
        this.limit = findLimit;
        this.lazyEvaluate = z;
        this.tmpBuffers = new byte[11][];
    }
}
