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