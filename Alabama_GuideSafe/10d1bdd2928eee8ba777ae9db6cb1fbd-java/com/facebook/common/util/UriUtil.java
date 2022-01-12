package com.facebook.common.util;

import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import com.facebook.react.bridge.PromiseImpl;
import java.net.MalformedURLException;
import java.net.URL;

public class UriUtil {
    public static final Uri LOCAL_CONTACT_IMAGE_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    public static String getSchemeOrNull(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static Uri getUriForResourceId(int i) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i)).build();
    }

    public static boolean isLocalCameraUri(Uri uri) {
        String uri2 = uri.toString();
        return uri2.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri2.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString());
    }

    public static boolean isLocalContentUri(Uri uri) {
        return "content".equals(getSchemeOrNull(uri));
    }

    public static boolean isLocalFileUri(Uri uri) {
        return PromiseImpl.STACK_FRAME_KEY_FILE.equals(getSchemeOrNull(uri));
    }

    public static boolean isNetworkUri(Uri uri) {
        String schemeOrNull = getSchemeOrNull(uri);
        return "https".equals(schemeOrNull) || "http".equals(schemeOrNull);
    }

    public static URL uriToUrl(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
