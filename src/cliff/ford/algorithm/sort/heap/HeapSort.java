package cliff.ford.algorithm.sort.heap;

import cliff.ford.algorithm.sort.Sort;

/**
 * 堆排序
 * @author Cliff_Ford
 */
public class HeapSort implements Sort {
    /**
     * 排序接口
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length <= 1){
            return;
        }

        for(int i = list.length; i > 1; i--){
            //初始化为大根堆
            initToBigHeap(list, i);
            //将最大值放到最后
            swap(list, 0, i-1);
        }
    }

    private void initToBigHeap(int[] list, int length) {
        if(list == null || length <= 1){
            return;
        }
        int end = length / 2 - 1;
        for(int i = end; i >= 0; i--){
            //有两个孩子
            if((i*2+2) < length){
                if(list[i] >= list[i*2+1] && list[i] >= list[i*2+2]) {
                    continue;
                }
                int j = indexToWhichIsMax(list, i*2+1, i*2+2);
                //可能破坏了之前的大根堆结构
                swap(list, i, j);
                initToBigHeap(list, length);
            }else{
                //只有一个孩子
                if(list[i] < list[i*2+1]){
                    swap(list, i, i*2+1);
                    //可能破坏了之前的大根堆结构
                    initToBigHeap(list, length);
                }
            }
        }
    }

    private void swap(int[] list, int i, int j) {
        int t = list[i];
        list[i] = list[j];
        list[j] = t;
    }

    private int indexToWhichIsMax(int[] list, int i, int j){
        return list[i] > list[j] ? i : j;
    }

}
