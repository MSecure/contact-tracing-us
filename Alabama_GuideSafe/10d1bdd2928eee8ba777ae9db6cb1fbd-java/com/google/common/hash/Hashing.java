package com.google.common.hash;

public final class Hashing {

    public static class Sha512Holder {
        public static final AbstractHashFunction SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
    }

    static {
        System.currentTimeMillis();
    }

    public static AbstractHashFunction sha512() {
        return Sha512Holder.SHA_512;
    }
}
