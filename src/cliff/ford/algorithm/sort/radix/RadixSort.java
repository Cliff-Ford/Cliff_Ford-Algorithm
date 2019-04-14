package cliff.ford.algorithm.sort.radix;
import cliff.ford.algorithm.sort.Sort;
import java.util.Arrays;

/**
 * 基数排序，桶排序的升级
 * @author Cliff_Ford
 */
public class RadixSort implements Sort {

    /**
     * 排序接口
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length <= 1){
            return;
        }
        //找出最大值
        int max = list[0];
        int len = list.length;
        for(int i = 1; i < len; i++){
            if(list[i] > max){
                max = list[i];
            }
        }
        //基数排序的轮数由最大值的数字个数决定
        int rounds = String.valueOf(max).length();

        for(int i = 0; i < rounds; i++){
            //每一轮都用新的桶
            int[][] buckets = new int[10][0];
            //为桶分配数据，作为一轮排序
            for(int var : list){
                int index = (int)(var / (Math.pow(10, i))) % 10;
                buckets[index] = Arrays.copyOf(buckets[index], buckets[index].length+1);
                buckets[index][buckets[index].length-1] = var;
            }
            //第一轮排序后，更新list的值
            int index = 0;
            for(int[] bucket : buckets){
                if(bucket.length > 0){
                    for(int var : bucket){
                        list[index++] = var;
                    }
                }
            }
        }
    }
}
