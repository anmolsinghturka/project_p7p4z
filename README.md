# Shopping Cart Project Phase 1

## A simple **java** based desktop application to keep track of the shopping items inventory, add items to inventory, add items to cart, purchase, view purchase history, and updated inventory.  
## Users are able to add, shopping items to a particular section. See purchase history, and updated inventory. 

More detail about the project:

- What will the application do?  

This application will be able to add shopping items for purchase, add items to cart and display a list of items to checkout, purchase them, update inventory, view list of updated inventory, and view list of purchased orders.

- Who will use it?

Users interested in shopping items over the desktop.

- Why is this project of interest to you?

I am interested in making a shopping cart application because keeping track of shopping inventory over the desktop is easy, and convenient for the users.

### User Stories are as follows:

- ##### As a user, I want to be able to add shopping items to a particular section. For example:
  * I want to add a T-shirt's brand, price, description, stock, rating to the *Clothing* section.
  * I want to add a Blanket’s  brand, price, description, stock, rating to the *Clothing* section.
  * I want to add Hand sanitizer's brand, price, description, stock, rating to *Health* section.
  * I want to add laptop's brand, price, description, stock, rating to *Electronics* section.

- ##### As a user, I want to be able to add shopping items to cart from a particular section.
- ##### As a user, I want to be able to purchase items.
- ##### As a user, I want to be able to view list of purchased items.
- ##### As a user, I want to be able to update the inventory after a purchase.
- ##### As a user, I want to be able to view list of updated inventory.


## Phase 2

- ##### As a user, I want to be able to save a list of shopping items to file.
- ##### As a user, I want to be able to save a list of items in cart to file.
- ##### As a user, I want to be able to save a list of items in purchase history to file.
- ##### As a user, I want to be able to load shopping items from a file. 
- ##### As a user, I want to be able to load items in cart from a file. 
- ##### As a user, I want to be able to load purchase history from a file. 
- ##### As a user, I want to be able to resume exactly from where I left off at some earlier time.

## Phase 3

- ##### As a user, I want to see a panel in which all the items added into the inventory are displayed.
- ##### As a user, I want to see a panel in which all the items in the cart are displayed.
- ##### As a user, I want to see a panel in which all the purchased items are displayed.

- ##### As a user, I want to see a button or menu that can be used to add items into the inventory.
- ##### As a user, I want to see a button or menu that can be used to add items into the cart.
- ##### As a user, I want to see a button or menu that can be used to purchase items.

- ##### As a user, I want to see a panel where items in the inventory are filtered according to price, stock, rating, and brand.

- ##### As a user, I want to see an audio visual when I purchase items.

- ##### As a user, I want to be able to load and save the state of the application when I click on a button.

## Phase 4

### Phase 4: Task 2

- ##### The classes where the Map interface has been used is in Cart, PurchaseHistory.



### Phase 4: Task 3

UML Diagram in the root represent the relationship between Cart, PurchaseHistory, ShoppingItem, ShoppingItemsInventory, 
User, JsonReader, JsonWriter, Writable, DashBoard, ItemPanel, Main, and ShoppingApp. It is clear from the diagram there 
is an aggregation relationship between ShoppingItem and ShoppingItemsInventory, Cart and ShoppingItem, DashBoard and
ItemPanel, purchase history and ShoppingItem. Also, DashBoard has association relationship with User, JsonReader, 
JsonWriter and ShoppingItemInventory. 

Following refactoring could be improved in design if there was more time to work on the project

- ##### Refactor DashBoard into an abstract classes, ItemPanel as subclass, other associated classes that would implement the GUI
- ##### Make use of composite pattern in ShoppingApp to define class hierarchies that contain primitive and superclass methods
- ##### Refactor ShoppingItem into super classes, and PurchaseHistory, ShoppingItemsInventory as subclasses to improve design 


![alt text](https://github.com/anmolsinghturka/project_p7p4z/blob/main/UML_Design_Diagram.png?raw=true)

![alt text](https://github.com/anmolsinghturka/project_p7p4z/blob/main/data/1.png?raw=true)
![alt text](https://github.com/anmolsinghturka/project_p7p4z/blob/main/data/2.png?raw=true)
![alt text](https://github.com/anmolsinghturka/project_p7p4z/blob/main/data/3.png?raw=true)
![alt text](https://github.com/anmolsinghturka/project_p7p4z/blob/main/data/4.png?raw=true)
![alt text](https://github.com/anmolsinghturka/project_p7p4z/blob/main/data/5.png?raw=true)
![alt text](https://github.com/anmolsinghturka/project_p7p4z/blob/main/data/6.png?raw=true)
![alt text](https://github.com/anmolsinghturka/project_p7p4z/blob/main/data/7.png?raw=true)





