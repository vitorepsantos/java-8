# Builder
Creational Pattern

# Intent

**Separate the construction of a complex object from its representation so that the same construction process cancreate different representations.**

# Motivation

Take a reader for the RTF (Rich Text Format), this app will be able to convert a RTF to a plenty of others formats such as pure ASCII text, TeXText or a TextWidget for edition. Pay attention to the fact that the number of possibilities of converters are open-ended, therefore you need to be able to add a new converter without modify the RTF Reader component. 

So, given a RTF file you want to be able to convert the file to ASCII format, TexText or TextWidget. Meanwhile your applicatiin must be flexible enough so new formats of converters can be added without affect previous code.

The Builder pattern will help to build this multiple representations. The solution is to configure the RTFReader with a TextConverter object that converts RTF to another text representation. Whenever RTFReader receives a request of parse it calls the TextConverter object. 

Attention, TextConverter is a abstract interface, the subclasses of TextConverter specialize in different conversions, those are the concrete classes. As you can see RTF Reader doesn't need to know the details of the converter, the converters details are hidden behind of a polymorphic TextConverter abstraction.

In the scenario described above, each converter is called a **builder** in the pattern, and the reader is called the **director**. 

Applied to this example, the Builder pattern separates the algorithm for interpretinga textual format (that is, the parser for RTF documents) from how a converted format gets created andrepresented. This lets us reuse the RTFReader's parsing algorithm to create different text representations fromRTF documents - just configure the RTFReader with different subclasses of TextConverter.  

# Applicability

1. The algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.

2. The construction process must allow different representations for the object that's constructed.

![Builder Structure [1]](./img/creational_patterns_builder_img_1_structure.png)

# Participants

1. **Builder (TextConverter)**

    * Specifies an abstract interface for creating parts of a Product object.

2. **ConcreteBuilder (ASCIIConverter, TeXConverter, TextWidgetConverter)**    

   * Constructs and assembles parts of the product by implementing the Builder interface.

   * Defines and keeps track of the representation it creates.

   * Provides an interface for retrieving the product (e.g., GetASCIIText, GetTextWidget).

3. **Director (RTFReader)**

    * Constructs an object using the Builder interface.  

4. **Product (ASCIIText, TeXText, TextWidget)**    

    * Represents the complex object under construction. ConcreteBuilder builds the product's internalrepresentation and defines the process by which it's assembled.

# Collaborations

1. The client creates the Director object and configures (dependecy injection) it with the desired Builder object.

2. Director notifies the builder whenever a part of the product should be built.

3. Builder handles requests from the director and adds parts to the product.

4. The client retrieves the product from the builder.  

![Builder Collaborations [1]](./img/creational_patterns_builder_img_2_collaborations.png)

# Consequences

Here are key consequences of the Builder pattern

1. **It lets you vary a product's internal representation.** 

    * Because the product isconstructed through an abstract interface, all you have to do to change the product's internal representationis define a new kind of builder.

2. **It isolates code for construction and representation.** 

    * The Builder pattern improves modularity byencapsulating the way a complex object is constructed and represented. Clients needn't know anythingabout the classes that define the product's internal structure. 

    * Each ConcreteBuilder contains all the code to create and assemble a particular kind of product. The code is written once; then different Directors can reuse it to build Product variants from the same set of parts. In the earlier RTF example, we could define a reader for a format other than RTF, say, an SGMLReader, and use the same TextConverters to generate ASCIIText, TeXText, and TextWidget renditions of SGMLdocuments.

3. **It gives you finer control over the construction process**  
   * Unlike creational patterns that construct productsin one shot, the Builder pattern constructs the product step by step under the director's control. Only whenthe product is finished does the director retrieve it from the builder. Hence the Builder interface reflectsthe process of constructing the product more than other creational patterns. This gives you finer controlover the construction process and consequently the internal structure of the resulting product.

# Implementation

* Typically there's an abstract Builder class that defines an operation for each component that a director may ask itto create
* The operations do nothing by default.
* A ConcreteBuilder class overrides operations for components it's interested in creating.

Here are other implementation issues to consider:

1. **Assembly and construction interface**. 
   
   * Builders construct their products in step-by-step fashion. Therefore the Builder class interface must be general enough to allow the construction of products for all kinds of concrete builders.
  
   * A key design issue concerns the model for the construction and assembly process. A model where theresults of construction requests are simply appended to the product is usually sufficient. In the RTFexample, the builder converts and appends the next token to the text it has converted so far.
   
   * But sometimes you might need access to parts of the product constructed earlier. In the Maze example wepresent in the Sample Code, the MazeBuilder interface lets you add a door between existing rooms. Treestructures such as parse trees that are built bottom-up are another example. In that case, the builder wouldreturn child nodes to the director, which then would pass them back to the builder to build the parentnodes.
 
2. **Why no abstract class for products?** 
   
   * In the common case, the products produced by the concrete builders differ so greatly in their representation that there is little to gain from giving different products a common parent class. In the RTF example, the ASCIIText and the TextWidget objects are unlikely to have a common interface, nor do they need one. Because the client usually configures the director with the proper concrete builder, the client is in a position to know which concrete subclass of Builder is in use and can handle its products accordingly
 
3. **Empty methods as default in Builder.** 
   
   * In C++, the build methods are intentionally not declared pure virtual member functions. They're defined as empty methods instead, letting clients override only the operations they're interested in.

# References

[1] Gamma et al. Design Patterns: Elements of Reusable Object-Oriented Software. 1994.
