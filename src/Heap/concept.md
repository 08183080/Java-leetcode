# 堆(heap)
heap is a kind of data structure.

堆类似于完全二叉树.

堆有两种: 最大堆、最小堆

堆的增删查改

堆的实现?

arr[i] > left: arr[2*i+1]

arr[i] > right: arr[2*i+2]

arr[i] > parent: arr[(i-1)/2]

增: 把元素添加到数组的最后一个,然后将其浮上去,保证满足堆的性质

删: 把最后一个元素和根部的元素交换,删除最后的,浮动新的根

查:

改: 

heapify


