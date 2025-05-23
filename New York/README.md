### Summary:

This app uses the Exposure API developed by Apple and Google jointly. If you are within 6 feet of another person with the app for 10 minutes, your phone exchanges a secure Bluetooth token (code) with that person's. Then, if that person gets COVID, you get a notification that you were exposed- because you have their token. There is NO way for this app to see your location. There is NO tracking of your location through the app. It does NOT compromise bluetooth. This app can save lives.

### App Permissions:

From Android Manifest.xml:

 <uses-feature
        android:name="android.hardware.bluetooth_le"
        android:required="true" />

    <uses-feature
        android:name="android.hardware.bluetooth" />

    <uses-permission
        android:name="android.permission.BLUETOOTH" />

    <uses-permission
        android:name="android.permission.INTERNET" />

    <uses-permission
        android:name="android.permission.ACCESS_NETWORK_STATE" />

    <uses-permission
        android:name="android.permission.ACCESS_WIFI_STATE" />

    <uses-permission
        android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

    <uses-permission
        android:name="android.permission.FOREGROUND_SERVICE" />

    <uses-permission
        android:name="android.permission.VIBRATE" />
+ Bluetooth
+ Internet
+ Access Network State
+ Access Wifi State
+ Receive Boot Completed
+ Foreground Service
Foreground services show a status bar notification, so that users are actively aware that your app is performing a task in the foreground and is consuming system resources. The notification cannot be dismissed unless the service is either stopped or removed from the foreground.
+ Vibrate
- No Location

### Privacy Policy:

COVID Alert NY protects your privacy and personal information. Downloading the app is voluntary, but the more New Yorkers that use this app, the more successful our efforts will be to stop the spread of COVID-19.

As you go about your day, the app uses Bluetooth to sense when you spend more than 10 minutes within 6 feet of another person with the app.

We don't collect info that can identify you. The app never tracks your location.

When your app senses the close contact, your phone exchanges a secure rnadom code with the other person's phone. Your phone stores this cose contact code in a list.
The app doesn't collect or share any names, locations, or phone numbers.

If you test positive for COVID-19, a public health representative will call you as soon as possible.
The representative will ask you if you're willing to share your app's list of close contact codes to help protect other people. Sharing your list is secure and private. The app never reveals who you are to anyone.

Each day, every phone that has the app compares its own list of close contact codes to the list of "infected" codes. If there's a match, the app will display a COVID alert.

https://coronavirus.health.ny.gov/covidalert-privacy/


### MANIFEST ANALYSIS
 - Broadcast Receiver
   - com.dieam.reactnativepushnotification.modules.RNPushNotificationBootEventReceiver.
     False Positive? An intent-filter exists. RNDeviceReceiver() no longer existed. With intents sent by adb, it seems like it's secured now.

   - False Positive. The permission is maintained by the Google API used.
   - Permission: com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
   [android:exported=true]
   - To obtain an certificate for this permission, an allowlisted Google account. We assume that this account would only be granted to approved users by Google and these users are not malicious. 
   - User Guide: https://developers.google.com/android/exposure-notifications/implementation-guide
   - Glossary: https://developers.google.com/android/exposure-notifications/exposure-notifications-api#glossary

 - Service 
    -  com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
    [android:exported=true]
    - com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE [android:exported=true] This is maintained by Google.
    - android.permission.BIND_JOB_SERVICE[android:exported=true] 
    - android.permission.DUMP[android:exported=true]
    - False positive bacause these two permission are only used by Android System; and we assume that the system is not malicious.


### CODE ANALYSIS
- The App used to have a Broadcast Receiver `RNDeviceReceiver`, which is a vulnerbility we found that allows malicious app to send an explicit intent to this app and compromise the data being stored in the Sharedpreferences
file. This Broadcast Receiver has been replaced in the newer version.
- The App uses an insecure Random Number Generator, java.util.Random. This should be replaced by java.secure.SecureRandom instead.
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
- IP Address disclosure?
- [*False Positive*] ~~	App uses SQLite Database and execute raw SQL query. Untrusted user input in raw SQL queries can cause SQL Injection. Also sensitive information should be encrypted and written to the database.~~
- App can read/write to External Storage. Any App can read data written to External Storage. ` Environment.getExternalStorageDirectory()`
- SHA-1 is a weak hash known to have hash collisions.

