# Algorithms HW 4: Mergesort & Quicksort
This assignment focuses on implementing and understanding two popular sorting algorithms: merge sort and quick sort. The tasks include writing pseudo code and actual code for both algorithms, explaining their workings through comments, comparing their time complexities in best, average, and worst-case scenarios, and finally, verifying the correctness of the implementations using a provided file.

## Details
### Merge Sort Explanation:

- Merge Sort in Programming Language:
 (code) MergeSort(array, leftIndex, rightIndex)
  if leftIndex < rightIndex
    middleIndex = (leftIndex + rightIndex) / 2
    MergeSort(array, leftIndex, middleIndex)
    MergeSort(array, middleIndex + 1, rightIndex)
    Merge(array, leftIndex, middleIndex, rightIndex)

Merge(array, leftIndex, middleIndex, rightIndex)
  create two temporary arrays leftArray and rightArray
  copy data to these temporary arrays
  initialize i = 0, j = 0, k = leftIndex
  while i < size of leftArray and j < size of rightArray
    if leftArray[i] <= rightArray[j]
      array[k] = leftArray[i]
      increment i
    else
      array[k] = rightArray[j]
      increment j
    increment k
  copy remaining elements of leftArray and rightArray if any
  (code)
- Quick Sort Explanation:

- Quick Sort in Programming Language:

- Time Complexity Comparison:
  How do the best, average and worst case time complexities compare between these two algorithms?
  
- Verification of Sort Algorithms : 
Use the uploaded file to verify your sort algorithms are working. numbers-4.txt Download numbers-4.txt  What is the position of 90262? What is the position of 11559?
