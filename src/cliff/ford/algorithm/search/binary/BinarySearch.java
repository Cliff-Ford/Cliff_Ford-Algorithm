package cliff.ford.algorithm.search.binary;

import cliff.ford.algorithm.search.Search;

/**
 * 二分查找，要求被查找序列有序
 * @author Cliff_Ford
 */
public class BinarySearch implements Search {

    /**
     * @param list   待查找序列
     * @param target 待查找值
     * @return 成功返回对应索引，否则返回-1
     */
    @Override
    public int search(int[] list, int target) {
        if(list == null || list.length == 0){
            return -1;
        }
        return binarySearch(list, target, 0, list.length-1);
    }

    private int binarySearch(int[] list, int target, int low, int high){

        int mid = (low+high) / 2;
        if(list[mid] == target){
            return mid;
        }else if(list[mid]>target && mid>low){
            return binarySearch(list, target, low, mid-1);
        }else if(list[mid]<target && mid<high){
            return binarySearch(list, target, mid+1, high);
        }
        return -1;
    }
}
