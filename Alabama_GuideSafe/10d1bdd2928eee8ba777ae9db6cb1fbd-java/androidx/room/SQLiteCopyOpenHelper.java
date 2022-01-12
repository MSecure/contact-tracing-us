package androidx.room;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper {
    public final Context mContext;
    public final String mCopyFromAssetPath;
    public final File mCopyFromFile;
    public DatabaseConfiguration mDatabaseConfiguration;
    public final int mDatabaseVersion;
    public final SupportSQLiteOpenHelper mDelegate;
    public boolean mVerified;

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.mDelegate.close();
        this.mVerified = false;
    }

    /* JADX INFO: finally extract failed */
    public final void copyDatabaseFile(File file) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.mCopyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else if (this.mCopyFromFile != null) {
            readableByteChannel = new FileInputStream(this.mCopyFromFile).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream newInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream newOutputStream = Channels.newOutputStream(channel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    newOutputStream.write(bArr, 0, read);
                }
            } else {
                channel.transferFrom(readableByteChannel, 0, RecyclerView.FOREVER_NS);
            }
            channel.force(false);
            readableByteChannel.close();
            channel.close();
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Failed to create directories for ");
                outline17.append(file.getAbsolutePath());
                throw new IOException(outline17.toString());
            } else if (!createTempFile.renameTo(file)) {
                StringBuilder outline172 = GeneratedOutlineSupport.outline17("Failed to move intermediate file (");
                outline172.append(createTempFile.getAbsolutePath());
                outline172.append(") to destination (");
                outline172.append(file.getAbsolutePath());
                outline172.append(").");
                throw new IOException(outline172.toString());
            }
        } catch (Throwable th) {
            readableByteChannel.close();
            channel.close();
            throw th;
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile();
            this.mVerified = true;
        }
        return this.mDelegate.getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegate.setWriteAheadLoggingEnabled(z);
    }

    public final void verifyDatabaseFile() {
        String databaseName = this.mDelegate.getDatabaseName();
        File databasePath = this.mContext.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        CopyLock copyLock = new CopyLock(databaseName, this.mContext.getFilesDir(), databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation);
        try {
            copyLock.mThreadLock.lock();
            if (copyLock.mFileLevelLock) {
                try {
                    FileChannel channel = new FileOutputStream(copyLock.mCopyLockFile).getChannel();
                    copyLock.mLockChannel = channel;
                    channel.lock();
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to grab copy lock.", e);
                }
            }
            if (!databasePath.exists()) {
                try {
                    copyDatabaseFile(databasePath);
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                }
            } else if (this.mDatabaseConfiguration == null) {
                copyLock.unlock();
            } else {
                try {
                    int readVersion = DBUtil.readVersion(databasePath);
                    if (readVersion == this.mDatabaseVersion) {
                        copyLock.unlock();
                    } else if (this.mDatabaseConfiguration.isMigrationRequired(readVersion, this.mDatabaseVersion)) {
                        copyLock.unlock();
                    } else {
                        if (this.mContext.deleteDatabase(databaseName)) {
                            try {
                                copyDatabaseFile(databasePath);
                            } catch (IOException e3) {
                                Log.w("ROOM", "Unable to copy database file.", e3);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        copyLock.unlock();
                    }
                } catch (IOException e4) {
                    Log.w("ROOM", "Unable to read database version.", e4);
                    copyLock.unlock();
                }
            }
        } finally {
            copyLock.unlock();
        }
    }
}
