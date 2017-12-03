CPEN 221 / Machine Problem 5

**Restaurants, Queries and Statistical Learning**
===

###Design choices

We looked over the fields in the different JSON files and found the fields that related the Reviews to Restaurants and Reviews to User. We used these create relationships between the different files.  

__Related Fields__

Restaurant: _business-id_ --> Review: _business-id_ 

Reviews: _user-id_ --> Users: _user-id_  


__Design Choice 1: Objects__
+ Create Restaurant and Review and User objects with field holding data from json files  
+ Create collections of these objects, eg. a Map<String,Restaurant>, with unique ids (_business-id_, _user-id_, _review-id_) as keys
+ Easier to create these objects and manage them
+ Simpler to implement
+ Takes more memory
+ Less changeable (eg. adding new fields for Restaurants requires changing the Restaurant class)

__Design Choice 2: Maps__
+ Map unique fields (_business-id_, _user-id_, _review-id_) with their corresponding data (stored as a Map)
+ Map<String, Map<String,JSONObject>>
+ More general and scalable to different types of reviewables (eg. adding new fields for Restaurants is much easier, simply add it to the map
+ More difficult to implement, as the Map<String,JSONObject> requires more work because it is more general

__We have chosen Design Choice 1: Objects for simpler implementation. We will consider trying out Design Choice 2 in the future or to test later__

###Other Fields

__Establish Relationships At Object Construction__
Map<String,Set<String>> that shows relationships from 

1. Users to Restaurants they have reviewed
2. Users to Reviews they have written
3. Restaurants to Reviews that are on this Restaurant

The Strings are all the unique ids (_business-id_, _user-id_, _review-id_)

Chose Set<String> because it prevents repeats, does not require order, is easier to check if something is contained.

Note: May consider changing to a List<String> if single retrieval from this Set/List is often needed

###Useful Operations
1. Getting the Map of all Restaurants OR all Reviews OR all Users

2. Add a new User OR a Restaurant OR a Review

3. Private method to re-update all ratings/average ratings/review_count 

__Future Possiblities__ (most will be done in the query section, so implementing these methods would only simplify these that process): 

+ Get all Restaurants a User has been to
+ Get all Reviews written by a User
+ Get all Reviews for a given Restaurant
+ Get all Restaurants of a given category/price/rating etc.
+ Get all very active users (active with reviewing)
+ Get longest/shortest reviews (looking for spam, useless or high quality reviews)

###Questions
+ Should we store all the data when we construct/initialize the database or constantly retrieve information from json files??
+ Can Restaurant/Review/User each be a datatype?
+ Should we make an Abstract class that extends MP5Db?
+ Other option: Map of differentiating variable to list of fields. Would this work?
+ How to parse json (omg jason mistake)?
+ How generalized should this be, eg. fields be an immutable type or instead of restaurant, be a product, etc.?

###Notes From Meeting with Professor Sathish  

+ To make Object method more general, we could have a Reviewable interface that a Restaurant/Movie/Product could implement

+ If we need to display all reviews of a restaurant
1) can just look through list of reviews each time
2) make relationships from the start (THIS IS DONE OFTEN, SO PROBABLY THIS ONE

__Want__

Add review -> easy to add it to that one too
Not have to compute on the fly

+ Recommend using parallel streams
+ The data set was chosen to be small enough to be stored in memory! 

__Type with key and value__

+ How general?
+ Search all italian. 
+ Datatype with specific fields

Disadvantage: new attribute -> update all code

List approach: new attribute -> not need to update all code

Restaurant: Map between name -> attributes

__Rep Invariants__
+ Easy ones: unique ids, non-nulls, non-negatives, 1-5, 1-4, in correct areas
+ Harder one: Reviews have user-id and business-id. Can we have reviews from users/business not in datatype?

+ We can use the open field in restaurant
+ Interesting privacy issues if users delete their account

+ Note: we can have users without any reviews!

+ JSON is super general! Fields to values! Even classes are like this as well
