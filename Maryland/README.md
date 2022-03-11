# MD Covid Alert

## APK Info
This information also exists in the MobSF pdf of the app as well as the apk_hash.txt file. 
```
  APK Signature:
  MD5: 62b187cb0c274c5b7df0bc7b1bbb6999
  SHA1: 6430ff9cd6342273d6d5df8fe81c993c24a3d215
  SHA256: 88c7ed9eb63dbac119125d843ffe8287e16744910dfef592f311e0a66abc8ae2
```

## App's Permissions:
- Network Status: ``<android.permission.ACCESS_NETWORK_STATE/>``
- Bluetooth: ``<android.permission.BLUETOOTH/>``
- Foreground Service: ``<android.permission.FOREGROUND_SERVICE/>``
- Internet Access: ``<android.permission.INTERNET/>``
- Recieve Boot Completed: ``<android.permission.RECEIVE_BOOT_COMPLETED/>``
- Wake Lock: ``<android.permission.WAKE_LOCK/>``

## Privacy Policy:
This is the privacy policy of MD Covid Alert: https://health.maryland.gov/phpa/Documents/COVID%20Link%20Privacy%20Policy%20(for%20Short%20Code)%20-%20FINAL.pdf
- They collect data monitor the spread of corona virus around a certain area as well as the symptoms associated with it at the moment
- They collect data but only in certain circumstances:
  - a lot of data can be chosen to be collected by the user; however there are some data we collect via automated means
  - They collect information that correspond to once location regarding where they live so they can provide services; however they do not gather the information from constant location tracking
  - Wherever legally permissable, they will track data regarding the use of third party applications
- They store information based on what you gave them such as address, phone number, information about symptoms, etc. 
- They also store information regarding tech phone calls or conversations you had with them in the past 
- They use the Security Socket Layers given from when you sign in to encrypt transmission of data and information
- They share the minimum data and data that is not identifiable to you such as your phone number to access certain services. 
- Privacy Policy contracdiction when retrieving Location..

## Manifest Analysis:
- Activity-Alias: `om.google.android.apps.exposurenotification.ENNotifyOthers` is not protected:
  - [TODO]
- Broadcast Receiver: ``com.google.android.apps.exposurenotification.nearby.ExposureNotificationBroadcastReceiver`` is protected by a permission but the protection level should be checked
- Broadcast Receiver: ``com.google.android.apps.exposurenotification.common.ExposureNotificationDismissedReceiver`` is not protected, an intent filter exists 
  - This broadcast receiver allows the app to dismiss notifications for the appliation by changing the shared preferences as shown in lines 16-19 where the app accordingly changes the shared preference based on if the Intent is a "Notification_Dissmissed_Action_ID".
  - The lack of a permission to protect the DismissedReceiver allows a malicious app to send Intents that access and change the sharedPreferences of the app
- Service: ``com.google.android.gms.nearby.exposurenotification.WakeUpService`` is protected by a permission but the permission level should also be checked
  - permission: ``com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK``
  - The permission backed by the Google Exposure Notification API 
- Service: ``androidx.work.impl.background.systemjob.SystemJobService`` is protected by a permission but the protection level of the permission should be checked
  - permission: ``android.permission.BIND_JOB_SERVICE``
  - This permission is protected by signature level protection where in which the system can only accepted by the system if the requesting app and the current application have the same signature. 
- Broadcast Receiver: ``androidx.work.impl.diagnostics.DiagnosticsReceiver`` is protected by a permission but the protection level of the permissio should be checked
  - permission: `android.permission.DUMP`

## Server Locations:
- Most servers exist within the US except for 1 of them in Noord-Holland, Neatherlands. 

## Privacy Violation:
- The app uses Java's library, `java.util.Random`, this library uses a protected algorithm to generate 32 pseudorandom bits: https://developer.android.com/reference/java/util/Random.-> should use SecureRandom Generator (this is a small error apart of Code Vulnerability).

## Network Vulnerability
- uses HTTP instead of HTTPS when applying code from open source websites such as from `mikepenz.com`, `http://schemas.android.com/apk/res/android`, `http://github.com/google/auto` which can be very susceptible to man-in-the-middle attacks or SQL Injections. 20 websites in total are written in http


