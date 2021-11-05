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
Random Values making the keys not so protected.(https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04g-Testing-Cryptography.md#weak-random-number-generators)
- retains keys and other sensitive information into its files evnetough it supposed to 


Ghera Violations:
- This app is vulnerable to SQL Injection due to the use of rawQuery() method in the f 
directory of where the code lies (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04h-Testing-Code-Quality.md#injection-flaws-mstg-arch-2-and-mstg-platform-2)

Manifest.xml Fixes:
- The Broadcast receiver needs to specify permission in order to make sure that an application that specified the required permission can send intents to the broadcast receiver.

Code Fixes:
- Using a temp file to store data (e/t/k.java):- in this file the code base shows that it uses the line, File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.b.getCacheDir()), to create a temp file and store data to it. To fix this error, they should just use the method createNewFile that actually creates a new file rather than a temp file. 
- Hardcodes sensitive informatino: Uses this line to hardcode sensitive information, StringBuilder j2 = f.a.a.a.a.j("Metadata key=", str4, ", value="). The problem is that sensitive information hardcoded like this should also be deleted out of the system, but it doesn't do that.
- Uses RawSQLQuery:- in the method, Cursor rawQuery = this.a.rawQuery("SELECT target_id, target_proto FROM targets", null), for file f/b/c/k/t/a1.java, there is the method rawQuery which cause the likelyhood SQL query injection. Use a method like SQLiteStatement which better defends against SQL code injections and stil allows to query, insert, update, and delete. 




 

