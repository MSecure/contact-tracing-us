# WA Notify Analysis

## APK Info
This information also exists in the MobSF pdf of the app as well as the apk_hash.txt file. 
```
  APK Signature:
  MD5: f99f9ea23666c8688c3f7194e046b674
  SHA1: e6e41e81e21499573e11f80910a0a56a5a90499d
  SHA256: 579d75c6276c8cd818288a136944ba72bcc6b3e4b5168702f5da9cf9b7c1c028
```

## App's Permissions:
- Network Status: ``<android.permission.ACCESS_NETWORK_STATE/>``
- Bluetooth: ``<android.permission.BLUETOOTH/>``
- Foreground Service: ``<android.permission.FOREGROUND_SERVICE/>``
- Internet Access: ``<android.permission.INTERNET/>``
- Recieve Boot Completed: ``<android.permission.RECEIVE_BOOT_COMPLETED/>``
- Wake Lock: ``<android.permission.WAKE_LOCK/>``

## WA Privacy Policy:
This is the Privacy Policy for WA Notify app for Covid Tracing: https://doh.wa.gov/emergencies/covid-19/wa-notify/privacy-policy
- containing data elements that can't be used to detect an individual
	- Random Codes: these hashed codes are stored 14 days and then 
	  shared via bluetooth to check for possible exposure.
	- Verification Link: pops up after given verification code once 
	  an individual is tested positive and the link is only voluntarily
	  give out.
	- Usage Logs: these logs are generated within the phone and work like
	  any other apps usage logs. They are also stored for about
	  14 days as well.
	- Analytics Data: you can choose if the app can collect extra data 
	  about you and collects info of how smartphone is used
- protects info using Google's exposure Notification Framework which stores and
generates codes
- Phones allows you to delete exposure logs and turn off exposure notifications

## Privacy Violation:
- It says that it doesn't log private info, however according to the report
it logs sensitive info 
- Private information like username, password, and keys are hardcoded ~ [False Positive] the file doesn't hardcode any keys, the line in which the error came is this one: StringBuilder j2 = f.a.a.a.a.j("Metadata key=", str4, ", value=");. str4 is a string object that decodes the bytes set from bArr2 using the charset from f.b.b.a.d.a in the line: String str4 = new String(bArr2, f.b.b.a.d.a);. Clearly the inputed value is not any constant from these two lines.  

## Manifest Analysis:
- Manifest Analysis Exposure Dismissed Receiver is exported and therefore not secure as a Broadcast Receiver, allows for other apps to change settings of apps -> needs to be looked into more
- The shareDiagnosisActivity is also exported out and not necessarily protected, which allows for other apps and users to access this activity. 

## Deeper Analysis:
- This App uses and insecure Number Generator which isn't much of a vulnerability considering that it uses google's random number generator
- Also, as seen in other apps, there is a server of this app that currently exists within Colombia in the city of the District Capital de Bogota. This a little interesting considering that all the Exposure Notification servers for this app should exist in the US.

## Ghera Vulnerabilities:
- App uses SQLite RawQuery so it's vulnerable to code injection ~ [False Positive] in each file where an SQL query is done, the SQL query never inputs a static string to which it uses for a SQL query to allow an SQL injection.
- app creates temp file by using the method createNewTempFile() should not store info
into this file should say createNewFile() method instead ~ [False Positive] deletes file after creation.
