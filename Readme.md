** Overview **
- The project is a MicroService based application that will take multiple files as the input, merge the data, anonymize,
and then transform the data into the Adobe Key-Value format.
- The input protocol to read is SFTP and the same is for the output connectivity.
- There is a Key masking that Obfusication of the keys.
- Tech Stack:
1. Java based Microservices
    Dagger2 DI, SQLite, Ormlite, Jersey
2. AngualJS/Reactive JS for the GUI
3. Docker based deployments, Hysterix co-ordination, NGINX for proxy, Ansible based deployments.

BUGS:
1. There is a NULL record that gets generated in the file dump that needs upload. Remove the null and debug how it is
generated.
2. Requirement as how to handle Duplicate Records in the files.
3. Requirements as how to handle the Lookup Table records.
4. Transformation rules for the data for formatting.

Requirements:
1. Update the Output using the selected 5 fields from the list. (Make the list configurable from GUI)
2. GUI for Key name definition
3. Extension to decrypt the Key name on the GUI

Enhancements:
1. DI using Dagger2
2. Deployment using Docker
3. Rest URL enhancements

