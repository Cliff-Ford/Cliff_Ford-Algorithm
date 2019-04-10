package cliff.ford.algorithm.search;

public interface Search {
    /**
     *
     * @param list 待查找序列
     * @param target 待查找值
     * @return 成功返回对应索引，否则返回-1
     */
    int search(int[] list, int target);
}
