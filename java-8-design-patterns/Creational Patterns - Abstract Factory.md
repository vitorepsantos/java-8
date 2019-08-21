# Abstract Factory or Kit
Creational Pattern

# Intent
> "Provide an interface for creating families of related or dependent objects without specifying their concrete classes." [1]  

Attention to "**families** of **related** or **dependent** objects", it tell us that the **Abstract Factory Pattern** is not about create one single object per factory, its propose that one factory will produce a set of objects that can only work properly when working together. Think you have a Client/Unit/Class that use a set of objects that, although each have its own behavior, they are design to work together. 

# Motivation
A good example is an app that have two themes, light and dark, when the user choose one of those two, it doesn't make sense combine them, imagine a white text in a white background. So you have two groups of objects, light and dark, that never work togheter.

# Applicability
> "a system should be independent of how its products are created, composed, and represented" [1]  

It creates a abstraction between the client and a concrete dependency, helping decoupling the code

> "a system should be configured with one of multiple families of products." [1]  

Because they depend on each other to work properly.

> "a family of related product objects is designed to be used together, and you need to enforce this constraint" [1]  

Because with you do not apply the constraint you'll have the components mixed and they'll not work propoerly

> "you want to provide a class library of products, and you want to reveal just their interfaces, not their implementations" [1]  

The client only knows the abstraction, during the runtime the proper concrete factory is choosen.

# Participants
**AbstractFactory**  
> "declares an interface for operations that create abstract product objects." [1]  

**ConcreteFactory**    
> "implements the operations to create concrete product objects." [1]    

You can have multiple concrete factorys, one for each family of related objects.

**AbstractProduct**    
> "declares an interface for a type of product object." [1]  

**ConcreteProduct**    
> "defines a product object to be created by the corresponding concrete factory." [1]  
> "implements the AbstractProduct interface." [1]  

You can have multiple concrete products for each family and for different families.

**Client**  
> "uses only interfaces declared by AbstractFactory and AbstractProduct classes." [1]


# Collaborations
> "Normally a single instance of a ConcreteFactory class is created at run-time. This concrete factory creates product objects having a particular implementation. To create different product objects, clients should use a different concrete factory. [1]

> "AbstractFactory defers creation of product objects to its ConcreteFactory subclass." [1]

# Consequences
> "It isolates concrete classes. The Abstract Factory pattern helps you control the classes of objects that an application creates" [1]  

Helps decoupling.

> "It makes exchanging product families easy. The class of a concrete factory appears only once in an application—that is, where it's instantiated" [1]  

> "It promotes consistency among products. When product objects in a family are designed to work together..." [1] 

> "Supporting new kinds of products is difficult. Extending abstract factories to produce new kinds of Products isn't easy. That's because the AbstractFactory interface fixes the set of products that can be created" [1]

# Implementation

Some useful techniques for implementing the Abstract Factory pattern.

> "Factories as singletons. An application typically needs only one instance of a ConcreteFactory per product family." [1]

> "Creating the products. AbstractFactory only declares an interface for creating products. It's up to ConcreteProduct subclasses to actually create them. The most common way to do this is to define a Factory Method for each product. A concrete factory will specify its products by overriding the Factory Method for each" [1]

The **AbstractFactory** have a set of factory methods wich are overriden by each concrete factory.

> "If many product families are possible, the concrete factory can be implemented using the Prototype pattern. The concrete factory is initialized with a prototypical instance of each product in the family, and it creates a new product by cloning its prototype. The Prototype-based approach eliminates the need for a new concrete factory class for each new product family" [1]

In this case you have only one concrete factory with a dictionary and which store a instace of all concrete products. The method make has a single paramether which will be used as a key to this dictionary, the method make will return a copy of object indicated by the given key.

> "Defining extensible factories. AbstractFactory usually defines a different operation for each kind of product it can produce. The kinds of products are encoded in the operation signatures. Adding a new kind of product requires changing the AbstractFactory interface and all the classes that depend on it. A more flexible but less safe design is to add a parameter to operations that create objects. This parameter specifies the kind of object to be created. It could be a class identifier, an integer, a string, or anything else that identifies the kind of product. In fact with this approach, AbstractFactory only needs a single "Make" operation with a parameter indicating the kind of object to create. This is the technique used in the Prototype- and the class-based abstract factories discussed earlier." [1]

# References
[1] Gamma et al. Design Patterns: Elements of Reusable Object-Oriented Software. 1994.
