# Algorithms HW 4: Mergesort & Quicksort

## Details
1. Write in pseudo code a merge sort algorithm that works over an array. Comment to explain the algorithm.

  MergeSort(array, leftIndex, rightIndex) //This takes the Array & indexs
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
        increment i++
      else
        array[k] = rightArray[j]
        increment j++
      increment k++
    copy remaining elements of leftArray and rightArray if any

3. Write in the programming language of your choice a merge sort algorithm that works over an array. Comment to explain the algorithm.

4. Write in pseudo code a quick sort algorithm that works over an array. Comment to explain the algorithm.

5. Write in the programming language of your choice a quick sort algorithm that works over an array. Comment to explain the algorithm.

6. How do the best, average, and worst-case time complexities compare between these two algorithms? 

7. Use the uploaded file to verify your sort algorithms are working. numbers-4.txt.  What is the position of 90262? What is the position of 11559? 
