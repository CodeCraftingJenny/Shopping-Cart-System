# My Personal Project

## Background

This program is a shopping cart system where customers can create an order. The store offers four items
that can be customized: beanies, caps, tote bags, and hoodies. Customers will be able to add items to 
their cart and place orders. To place an order, customers will have to  input their name, address, phone 
number. I have chosen this idea for my  personal project because I have an interest in business and I
feel that I would learn a  lot from trying to create this.

User Stories

- As a customer, I want to browse and select from a range of clothing items.
- As a customer, I want to choose the size and color of the selected item.
- As a customer, I want to be able to order multiple items, add items, remove items from my shopping cart
- As a customer, I want to be able to view the items and the total amount in my cart

- As a customer, I want to have the option to save my shopping cart to file
- As a customer, when I return to the store, I want to be given the option to load my shopping cart from file

**Instructions for grader**

- You can browse and select the range of clothing by clicking into the clothing buttons, for example if you wanted
to browse hoodies, you can do that by pressing the "Hoodie" button to see what sizes and colours are available. 
- You can choose the size and colour by selecting an option from the drop-down menu after you have clicked into an item. 
- You can order multiple items by clicking on the cart button, then by pressing on the order button.
- You can add items to the cart pressing into the clothing option and pressing add cart after you have chosen your 
preferred colour and size. 
- You can remove items by inputting the index of the item that you want removed. For example, if there are 2 items in 
your cart, and you want to remove the second item, you can input 2 into the field and press remove. 
- To view the items in the cart simply click on the cart button
- To save what you have in your cart click on the save option in the cart menu
- To load what you had previously in cart, click on the load button.
- You can locate my visual component when you first run the program. There are pictures of clothing, and if you want to
view different colours, you can choose a colour, and it will show what the item looks like in that colour. 

**Phase 4: Task 2**
Sample of eventLog:

Sun Mar 31 21:25:30 PDT 2024
hoodie-black-S added to cart

Sun Mar 31 21:25:35 PDT 2024
cap-white-L added to cart

Sun Mar 31 21:25:37 PDT 2024
Cart has been opened

Sun Mar 31 21:25:37 PDT 2024
Total price of items in cart was returned.

Sun Mar 31 21:25:40 PDT 2024
hoodie-black-S removed from cart

Sun Mar 31 21:25:49 PDT 2024
Cart has been cleared

**Phase 4: Task 3**
My MainMenu class can be significantly improved by following the Single Responsibility Principle. In this class, 
buttons, labels, event handling are all contained in one class. This violates SRP since the MainMenu class has 
more than one responsibility. For the components such as buttons, labels, and frames, I could create a separate 
class that is only responsible for creating these UI components. Within this class I would have methods called 
“createButton, “createLabel”, etc. This way my code duplication and redundancy decrease.  I could also create 
a class that handles my events. So rather than having methods such as addToCart, removeFromCart, displayMessage, 
etc. all in one class with methods for the UI creation I could create another class to handle events. Applying 
these changes would make my code more maintainable and readable.  

Another improvement that I could make is to use enumerations in my Clothing class. In my clothing class, there 
are four items: hoodies, caps, beanies, and totebags. Each comes in 3 sizes: S, M, L. Each has its own price 
attached to the item. I could create an Enumeration class for the clothing item names, sizes, and colours. It 
would be a good idea to use enumerations because this would ensure that only valid values are used and would 
also make my code easier to maintain if I need to add a new clothing item. 
