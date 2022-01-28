package org.spongycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PemObject {
    public static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    public byte[] content;
    public List headers;
    public String type;

    public PemObject(String str, byte[] bArr) {
        List list = EMPTY_LIST;
        this.type = str;
        this.headers = Collections.unmodifiableList(list);
        this.content = bArr;
    }

    public PemObject(String str, List list, byte[] bArr) {
        this.type = str;
        this.headers = Collections.unmodifiableList(list);
        this.content = bArr;
    }
}
