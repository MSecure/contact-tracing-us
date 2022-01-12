Covid CA Notify App(Mihir Madhira)

App Permissions:
- Internet
- Bluetooth
- Access Network State
- Wake Lock
- Recieve Boot Completed
- Foreground Service

Privacy Policy:
CA Notify has the potential to help stop the spread of the infection and its use is 
highly encouraged, but it is completely voluntary.

Users may turn the system on or off at any time, or uninstall the app on an Android device. 
The system does not collect, track or store users’ location, GPS information, or personal 
information.

This is the Privacy Policy for CA Notify app for Covid Tracing: https://canotify.ca.gov/privacy/

- only data used are the anonymous keys, Bluetooth signal strength, and date and duration of
exposure
- CA Notify does not collect or exchange any personal information
- Never shares user's keys with the system unless the user elects upon doing so, also a user's
keys changes randomly to protect the user's identity. *key = generated numbers shared via 
Bluetooth
- each day collects all the keys sent over voluntarily and checks with other keys the past
14 days for possible exposures and sends a notification accordingly
- accesses the IP address and collects them for analytical purposes and later anonymizes it 
for security purposes
- If the user uninstalls or deactivates CA Notify all keys currently stored on the device 
will be immediately deleted.
- When anonymous keys are released, the notifications that may be generated do not disclose 
the COVID-19 positive user’s identity, location, phone number, or any other personal 
information.
- information will not include any personal or location information, nor can it be 
used to identify any system user.

Privacy Policy Violations:

- The Privacy Policy says that the app doesn't store private information however after running
the analysis, it says the app inserts Sensitive Information into a Log File. (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x05d-Testing-Data-Storage.md#logs)

- To protect the keys it keeps changing the key values; however, they use insufficient 
Random Values making the keys not so protected. (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04g-Testing-Cryptography.md#weak-random-number-generators)
-  retains keys and other sensitive information into its files evnetough it supposed to

Manifest.xml Fixes:
- Activity: Share DiagnosisActivity is shared amongst other apps on the device because it explicitly states android:exported to true
- Broadcast Receiver: 
     -[False Positive, ExposureNotificationBroadcastReceiver needs to check the security of its permission in order to make sure that an application that specified the required       permission can send intents to the broadcast receiver], this permission is maintained by the Google ExposureNotification's API
     - ExposureNotificationDismissedReceiver is not explicityly state a value for android:exported therefore leading it to be shared with other apps
- Service: [False Positive, EXPOSURE_CALLBACK permission for the service WakeUpService needs to have its protection level] this permission is once again checked by and maintained by the Google ExposureNotifications API

Code Fixes:
- Using a temp file to store data (e/t/k.java):- in this file the code base shows that it uses the line, File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.b.getCacheDir()), to create a temp file and store data to it. To fix this error, they should just use the method createNewFile that actually creates a new file rather than a temp file. 
- [False Positive] the file doesn't hardcode any keys, the line in which the error came is this one: StringBuilder j2 = f.a.a.a.a.j("Metadata key=", str4, ", value=");. str4 is a string object that decodes the bytes set from bArr2 using the charset from f.b.b.a.d.a in the line: String str4 = new String(bArr2, f.b.b.a.d.a);. Clearly the inputed value is not any constant from these two lines. ̶H̶a̶r̶d̶c̶o̶d̶e̶s̶ ̶s̶e̶n̶s̶i̶t̶i̶v̶e̶ ̶i̶n̶f̶o̶r̶m̶a̶t̶i̶n̶o̶:̶ ̶U̶s̶e̶s̶ ̶t̶h̶i̶s̶ ̶l̶i̶n̶e̶ ̶t̶o̶ ̶h̶a̶r̶d̶c̶o̶d̶e̶ ̶s̶e̶n̶s̶i̶t̶i̶v̶e̶ ̶i̶n̶f̶o̶r̶m̶a̶t̶i̶o̶n̶,̶ ̶S̶t̶r̶i̶n̶g̶B̶u̶i̶l̶d̶e̶r̶ ̶j̶2̶ ̶=̶ ̶f̶.̶a̶.̶a̶.̶a̶.̶a̶.̶j̶(̶"̶M̶e̶t̶a̶d̶a̶t̶a̶ ̶k̶e̶y̶=̶"̶,̶ ̶s̶t̶r̶4̶,̶ ̶"̶,̶ ̶v̶a̶l̶u̶e̶=̶"̶)̶.̶ ̶T̶h̶e̶ ̶p̶r̶o̶b̶l̶e̶m̶ ̶i̶s̶ ̶t̶h̶a̶t̶ ̶s̶e̶n̶s̶i̶t̶i̶v̶e̶ ̶i̶n̶f̶o̶r̶m̶a̶t̶i̶o̶n̶ ̶h̶a̶r̶d̶c̶o̶d̶e̶d̶ ̶l̶i̶k̶e̶ ̶t̶h̶i̶s̶ ̶s̶h̶o̶u̶l̶d̶ ̶a̶l̶s̶o̶ ̶b̶e̶ ̶d̶e̶l̶e̶t̶e̶d̶ ̶o̶u̶t̶ ̶o̶f̶ ̶t̶h̶e̶ ̶s̶y̶s̶t̶e̶m̶,̶ ̶b̶u̶t̶ ̶i̶t̶ ̶d̶o̶e̶s̶n̶'̶t̶ ̶d̶o̶ ̶t̶h̶a̶t̶.̶




 

