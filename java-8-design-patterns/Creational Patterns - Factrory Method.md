# Factory Method/Virtual Constructor
Creational Pattern

# Intent

**Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.**

 _* Originally Factory Method was designed to be addressed with inheritance, however in some cases you may achieve the same results by composition and dependency injection._

_* It's possible substitute 'defer instantiation to subclasses' by 'defer instantiation to the factory object injected'._

_* Either way is importante to understand that by using inheritance you can make a piece of code reusable by simply extending it and overriding the object instantiation methods._

# Motivation

Frameworks use abstract classes to define and maintain relationships between objects. A framework is often responsible for creating (to instantiate) these objects as well.

Consider a framework for applications that can present multiple documents to the user. Two key abstractions in this framework are the classes Application and Document. Both classes are abstract, and clients have to subclass them to realize their application-specific implementations. To create a drawing application, for example, we define the classes _DrawingApplication_ and _DrawingDocument_. The Application class is responsible for managing Documents and will create them as required - when the user selects Open or New from a menu, for example.

Because the particular Document subclass to instantiate is application-specific, the Application class can't predict the subclass of Document to instantiate - the Application class only knows **when** a new document should be created, not **what kind** of Document to create. This creates a dilemma: The framework must instantiate classes, but it only knows about abstract classes, which it cannot instantiate.

_* The Factory Method offers an alternative to objects instantiation, where instead of to hard-code a new instance of a concrete object you can use a method to return that object. The return type of that method shall be an abstraction, that way you can use polymorphism to have different realizations. By applying this pattern you can decoupled the creation of a object from its use, making both of them interchangeable._

The Factory Method pattern offers a solution. It encapsulates the knowledge of which Document subclass to createand moves this knowledge out of the framework.

| ![Factory Method Motivation [1]](./img/factory_method_motivation.png) |
|:--:| 
| **Factory Method Motivation [1]** |

Application subclasses redefine an abstract CreateDocument operation on Application to return the appropriate Document subclass. Once an Application subclass is instantiated, it can then instantiate application-specific Documents without knowing their class. We call CreateDocument a **factory method** because it's responsible for "manufacturing" an object.

_* Think the case presented above as a framework that can work with different formats of documents, they have the same behaviors/methods but perform differently. In order to work properly with each document, your client have to extend the proper ConcreteApplication._

# Applicability

Use the Factory Method pattern when:

1. a class can't anticipate the class of objects it must create.
 
_* think in a reusable piece of code that uses polymorphism so the same code can work with diferent realizations._

2. a class wants its subclasses to specify the objects it creates.

3. classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.

# Structure

| ![Factory Method Structure [1]](./img/factory_method_structure.png) |
|:--:| 
| **Factory Method Structure [1]** |

# Participants

1. **Product (Document)**

    * defines the interface of objects the factory method creates.

2. **ConcreteProduct (MyDocument)**

    * implements the Product interface.

3. **Creator (Application)**

    * declares the factory method, which returns an object of type Product. Creator may also define a default implementation of the factory method that returns a default ConcreteProduct object.

    * may call the factory method to create a Product object.

4. **ConcreteCreator (MyApplication)**

    * overrides the factory method to return an instance of a ConcreteProduct.

# Collaborations

1. Creator relies on its subclasses to define the factory method so that it returns an instance of the appropriate ConcreteProduct.

# Consequences

Factory methods eliminate the need to bind application-specific classes into your code. The code only deals with the Product interface; therefore it can work with any user-defined ConcreteProduct classes.

A potential disadvantage of factory methods is that clients might have to subclass the Creator class just to create a particular ConcreteProduct object. Subclassing is fine when the client has to subclass the Creator class anyway, but otherwise the client now must deal with another point of evolution.

Here are two additional consequences of the Factory Method pattern:

1. **Provides hooks for subclasses.** Creating objects inside a class with a factory method is always more flexible than creating an object directly. Factory Method gives subclasses a hook for providing an extended version of an object.

_* 'hook' by polymorphism you can implement as many variations as needed._

In the Document example, the Document class could define a factory method called CreateFileDialog that creates a default file dialog object for opening an existing document. A Document subclass can define an application-specific file dialog by overriding this factory method. In this case the factory method is not abstract but provides a reasonable default implementation.

2. **Connects parallel class hierarchies.** In the examples we've considered so far, the factory method is only called by Creators. But this doesn't have to be the case; clients can find factory methods useful, especially in the case of parallel class hierarchies. 

**Parallel class hierarchies result when a class delegates some of its responsibilities to a separate class.** Consider graphical figures that can be manipulated interactively; that is, they can be stretched, moved, or rotated using the mouse. Implementing such interactions isn't always easy. It often requires storing and updating information that records the state of the manipulation at a given time. This state is needed only during manipulation; therefore it needn't be kept in the figure object. Moreover, different figures behave differently when the user manipulates them. For example, stretching a line figure might have the effect of moving an endpoint, whereas stretching a text figure may change its line spacing.

With these constraints, it's better to use a separate Manipulator object that implements the interaction and keeps track of any manipulation-specific state that's needed. Different figures will use different Manipulator subclasses to handle particular interactions. The resulting Manipulator class hierarchy parallels (at least partially) the Figure class hierarchy: 

| ![Factory Method Consequences [1]](./img/factory_method_consequences.png) |
|:--:| 
| **Factory Method Consequences [1]** |

**The Figure class provides a CreateManipulator factory method that lets clients create a Figure's corresponding Manipulator**. Figure subclasses override this method to return an instance of the Manipulator subclass that's right for them. Alternatively, the Figure class may implement CreateManipulator to return a default Manipulator instance, and Figure subclasses may simply inherit that default. The Figure classes that do so need no corresponding Manipulator subclass - hence the hierarchies are only partially parallel. 

**Notice how the factory method defines the connection between the two class hierarchies.** It localizes knowledge of which classes belong together.

_* instead of the Factory Method be called by Figure(Creator) is the Client that make the call._

# Implementation

Consider the following issues when applying the Factory Method pattern:

1. **Two major varieties.** The two main variations of the Factory Method pattern are (1) the case when the **Creator class is an abstract** class and **does not provide an implementation** for the factory method it declares, and (2) the case when the **Creator is a concrete class and provides a default implementation** for the factory method. It's also possible to have an abstract class that defines a default implementation, but this is less common.

The first case requires subclasses to define an implementation, because there's no reasonable default. It gets around the dilemma of having to instantiate unforeseeable classes. 

In the second case, the concrete Creator uses the factory method primarily for flexibility. **It's following a rule that says, "Create objects in a separate operation so that subclasses can override the way they're created."** This rule ensures that designers of subclasses can change the class of objects their parent class instantiates if necessary.

_* first case doesn't offer a default implementation, that's ok if your application may not offer one, in this case all the instantion occurs in the subclasses._

_* second case your application offers a default implementation and your are using factoy method to achive a more flexible design._
   
2. **Parameterized factory methods.** Another variation on the pattern lets the factory method create multiple kinds of products.** The factory method takes a parameter that identifies the kind of object to create**. All objects the factory method creates will share the Product interface. In the Document example, Application might support different kinds of Documents. You pass CreateDocument an extra parameter to specify the kind of document to create.

The Unidraw graphical editing framework uses this approach for reconstructing objects saved on disk. Unidraw **defines a Creator class with a factory method** Create **that takes a class identifier as an argument**. The class identifier specifies the class to instantiate. **When Unidraw saves an object to disk, it writes out the class identifier** first and then its instance variables. When it reconstructs the object from disk, it reads the class identifier first.

Once the class identifier is read, the framework calls Create, passing the identifier as the parameter. Create looks up the constructor for the corresponding class and uses it to instantiate the object. Last, Create calls the object's Read operation, which reads the remaining information on the disk and initializes the object's instance variables.

A parameterized factory method has the following general form, where **MyProduct** and **YourProduct** are subclasses of **Product**:

```
class Creator {
public:
    virtual Product* Create(ProductId);
};

Product* Creator::Create (ProductId id) {
    if (id == MINE) return new MyProduct;
    if (id == YOURS) return new YourProduct;
    // repeat for remaining products...
    return 0;
}
```

**Overriding a parameterized factory method lets you easily and selectively extend or change the products that a Creator produces. You can introduce new identifiers for new kinds of products, or you can associate existing identifiers with different products.**

For example, a subclass **MyCreator** could swap **MyProduct** and **YourProduct** and support a new **TheirProduct** subclass:

```
Product* MyCreator::Create (ProductId id) {
    if (id == YOURS) return new MyProduct;
    if (id == MINE) return new YourProduct; 
        // N.B.: switched YOURS and MINE
    if (id == THEIRS) return new TheirProduct;
    return Creator::Create(id); // called if all others fail
}
```

Notice that the last thing this operation does is call **Create** on the parent class. That's because **MyCreator::Create** handles only YOURS, MINE, and THEIRS differently than the parent class. It isn't interested in other classes. Hence **MyCreator** extends the kinds of products created, and it defers responsibility for creating all but a few products to its parent.

3. **Language-specific variants and issues.** Different languages lend themselves to other interesting variations and caveats.

Smalltalk programs often use a method that returns the class of the object to be instantiated. A Creator factory method can use this value to create a product, and a **ConcreteCreator** may store or even compute this value. The result is an even later binding for the type of **ConcreteProduct** to be instantiated.

A Smalltalk version of the **Document** example can define a **documentClass** method on **Application**. The **documentClass** method returns the proper **Document** class for instantiating documents. The implementation of **documentClass** in **MyApplication** returns the **MyDocument** class. 

Thus in class Application we have

```
clientMethod
    document := self documentClass new.

documentClass
    self subclassResponsibility
```

In class MyApplication we have

```
documentClass
    ^ MyDocument
```

which returns the class **MyDocument** to be instantiated to **Application**.

An even **more flexible approach** akin to parameterized factory methods **is to store the class to be created** as a class variable of **Application**. That way you don't have to subclass **Application** to vary the product.

Factory methods in C++ are always virtual functions and are often pure virtual. Just be careful not to call factory methods in the **Creator**'s constructor - the factory method in the **ConcreteCreator** won't be available yet.

**You can avoid this by being careful to access products solely through accessor operations** that create the product on demand. Instead of creating the concrete product in the constructor, **the constructor merely initializes it to 0**. The accessor returns the product. But first it checks to make sure the product exists, and if it doesn't, the accessor creates it. This technique is sometimes called **lazy initialization**. The following code shows a typical implementation:

```
class Creator {
    public:
        Product* GetProduct();
    protected:
        virtual Product* CreateProduct();
    private:
        Product* _product;
};

Product* Creator::GetProduct () {
    if (_product == 0) {
        _product = CreateProduct();
    }
    return _product;
}
```

4. **Using templates to avoid subclassing.** As we've mentioned, another potential problem with factory methods is that they might force you to subclass just to create the appropriate **Product** objects. **Another way to get around this** in C++ is to provide a template subclass of **Creator** that's parameterized by the Product class:

```
class Creator {
public:
    virtual Product* CreateProduct() = 0;
};

template <class TheProduct>
class StandardCreator: public Creator {
public:
    virtual Product* CreateProduct();
};

template <class TheProduct>
Product* StandardCreator<TheProduct>::CreateProduct () {
    return new TheProduct;
}
```

With this template, **the client supplies just the product class** - no subclassing of **Creator** is required.

```
class MyProduct : public Product {
public:
    MyProduct();
    // ...
};

StandardCreator<MyProduct> myCreator;
```

5. **Naming conventions.** It's good practice to use naming conventions that **make it clear you're using factory methods**. For example, the MacApp Macintosh application framework [App89] always declares the abstract operation that defines the factory method as **Class* DoMakeClass()**, **where Class is the Product class**.

# Sample Code

[Factory Method Code Sample](./factory-method)

The function **CreateMaze** (page 84) builds and returns a maze. One problem with this function is that **it hard-codes the classes of maze, rooms, doors, and walls**. We'll introduce factory methods to let subclasses choose these components.

**Each factory method returns a maze component of a given type**. MazeGame provides default implementations that return the simplest kinds of maze, rooms, walls, and doors.

Different games can subclass **MazeGame** to specialize parts of the maze. MazeGame subclasses can redefine some or all of the factory methods to specify variations in products. For example, a **BombedMazeGame** can redefine the Room and Wall products to return the bombed varieties.
 
# Known Uses

Factory methods pervade toolkits and frameworks. The preceding document example is a typical use in MacApp and ET++. The manipulator example is from Unidraw. Class View in the Smalltalk-80 Model/View/Controller framework has a method defaultController that creates a controller, and this might appear to be a factory method. But subclasses of View specify the class of their
default controller by defining defaultControllerClass, which returns the class from which defaultController creates instances. So defaultControllerClass is the real factory method, that is, the method that subclasses should override. 

A more esoteric example in Smalltalk-80 is the factory method parserClass defined by Behavior (a superclass of all objects representing classes). This enables a class to use a customized parser for its source code. For example, a client can define a class SQLParser to analyze the source code of a class with embedded SQL statements. The Behavior class implements parserClass to return the standard Smalltalk Parser class. A class that includes embedded SQL statements overrides this method (as a class method) and returns the SQLParser class.

The Orbix ORB system from IONA Technologies uses Factory Method to generate an appropriate type of proxy (see Proxy (207)) when an object requests a reference to a remote object. Factory Method makes it easy to replace the default proxy with one that uses client-side caching, for example.

# Related Patterns

Abstract Factory (87) is often implemented with factory methods. The Motivation example in the Abstract Factory pattern illustrates Factory Method as well. 

Factory methods are usually called within Template Methods (325). In the document example above, NewDocument is a template method.

Prototypes (117) don't require subclassing Creator. However, they often require an Initialize operation on the Product class. Creator uses Initialize to initialize the object. Factory Method doesn't require such an operation.

# References

[1] Gamma et al. Design Patterns: Elements of Reusable Object-Oriented Software. 1994.
