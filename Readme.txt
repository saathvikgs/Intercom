To run the application, 
1. Open command prompt on windows.
2. Navigate to the folder which contains the executable jar "Invitation.jar"
3. To execute enter the following in command line:

	java -jar Invitation.jar
	
	
Few other things:

1. The appliation will ask user to choose file consisting o json records for customers.

2. If an unexpected event occurs during the execution of the application, then they are ignored and application continues its execution. 
   If there is an error while reading file containing json data, then the application terminates. 
   Any error or unexpected event will be logged in invitation_olg.txt file.


3. Source files are found in Intercom_Challenge/src folder

4. For testing, I have used customers_test.txt file.
