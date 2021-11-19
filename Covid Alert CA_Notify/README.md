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

- [False Positive] After looking at the files, majority of the files log constants that are strings (e/i/c/d.java) or information not sensitive such as error from a try/catch statement (e/i/a/d.java). T̶h̶e̶ ̶P̶r̶i̶v̶a̶c̶y̶ ̶P̶o̶l̶i̶c̶y̶ ̶s̶a̶y̶s̶ ̶t̶h̶a̶t̶ ̶t̶h̶e̶ ̶a̶p̶p̶ ̶d̶o̶e̶s̶n̶'̶t̶ ̶s̶t̶o̶r̶e̶ ̶p̶r̶i̶v̶a̶t̶e̶ ̶i̶n̶f̶o̶r̶m̶a̶t̶i̶o̶n̶ ̶h̶o̶w̶e̶v̶e̶r̶ ̶a̶f̶t̶e̶r̶ ̶r̶u̶n̶n̶i̶n̶g̶ ̶t̶h̶e̶ ̶a̶n̶a̶l̶y̶s̶i̶s̶,̶ ̶i̶t̶ ̶s̶a̶y̶s̶ ̶t̶h̶e̶ ̶a̶p̶p̶ ̶i̶n̶s̶e̶r̶t̶s̶ ̶S̶e̶n̶s̶i̶t̶i̶v̶e̶ ̶I̶n̶f̶o̶r̶m̶a̶t̶i̶o̶n̶ ̶i̶n̶t̶o̶ ̶a̶ ̶L̶o̶g̶ ̶F̶i̶l̶e̶.̶ ̶(̶h̶t̶t̶p̶s̶:̶/̶/̶g̶i̶t̶h̶u̶b̶.̶c̶o̶m̶/̶M̶o̶b̶S̶F̶/̶o̶w̶a̶s̶p̶-̶m̶s̶t̶g̶/̶b̶l̶o̶b̶/̶m̶a̶s̶t̶e̶r̶/̶D̶o̶c̶u̶m̶e̶n̶t̶/̶0̶x̶0̶5̶d̶-̶T̶e̶s̶t̶i̶n̶g̶-̶D̶a̶t̶a̶-̶S̶t̶o̶r̶a̶g̶e̶.̶m̶d̶#̶l̶o̶g̶s̶) 
- To protect the keys it keeps changing the key values; however, they use insufficient 
Random Values making the keys not so protected. (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04g-Testing-Cryptography.md#weak-random-number-generators)
- [False Positive] the file doesn't hardcode any keys, the line in which the error came is this one: StringBuilder j2 = f.a.a.a.a.j("Metadata key=", str4, ", value=");. str4 is a string object that decodes the bytes set from bArr2 using the charset from f.b.b.a.d.a in the line: String str4 = new String(bArr2, f.b.b.a.d.a);. Clearly the inputed value is not any constant from these two lines. r̶e̶t̶a̶i̶n̶s̶ ̶k̶e̶y̶s̶ ̶a̶n̶d̶ ̶o̶t̶h̶e̶r̶ ̶s̶e̶n̶s̶i̶t̶i̶v̶e̶ ̶i̶n̶f̶o̶r̶m̶a̶t̶i̶o̶n̶ ̶i̶n̶t̶o̶ ̶i̶t̶s̶ ̶f̶i̶l̶e̶s̶ ̶e̶v̶n̶e̶t̶o̶u̶g̶h̶ ̶i̶t̶ ̶s̶u̶p̶p̶o̶s̶e̶d̶ ̶t̶o̶

Ghera Violations:
- This app is vulnerable to SQL Injection due to the use of rawQuery() method in the f 
directory of where the code lies (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04h-Testing-Code-Quality.md#injection-flaws-mstg-arch-2-and-mstg-platform-2)

Manifest.xml Fixes:
- The Broadcast receiver needs to specify permission in order to make sure that an application that specified the required permission can send intents to the broadcast receiver.

Code Fixes:
- Using a temp file to store data (e/t/k.java):- in this file the code base shows that it uses the line, File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.b.getCacheDir()), to create a temp file and store data to it. To fix this error, they should just use the method createNewFile that actually creates a new file rather than a temp file. 
- Hardcodes sensitive informatino: Uses this line to hardcode sensitive information, StringBuilder j2 = f.a.a.a.a.j("Metadata key=", str4, ", value="). The problem is that sensitive information hardcoded like this should also be deleted out of the system, but it doesn't do that.
- Uses RawSQLQuery:- in the method, Cursor rawQuery = this.a.rawQuery("SELECT target_id, target_proto FROM targets", null), for file f/b/c/k/t/a1.java, there is the method rawQuery which cause the likelyhood SQL query injection. Use a method like SQLiteStatement which better defends against SQL code injections and stil allows to query, insert, update, and delete. 




 

