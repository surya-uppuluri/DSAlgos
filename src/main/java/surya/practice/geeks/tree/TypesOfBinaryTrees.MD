## Full Binary Tree :

 1. All nodes except leaves have two children.
 2. Nodes can have `Zero` children too.

###  Example1:

               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40

###  Example2:


             18
           /    \   
         15     20    
        /  \       
      40    50   
    /   \
    30   50



###  Example3:

               18
            /     \  
          40       30  
                   /  \
                 100   40


##  Complete Binary Tree:

1. Last level needn't be filled.

~~2. All but last level shall be filled with 2 elements.~~

2. Keys shall be as left as possible.

###  Example1:

               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40

###  Example2:

               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40
     /  \   /
    8   7  9 

Practical example of Complete Binary Tree is Binary Heap.



##  Perfect Binary Tree:

All internal nodes have two children and all leaves are at the same level.

###  Example1:

               18
           /       \  
         15         30  
        /  \        /  \
      40    50    100   40

###  Example2:

               18
           /       \  
         15         30  




###  Balanced Binary Tree

A binary tree is balanced if the height of the tree is O(Log n) where n is the number of nodes.  
For Example, AVL tree maintains O(Log n) height by making sure that the difference between heights of left and right subtrees is at most 1.

Red-Black trees maintain O(Log n) height by making sure that the number of Black nodes on every root to leaf paths are same and there are no adjacent red nodes.

Balanced Binary Search trees are performance wise good as they provide O(log n) time for search, insert and delete.



###  A degenerate (or pathological) tree

A Tree where every internal node has one child. Such trees are performance-wise same as linked list.

      10
      /
    20
     \
     30
      \
      40     


Source: GFG and Wikipedia