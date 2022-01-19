package com.facebook.react.modules.camera;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeCameraRollManagerSpec;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import okhttp3.internal.cache.DiskLruCache;

@ReactModule(name = CameraRollManager.NAME)
public class CameraRollManager extends NativeCameraRollManagerSpec {
    public static final String ASSET_TYPE_ALL = "All";
    public static final String ASSET_TYPE_PHOTOS = "Photos";
    public static final String ASSET_TYPE_VIDEOS = "Videos";
    public static final String ERROR_UNABLE_TO_FILTER = "E_UNABLE_TO_FILTER";
    public static final String ERROR_UNABLE_TO_LOAD = "E_UNABLE_TO_LOAD";
    public static final String ERROR_UNABLE_TO_LOAD_PERMISSION = "E_UNABLE_TO_LOAD_PERMISSION";
    public static final String ERROR_UNABLE_TO_SAVE = "E_UNABLE_TO_SAVE";
    public static final String NAME = "CameraRollManager";
    public static final String[] PROJECTION = {"_id", "mime_type", "bucket_display_name", "datetaken", RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, "longitude", "latitude", "_data"};
    public static final String SELECTION_BUCKET = "bucket_display_name = ?";
    public static final String SELECTION_DATE_TAKEN = "datetaken < ?";
    public static final String SELECTION_MEDIA_SIZE = "_size < ?";

    public static class GetMediaTask extends GuardedAsyncTask<Void, Void> {
        public final String mAfter;
        public final String mAssetType;
        public final Context mContext;
        public final int mFirst;
        public final String mGroupName;
        public final Integer mMaxSize;
        public final ReadableArray mMimeTypes;
        public final Promise mPromise;

        public GetMediaTask(ReactContext reactContext, int i, String str, String str2, ReadableArray readableArray, String str3, Integer num, Promise promise, AnonymousClass1 r9) {
            super(reactContext);
            this.mContext = reactContext;
            this.mFirst = i;
            this.mAfter = str;
            this.mGroupName = str2;
            this.mMimeTypes = readableArray;
            this.mPromise = promise;
            this.mAssetType = str3;
            this.mMaxSize = num;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void[] voidArr) {
            StringBuilder sb = new StringBuilder(DiskLruCache.VERSION_1);
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(this.mAfter)) {
                sb.append(" AND datetaken < ?");
                arrayList.add(this.mAfter);
            }
            if (!TextUtils.isEmpty(this.mGroupName)) {
                sb.append(" AND bucket_display_name = ?");
                arrayList.add(this.mGroupName);
            }
            if (this.mMaxSize != null) {
                sb.append(" AND _size < ?");
                arrayList.add(this.mMaxSize.toString());
            }
            String str = this.mAssetType;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1905167199) {
                if (hashCode != -1732810888) {
                    if (hashCode == 65921 && str.equals(CameraRollManager.ASSET_TYPE_ALL)) {
                        c = 2;
                    }
                } else if (str.equals(CameraRollManager.ASSET_TYPE_VIDEOS)) {
                    c = 1;
                }
            } else if (str.equals(CameraRollManager.ASSET_TYPE_PHOTOS)) {
                c = 0;
            }
            if (c == 0) {
                sb.append(" AND media_type = 1");
            } else if (c == 1) {
                sb.append(" AND media_type = 3");
            } else if (c != 2) {
                Promise promise = this.mPromise;
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Invalid filter option: '");
                outline15.append(this.mAssetType);
                outline15.append("'. Expected one of '");
                outline15.append(CameraRollManager.ASSET_TYPE_PHOTOS);
                outline15.append("', '");
                outline15.append(CameraRollManager.ASSET_TYPE_VIDEOS);
                outline15.append("' or '");
                outline15.append(CameraRollManager.ASSET_TYPE_ALL);
                outline15.append("'.");
                promise.reject(CameraRollManager.ERROR_UNABLE_TO_FILTER, outline15.toString());
                return;
            } else {
                sb.append(" AND media_type IN (3,1)");
            }
            ReadableArray readableArray = this.mMimeTypes;
            if (readableArray != null && readableArray.size() > 0) {
                sb.append(" AND mime_type IN (");
                for (int i = 0; i < this.mMimeTypes.size(); i++) {
                    sb.append("?,");
                    arrayList.add(this.mMimeTypes.getString(i));
                }
                sb.replace(sb.length() - 1, sb.length(), ")");
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            ContentResolver contentResolver = this.mContext.getContentResolver();
            try {
                Cursor query = contentResolver.query(MediaStore.Files.getContentUri("external"), CameraRollManager.PROJECTION, sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]), "datetaken DESC, date_modified DESC LIMIT " + (this.mFirst + 1));
                if (query == null) {
                    this.mPromise.reject(CameraRollManager.ERROR_UNABLE_TO_LOAD, "Could not get media");
                    return;
                }
                try {
                    CameraRollManager.putEdges(contentResolver, query, writableNativeMap, this.mFirst);
                    CameraRollManager.putPageInfo(query, writableNativeMap, this.mFirst);
                } finally {
                    query.close();
                    this.mPromise.resolve(writableNativeMap);
                }
            } catch (SecurityException e) {
                this.mPromise.reject(CameraRollManager.ERROR_UNABLE_TO_LOAD_PERMISSION, "Could not get media: need READ_EXTERNAL_STORAGE permission", e);
            }
        }
    }

    public static class SaveToCameraRoll extends GuardedAsyncTask<Void, Void> {
        public final Context mContext;
        public final Promise mPromise;
        public final Uri mUri;

        public SaveToCameraRoll(ReactContext reactContext, Uri uri, Promise promise) {
            super(reactContext);
            this.mContext = reactContext;
            this.mUri = uri;
            this.mPromise = promise;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0057 A[Catch:{ IOException -> 0x0126, all -> 0x0121 }] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
        @Override // com.facebook.react.bridge.GuardedAsyncTask
        public void doInBackgroundGuarded(Void[] voidArr) {
            Throwable th;
            FileChannel fileChannel;
            ReadableByteChannel readableByteChannel;
            Throwable th2;
            IOException e;
            File externalStoragePublicDirectory;
            String str;
            File file = new File(this.mUri.getPath());
            ReadableByteChannel readableByteChannel2 = null;
            try {
                String scheme = this.mUri.getScheme();
                if (!scheme.equals("http")) {
                    if (!scheme.equals("https")) {
                        readableByteChannel = new FileInputStream(file).getChannel();
                        externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                        externalStoragePublicDirectory.mkdirs();
                        if (externalStoragePublicDirectory.isDirectory()) {
                            this.mPromise.reject(CameraRollManager.ERROR_UNABLE_TO_LOAD, "External media storage directory not available");
                            if (readableByteChannel != null && readableByteChannel.isOpen()) {
                                try {
                                    readableByteChannel.close();
                                    return;
                                } catch (IOException e2) {
                                    FLog.e("ReactNative", "Could not close input channel", e2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            File file2 = new File(externalStoragePublicDirectory, file.getName());
                            String name = file.getName();
                            if (name.indexOf(46) >= 0) {
                                String substring = name.substring(0, name.lastIndexOf(46));
                                str = name.substring(name.lastIndexOf(46));
                                name = substring;
                            } else {
                                str = "";
                            }
                            int i = 0;
                            while (!file2.createNewFile()) {
                                file2 = new File(externalStoragePublicDirectory, name + "_" + i + str);
                                i++;
                            }
                            fileChannel = new FileOutputStream(file2).getChannel();
                            try {
                                ByteBuffer allocate = ByteBuffer.allocate(1048576);
                                while (readableByteChannel.read(allocate) > 0) {
                                    allocate.flip();
                                    fileChannel.write(allocate);
                                    allocate.compact();
                                }
                                allocate.flip();
                                while (allocate.hasRemaining()) {
                                    fileChannel.write(allocate);
                                }
                                readableByteChannel.close();
                                fileChannel.close();
                                MediaScannerConnection.scanFile(this.mContext, new String[]{file2.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() {
                                    /* class com.facebook.react.modules.camera.CameraRollManager.SaveToCameraRoll.AnonymousClass1 */

                                    public void onScanCompleted(String str, Uri uri) {
                                        if (uri != null) {
                                            SaveToCameraRoll.this.mPromise.resolve(uri.toString());
                                        } else {
                                            SaveToCameraRoll.this.mPromise.reject(CameraRollManager.ERROR_UNABLE_TO_SAVE, "Could not add image to gallery");
                                        }
                                    }
                                });
                                if (readableByteChannel.isOpen()) {
                                    try {
                                        readableByteChannel.close();
                                    } catch (IOException e3) {
                                        FLog.e("ReactNative", "Could not close input channel", e3);
                                    }
                                }
                                if (!fileChannel.isOpen()) {
                                    return;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                try {
                                    this.mPromise.reject(e);
                                    if (readableByteChannel != null && readableByteChannel.isOpen()) {
                                        try {
                                            readableByteChannel.close();
                                        } catch (IOException e5) {
                                            FLog.e("ReactNative", "Could not close input channel", e5);
                                        }
                                    }
                                    if (fileChannel == null || !fileChannel.isOpen()) {
                                        return;
                                    }
                                    fileChannel.close();
                                    return;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    th = th2;
                                    readableByteChannel2 = readableByteChannel;
                                    if (readableByteChannel2 != null && readableByteChannel2.isOpen()) {
                                        try {
                                            readableByteChannel2.close();
                                        } catch (IOException e6) {
                                            FLog.e("ReactNative", "Could not close input channel", e6);
                                        }
                                    }
                                    if (fileChannel != null && fileChannel.isOpen()) {
                                        try {
                                            fileChannel.close();
                                        } catch (IOException e7) {
                                            FLog.e("ReactNative", "Could not close output channel", e7);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            try {
                                fileChannel.close();
                                return;
                            } catch (IOException e8) {
                                FLog.e("ReactNative", "Could not close output channel", e8);
                                return;
                            }
                        }
                    }
                }
                readableByteChannel = Channels.newChannel(new URL(this.mUri.toString()).openStream());
                try {
                    externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                    externalStoragePublicDirectory.mkdirs();
                    if (externalStoragePublicDirectory.isDirectory()) {
                    }
                } catch (IOException e9) {
                    e = e9;
                    fileChannel = null;
                    this.mPromise.reject(e);
                    readableByteChannel.close();
                } catch (Throwable th4) {
                    th2 = th4;
                    fileChannel = null;
                    th = th2;
                    readableByteChannel2 = readableByteChannel;
                    readableByteChannel2.close();
                    fileChannel.close();
                    throw th;
                }
            } catch (IOException e10) {
                readableByteChannel = null;
                e = e10;
                fileChannel = null;
                this.mPromise.reject(e);
                readableByteChannel.close();
            } catch (Throwable th5) {
                th = th5;
                fileChannel = null;
                readableByteChannel2.close();
                fileChannel.close();
                throw th;
            }
        }
    }

    public CameraRollManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static void putBasicNodeInfo(Cursor cursor, WritableMap writableMap, int i, int i2, int i3) {
        writableMap.putString("type", cursor.getString(i));
        writableMap.putString("group_name", cursor.getString(i2));
        writableMap.putDouble("timestamp", ((double) cursor.getLong(i3)) / 1000.0d);
    }

    public static void putEdges(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i) {
        int i2;
        WritableNativeArray writableNativeArray;
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("mime_type");
        int columnIndex3 = cursor.getColumnIndex("bucket_display_name");
        int columnIndex4 = cursor.getColumnIndex("datetaken");
        int columnIndex5 = cursor.getColumnIndex(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH);
        int columnIndex6 = cursor.getColumnIndex(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT);
        int columnIndex7 = cursor.getColumnIndex("longitude");
        int columnIndex8 = cursor.getColumnIndex("latitude");
        int columnIndex9 = cursor.getColumnIndex("_data");
        int i3 = i;
        int i4 = 0;
        while (i4 < i3 && !cursor.isAfterLast()) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            if (putImageInfo(contentResolver, cursor, writableNativeMap2, columnIndex, columnIndex5, columnIndex6, columnIndex9, columnIndex2)) {
                putBasicNodeInfo(cursor, writableNativeMap2, columnIndex2, columnIndex3, columnIndex4);
                putLocationInfo(cursor, writableNativeMap2, columnIndex7, columnIndex8);
                writableNativeMap.putMap("node", writableNativeMap2);
                writableNativeArray = writableNativeArray2;
                writableNativeArray.pushMap(writableNativeMap);
                i2 = i4;
            } else {
                writableNativeArray = writableNativeArray2;
                i2 = i4 - 1;
            }
            cursor.moveToNext();
            i4 = i2 + 1;
            i3 = i;
            writableNativeArray2 = writableNativeArray;
            columnIndex8 = columnIndex8;
            columnIndex7 = columnIndex7;
            columnIndex = columnIndex;
            columnIndex5 = columnIndex5;
        }
        writableMap.putArray("edges", writableNativeArray2);
    }

    public static boolean putImageInfo(ContentResolver contentResolver, Cursor cursor, WritableMap writableMap, int i, int i2, int i3, int i4, int i5) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("file://");
        outline15.append(cursor.getString(i4));
        Uri parse = Uri.parse(outline15.toString());
        writableNativeMap.putString(NetworkingModule.REQUEST_BODY_KEY_URI, parse.toString());
        float f = (float) cursor.getInt(i2);
        float f2 = (float) cursor.getInt(i3);
        String string = cursor.getString(i5);
        if (string != null && string.startsWith("video")) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(parse, "r");
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(openAssetFileDescriptor.getFileDescriptor());
                if (f <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f2 <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    try {
                        f = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        f2 = (float) Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    } catch (NumberFormatException e) {
                        FLog.e("ReactNative", "Number format exception occurred while trying to fetch video metadata for " + parse.toString(), e);
                        mediaMetadataRetriever.release();
                        openAssetFileDescriptor.close();
                        return false;
                    } catch (Throwable th) {
                        mediaMetadataRetriever.release();
                        openAssetFileDescriptor.close();
                        throw th;
                    }
                }
                writableNativeMap.putInt("playableDuration", Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000);
                mediaMetadataRetriever.release();
                openAssetFileDescriptor.close();
            } catch (Exception e2) {
                StringBuilder outline152 = GeneratedOutlineSupport.outline15("Could not get video metadata for ");
                outline152.append(parse.toString());
                FLog.e("ReactNative", outline152.toString(), e2);
                return false;
            }
        }
        if (f <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER || f2 <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            try {
                AssetFileDescriptor openAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(parse, "r");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFileDescriptor(openAssetFileDescriptor2.getFileDescriptor(), null, options);
                f = (float) options.outWidth;
                f2 = (float) options.outHeight;
                openAssetFileDescriptor2.close();
            } catch (IOException e3) {
                StringBuilder outline153 = GeneratedOutlineSupport.outline15("Could not get width/height for ");
                outline153.append(parse.toString());
                FLog.e("ReactNative", outline153.toString(), e3);
                return false;
            }
        }
        writableNativeMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, (double) f);
        writableNativeMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, (double) f2);
        writableMap.putMap("image", writableNativeMap);
        return true;
    }

    public static void putLocationInfo(Cursor cursor, WritableMap writableMap, int i, int i2) {
        double d = cursor.getDouble(i);
        double d2 = cursor.getDouble(i2);
        if (d > 0.0d || d2 > 0.0d) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("longitude", d);
            writableNativeMap.putDouble("latitude", d2);
            writableMap.putMap("location", writableNativeMap);
        }
    }

    public static void putPageInfo(Cursor cursor, WritableMap writableMap, int i) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("has_next_page", i < cursor.getCount());
        if (i < cursor.getCount()) {
            cursor.moveToPosition(i - 1);
            writableNativeMap.putString("end_cursor", cursor.getString(cursor.getColumnIndex("datetaken")));
        }
        writableMap.putMap("page_info", writableNativeMap);
    }

    @Override // com.facebook.fbreact.specs.NativeCameraRollManagerSpec
    public void deletePhotos(ReadableArray readableArray, Promise promise) {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeCameraRollManagerSpec
    public void getPhotos(ReadableMap readableMap, Promise promise) {
        int i = readableMap.getInt("first");
        String string = readableMap.hasKey("after") ? readableMap.getString("after") : null;
        String string2 = readableMap.hasKey("groupName") ? readableMap.getString("groupName") : null;
        String string3 = readableMap.hasKey("assetType") ? readableMap.getString("assetType") : ASSET_TYPE_PHOTOS;
        Integer valueOf = readableMap.hasKey("maxSize") ? Integer.valueOf(readableMap.getInt("maxSize")) : null;
        ReadableArray array = readableMap.hasKey("mimeTypes") ? readableMap.getArray("mimeTypes") : null;
        if (!readableMap.hasKey("groupTypes")) {
            new GetMediaTask(getReactApplicationContext(), i, string, string2, array, string3, valueOf, promise, null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new JSApplicationIllegalArgumentException("groupTypes is not supported on Android");
    }

    @Override // com.facebook.fbreact.specs.NativeCameraRollManagerSpec
    public void saveToCameraRoll(String str, String str2, Promise promise) {
        new SaveToCameraRoll(getReactApplicationContext(), Uri.parse(str), promise).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
