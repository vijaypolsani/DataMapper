<B> AAM Data Load project</B>

<B> Overview: </B>
The document explains the details of the uploading the member profile data  as a file into Cloud and configuring Audience Manager to visualize the rules defined as part of Traits. 

Adobe Audience Manager is used to define Traits, Segments for Adobe Marketing Cloud. There are two sets of conventions. 
First is the file naming convention, which defines the name of the file that will be uploaded to Adobe Cloud. 
Second is the data file content format definition (UUID as the item with TAB separated with Key-Value pairs)

File Naming Convention: 
ftp_dpm_xxx_1366545717.overwrite.gz<br>
ftp_dpm_xxx_1366545717.sync.gz

1.	In the above example, the ‘overwrite’ is the first upload syntax and the delta uploads should have the ‘sync’ extension.
2.	ID of the DataSource used in AAM: xxxx
3.	“1366545717” is the TimeStamp in MilliSecs. Used to keep file names distinct and identify succession. 

<b>Data Format Conventions:</b><br>

UUID: The record unique identifier (Separator: TAB)
TRAIT: Traits that can be used in AAM (Separator: EQUALS, Trait Separator: COMMA)

Ex: DDB2FD3F-B912-4AD2-B083-0008CBA47D46	"b"="5000004442","c"="CA-800700-0-358511055-1-22-20140101-5830","d"="800700","e"="0"

Data is uploaded into the Adobe Cloud in a predefined format as defined in below links.
https://marketing.adobe.com/resources/help/en_US/aam/c_name_reqs.html<br>
https://marketing.adobe.com/resources/help/en_US/aam/c_file_based_id_sync.html<br>
https://marketing.adobe.com/resources/help/en_US/aam/c_inbound_data_file.html<br>
<a>AAM Configurations:</b>
<br>
AAM needs the traits created manually matching the trait names that are in the data upload. Once the traits are created, based on the required rules, Segments can be created with a combination of the Traits. The combination of the Traits can be refined based on Trait Expressions. Trait Expressions are something that you are trying to match the data to the specific Trait. The matching criterion is what you can define in the expression.

Ex: Trait Rule	(testBt == "1")
In the above example “testBt” is the name of the Trait. “==” is the EqualsTo assignment that tries to match the trait exactly equals to data. Other advanced options could be “matchesregex” which you can mention using a Java Regex expression. 
 
<b>AAM Analytics:</b>
Analytics on AAM gives the report of the data upload, Trait matching report, Segmentation matching reports etc. The report containing the Data Upload could be visualized in the analytics screen
 
<B> DataMapper Technical Java MicroService Details: </B>
The POC project is a MicroService based application that will take multiple files as the input, merge the data, anonymize and then transform the data into the Adobe Key-Value format. The input protocol to read is SFTP and the same is for the output connectivity. There is a Key masking that Obfuscation of the keys.
Tech Stack:
    Java based MicroService
    Dagger2 DI, SQLite, Ormlite, Jersey
    AngualJS/Reactive JS for the GUI
    Docker based deployments, Hysterix co-ordination, NGINX for proxy, Ansible based deployments.

* Know Bugs:
There is a NULL record that gets generated in the file dump that needs upload. Remove the null and debug how it is generated.
How to handle Duplicate Records in the files.
How to handle the Lookup Table records.

* Future Requirements:
Rules governing Key and Value. 
Update the Output using the selected 5 fields from the list. (Make the list configurable from GUI)
GUI for Key name definition
PGP Encryptions to encrypt/decrypt the file name

* Enhancements:
DI using Dagger2
Deployment using Docker
Rest URL enhancements