package cliff.ford.data.structure.hashtable;

import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class HashTableTest {
    @Test
    public void test(){
        HashTable hashTable = new HashTable();
        hashTable.push(5);
        System.out.println(hashTable.get(5).val);
        hashTable.push(17);
        System.out.println(hashTable.pop(4));
        System.out.println(hashTable.pop(17).val);
        hashTable.change(5,6);
        System.out.println(hashTable.pop(6).val);
    }
}
