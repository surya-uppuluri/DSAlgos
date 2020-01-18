## Min Heap

1. A variation of [Complete Binary Tree](../tree/TypesOfBinaryTrees.MD#L62) in which the value in each internal node <= values in the children of that node.
2. When represented as an array, if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.

### Example1:

            5             
         /      \         
       10        15       
      /                   
    30                    

### Example2:

         13
      /       \  
    16         31 
    /  \        /  \
    41    51    100   41

#### Representation

Typically represented as an array. The root element will be at Arr(0). For any ith node, i.e., Arr(i):


    Arr[(i -1) / 2] returns its parent node.
    Arr[(2 * i) + 1] returns its left child node.
    Arr[(2 * i) + 2] returns its right child node.

#### Operations on Min Heap:

    getMin(): It returns the root element of Min Heap. Time Complexity of this operation is O(1).
    extractMin(): Removes the minimum element from MinHeap. 
                  Time Complexity of this Operation is O(Log n)
                  This operation needs to maintain the heap property (by calling heapify()) after removing root.
    insert(): Inserting a new key takes O(Log n) time. 
               We add a new key at the end of the tree. If new key is larger than its parent, then we don’t need to do anything. 
               Otherwise, we need to traverse up to fix the violated heap property.

Credits: GFG


### Heap vs BST

**Summary**

|  Operation  | Type   |  BST  |  Heap  |
|:---|:---|:---|:---|
|Insert   | average |  log(n) |   1|
|Insert  |  worst   |  log(n)  |  log(n) or n|
|Find any | worst    | log(n)   | n|
|Find max  |worst     |1 (**)   | 1|
|Create    |worst     |n log(n) | n|
|Delete    |worst     |log(n)   | log(n)|

All average times on this table are the same as their worst times except for Insert.

Credits: [Stack Overflow](https://stackoverflow.com/questions/6147242/heap-vs-binary-search-tree-bst)

