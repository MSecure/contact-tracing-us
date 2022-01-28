package org.spongycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;

public class Base64Encoder implements Encoder {
    public final byte[] decodingTable = new byte[128];
    public final byte[] encodingTable = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    public byte padding = 61;

    public Base64Encoder() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i < bArr2.length) {
                this.decodingTable[bArr2[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.util.encoders.Encoder
    public int decode(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0) {
            int i = length - 1;
            if (!ignore(str.charAt(i))) {
                break;
            }
            length = i;
        }
        int i2 = length - 4;
        int i3 = 0;
        int nextI = nextI(str, 0, i2);
        while (nextI < i2) {
            int i4 = nextI + 1;
            byte b = this.decodingTable[str.charAt(nextI)];
            int nextI2 = nextI(str, i4, i2);
            int i5 = nextI2 + 1;
            byte b2 = this.decodingTable[str.charAt(nextI2)];
            int nextI3 = nextI(str, i5, i2);
            int i6 = nextI3 + 1;
            byte b3 = this.decodingTable[str.charAt(nextI3)];
            int nextI4 = nextI(str, i6, i2);
            int i7 = nextI4 + 1;
            byte b4 = this.decodingTable[str.charAt(nextI4)];
            if ((b | b2 | b3 | b4) >= 0) {
                outputStream.write((b << 2) | (b2 >> 4));
                outputStream.write((b2 << 4) | (b3 >> 2));
                outputStream.write((b3 << 6) | b4);
                i3 += 3;
                nextI = nextI(str, i7, i2);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        char charAt = str.charAt(i2);
        char charAt2 = str.charAt(length - 3);
        char charAt3 = str.charAt(length - 2);
        int i8 = 1;
        char charAt4 = str.charAt(length - 1);
        byte b5 = this.padding;
        if (charAt3 == b5) {
            if (charAt4 == b5) {
                byte[] bArr = this.decodingTable;
                byte b6 = bArr[charAt];
                byte b7 = bArr[charAt2];
                if ((b6 | b7) >= 0) {
                    outputStream.write((b7 >> 4) | (b6 << 2));
                } else {
                    throw new IOException("invalid characters encountered at end of base64 data");
                }
            } else {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
        } else if (charAt4 == b5) {
            byte[] bArr2 = this.decodingTable;
            byte b8 = bArr2[charAt];
            byte b9 = bArr2[charAt2];
            byte b10 = bArr2[charAt3];
            if ((b8 | b9 | b10) >= 0) {
                outputStream.write((b8 << 2) | (b9 >> 4));
                outputStream.write((b10 >> 2) | (b9 << 4));
                i8 = 2;
            } else {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
        } else {
            byte[] bArr3 = this.decodingTable;
            byte b11 = bArr3[charAt];
            byte b12 = bArr3[charAt2];
            byte b13 = bArr3[charAt3];
            byte b14 = bArr3[charAt4];
            if ((b11 | b12 | b13 | b14) >= 0) {
                outputStream.write((b11 << 2) | (b12 >> 4));
                outputStream.write((b12 << 4) | (b13 >> 2));
                outputStream.write(b14 | (b13 << 6));
                i8 = 3;
            } else {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
        }
        return i3 + i8;
    }

    @Override // org.spongycastle.util.encoders.Encoder
    public int encode(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        int i3;
        int i4;
        int i5 = i2 % 3;
        int i6 = i2 - i5;
        int i7 = i;
        while (true) {
            i3 = i + i6;
            i4 = 4;
            if (i7 >= i3) {
                break;
            }
            int i8 = bArr[i7] & 255;
            int i9 = bArr[i7 + 1] & 255;
            int i10 = bArr[i7 + 2] & 255;
            outputStream.write(this.encodingTable[(i8 >>> 2) & 63]);
            outputStream.write(this.encodingTable[((i8 << 4) | (i9 >>> 4)) & 63]);
            outputStream.write(this.encodingTable[((i9 << 2) | (i10 >>> 6)) & 63]);
            outputStream.write(this.encodingTable[i10 & 63]);
            i7 += 3;
        }
        if (i5 == 1) {
            int i11 = bArr[i3] & 255;
            outputStream.write(this.encodingTable[(i11 >>> 2) & 63]);
            outputStream.write(this.encodingTable[(i11 << 4) & 63]);
            outputStream.write(this.padding);
            outputStream.write(this.padding);
        } else if (i5 == 2) {
            int i12 = bArr[i3] & 255;
            int i13 = bArr[i3 + 1] & 255;
            outputStream.write(this.encodingTable[(i12 >>> 2) & 63]);
            outputStream.write(this.encodingTable[((i12 << 4) | (i13 >>> 4)) & 63]);
            outputStream.write(this.encodingTable[(i13 << 2) & 63]);
            outputStream.write(this.padding);
        }
        int i14 = (i6 / 3) * 4;
        if (i5 == 0) {
            i4 = 0;
        }
        return i14 + i4;
    }

    public final boolean ignore(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    public final int nextI(String str, int i, int i2) {
        while (i < i2 && ignore(str.charAt(i))) {
            i++;
        }
        return i;
    }
}
