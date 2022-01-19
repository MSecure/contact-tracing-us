package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
    public static Set<String> sEnabledNotificationListenerPackages = new HashSet();
    public static String sEnabledNotificationListeners;
    public static final Object sEnabledNotificationListenersLock = new Object();
    public static final Object sLock = new Object();
    public static SideChannelManager sSideChannelManager;
    public final Context mContext;
    public final NotificationManager mNotificationManager;

    public static class NotifyTask implements Task {
        public final int id;
        public final Notification notif;
        public final String packageName;
        public final String tag;

        public NotifyTask(String str, int i, String str2, Notification notification) {
            this.packageName = str;
            this.id = i;
            this.tag = str2;
            this.notif = notification;
        }

        @Override // androidx.core.app.NotificationManagerCompat.Task
        public void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.packageName, this.id, this.tag, this.notif);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:");
            sb.append(this.packageName);
            sb.append(", id:");
            sb.append(this.id);
            sb.append(", tag:");
            return GeneratedOutlineSupport.outline12(sb, this.tag, "]");
        }
    }

    public static class ServiceConnectedEvent {
        public final ComponentName componentName;
        public final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName componentName2, IBinder iBinder2) {
            this.componentName = componentName2;
            this.iBinder = iBinder2;
        }
    }

    public static class SideChannelManager implements Handler.Callback, ServiceConnection {
        public Set<String> mCachedEnabledPackages = new HashSet();
        public final Context mContext;
        public final Handler mHandler;
        public final HandlerThread mHandlerThread;
        public final Map<ComponentName, ListenerRecord> mRecordMap = new HashMap();

        public static class ListenerRecord {
            public boolean bound = false;
            public final ComponentName componentName;
            public int retryCount = 0;
            public INotificationSideChannel service;
            public ArrayDeque<Task> taskQueue = new ArrayDeque<>();

            public ListenerRecord(ComponentName componentName2) {
                this.componentName = componentName2;
            }
        }

        public SideChannelManager(Context context) {
            this.mContext = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        }

        public boolean handleMessage(Message message) {
            Set<String> set;
            int i = message.what;
            if (i == 0) {
                Task task = (Task) message.obj;
                String string = Settings.Secure.getString(this.mContext.getContentResolver(), "enabled_notification_listeners");
                synchronized (NotificationManagerCompat.sEnabledNotificationListenersLock) {
                    if (string != null) {
                        if (!string.equals(NotificationManagerCompat.sEnabledNotificationListeners)) {
                            String[] split = string.split(ColorPropConverter.PACKAGE_DELIMITER, -1);
                            HashSet hashSet = new HashSet(split.length);
                            for (String str : split) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString != null) {
                                    hashSet.add(unflattenFromString.getPackageName());
                                }
                            }
                            NotificationManagerCompat.sEnabledNotificationListenerPackages = hashSet;
                            NotificationManagerCompat.sEnabledNotificationListeners = string;
                        }
                    }
                    set = NotificationManagerCompat.sEnabledNotificationListenerPackages;
                }
                if (!set.equals(this.mCachedEnabledPackages)) {
                    this.mCachedEnabledPackages = set;
                    List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet hashSet2 = new HashSet();
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (set.contains(resolveInfo.serviceInfo.packageName)) {
                            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                            ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                            if (resolveInfo.serviceInfo.permission != null) {
                                Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                            } else {
                                hashSet2.add(componentName);
                            }
                        }
                    }
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        ComponentName componentName2 = (ComponentName) it.next();
                        if (!this.mRecordMap.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                String str2 = "Adding listener record for " + componentName2;
                            }
                            this.mRecordMap.put(componentName2, new ListenerRecord(componentName2));
                        }
                    }
                    Iterator<Map.Entry<ComponentName, ListenerRecord>> it2 = this.mRecordMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry<ComponentName, ListenerRecord> next = it2.next();
                        if (!hashSet2.contains(next.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Removing listener record for ");
                                outline15.append(next.getKey());
                                outline15.toString();
                            }
                            ListenerRecord value = next.getValue();
                            if (value.bound) {
                                this.mContext.unbindService(this);
                                value.bound = false;
                            }
                            value.service = null;
                            it2.remove();
                        }
                    }
                }
                for (ListenerRecord listenerRecord : this.mRecordMap.values()) {
                    listenerRecord.taskQueue.add(task);
                    processListenerQueue(listenerRecord);
                }
                return true;
            } else if (i == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                ComponentName componentName3 = serviceConnectedEvent.componentName;
                IBinder iBinder = serviceConnectedEvent.iBinder;
                ListenerRecord listenerRecord2 = this.mRecordMap.get(componentName3);
                if (listenerRecord2 != null) {
                    listenerRecord2.service = INotificationSideChannel.Stub.asInterface(iBinder);
                    listenerRecord2.retryCount = 0;
                    processListenerQueue(listenerRecord2);
                }
                return true;
            } else if (i == 2) {
                ListenerRecord listenerRecord3 = this.mRecordMap.get((ComponentName) message.obj);
                if (listenerRecord3 != null) {
                    if (listenerRecord3.bound) {
                        this.mContext.unbindService(this);
                        listenerRecord3.bound = false;
                    }
                    listenerRecord3.service = null;
                }
                return true;
            } else if (i != 3) {
                return false;
            } else {
                ListenerRecord listenerRecord4 = this.mRecordMap.get((ComponentName) message.obj);
                if (listenerRecord4 != null) {
                    processListenerQueue(listenerRecord4);
                }
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Connected to service " + componentName;
            }
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Disconnected from service " + componentName;
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        public final void processListenerQueue(ListenerRecord listenerRecord) {
            boolean z;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Processing component ");
                outline15.append(listenerRecord.componentName);
                outline15.append(", ");
                outline15.append(listenerRecord.taskQueue.size());
                outline15.append(" queued tasks");
                outline15.toString();
            }
            if (!listenerRecord.taskQueue.isEmpty()) {
                if (listenerRecord.bound) {
                    z = true;
                } else {
                    boolean bindService = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(listenerRecord.componentName), this, 33);
                    listenerRecord.bound = bindService;
                    if (bindService) {
                        listenerRecord.retryCount = 0;
                    } else {
                        StringBuilder outline152 = GeneratedOutlineSupport.outline15("Unable to bind to listener ");
                        outline152.append(listenerRecord.componentName);
                        Log.w("NotifManCompat", outline152.toString());
                        this.mContext.unbindService(this);
                    }
                    z = listenerRecord.bound;
                }
                if (!z || listenerRecord.service == null) {
                    scheduleListenerRetry(listenerRecord);
                    return;
                }
                while (true) {
                    Task peek = listenerRecord.taskQueue.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            String str = "Sending task " + peek;
                        }
                        peek.send(listenerRecord.service);
                        listenerRecord.taskQueue.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            StringBuilder outline153 = GeneratedOutlineSupport.outline15("Remote service has died: ");
                            outline153.append(listenerRecord.componentName);
                            outline153.toString();
                        }
                    } catch (RemoteException e) {
                        StringBuilder outline154 = GeneratedOutlineSupport.outline15("RemoteException communicating with ");
                        outline154.append(listenerRecord.componentName);
                        Log.w("NotifManCompat", outline154.toString(), e);
                    }
                }
                if (!listenerRecord.taskQueue.isEmpty()) {
                    scheduleListenerRetry(listenerRecord);
                }
            }
        }

        public final void scheduleListenerRetry(ListenerRecord listenerRecord) {
            if (!this.mHandler.hasMessages(3, listenerRecord.componentName)) {
                int i = listenerRecord.retryCount + 1;
                listenerRecord.retryCount = i;
                if (i > 6) {
                    StringBuilder outline15 = GeneratedOutlineSupport.outline15("Giving up on delivering ");
                    outline15.append(listenerRecord.taskQueue.size());
                    outline15.append(" tasks to ");
                    outline15.append(listenerRecord.componentName);
                    outline15.append(" after ");
                    outline15.append(listenerRecord.retryCount);
                    outline15.append(" retries");
                    Log.w("NotifManCompat", outline15.toString());
                    listenerRecord.taskQueue.clear();
                    return;
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, listenerRecord.componentName), (long) ((1 << (i - 1)) * 1000));
            }
        }
    }

    public interface Task {
        void send(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public NotificationManagerCompat(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }
}
