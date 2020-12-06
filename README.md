# Refactor exercise

The two new classes are PrimerNumbersGenerator and NumberPrinter. NumberPrinter has the main method that should be run,
it can print a list of numbers in a paginated columnar way, or by executing a received NumberGenerator it can print the
results.

# Parser exercise

The issues found on the Parser class are the following:

* The class doesn't really seem to parse the data it reads, it's more of a file reader and writer, in which case
  the class doesn't do what it suggests and has two responsibilities that don't seem related
* The variable names don't indicate what they do, especially the streams being called i and o
* Writing to a file seems out of place in this class since its main responsibility, parsing, is read only.
* The saveContent method is dangerous because it's going to replace the file that was read originally This is an _unexpected and destructive_ side effect.
* Concatenation of Strings in a loop should be avoided since a new string is created in each pass, which has a lot of overhead and uses up memory
* the saveContent method is lacking the handling of a FileNotFoundException and it swallows the IOException without actually notifying the caller