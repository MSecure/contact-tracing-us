package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface Cache {

    public static class Entry {
        public List<Header> allResponseHeaders;
        public byte[] data;
        public String etag;
        public long lastModified;
        public Map<String, String> responseHeaders = Collections.emptyMap();
        public long softTtl;
        public long ttl;
    }
}
