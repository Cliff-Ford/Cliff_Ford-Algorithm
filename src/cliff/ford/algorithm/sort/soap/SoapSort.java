package cliff.ford.algorithm.sort.soap;

import cliff.ford.algorithm.sort.Sort;

/**
 * 冒泡排序
 * @author Cliff_Ford
 */
public class SoapSort implements Sort {
    /**
     * 排序接口
     * @param list 待排序序列
     * @return list 返回已排序好的序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length == 0 || list.length == 1){
            return;
        }
        int len = list.length;
        for(int i = 0; i < len-1; i++){
            for(int j = 1; j < len-i; j++){
                if(list[j] < list[j-1]){
                    int t = list[j];
                    list[j] = list[j-1];
                    list[j-1] = t;
                }
            }
        }
    }
}
