-----------------------------
-- Application description --
-----------------------------
Bank details:
Bank	Card number	Expiry date
HSBC Canada	5601-2345-3446-5678	Nov-2017
Royal Bank of Canada 4519-4532-4524-2456	Oct-2017
American Express	3786-7334-8965-345	Dec-2018

Use the information provided above, write a programme that will output the data based on the criteria provided below:
1.	Sort the data by Expiry date in descending order
2.	Each card number must be masked to below:
Card number	Masked card number
5601-2345-3446-5678	56xx-xxxx-xxxx-xxxx
4519-4532-4524-2456	4519-xxxx-xxxx-xxxx
3786-7334-8965-345	xxxx-xxxx-xxxx-345

--------------------
-- How to run it  --
--------------------
A an executable jar is provided along with the source. The application takes the bank details as parameters, and outputs the results. Each parameter should be a csv, composed of the bank name, the card number and the expriry date. And example of how to use it is the following:

C:\Users\someuser\CardMasker> java -jar jar\cardmasker.jar "HSBC Canada,5601-2345-3446-5678,Nov-2017" "Royal Bank of Canada,4519-4532-4524-2456,Oct-2017" "American Express,3786-7334-8965-345,Dec-2018"

American Express       xxxx-xxxx-xxxx-345    Dec-2018
HSBC Canada            56xx-xxxx-xxxx-xxxx   Nov-2017
Royal Bank of Canada   4519-xxxx-xxxx-xxxx   Oct-2017

The above is also provided as an example, in example.bat which you can run.

------------------
-- How to build --
------------------
You should have ant installed. Then go to the application root directory and do:
C:\Users\someuser\CardMasker> ant

----------------------
-- How to run tests --
----------------------
First make sure you have built the application (see above). Then you can run the tests by doing:
C:\Users\someuser\CardMasker> ant test
test:
    [junit] Running com.bcsg.AllTests
    [junit] Tests run: 17, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.169 sec
    [junit] Running com.bcsg.card.CardManagerTest
    [junit] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.077 sec
    [junit] Running com.bcsg.card.CardTest
    [junit] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.124 sec
    [junit] Running com.bcsg.cardmasker.CardMaskerTest
    [junit] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.08sec
    [junit] Running com.bcsg.cardvalidator.CardValidatorTest
    [junit] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.066 sec

BUILD SUCCESSFUL
Total time: 2 seconds
