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


###Notes From Meeting with Professor Sathish  
think of way to have the least/simpler rep invariant

Movie/restaurant as reviewable object 

if need to display all reviews of a restaurant
1) can just look through list of reviews each time
2) make relationships from the start

Add review -> easy to add it to that one too
Not have to compute on the fly

parallel streams
in memory! small enough for that


type hierarchy that would work 

Restaurant/Review/User datatype each
Abstract class that extends MP5Db
Map of differentiating variable to list of fields
How to parse json (omg jason mistake)
How generalized should this be, eg. fields be an immutable type or instead of restaurant, be a product


1). type with key and value

How general?
*Search all italian. 
Datatype with specific fields

Disadvantage: new attribute -> update all code
List approach: new attribute -> not need to
Restaurant between name -> attributes

Review has user_id and business_id, can we have reviews from users/business not here

Can use open/close field in restaurant
User_id but privacy issues if they delete their account

Also, we can have users without any reviews!

JSON is this general! List of fields to values
