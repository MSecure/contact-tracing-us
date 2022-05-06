<!-- # Instuction from slack
When you analyze an app, don't have to write the report straightaway. Note the following:
1. What permissions are being used
2. What features of the device the app is using (e.g., storage, Bluetooth, location, etc.)
3. What is the app's privacy policy.
4. Is the app violating its own privacy policy. How?

For each app, keep a note of these points. At the end of the semester you should compile them in a report.  -->

# Covid Alert MN Analysis (Minqi) 
### APK Basic Info
App: COVIDaware MN_1.17.12. The report from MobSF, ```MN_MobSF_report.pdf```, is also inside this folder. 

```
APK Signature:
MD5: bf107ce32b4fe1126d4d80f7ce344c59
SHA1: a5c1f550a1815417b4f10c2595835ee72929f8b0
SHA256: bdb8362bacf934251ae65ee83624ed9abcd23b45de5c2eafc98810fb7912d25d
```

### App Permissions Declared
  - view network status (android.permission.ACCESS_NETWORK_STATE)
  - view Wi-Fi status (android.permission.ACCESS_WIFI_STATE)
  - create Bluetooth connections (android.permission.BLUETOOTH)
  - android.permission.FOREGROUND_SERVICE
  - full Internet access (android.permission.INTERNET)
  - automatically start at boot (android.permission.RECEIVE_BOOT_COMPLETED)
  - control vibrator (android.permission.VIBRATE)
  - prevent phone from sleeping (android.permission.WAKE_LOCK)

### MANIFEST ANALYSIS
 - MainActivity is not protected. [android:exported=true].
 - Broadcast Receiver
   - [*False Positive*]. The permission is maintained by the Google API used.
   - Permission: com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK
   [android:exported=true]
   - To obtain an certificate for this permission, an allowlisted Google account. We assume that this account would only be granted to approved users by Google and these users are not malicious. 
   - User Guide: https://developers.google.com/android/exposure-notifications/implementation-guide
   - Glossary: https://developers.google.com/android/exposure-notifications/exposure-notifications-api#glossary
 - Service 
    - Permission: android.permission.BIND_JOB_SERVICE[android:exported=true] 
    - Permission: android.permission.DUMP[android:exported=true]
    - False positive bacause these two permission are only used by Android System; and we assume that the system is not malicious.


 
### Privacy Policy
- The MI COVID Alert app is intended for use to help facilitate contact tracing in response to COVID-19. Contacts who receive push notifications of past potential exposure will be given the option to be put in contact with Public Health and may be subsequently enrolled in contact monitoring. Contact tracing consists of notifying and monitoring individuals who have been in close contact with someone who is infected with a virus and could potentially infect others.

https://www.michigan.gov/coronavirus/0,9753,7-406-99891_102592_102596---,00.html

### Privacy Violations
No privacy Violations found.



### CODE ANALYSIS
- The App uses ECB mode in Cryptographic encryption algorithm in `com/bottlerocketstudios/vault/keys/wrapper/ObfuscatingSecretKeyWrapper.java`. ECB mode is known to be weak as it results in the same ciphertext for identical blocks of plaintext.
- The App uses an insecure Random Number Generator, java.util.Random. Although this is used in a third-party code, it is still the responsibility of this APP itself to check make sure no insecure functions used anywhere. 
- In the file `com/reactnativecommunity/webview/RNCWebViewModule.java`, a method, [getExternalFilesDir()](https://developer.android.com/reference/android/content/Context#getExternalFilesDir(java.lang.String)), is called to get the external directory and use it to create temp files (which is not deleted after use). Although the files placed at such directory are internal to the applications, there is no security enforced with these files. For example, any application holding `Manifest.permission.WRITE_EXTERNAL_STORAGE` can write to these files, which imposes potential security vulnerability.
- [*False Positive*] ~~Files may contain hardcoded sensitive information like usernames, passwords, keys etc~~. After manually checked all the file containing this warning, the hardcoded information are only normal constants; no hardcoded password exists.
- [*False Positive*]~~App uses SQLite Database and execute raw SQL query.~~ No suspicious SQL injection vulnerabilities found.


### SERVER LOCATIONS
No suspicious servers or suspicious location of servers find here.

### URL
HTTP Connections made in `com/bugsnag/android/DefaultDelivery.java` and `org/matomo/sdk/dispatcher/DefaultDispatcher.java`. This might leak some info when requesting, but it won't cause any later leaking in a normal setting, because the server forces HTTPS on its end.

However, since the app allows the use of HTTP, it is vulnerable to Man-In-The-Middle attack. The attacker can talk to the app using HTTP but using HTTPS with the server. There might be potential info leaks made here.
