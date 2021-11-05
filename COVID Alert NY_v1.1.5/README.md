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

    <uses-permission
        android:name="com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE" />
+ Bluetooth
+ Internet
+ Access Network State
+ Access Wifi State
+ Receive Boot Completed
+ Foreground Service
Foreground services show a status bar notification, so that users are actively aware that your app is performing a task in the foreground and is consuming system resources. The notification cannot be dismissed unless the service is either stopped or removed from the foreground.
+ Vibrate
+ BIND_GET_INSTALL_REFERRER_SERVICE
Used by Firebase (a platform developed by Google for creating mobile and web applications) to recognize where the app was installed from.
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
