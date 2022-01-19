package com.facebook.react.modules.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeImageEditorSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@ReactModule(name = ImageEditingManager.NAME)
public class ImageEditingManager extends NativeImageEditorSpec {
    public static final int COMPRESS_QUALITY = 90;
    @SuppressLint({"InlinedApi"})
    public static final String[] EXIF_ATTRIBUTES = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
    public static final List<String> LOCAL_URI_PREFIXES = Arrays.asList("file://", "content://");
    public static final String NAME = "ImageEditingManager";
    public static final String TEMP_FILE_PREFIX = "ReactNative_cropped_image_";

    public static class CleanTask extends GuardedAsyncTask<Void, Void> {
        public final Context mContext;

        public CleanTask(ReactContext reactContext, AnonymousClass1 r2) {
            super(reactContext);
            this.mContext = reactContext;
        }

        public final void cleanDirectory(File file) {
            File[] listFiles = file.listFiles(new FilenameFilter(this) {
                /* class com.facebook.react.modules.camera.ImageEditingManager.CleanTask.AnonymousClass1 */

                public boolean accept(File file, String str) {
                    return str.startsWith(ImageEditingManager.TEMP_FILE_PREFIX);
                }
            });
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void[] voidArr) {
            cleanDirectory(this.mContext.getCacheDir());
            File externalCacheDir = this.mContext.getExternalCacheDir();
            if (externalCacheDir != null) {
                cleanDirectory(externalCacheDir);
            }
        }
    }

    public static class CropTask extends GuardedAsyncTask<Void, Void> {
        public final boolean mAllowExternalStorage;
        public final Context mContext;
        public final Callback mError;
        public final int mHeight;
        public final Callback mSuccess;
        public int mTargetHeight = 0;
        public int mTargetWidth = 0;
        public final String mUri;
        public final int mWidth;
        public final int mX;
        public final int mY;

        public CropTask(ReactContext reactContext, String str, int i, int i2, int i3, int i4, boolean z, Callback callback, Callback callback2, AnonymousClass1 r10) {
            super(reactContext);
            if (i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            this.mContext = reactContext;
            this.mUri = str;
            this.mX = i;
            this.mY = i2;
            this.mWidth = i3;
            this.mHeight = i4;
            this.mAllowExternalStorage = z;
            this.mSuccess = callback;
            this.mError = callback2;
        }

        public final Bitmap crop(BitmapFactory.Options options) throws IOException {
            InputStream openBitmapInputStream = openBitmapInputStream();
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openBitmapInputStream, false);
            try {
                return newInstance.decodeRegion(new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), options);
            } finally {
                openBitmapInputStream.close();
                newInstance.recycle();
            }
        }

        /* JADX INFO: finally extract failed */
        public final Bitmap cropAndResize(int i, int i2, BitmapFactory.Options options) throws IOException {
            float f;
            float f2;
            float f3;
            float f4;
            AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(options);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            InputStream openBitmapInputStream = openBitmapInputStream();
            try {
                BitmapFactory.decodeStream(openBitmapInputStream, null, options2);
                openBitmapInputStream.close();
                float f5 = (float) this.mWidth;
                float f6 = (float) this.mHeight;
                float f7 = (float) i;
                float f8 = (float) i2;
                float f9 = f7 / f8;
                if (f5 / f6 > f9) {
                    f = f9 * f6;
                    f4 = ((f5 - f) / 2.0f) + ((float) this.mX);
                    f3 = (float) this.mY;
                    f2 = f8 / f6;
                } else {
                    float f10 = f5 / f9;
                    float f11 = ((f6 - f10) / 2.0f) + ((float) this.mY);
                    float f12 = f7 / f5;
                    f = f5;
                    f4 = (float) this.mX;
                    f2 = f12;
                    f3 = f11;
                    f6 = f10;
                }
                options.inSampleSize = ImageEditingManager.getDecodeSampleSize(this.mWidth, this.mHeight, i, i2);
                options2.inJustDecodeBounds = false;
                InputStream openBitmapInputStream2 = openBitmapInputStream();
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(openBitmapInputStream2, null, options);
                    if (decodeStream != null) {
                        openBitmapInputStream2.close();
                        float f13 = f2 * ((float) options.inSampleSize);
                        Matrix matrix = new Matrix();
                        matrix.setScale(f13, f13);
                        return Bitmap.createBitmap(decodeStream, (int) Math.floor((double) (f4 / ((float) options.inSampleSize))), (int) Math.floor((double) (f3 / ((float) options.inSampleSize))), (int) Math.floor((double) (f / ((float) options.inSampleSize))), (int) Math.floor((double) (f6 / ((float) options.inSampleSize))), matrix, true);
                    }
                    throw new IOException("Cannot decode bitmap: " + this.mUri);
                } catch (Throwable th) {
                    openBitmapInputStream2.close();
                    throw th;
                }
            } catch (Throwable th2) {
                openBitmapInputStream.close();
                throw th2;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void[] voidArr) {
            Bitmap bitmap;
            File file;
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (this.mTargetWidth > 0 && this.mTargetHeight > 0) {
                    bitmap = cropAndResize(this.mTargetWidth, this.mTargetHeight, options);
                } else {
                    bitmap = crop(options);
                }
                String str = options.outMimeType;
                if (str == null || str.isEmpty()) {
                    throw new IOException("Could not determine MIME type");
                }
                try {
                    file = ImageEditingManager.writeBitmapToInternalCache(this.mContext, bitmap, str);
                } catch (Exception unused) {
                    if (this.mAllowExternalStorage) {
                        file = ImageEditingManager.writeBitmapToExternalCache(this.mContext, bitmap, str);
                    } else {
                        throw new SecurityException("We couldn't create file in internal cache and external cache is disabled. Did you forget to pass allowExternalStorage=true?");
                    }
                }
                if (str.equals("image/jpeg")) {
                    ImageEditingManager.copyExif(this.mContext, Uri.parse(this.mUri), file);
                }
                this.mSuccess.invoke(Uri.fromFile(file).toString());
            } catch (Exception e) {
                this.mError.invoke(e.getMessage());
            }
        }

        public final InputStream openBitmapInputStream() throws IOException {
            InputStream inputStream;
            if (ImageEditingManager.isLocalUri(this.mUri)) {
                inputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mUri));
            } else {
                inputStream = new URL(this.mUri).openConnection().getInputStream();
            }
            if (inputStream != null) {
                return inputStream;
            }
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("Cannot open bitmap: ");
            outline15.append(this.mUri);
            throw new IOException(outline15.toString());
        }
    }

    public ImageEditingManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        new CleanTask(getReactApplicationContext(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void copyExif(Context context, Uri uri, File file) throws IOException {
        File fileFromUri = getFileFromUri(context, uri);
        if (fileFromUri == null) {
            FLog.w("ReactNative", "Couldn't get real path for uri: " + uri);
            return;
        }
        ExifInterface exifInterface = new ExifInterface(fileFromUri.getAbsolutePath());
        ExifInterface exifInterface2 = new ExifInterface(file.getAbsolutePath());
        String[] strArr = EXIF_ATTRIBUTES;
        for (String str : strArr) {
            String attribute = exifInterface.getAttribute(str);
            if (attribute != null) {
                exifInterface2.setAttribute(str, attribute);
            }
        }
        exifInterface2.saveAttributes();
    }

    public static File createTempFile(File file, String str) throws IOException {
        if (file != null) {
            return File.createTempFile(TEMP_FILE_PREFIX, getFileExtensionForType(str), file);
        }
        throw new IOException("No cache directory available");
    }

    public static Bitmap.CompressFormat getCompressFormatForType(String str) {
        if ("image/png".equals(str)) {
            return Bitmap.CompressFormat.PNG;
        }
        if ("image/webp".equals(str)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    public static int getDecodeSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i3 || i > i4) {
            int i6 = i2 / 2;
            int i7 = i / 2;
            while (i7 / i5 >= i3 && i6 / i5 >= i4) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static String getFileExtensionForType(String str) {
        if ("image/png".equals(str)) {
            return ".png";
        }
        return "image/webp".equals(str) ? ".webp" : ".jpg";
    }

    public static File getFileFromUri(Context context, Uri uri) {
        Cursor query;
        if (uri.getScheme().equals(PromiseImpl.STACK_FRAME_KEY_FILE)) {
            return new File(uri.getPath());
        }
        if (!uri.getScheme().equals("content") || (query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null)) == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                String string = query.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    return new File(string);
                }
            }
            query.close();
            return null;
        } finally {
            query.close();
        }
    }

    public static boolean isLocalUri(String str) {
        for (String str2 : LOCAL_URI_PREFIXES) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static File writeBitmapToExternalCache(Context context, Bitmap bitmap, String str) throws IOException {
        File createTempFile = createTempFile(context.getExternalCacheDir(), str);
        writeCompressedBitmapToFile(bitmap, str, createTempFile);
        return createTempFile;
    }

    public static File writeBitmapToInternalCache(Context context, Bitmap bitmap, String str) throws IOException {
        File createTempFile = createTempFile(context.getCacheDir(), str);
        writeCompressedBitmapToFile(bitmap, str, createTempFile);
        return createTempFile;
    }

    public static void writeCompressedBitmapToFile(Bitmap bitmap, String str, File file) throws IOException {
        bitmap.compress(getCompressFormatForType(str), 90, new FileOutputStream(file));
    }

    @Override // com.facebook.fbreact.specs.NativeImageEditorSpec
    public void cropImage(String str, ReadableMap readableMap, Callback callback, Callback callback2) {
        ReadableMap readableMap2 = null;
        ReadableMap map = readableMap.hasKey("offset") ? readableMap.getMap("offset") : null;
        if (readableMap.hasKey("size")) {
            readableMap2 = readableMap.getMap("size");
        }
        boolean z = readableMap.hasKey("allowExternalStorage") ? readableMap.getBoolean("allowExternalStorage") : true;
        if (map == null || readableMap2 == null || !map.hasKey("x") || !map.hasKey("y") || !readableMap2.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH) || !readableMap2.hasKey(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT)) {
            throw new JSApplicationIllegalArgumentException("Please specify offset and size");
        } else if (str == null || str.isEmpty()) {
            throw new JSApplicationIllegalArgumentException("Please specify a URI");
        } else {
            CropTask cropTask = new CropTask(getReactApplicationContext(), str, (int) map.getDouble("x"), (int) map.getDouble("y"), (int) readableMap2.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH), (int) readableMap2.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT), z, callback, callback2, null);
            if (readableMap.hasKey("displaySize")) {
                ReadableMap map2 = readableMap.getMap("displaySize");
                int i = (int) map2.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH);
                int i2 = (int) map2.getDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT);
                if (i <= 0 || i2 <= 0) {
                    throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2)));
                }
                cropTask.mTargetWidth = i;
                cropTask.mTargetHeight = i2;
            }
            cropTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        new CleanTask(getReactApplicationContext(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
