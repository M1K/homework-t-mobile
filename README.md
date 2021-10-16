# Test for developers
Let's have a file with transactions. 
The file consists of name of the transaction, name of the partner and telephone number of the client and time when the ransaction was paid. 

## Write a function:
class Solution { public String solution(String location); }

- that will read the file with name location which contains the list of M transactions
- returns the string representing the list of transactions and order for given partner
- the order of lines should stay the same

## For example, given a string:
payment weekly, Netflix/603603603, 2013-09-05 14:08:15
game Of Thrones, Apple / 603123456, 2015-06-20 15:13:22
payment yearly, Netflix / 604222333, 2013-09-05 14:07:13
Office 365, Microsoft /603698741, 2015-07-23 08:03:02
Office 365, Microsoft /602333666, 2015-07-22 23:59:59
payment weekly, Apple / 603999888, 2015-08-05 00:02:03
application Any.DO, Microsoft / 604123456, 2015-09-01 12:00:00
new subscription , Netflix / 602456987, 2013-09-06 15:40:22
installation of Modem, Netflix / 602666999, 2016-02-13 13:33:50
Sport 02,  Netflix /602603602, 2016-01-02 15:12:22
monthly subscription, Netflix /  603602333, 2016-01-02   14:34:30
"O2TV, SportTV", Netflix /603605506, 2016-01-02   15:15:01
game Of thrones, Netflix /602602602, 2016-01-02 09:49:09
yearly subscription, Netflix /602602602, 2016-01-02 10:55:32
recharging of 987654321, Netflix /604606321, 2016-02-29 22:13:11

## your function should return:
Netflix|02|payment weekly
Apple|1|game Of Thrones
Netflix|01|payment yearly
Microsoft|2|Office 365
Microsoft|1|Office 365
Apple|2|payment weekly
Microsoft|3|application Any.DO
Netflix|03|new subscription
Netflix|09|installation of Modem
Netflix|07|Sport 02
Netflix|06|monthly subscription
Netflix|08|O2TV, SportTV
Netflix|04|game Of thrones
Netflix|05|yearly subscription
Netflix|10|recharging of 987654321

as there are ten transaction for Netflix (numbered from 01 to 10), two for Apple (numbered from 1 to 2) and three for Microsoft (numbered from 1 to 3).
The new list of the transactions is returned in the same order as in the given string. Assume that:
- M is an integer within the range [1..100];
- M is an integer within the range [1..100];
- Each year is an integer within the range [2000..2020];
- Each line of the input string is of the format "«name of transaction» «partner»/«client phone number» yyyy-mm-dd hh:mm:ss" and lines are separated with
newline characters;
- Each transaction name consists only of at least 1 and at most 200 characters;
- Each name of the partner consists only of at least 1 and at most 30 characters;;
- No two transactions share the same date and time;

## Technical requirements:
- we expect project will be built in Maven
- we expect delivery of executable jar which will accept one parameter: filename location

## Please during your development take into account that in the backlog (work for the future) you can see that there are requirements like:
- create a web page that will represent the list from file S in the UI
- there can be multiple input files
- store the output in a sql database


#### Start application
Download project and open its directory (homework-t-mobile) and build from command line:
```
mvn clean install
```
Open target directory (homework-t-mobile/target) and run jar file
```
java -jar homework-t-mobile-1.0-SNAPSHOT.jar "/home/michal/DATA/Local/homework-t-mobile/src/main/resources/example_input.txt"
```
