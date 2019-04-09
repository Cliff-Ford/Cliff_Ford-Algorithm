package cliff.ford.algorithm.sort.insert;

import cliff.ford.algorithm.sort.Sort;

/**
 * 插入排序
 * @author Cliff_Ford
 */
public class InsertSort implements Sort {
    /**
     * 排序接口
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length <= 1){
            return;
        }
        int len = list.length;
        for(int i = 1; i < len; i++){
            int temp = list[i];
            int j = i;
            while(j > 0){
                if(temp < list[j-1]){
                    list[j] = list[j-1];
                    j--;
                }else{
                    break;
                }
            }
            list[j] = temp;
        }
    }
}
