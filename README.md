# Family

## Application build and execute instructions

These are as per specifications in the problem statement (Solution with build file)
 - "family" is a maven project.
 - Unzip and install the project. 
 - Run maven clean package/install command to package / install the distribution (jar). The target folder generates geektrust.jar.
 - Execute the application by following command
 	`java -jar geektrust.jar <path_to_input_file>`


## Assumptions and Considerations

 - Assumed that the names of the family members are unique.
 - Addition of spouse in the family tree is implemented on the lines similar to that of "ADD_CHILD" function.
 - Relationship, in general, is a complicated subject to understand. Current solution is implemented considering simple and basic understanding of this subject.
 - Some of the implemented `Relationships` are used only for testing purposes. They are not required/used to in application execution.
 - There could be cases or boundary conditions which might have got missed or are not covered in the implemented solution. For such cases, this solution can be improved upon; starting by adding failing tests for such cases. 
 - Current supported behavior of this application is defined "entirely" by written tests.
 
## Approach

### Data model

`Member` represents an individual person in the domain model. It has simple attributes - name and gender, and relational attributes (referencing other member objects) - mother, father and spouse.

`Family` represents a family tree. Family has simple attribute - name - representing a family name. A LinkedHashMap data structure is used as an attribute of `Family` to maintain all members of the family. The name of the member is key of this map (assumption is that the member names are unique in family) to support search function by member name. The 'linked' behavior of this map is utilized to retrieve the family members in the order in which they were added to the family tree.

`Relation` among the members is implemented as a function that returns the list of relatives of a member. Above mentioned attributes of `Member` class and `Family` class are used to resolve all relation functions to find respective relatives.

`ModelProcedures` are created to model the family tree, and to add new members. Current implementation supports 2 functions - "add child through mother" as mentioned in the problem statement, and "add spouse" as a consideration/assumption.

### Components / packages

The root package of the project handles creation of initial setup of `ExecutionContext` (it initializes the existing family tree on program start).

`app` package handles user interface functions. 

`app.commands` handles identifying and processing the instructions specified in input file - ADD\_CHILD and GET\_RELATIONSHIP.

`model` package maintains data model related classes and functions.

`model.exceptions` the relevant exceptional scenarios while processing user requests, are captured as specific exceptions.

`model.procedures` manages functions that update the family tree.

`model.relationships` contains functions representing all the required relationships in a family tree.

### Testing

 - Unit tests are written that run during build time of the project. 
 - Specifications and expected outcomes are implemented in these tests, before the implementing the function that would produce desired outcomes.
 - Any new functionality can be added or existing functionality can be modified by making required modifications in these implemented tests.

 
