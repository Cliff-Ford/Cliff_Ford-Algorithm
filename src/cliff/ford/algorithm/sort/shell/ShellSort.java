package cliff.ford.algorithm.sort.shell;

import cliff.ford.algorithm.sort.Sort;

/**
 * 希尔排序，插入排序的增强版
 * @author Cliff_Ford
 */
public class ShellSort implements Sort {

    /**
     * 排序接口
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length == 0 || list.length == 1){
            return;
        }
        int len = list.length;
        int shellVal = 2;
        //gap是一个间隔量，不断缩小的间隔量，至到gap=1是最后一轮插入排序
        for(int gap = len / shellVal; gap > 0; gap /= shellVal){
            for(int i = gap; i < len; i++){
                int j = i;
                while(j-gap>=0 && list[j-gap]>list[j]){
                    int t = list[j-gap];
                    list[j-gap] = list[j];
                    list[j] = t;
                    j = j - gap;
                }
            }
        }
    }
}
