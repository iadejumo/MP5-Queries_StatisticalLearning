CPEN 221 / Machine Problem 5

**Restaurants, Queries and Statistical Learning**
===

###Design choices

We found the fields in the different JSON files and used similar fields to come up with relationships between the different files  

Restaurant: business-id --> Review: business-id  
Reviews: user-id --> Users: user-id  

===  
Objects:
+ Create restaurant/review/user objects with field holding data from json files.  
+ Create collections of these objects

===  
Maps:
+ Map unique fields with their corresponding data (stored as a list)
+ It would be faster to find a specific Key in Map, and we would know what each index in the list represents which would make it relatively easier/faster to retrieve information.
+ Have constants to represent the different indices in the map 

###Operations

###Questions
+ Should we store all the data when we construct/initialize the database or constantly retrieve information from json files??
+  
