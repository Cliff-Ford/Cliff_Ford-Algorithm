package cliff.ford.algorithm.sort.count;

import cliff.ford.algorithm.sort.Sort;

/**
 * 计数排序
 * @author Cliff_Ford
 */
public class CountSort implements Sort {
    /**
     * 排序接口
     *
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length <= 1){
            return;
        }
        //找出最大值
        int max = list[0];
        for(int i = 1, len = list.length; i < len; i++){
            if(list[i] > max){
                max = list[i];
            }
        }
        //临时数组保存每个不同元素出现的次数，并且索引顺序即为值的排序结果
        int[] temp = new int[max+1];
        for(int t : list){
            temp[t]++;
        }
        //覆盖
        int j = 0;
        for(int i = 0, len = max+1; i < len; i++){
            while(temp[i] > 0){
                list[j] = i;
                temp[i]--;
                j++;
            }
        }
    }
}
