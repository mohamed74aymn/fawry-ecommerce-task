# E-Commerce Java Project for Fawry

this is a simple Fawry project for an e-commerce that handle all process of buing products and checkout

## Project Structure

```
src/ main/ java/ com/ fawry/ecommerce/
                              |
                              ├── model/
                              │   ├── Biscuit.java
                              │   ├── Cheese.java
                              │   ├── Customer.java
                              │   ├── Expirable.java
                              │   ├── Milk.java
                              │   ├── Product.java
                              │   ├── ScratchCard.java
                              │   ├── Shippable.java
                              │   └── TV.java
                              |── service/
                              |     ├── Cart.java
                              |     ├── CheckoutService.java
                              |     └── ShippingService.java
                              |__ App.java
```

## Model file

**Product (Interface)**: Base for all products.
**Expirable (Interface)**: For items that can expire ( Milk, Biscuit, Cheese).
**Shippable (Interface)**: For items that can be shipped ( TV, Cheese , other products).
**Customer**: Represents a customer with a name and balance.
**Product Classes**: Biscuit, Cheese, Milk, TV, ScratchCard.

## Services

- **Cart**: Allows adding and storing products.
- **CheckoutService**: Processes orders, validates stock and payment.
- **ShippingService**: Handles delivery for shippable items.

## App Entry Point

- `App.java` is the main file where execution starts. It connects all components to run the e-commerce flow.

## Why i Maven?

-because it Standard project structure and Easy dependency management and Ready for scaling into Spring Boot REST APIs

## output of project
```
cart1.add(cheese, 2);
cart1.add(biscuit, 1);
cart1.add(Milk, 1);
cart1.add(scratchCard, 2);
cart1.add(tv, 3);

? Cannot add expired product Biscuit
=== Checkout for mohamed Ayman ===

- ** Shipment notice **
  2x Cheese 500g
  3x TV 24000g
  Total weight 24.5kg

** Checkout receipt **
2x Cheese 100.0
1x Milk 120.0
2x ScratchCard 100.0
3x TV 3000.0
```


Subtotal 3320.0
Shipping 50.0
Amount 3370.0
Remaining balance: 1630.0

## features in project

- it is not allowed to buy anything if the amount in the wallet is less than the price of the coin.

- Also, if you want to buy a quantity of a product that is greater than the quantity available in the warehouse, the system prevents this from happening.

-Some products may require shipping like Cheese and TV, other
products like Mobile scratch cards may not require so this project set every
shippable item provide its weight.

-check if cart is empty and and tell user if it empty.

- divided the project in a way that was convenient for me and other programmers if they wanted to modify it.

- Also, if you try to buy an expired product, they prohibit that.

## how connect to Frontend

**Convert the Backend to a Web API**
-this Java app is console-based,so it need to expose functionality over HTTP using a web framework (spring boot for example)
-and Create REST Controllers

##

## Explain code

**model folder: Represents domain entities and interfaces also products**

_take a product for example Biscuit to explain_

Biscut Implements
Product – core interface for all product types

Expirable – indicates that the product can expire

Shippable – allows the product to be included in shipments based on weight
_i not add to it some products that donsn't need it weight like ScratchCard_

Main Methods
getName() – returns the product name

getPrice() – returns the price per unit

getQuantity() – returns current stock quantity

getWeight() – returns the product weight (for shipping cost calculation)

isExpired() – returns true if the product is expired

isShippable() – returns true (this product is eligible for shipping)

reduceStock(int q) – decreases stock by the specified quantity after checkout

**service folder:contains the business logic of the project. It does the actual processing**
_Managing cart items_

_Validating quantities and expiration_

_Calculating totals and checkouts_

_Handling shipping and checkout flow_

**Cart.java**
Manages the products that a customer adds for purchase.

Responsibilities:
Store items using a Map<Product, Integer>

Ensure valid quantity and stock

Prevent adding expired or unavailable items

Checks for:

Invalid quantity (<= 0)

Expired product

Exceeding available stock

Adds product to cart or prints error

**CheckoutService.java**
Handles the entire checkout process.

Responsibilities:

Verifies products

Calculates subtotal and shipping

Deducts product stock

Updates customer balance

Prints receipt and shipping info

Checks for:

Validates cart – if empty, exits

Loops through cart items:

Rejects expired items

Adds up prices (subtotal)

Adds shipping cost if item is Shippable

Validates customer balance

Deducts stock using reduceStock(q)

Calls _ShippingService.ship()_

Prints checkout receipt

**ShippingService.java**
Simulates a shipping label and calculates total package weight

it responsiple for ** Shipment notice **

_i am using the grouped and counts maps in ShippingService.java ?_

to group the same products together and calculate:

The number of each item (like 2x Cheese)

The total combined weight of each item name

The total shipment weight

_if i just loop and print directly_
it will be ❌ Not grouped, ❌ total looks repeated, ❌ less professional.

## Contact

If you have any questions, feedback, or would like edit this project, feel free to reach out:

👤 Name: Mohamed Ayman Mostafa

📧 Email: mohamedaymnali111@gmail.com
