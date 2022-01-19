package com.android.volley;

public class VolleyError extends Exception {
    public VolleyError() {
    }

    public VolleyError(NetworkResponse networkResponse) {
    }

    public VolleyError(Throwable th) {
        super(th);
    }
}
