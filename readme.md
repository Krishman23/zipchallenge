This application-Zipcode challenge  is based on Simple Spring web application with maven and Junit tools using : Spring Tool Suite, Version: 3.8.2.RELEASE, Platform: Eclipse Neon.1 (4.6.1) and Tomcal server.

Introduction:
 This is a real world problem. To filter out the zip code range. 
 The code is able to take user input of zip codes range in following format. 
   ([49679, 52015], [49800, 50000], [51500, 53479], [45012, 46937], [54012, 59607], [45500, 45590], [45999, 47900], [44000, 45000], [43012, 45950])
This should be mentioned in the ziprange.txt file from resources folder (which later can be scalable from csv file or any other format.

Output: 
Merged Result:
   [43012, 47900], [49679, 53479], [54012, 59607] 
which will be viewable in homepage.jsp while loading path localhost:<your port>/challenge/



Problem solution and Algorithm:
1. As stated in the introduction, the zip code range is received from file. so need to retrieve the file and then parse it. The error is handled through IOException
2. Further it is parsed for different brackets and commas, and then send to zipcodeValidator that validates 5 digit zipcode and returns boolean value
once the upper and lower range is validated for all zip codes 
3. It is further kept in Tree map and the beauty of treemap will sort the zip codes based on lower zip range using class TreemapToArray and further it is converted into Arraylist of arraylist. 
4. Now we have list of sorted zip code based on lower zip range. to merge the zip ranges, we will have further 3 cases to done till the end of the list:
	a. the upper range is less than lower range of next zip range (adjacent). 
		Result: let lower and upper range as one of the output range. and move to next range.
	b. the upper range is greater than lower range and lesser than upper range of next zip range (adjacent).
		Result: take the lower range of current and upper range of adjacent range and then look for next range using step 4.
	c. the upper range is greater than lower range of next zip range (adjacent). 
		Result: let lower and upper range  of current and avoid the adjacent range and continue step 4 to another range (second adjacent).
5. Finally we will retrieve the output as the merged arraylist of the zip code 

Test Cases:
This is done using junit. and we have 2 test classes defined to test zipcode validation, convert treemap to arraylist, and finally merge the zip code.


Example: 

1. 
Entered Zip :
[49679,520a15],[49800,50000],[51500,53479],[45012,46937],[54012,59607],[45500,45590],[45999,47900],[44000,45000],[43012,45950]

MergdMap:
Invalid format near 49679,520a15

2.
Entered Zip :
[49679,52015],[49800,5000130],[51500,53479],[45012,46937],[54012,59607],[45500,45590],[45999,47900],[44000,45000],[43012,45950]

MergdMap:
Invalid format near 49800,5000130

3. 
Entered Zip :
[49679,52015],[49800,50000],[51500,53479],[45012,46937],[54012,59607],[45500,45590],[45999,47900],[44000,45000],[43012,45950]

MergdMap:
[ 43012, 47900], [ 49679, 53479], [ 54012, 59607],


4.
 Entered Zip :
[40000,41234],[40001,41235]

MergdMap:
[ 40000, 41235], 

 
5.//Edge case
 Entered Zip :
[40000,41000],[41001,41235]

MergdMap:
[ 40000, 41235],


6.
 Entered Zip :
[40000,41999],[41001,41235]

MergdMap:
[ 40000, 41999],

