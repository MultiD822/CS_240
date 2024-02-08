# Algorithms HW 4: Mergesort & Quicksort
This assignment focuses on implementing and understanding two popular sorting algorithms: merge sort and quick sort. The tasks include writing pseudo code and actual code for both algorithms, explaining their workings 
through comments, comparing their time complexities in best, average, and worst-case scenarios, and finally, verifying the correctness of the implementations using a provided file.

## Details

- Merge Sort Explanation:
```plaintext
MergeSort(array)
  Call sortArray(array, 0, array.length - 1)

sortArray(data, lowIndex, highIndex)
  if highIndex - lowIndex >= 1
    middleValue1 = (lowIndex + highIndex) / 2
    middleValue2 = middleValue1 + 1
    Call sortArray(data, lowIndex, middleValue1)
    Call sortArray(data, middleValue2, highIndex)
    Call mergeArrays(data, lowIndex, middleValue1, middleValue2, highIndex)

mergeArrays(arrayData, lowIndex, middleValue1, middleValue2, highIndex)
  Initialize combinedArrays with the same length as arrayData
  Merge the arrays until reaching the end of either array
  If the left array is empty, copy the remaining elements from the right array
  If the right array is empty, copy the remaining elements from the left array
  Copy values back into the original array
```
- Merge Sort in Programming Language:

- Quick Sort Explanation:
```plaintext
QuickSort(arrayData, startingIndex, endIndex)
  if endIndex <= startingIndex
    return
  pivotIndex = PartitionSort(arrayData, startingIndex, endIndex)
  QuickSort(arrayData, startingIndex, pivotIndex - 1)
  QuickSort(arrayData, pivotIndex + 1, endIndex)

PartitionSort(arrayData, startingIndex, endIndex)
  pivot = arrayData[endIndex]
  i = startingIndex - 1
  for j = startingIndex to endIndex - 1
    if arrayData[j] < pivot
      i = i + 1
      swap arrayData[i] and arrayData[j]
  i = i + 1
  swap arrayData[i] and arrayData[endIndex]
  return i
```
- Quick Sort in Programming Language:

- Time Complexity Comparison:
  How do the best, average and worst case time complexities compare between these two algorithms?
```plaintext
Merge Sort: Best Case: O(n log n), Average Case: O(n log n), Worst Case: O(n log n)
Quick Sort: Best Case: O(n log n), Average Case: O(n log n), Worst Case: O(n^2)

Both algorithms have the same time complexity of O(n log n) in the best and average cases. However, in the worst case of Quick Sort, the time complexity can degrade into O(n^2) while Merge Sort maintains a time complexity of O(n log n). The worst case for Quick Sort occurs when the pivot chosen is the smallest or largest element within the array, leading to an unbalanced partition and adding more time complexity.
```
- Verification of Sort Algorithms : 
```plaintext

```
