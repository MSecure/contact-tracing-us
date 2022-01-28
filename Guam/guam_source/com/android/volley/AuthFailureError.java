package com.android.volley;

public class AuthFailureError extends VolleyError {
    public AuthFailureError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
