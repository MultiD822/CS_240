# Data Structures 3: Hash tables
-You will build the following data structure in the programming language of your choice. 

## Objective
Implement a hash table with a hash function of your choice.  You should turn in two types of hash tables with some way to handle collisions.  

### Hashtable
This is a data structure that stores unique keys to values, for example <Integers, Strings>.  Each key/value pair is known as an entry; having these entries allows the data structure to have
fast insertion, look-up, and deletion of entries.  Hash Tables are not so ideal when there is a small data set, but the efficiency of the data structure goes up when there is a larger data set.

### Hashing
The process of hashing takes a key and then computes an integer, for the hashing formulas will be different based on the key and the data type.
In a HashTable, we take a hash value remainder when we divide the hash by the capacity to then return an index number example key.hashCode() % capacity = index

### Bucket
A bucket is, in a way, an array in the sense that it is an indexed storage location for one or more entries when dealing with a hash table.  What differs from being an array is that multiple
entries can be stored at the same index. This happens in case of a collision, so in a way, it is like a linked list.

### Collision
Collisions happen when the hash functions generate the same index for more than one key, this can lead to the hash table being less efficient, and more collisions will equal longer insertion, look-up, and deletion of entries.
If we have fewer collisions it will equal more efficiency.

### Time Complexity
- The Best Case time is O(1)
- The Worst Case time is O(n) 
