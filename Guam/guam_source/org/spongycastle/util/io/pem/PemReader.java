package org.spongycastle.util.io.pem;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.spongycastle.util.encoders.Base64;

public class PemReader extends BufferedReader {
    public PemReader(Reader reader) {
        super(reader);
    }

    public PemObject readPemObject() throws IOException {
        String readLine;
        String readLine2 = readLine();
        while (readLine2 != null && !readLine2.startsWith("-----BEGIN ")) {
            readLine2 = readLine();
        }
        if (readLine2 == null) {
            return null;
        }
        String substring = readLine2.substring(11);
        int indexOf = substring.indexOf(45);
        String substring2 = substring.substring(0, indexOf);
        if (indexOf <= 0) {
            return null;
        }
        String outline8 = GeneratedOutlineSupport.outline8("-----END ", substring2);
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = readLine();
            if (readLine == null) {
                break;
            } else if (readLine.indexOf(ColorPropConverter.PACKAGE_DELIMITER) >= 0) {
                int indexOf2 = readLine.indexOf(58);
                arrayList.add(new PemHeader(readLine.substring(0, indexOf2), readLine.substring(indexOf2 + 1).trim()));
            } else if (readLine.indexOf(outline8) != -1) {
                break;
            } else {
                stringBuffer.append(readLine.trim());
            }
        }
        if (readLine != null) {
            return new PemObject(substring2, arrayList, Base64.decode(stringBuffer.toString()));
        }
        throw new IOException(GeneratedOutlineSupport.outline8(outline8, " not found"));
    }
}
