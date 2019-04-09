package cliff.ford.algorithm.sort.merge;

import cliff.ford.algorithm.sort.Sort;

/**
 * 归并排序
 * @author Cliff_Ford
 */
public class MergeSort implements Sort {
    /**
     * 排序接口
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length <= 1){
            return;
        }
        int[] temp = new int[list.length];
        mergeSort(list, temp, 0, list.length-1);
    }
    private void mergeSort(int[] list, int[] temp, int start, int last){
        if(start != last){
            mergeSort(list, temp, start, start+(last-start+1)/2-1);
            mergeSort(list, temp, start+(last-start+1)/2, last);
        }
        merge(list, temp, start, last);
    }

    private void merge(int[] list, int[] temp, int start, int last) {
        //片段内只有一个元素的直接返回
        if(start == last){
            temp[start] = list[start];
            return;
        }
        int i = start;
        //简单的mid=last/2求得的值并不是该片段的中点
        int mid = start+(last-start+1)/2-1;
        int j = mid+1;
        int k = start;
        //选择最小的写进temp
        while(i<=mid && j<=last){
            if(list[i] <= list[j]){
                temp[k] = list[i];
                i++;
            }else{
                temp[k] = list[j];
                j++;
            }
            k++;
        }
        //将未写入temp的片段完整写进去
        if(i > mid){
            while(j <= last){
                temp[k] = list[j];
                j++;
                k++;
            }
        }else{
            while(i <= mid){
                temp[k] = list[i];
                i++;
                k++;
            }
        }
        //复制到list中
        System.arraycopy(temp, start, list, start, last + 1 - start);
    }
}
