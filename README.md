Task 2: Product Inventory Management API

Description: Create an API for managing product inventory in a store. The API should allow:

•	Adding a new product to the inventory (POST).
•	Retrieving details of a product by its ID (GET).
•	Updating the quantity of a product in stock (PUT).
•	Deleting a product from the inventory (DELETE).
•	Listing all products in stock (GET).
Data Fields:

•	Product ID (Primary Key)
•	Name
•	Category
•	Price
•	Quantity in Stock

Database Tables:
•	Products



•	Adding a new product to the inventory (POST).
addind product to the inventory only if all the required details are provided the product data will be created otherwise indicate the user to fill the required field

• Retrieving details of a product by its ID (GET). 
if the ID is alredy present in the table then it will retrive the datas if not it will indicate ID not found

• Updating the quantity of a product in stock (PUT).
upadting only the quantity of the Stock using its id if the product alredyexist update will be compleded otherwise indicate productID not found

• Deleting a product from the inventory (DELETE).
deleting the particular product from the table usind its id if pressent other wise indicate not found

• Listing all products in stock (GET).
Retrieving all details which are pressent in the database

• Listing all products in stock (GET). Retrieving all details from the table if pressent.
