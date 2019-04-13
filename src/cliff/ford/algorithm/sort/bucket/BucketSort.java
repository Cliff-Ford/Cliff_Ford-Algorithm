package cliff.ford.algorithm.sort.bucket;

import cliff.ford.algorithm.sort.Sort;
import cliff.ford.algorithm.sort.count.CountSort;

import java.util.Arrays;

/**
 * 桶排序,计数排序的升级版
 * @author Cliff_Ford
 */
public class BucketSort implements Sort {

    /**
     * 排序接口
     *
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length == 0 || list.length == 1){
            return;
        }
        int max = list[0];
        int min = list[0];
        for(int i = 1, len = list.length; i < len; i++){
            if(list[i] > max){
                max = list[i];
            }
            if(list[i] < min){
                min = list[i];
            }
        }
        //预期每个桶的大小
        int bucketSize = 4;
        //预期桶的数目
        int bucketNum = (int)Math.floor((max-min)/bucketSize) + 1;
        int[][] buckets = new int[bucketNum][0];
        //遍历，将每个数扔进一个桶里面
        for (int cur : list) {
            int index = (cur - min) / bucketSize;
            buckets[index] = Arrays.copyOf(buckets[index], buckets[index].length+1);
            buckets[index][buckets[index].length-1] = cur;
        }
        //每一个桶内的元素进行排序
        Sort countSort = new CountSort();
        for(int[] l : buckets){
            if(l.length > 1){
                countSort.sort(l);
            }
        }
        //覆盖
        int i = 0;
        for(int[] l : buckets){
            for(int t : l){
                list[i] = t;
                i++;
            }
        }
    }
}
