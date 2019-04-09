package cliff.ford.algorithm.sort.quick;

import cliff.ford.algorithm.sort.Sort;

/**
 * 快速排序
 * @author Cliff_Ford
 */
public class QuickSort implements Sort {

    /**
     * 排序接口
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length <= 1){
            return;
        }
        quickSort(list, 0, list.length-1);
    }

    /**
     * 默认list[low]为基准值
     * @param list 待排序的片段
     * @param low 起始位置
     * @param high 末尾位置
     */
    private void quickSort(int[] list, int low, int high) {
        int i = low;
        int j = high;
        while(i!=j && i<j){
            //找到第一个比基准值小的值
            while(j>i && list[j]>=list[i]){
                j--;
            }
            swap(list, j, i);
            //找到第一个比基准值大的值
            while(i<j && list[i]<= list[j]){
                i++;
            }
            swap(list, i, j);
        }
        if(i > low){
            quickSort(list, low, i-1);
        }
        if(j < high){
            quickSort(list, j+1, high);
        }
    }

    private void swap(int[] list, int j, int i) {
        int t = list[i];
        list[i] = list[j];
        list[j] = t;
    }
}
