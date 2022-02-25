# Covid CA Notify App(Mihir Madhira)

## App Permissions:
- Network Status: ``<android.permission.ACCESS_NETWORK_STATE/>``
- Bluetooth: ``<android.permission.BLUETOOTH/>``
- Foreground Service: ``<android.permission.FOREGROUND_SERVICE/>``
- Internet Access: ``<android.permission.INTERNET/>``
- Recieve Boot Completed: ``<android.permission.RECEIVE_BOOT_COMPLETED/>``
- Wake Lock: ``<android.permission.WAKE_LOCK/>``

## Privacy Policy:
CA Notify has the potential to help stop the spread of the infection and its use is 
highly encouraged, but it is completely voluntary.

Users may turn the system on or off at any time, or uninstall the app on an Android device. 
The system does not collect, track or store users’ location, GPS information, or personal 
information.

## This is the Privacy Policy for CA Notify app for Covid Tracing: https://canotify.ca.gov/privacy/

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

## Privacy Policy Violations:
- The Privacy Policy says that the app doesn't store private information however after running
the analysis, it says the app inserts Sensitive Information into a Log File. (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x05d-Testing-Data-Storage.md#logs)
- To protect the keys it keeps changing the key values; however, they use insufficient 
Random Values making the keys not so protected.(https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04g-Testing-Cryptography.md#weak-random-number-generators)
- retains keys and other sensitive information into its files evnetough it supposed to 


## Ghera Violations:
- This app is vulnerable to SQL Injection due to the use of rawQuery() method in the f 
directory of where the code lies (https://github.com/MobSF/owasp-mstg/blob/master/Document/0x04h-Testing-Code-Quality.md#injection-flaws-mstg-arch-2-and-mstg-platform-2)




 

