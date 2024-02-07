# Algorithms HW 4: Mergesort & Quicksort
This assignment focuses on implementing and understanding two popular sorting algorithms: merge sort and quick sort. The tasks include writing pseudo code and actual code for both algorithms, explaining their workings through comments, comparing their time complexities in best, average, and worst-case scenarios, and finally, verifying the correctness of the implementations using a provided file.

## Details

### Merge Sort Explanation:

### Merge Sort in Programming Language:
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
  
- Quick Sort Explanation:

- Quick Sort in Programming Language:

- Time Complexity Comparison:
  How do the best, average and worst case time complexities compare between these two algorithms?
  
- Verification of Sort Algorithms : 
Use the uploaded file to verify your sort algorithms are working. numbers-4.txt Download numbers-4.txt  What is the position of 90262? What is the position of 11559?
