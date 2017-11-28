# Binary-Tree-and-Directory-Reader
Binary Tree and Directory Reader written in Java.

## Binary Tree
Binary tree has three main functions addValue, findParent and toString.

### addValue
addValue takes three arguments, the value to be added, the parent value and boolean to pick where to add the value (right or left).
It doesn't return anything.

### findParent
findParent takes two arguments, the root of the subtree to start searching in and the value to search for.
It returns either the BinaryNode that was found or null.

### toString
Returns the string representation of a Binary Tree.

```
(A (D () ()) (B (C () ()) ()))
```

## Directory Reader
Directory Reader creates a window using JFrame where the user can click on an button.
The Button opens a popup dialog where the user picks a folder and the program outputs the files contained in this folder and recursively goes through the folders to list its contents.
The folders become Trees with the the files their content and each folder inside becomes another Node.

## Testing
Using JUnit 4 for Testing Functions.
