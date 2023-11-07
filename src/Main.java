import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

enum Color {
    RED, GREEN, BLUE
}


class ThreadPoolExample implements Runnable {

    private AtomicInteger count = null;
    private CountDownLatch latch = null;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try {
            // Thread.sleep(2);
            latch.countDown();
            print(String.format("Thread: %s, Index: %d, %d, countDown: %d", threadName, count.addAndGet(1), System.currentTimeMillis(), latch.getCount()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    ThreadPoolExample(AtomicInteger count, CountDownLatch latch) {
        this.count = count;
        this.latch = latch;
    }

    ThreadPoolExample() {
    }

    void print(String msg) {
        System.out.println(msg);
    }

}


public class Main {
    private static int count = 0;

    private boolean isPower2N(int N) {
        Set table = generate_power2_set();
        String cur_sorted_string = convert_2_sorted_str(N);
        if (table.contains(cur_sorted_string)) {
            return true;
        }
        return false;
    }

    private String convert_2_sorted_str(int N) {
        char[] arr = String.valueOf(N).toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    private Set generate_power2_set() {
        Set result = new HashSet<>();
        for (int i = 0; i < 31; ++i) {
            char[] mid_array = String.valueOf((1 << i)).toCharArray();
            Arrays.sort(mid_array);
            result.add(String.valueOf(mid_array));
        }
        return result;
    }

    private static boolean havReorderedPower2N(int i, int j, char[] arr) {
        if (j < 1) {
            return false;
        }
        if (i == j) {
            count += 1;
            Long cur = Long.valueOf(String.valueOf(arr));
            if (cur == 2147483648L) {
                print("find : " + cur);
            }
            if (isPowered2Num(cur)) {
                print("2 OK:" + cur);
                return true;
            }
        }
        for (int jj = i; jj < j; ++jj) {
            swap(i, jj, arr);
            boolean r = havReorderedPower2N(i + 1, j, arr);
            if (r) {
                return r;
            }
            swap(i, jj, arr);
        }
        return false;
    }

    private static void print(Object v) {
        System.out.println(v.toString());
    }

    private static void swap(int i, int j, char[] arr) {
        char tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    @Test
    public void TestStr() {
        String r = "abc";
        String p0_0 = r.substring(0, 0);
        String p0_1 = r.substring(0, 1);
        String p0_3 = r.substring(0, 3);

        print(String.format("raw: %s, p0_0: [%s], p0_1: [%s], p0_3: [%s]", r, p0_0, p0_1, p0_3));
    }

    private static boolean isPowered2Num(long v) {
        if ((v & (v - 1)) == 0) {
            return true;
        }
        return false;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        post_traversal(root, list);
        return list;
    }

    private void post_traversal(Node root, List<Integer> list) {
        if (root != null) {
            if (root.children.size() > 0) {
                for (Node item : root.children) {
                    post_traversal(item, list);
                }
            }
            list.add(root.val);
        }
    }

    public void parse() {
        print(Integer.MIN_VALUE + " : " + Integer.MAX_VALUE);
        String s = "abc";
        s.charAt(0);
        Long a = 0L;
        a.intValue();
        StringBuffer sf = new StringBuffer();
        Map m = new HashMap<String, Integer>();
        ((Integer) Integer.MAX_VALUE).toString().length();
        Integer v = Integer.parseInt("-2147483646");
    }

    private void TestLong() {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean ok = false;
        for (int i = 0; i < 10; ++i) {
            ok = queue.offer(i);
            print("status: " + ok);
        }

        Integer curVal = 0;
        while (!queue.isEmpty()) {
            curVal = queue.poll();
            if (curVal != null) {
                print("poll value:" + curVal);
            }
        }

        // int n = 10;
        // int[][] array = new int[n][];
        // int[] single = new int[5];

        List<Integer> list = new ArrayList<>();
        int a = 0;
        list.add(a);
        a = 2;
        list.add(0, a);

        for (Integer v : list) {
            print("v: " + v);
        }

        Set<Integer> set = new HashSet<Integer>();

        set.add(1);
        set.add(3);
        boolean set_r = set.contains(1);
        Character c = 'A';
        boolean is_v = c >= 'A' && c <= 'Z';

        for (Integer set1 : set) {
            print("set value: " + set1);
        }

        String splitRaw = "a11b1c11";

        String[] arraysplit = splitRaw.split("1", 4);
        print(Arrays.toString(arraysplit));

        arraysplit = splitRaw.split("1", -1);
        print(Arrays.toString(arraysplit));

        arraysplit = splitRaw.split("1", 0);
        print(Arrays.toString(arraysplit));


        Long vLong = 9L;
        int vInt = Long.valueOf(vLong).intValue();

        print(String.format("vLong: %d, int: %d", vLong, vInt));

    }

    @Test
    public void TestSingleChar() {
        char a = 'a';
        char b = 'b';
        char c = 'b';

        int r = ((a) ^ (b) ^ (c));
        String s = "abc";
        s.indexOf('a');
        print(r + " " + (char) r);

        String t = "def";

        String v = s.concat(t);
        print("s.concat(t) = : " + v);

        char[] array = {'2', '1', '4'};
        List tList = new ArrayList();
        // v.toCharArray();

        Integer vi1 = 1;
        Integer vi2 = 1;

        print("vi1: " + vi1 + " vi2: " + vi2);

        if (vi1 == vi2) {
            print("vi1 == vi2 ");
        }

        if (vi1.equals(vi2)) {
            print("vi1 equals vi2 ");
        }

    }

    @Test
    public void testQueueOfLinkedList() {
        Queue<Integer> queue = new LinkedList<>();
        queue.isEmpty();
        queue.add(0);
        queue.poll();

        List<Integer> list = new ArrayList<>();
        if (!list.isEmpty()) {
            list.get(0);
        }
    }

    @Test
    public void testLinkedList() {
        List<Integer> list = new LinkedList<>();
        Integer[] array = {1, 2, 3};
        list.addAll(Arrays.asList(array));


        List<Integer> listForAdd = new LinkedList<>();
        int j = 0;
        int bound = j + 10;
        for (; j < bound; ++j) {
            listForAdd.add(j, j);
        }

        print(String.format("list with add(index, val): %s", listForAdd));

        String[] key = {"redisKey"};
        List<String> listAs = Arrays.asList(key);
        print(listAs);
    }

    @Test
    public void testBitSet() {
        BitSet bitSet63 = new BitSet(63);
        Assert.assertEquals(64, bitSet63.size());
        BitSet bitSet65 = new BitSet(65);
        Assert.assertEquals(128, bitSet65.size());

        BitSet bitSet = new BitSet(64);
        Assert.assertEquals(64, bitSet.size());

        print("bitSet.size: " + bitSet.size());
        bitSet.set(0);
        bitSet.get(0);
        bitSet.clear(0);
        // return;
        bitSet.clear(0, 0);
        // clear 1 position
        bitSet.clear(0, 1);
        bitSet.size();
        bitSet.flip(0);

        for (int i = 0; i < bitSet.size(); ++i) {
            print(" " + i + ":" + bitSet.get(i));
        }
    }

    @Test
    public void testArrayList() {
        int m = 10;
        List<Integer> list = new ArrayList<>(m);

        for (int i = m - 1; i >= 0; --i) {
            list.add(0, i);
        }

        print(String.format("V1: array: %s, size: %d", Arrays.toString(list.toArray()), list.size()));
        print(String.format("V2: array: %s, size: %d", list.toString(), list.size()));

        Integer[] array = new Integer[3];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;

        boolean b = list.contains(0);
        assert b == true;

        //1: array -> list
        List<Integer> listBak = Arrays.asList(array);
        print(String.format("Array to List: %s", listBak.toString()));

        //2: list -> array
        Integer[] arrayBak = new Integer[list.size()];
        list.toArray(arrayBak);

        print(String.format("List to Array: %s", Arrays.toString(arrayBak)));

        List<Integer> listAddArray = new ArrayList<>();
        Integer[] nArray = {0, 1, 2};
        listAddArray.addAll(Arrays.asList(nArray));

        print("list addAll for [array -> list]" + listAddArray.toString());

        Long lItem = Long.MAX_VALUE;
        int i = lItem.intValue();

        print(String.format("long: %d, int: %d", lItem, i));

        // reverse order
        /*
        Arrays.sort(nArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        */

        // Integer[] tArray = {1, 2, 3, 4};
        Arrays.sort(nArray, (Integer a1, Integer b1) -> (b1 - a1));
        Arrays.sort(nArray, (a1, b1) -> (b1 - a1));
        print("nArray: after reverse sort: " + Arrays.toString(nArray));

        int[] tArray = {1, 2, 3, 4};
        // Arrays.sort(tArray, (a1, b1)->{b1-a1;});
        print("nArray: after reverse sort: " + Arrays.toString(tArray));

        List<Integer> sortedList = new ArrayList<>();
        Integer[] arraySorted = {1, 2, 3};
        sortedList.addAll(Arrays.asList(arraySorted));
        Collections.sort(sortedList, Collections.reverseOrder());

        print(String.format("original: %s, reverse: %s", Arrays.toString(arraySorted), sortedList));

        List<Integer> removeList = new ArrayList<>();

        for (int j = 0; j < 4; ++j) {
            removeList.add(j);
        }

        print(String.format("[1] Test Remove: original: %s", removeList));

        for (int j = 0; j < 4; ++j) {
            removeList.remove(Integer.valueOf(j));
        }

        print(String.format("[2] Test Remove: original: %s", removeList));
    }

    @Test
    public void testArraysSort() {
        // part 1
        int m = 10, n = 2, base = 100;
        int[][] matrix = new int[m][];
        for (int i = 0; i < m; ++i) {
            matrix[i] = new int[n];

            for (int j = 0; j < n; ++j) {
                matrix[i][j] = base - j;
                base -= j;
            }
        }

        print("Original:");
        for (int i = 0; i < m; ++i) {
            print(Arrays.toString(matrix[i]));
        }

        // part 2;

        Arrays.sort(matrix, (a, b) -> (a[0] - b[0]));
        print("Sorted:");
        for (int i = 0; i < m; ++i) {
            print(Arrays.toString(matrix[i]));
        }
    }

    @Test
    public void testListSubList() {
        List<Integer> list = new LinkedList<>();
        Integer[] array = {0,1,2,4};
        list.addAll(Arrays.asList(array));
        List<Integer> subList = list.subList(0, Math.min(2, array.length));

        print(String.format("subList: %s", subList));
    }

    @Test
    public void testForEach() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; ++i) {
            list.add(i);
        }

        // List can use for-each output content.
        int index = 0;
        for (int v : list) {
            print(String.format("[%d]: %d", index++, v));
        }
    }

    @Test
    public void testSplitOfStringWithMultiDelimiter() {
        String raw = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String delimiter = "[ !?',;.]";

        String[] items = raw.split(delimiter);

        for (String item : items) {
            if (item.length() > 0) {
                print(item.toLowerCase());
            }
        }
    }

    @Test
    public void testBubbleSort() {
        int[] data = {1, 5, 4, 2, 7, 3};

        for (int i = 0; i < data.length; ++i) {
            System.out.printf("%d\t", data[i]);
        }
        System.out.println();

        int tmp = 0;
        for (int j = data.length - 1; j > 0; --j) {

            for (int i = 0; i < j; ++i) {
                if (data[i] > data[i + 1]) {
                    tmp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < data.length; ++i) {
            System.out.printf("%d\t", data[i]);
        }
        print("");
    }

    @Test
    public void testBytes() {
        Character character = '\0';
        String msg = "rem人民";
        for (int i = 0; i < msg.length(); ++i) {
            character = msg.charAt(i);
            print(String.format("char: %c, bytes: %d", character, character.toString().getBytes().length));
        }
    }

    public String[] GetUncommonList() {
        String str1 = "this is a dog";

        String[] list1 = str1.split(" ");
        String[] list2 = str1.split(" ");
        Map<String, Integer> m = new HashMap<>();

        for (String s : list1) {
            m.put(s, 1);
        }

        for (String s : list2) {
            if (m.containsKey(s)) {
                m.put(s, 2);
            } else {
                m.put(s, 1);
            }
        }

        List result = new ArrayList<String>();
        for (String k : m.keySet()) {
            Integer v = m.get(k);
            if (v == 1) {
                result.add(k);
            }
        }

        return (String[]) result.toArray();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] results = new int[nums1.length];
        // List<Integer> N = Arrays.asList(results);
        // for (int i: nums1) {
        //     int index = nums2.
        // }
        //
        // synchronized ()

        Set s = new HashSet<Integer>();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        return results;
    }

    @Test
    public void testQueue() {
        Queue queue = new ArrayBlockingQueue<Integer>(10);
        Integer v = 10;
        queue.offer(v);
        queue.poll();

        Queue<Integer> q = new LinkedList<>();
        q.isEmpty();
        q.add(1);
        int removeItem = q.remove();
        print("removeItem: " + removeItem);
    }

    @Test
    public void testSet() {
        char c = 65;
        System.out.println("c = " + c);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 2);
        map.put(2, 4);
        map.put(5, 4);
        map.put(6, 4);

        Integer[] store = map.keySet().toArray(new Integer[0]);

        for (int i = 0; i < store.length; ++i) {
            print(String.format("i: %d, val: %s", i, store[i]));
        }
    }

    @Test
    public void testEnum() {
        Color[] values = Color.values();

        for (Color item : values) {
            print(String.format("%d %s", item.ordinal(), item.toString()));
        }
    }

    @Test
    public void testArray() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        Integer[] nums = list.toArray(new Integer[0]);

        print(Arrays.toString(nums));
        Integer[] array = new Integer[list.size()];
        list.toArray(array);

        for (int i = 0; i < array.length; ++i) {
            print(String.format("[%d]:[%d]", i, array[i]));
        }

        print(String.format("list.size: %d", list.size()));
    }

    @Test
    public void testSortedMap() {
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.put(20, 20);
        sortedMap.put(1, 10);
        sortedMap.put(2, 4);
        sortedMap.put(0, 0);
        // < key; [)
        String headVal = sortedMap.headMap(1).toString();
        // >= key [
        String tailVal = sortedMap.tailMap(1).toString();

        print(String.format("head: %s, tail: %s", headVal, tailVal));

        String headValNull = sortedMap.headMap(-1).toString();
        print(String.format("Not Find key: [%s]", headValNull));

        Assert.assertNotEquals("headValNull is null", null, headValNull);
        Assert.assertEquals("headValNull length is 0", "{}", headValNull);

        sortedMap.lastKey();
        sortedMap.firstKey();
    }

    @Test
    public void testIntegerEqual() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            list.add(0, i);
            list.add(i);
        }

        print("list: " + list);
        int last = list.size() - 1;
        boolean b = list.get(0) == list.get(last);

        Integer b1 = -5;
        Integer b2 = -5;

        print(String.format("val: %b, b2: %b", b, b1 == b2));

        for (int i = 0, j = list.size() - 1; i < j; ++i, --j) {
            if (list.get(i) != list.get(j)) {
                print(String.format("v1: %d, v2: %d", list.get(i), list.get(j)));
            }
        }

        Integer valueOfInt = Integer.valueOf(10);
        Assert.assertEquals(10, valueOfInt.intValue());
        print(String.format("valueOfInt: %d", valueOfInt));

        // return result is int
        Integer.parseInt("123");
    }

    @Test
    public void testSortedSet() {
        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (int i = 10; i >= 5; --i) {
            sortedSet.add(i);
        }

        int idx = 0;
        for (int key : sortedSet) {
            print(String.format("%d: %d", idx++, key));
        }

        int first = sortedSet.first();
        int last = sortedSet.last();
        print(String.format("first: %d, last: %d", first, last));

        boolean r = sortedSet.remove(first);
        Assert.assertTrue(r);

    }

    @Test
    public void testCollectionsSort() {
        List<List<Integer>> store = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 4; i > 0; --i) {
            row.add(i);
        }

        List<Integer> row1 = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            row1.add(i);
        }

        store.add(row);
        store.add(row1);

        print(String.format("before sorted: %s", store));

        Collections.sort(store, (a, b)->{
            for (int i = 0; i < a.size(); ++i) {
                if (a.get(i) < b.get(i)) {
                    return -1;
                }

                if (a.get(i) > b.get(i)) {
                    return 1;
                }
            }

            return 0;
        });

        print(String.format("after sorted: %s", store));

    }

    @Test
    public void test2DArraySort() {
        int[][] grid = {{1,5},{2,3},{3,7}, {4,4}};

        // asc sort [1]
        Arrays.sort(grid, (a, b)->(a[1]-b[1]));

        for (int i = 0; i < grid.length; ++i) {
            print(String.format("%d: %s", i, Arrays.toString(grid[i])));
        }

        // desc sort [1]
        Arrays.sort(grid, (a, b)->(b[1]-a[1]));

        for (int i = 0; i < grid.length; ++i) {
            print(String.format("%d: %s", i, Arrays.toString(grid[i])));
        }

        Integer[] array = {1, 2, 4, 3, 7};
        print(String.format("original: %s", Arrays.toString(array)));
        // Arrays.sort(array, (a, b)->(b-a));
        // Arrays.sort(array, (a, b)->{return b - a;});
        Arrays.sort(array, Collections.reverseOrder());
        print(String.format("after   : %s", Arrays.toString(array)));
    }

    @Test
    public void testDeque() {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < 3; ++i) {
            deque.addFirst(i);
            deque.addLast(i);
        }

        for (int i = 0; i < 3; ++i) {
            deque.addFirst(7);
        }

        for (int i = 0; i < 3; ++i) {
            deque.addLast(9);
        }


        print(String.format("deque: %s", deque));

        int index = 0;
        while (!deque.isEmpty()) {
            int v = deque.pollFirst();
            print(String.format("[%d]: %d", index++, v));
        }

    }

    @Test
    public void testCopyOfRange() {
        int[] array = {1,2,3,4,5};

        int[] p1 = Arrays.copyOfRange(array, 0, 3);
        int[] p2 = Arrays.copyOfRange(array, 3, array.length);

        print(String.format("p1: %s, p2: %s", Arrays.toString(p1), Arrays.toString(p2)));
    }

    @Test
    public void testTreeMap() {
        SortedMap<Integer, Character> map = new TreeMap<>();
        for (int i = 5; i >= 0; --i) {
            map.put(i, (char) ('a' + 1));
        }

        print(String.format("first: %d, last: %d", map.firstKey(), map.lastKey()));
    }

    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        String raw = "abcd";
        sb.append(raw);
        sb.append(raw);

        sb.deleteCharAt(0);
        sb.delete(0, 1);

        sb.insert(0, 0);
        print("value: " + sb.toString());

        sb.delete(0, sb.length());
        int[] array = {0, 1, 2, 3};
        sb.append(Arrays.toString(array));

        print("append.array: " + sb.toString());

        sb.delete(0, sb.length());
        for (int i = 0; i < 5; ++i) {
            sb.append(String.valueOf('a' + i));
        }

        for (int i = 0; i < 5; ++i) {
            sb.append(String.valueOf(900 + i));
            sb.append(",");
        }

        print("String.valueOf(char): " + sb.toString());
    }

    @Test
    public void testStack() {
        Stack<Integer> stack = new Stack<>();
        int m = 5;
        for (int i = 0; i < m; ++i) {
            stack.push(i);
        }

        for (int i = 0; i < m; ++i) {
            print(String.format("i: %d, search-return: %d", i, stack.search(Integer.valueOf(i))));
        }

        int index = 0;
        while (!stack.empty()) {
            print(String.format("[%d]: %d", index++, stack.pop()));
        }
    }

    @Test
    public void testIteratorOfArrayListToDelete() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 4; ++i) {
            list.add(i);
        }

        print("original: " + list.toString());

        Integer[] ints = {1, 2, 3};
        int a = 0;
        Integer[] intsNew = {a, a + 1, a + 2};
        print("intsNew:" + Arrays.toString(intsNew));


        List<Integer[]> listArray = new ArrayList<>();

        listArray.add(ints);
        listArray.add(ints);

        listArray.add(new Integer[]{a, a + 1, a + 100});

        Iterator<Integer[]> it = listArray.iterator();

        Integer[] v = null;
        while (it.hasNext()) {
            v = it.next();
            if (v.length == 0) {
                it.remove();
            }

            print("val:" + Arrays.toString(v));
        }

        print("last: " + listArray.toString());
    }

    @Test
    public void testString() {
        String rawWithSpace = " a bc  ed f    ".trim();
        String[] splitArray = rawWithSpace.split(" ", 3);
        Assert.assertEquals(3, splitArray.length);

        int index = 0;
        for (String v: splitArray) {
            print(index++ + ":[" + v.trim() + "] " + v.length());
        }

        String alphabet = "12ad34";
        String lower = alphabet.toLowerCase();
        String toUpper = alphabet.toUpperCase();
        String pre = alphabet.intern();

        String raw = "abcd";
        StringBuffer sb = new StringBuffer(raw);
        sb.setCharAt(0, 'x');
        sb.delete(0, sb.length());
        sb.append(raw);

        print("value: " + sb.toString());

        int v = "abc".compareTo("bcd");
        print("compareto v:" + v);

        sb.delete(0, sb.length());

        sb.append(0);
        boolean isEqual = sb.toString().equals("0");
        print("isEqual: " + isEqual);
        isEqual = sb.equals(0);
        print("isEqual: " + isEqual);

        String v1 = "abc";
        String v2 = String.valueOf('c');
        print(String.format("v1: %s, v2: %s", v1, v2));

        v1 = "  a B C d Efa  ";

        v1.toLowerCase();
        v1.toUpperCase();

        StringBuilder v1Sb = new StringBuilder(v1);
        String v1Trim = v1Sb.toString().trim();

        print(String.format("v1Sb: %s, v1Trim: [%s]", v1Sb, v1Trim));

    }

    @Test
    public void testSortString() {
        String[] array = {"e!=b", "a==b"};
        print("V1: " + Arrays.toString(array));
        Arrays.sort(array);
        print("V2: " + Arrays.toString(array));

    }

    @Test
    public void testBooleanArray() {
        int n = 5;
        boolean[] bArray = new boolean[n];
        print(String.format("default boolean array content: %s", Arrays.toString(bArray)));
    }

    @Test
    public void testStringBuilderV2() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; ++i) {
            sb.append(i);
        }

        print(String.format("content: %s", sb.toString()));
    }

    @Test
    public void subStringByBytes() {
        String singleCharStr = "A";
        Assert.assertTrue(singleCharStr.getBytes().length == 1);

        String singleChineseCharStr = "汉";
        Assert.assertTrue(singleChineseCharStr.getBytes().length == 3);

        String str = "人124民";
        int nBytes = str.getBytes().length;
        int len = 7;
        // 字符类型判断
        int m = str.length();
        char[] array = str.toCharArray();
        int curSum = 0;

        final int nChineseBytes = "人".getBytes().length;
        final int normalCharBytes = "a".getBytes().length;

        int i = 0;
        for (; i < m; ++i) {
            if (isChinese(array[i])) {
                curSum += nChineseBytes;
            } else {
                curSum += normalCharBytes;
            }

            if (curSum >= len) {
                break;
            }
        }

        if (i < m) {
            i += 1;
        }

        String result = str.substring(0, i);

        print(String.format("raw: %s, result: %s, len: %d, nBytes: %d", str, result, len, nBytes));

        String strChinese = "人";
        String strChar = "a";

        print(String.format("raw: %s, nbytes: %d; char: %s, nbytes: %d", strChinese, strChinese.getBytes().length, strChar, strChar.getBytes().length));
    }

    public boolean isChinese(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }

    @Test
    public void testListArray() {
        int n = 2;
        List<Integer>[] nodesList = new ArrayList[n];

        for (int i = 0; i < nodesList.length; ++i) {
            nodesList[i] = new ArrayList<>();

            nodesList[i].add(i);
            nodesList[i].add(i);
            nodesList[i].add(i);

            print(nodesList[i].toString());
        }
    }

    @Test
    public void isChineseBak() {
        char c = '人';
        boolean b = String.valueOf(c).matches("[\u4e00-\u9fa5]");

        print(String.format("char: %c, boolean: %b", c, b));
    }

    @Test
    public void testInteger() {
        int i = 5;
        Integer I = Integer.valueOf(i);
        print(String.format("i: %d, I: %d", i, I));
        I.intValue();
        I.hashCode();
        I.shortValue();
        I.floatValue();
        I.longValue();
        I.doubleValue();
    }

    @Test
    public void testListArrayAndArrayList() {
        // 1. List<Array>
        List<Integer[]> listArray = new LinkedList<>();

        listArray.add(0, new Integer[1]);
        listArray.set(0, new Integer[5]);

        // print
        for (int i = 0; i < listArray.size(); ++i) {
            print(String.format("ListArray [%d]: %s", i, Arrays.toString(listArray.get(i))));
        }

        int m = 4;
        int n = 5;
        int v = 0;
        Integer[] row = null;
        for (int i = 0; i < m; ++i) {
            row = new Integer[n];
            // listArray.set(i, row);
            listArray.add(i, row);

            for (int j = 0; j < n; ++j) {
                row[j] = v;
            }

            v += 1;
        }

        // print
        for (int i = 0; i < m; ++i) {
            print(String.format("ListArray [%d]: %s", i, Arrays.toString(listArray.get(i))));
        }

        //2. Array[List]
        int size = 5;
        List<Integer>[] arrayList = new LinkedList[size];
        int columns = 4;
        for (int i = 0; i < size; ++i) {
            arrayList[i] = new LinkedList<>();

            for (int j = 0; j < columns; ++j) {
                arrayList[i].add(v);
            }

            v += 1;
        }

        for (int i = 0; i < size; ++i) {
            print(String.format("ArrayList [%d]: %s", i, arrayList[i]));
        }

        Integer r = new Integer(0);
        r.intValue();
    }

    @Test
    public void testReverseStack() {
        Stack<Integer> stack = new Stack<>();
        int n = 9;
        for (int i = 1; i <= n; ++i) {
            stack.push(i);
        }
        // gLobalIndex = stack.size();
        if ((n & 1) == 0) {
            print("Reverse Stack order output:");
            reverseOutputStack(stack, stack.size());
        } else {
            print("Normal Stack order output:");
            while (!stack.empty()) {
                print(stack.pop());
            }
        }
    }

    // int gLobalIndex = 1;

    void reverseOutputStack(Stack<Integer> stack, int index) {
        if (index == 1) {
            assert stack.size() == 1;
            print(stack.pop());
            // gLobalIndex += 1;
            return;
        } else {
            int v = stack.pop();
            reverseOutputStack(stack, index - 1);
            print(v);
        }
    }

    @Test
    public void testSetList() {
        Set<List<Integer>> listSet = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            list1.add(i);
            list2.add(i);
        }

        boolean b1 = listSet.add(list1);
        boolean b2 = listSet.add(list2);

        print(String.format("b1: %b, b2: %b", b1, b2));

        Assert.assertEquals(b1, true);
        Assert.assertEquals(b2, false);
    }

    @Test
    public void testRandom() {
        int seeds = 5;
        int bound = 3;

        Random random = new Random(seeds);

        for (int i = 0; i < 4 * bound; ++i) {
            print(String.format("%02d: %d", i, random.nextInt(bound)));
        }

        Assert.assertEquals(0, 0);
    }

    @Test
    public void testFormat() {
        String r1 = String.format("%d %b", 100L, true);
        print(r1);
        Assert.assertEquals(r1.length(), 8);
    }

    public static void main(String[] args) {
        Main ins = new Main();

        // ins.TestQueue();
        // ins.TestStr();
        // ins.TestSingalChar();
        ins.TestLong();
        // ins.testPuppletSort();
        // ins.testSetValue();
        // ins.testEnum();
        // ins.testArray();
        System.exit(0);

        // Map tables = new HashMap<Integer, Integer>();
        // tables.get()
        // Long v = Long.valueOf("2147483648");
        /*
        Long v = Long.valueOf("4583167");
        print(v);
        char [] arr = String.valueOf(v).toCharArray();
        boolean r = havReorderedPower2N(0, arr.length, arr);
        print("main: "+ v + " count: " + count);
        */

        /*
        ins.parse();
        int test_arr[] = new int[]{1, 2, 4, 8, 16, 4096, 1280};
        for (int i = 0; i < test_arr.length; ++i) {
            boolean v = ins.isPower2N(test_arr[i]);
            print("v: [" + v + "] src: " + test_arr[i]);
        }
        */
    }

    @Test
    public void testLowBit() {
        int n = 10;
        int v1 = 0, v2 = 0;
        for (int i = 0; i < n; ++i) {
            v1 = lowBitV1(i);
            v2 = lowBitV2(i);
            print(String.format("[%d] v1: %d, v2: %d", i, v1, v2));
            assert v1 == v2;
            Assert.assertEquals(v1, v2);
        }
    }

    int lowBitV1(int n) {
        return n & (~n + 1);
    }

    int lowBitV2(int n) {
        return n & (-n);
    }

    @Test
    public void testThreadPool() {
        // 阻塞队列
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
        // 饱和策略
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();

        AtomicInteger count = new AtomicInteger(0);

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                100
                ,200
                ,60
                , TimeUnit.SECONDS
                , queue
                , handler
        );

        int size = 1200;
        CountDownLatch latch = new CountDownLatch(size);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(size);
        cyclicBarrier.reset();

        for (int i = 0; i < size; i++) {
            threadPool.execute(new Thread(new ThreadPoolExample(count, latch), "Thread".concat(i + "")));
            System.out.println("Index:" + i + " 线程中活跃的线程数：" + threadPool.getPoolSize());
            if(queue.size() > 0){
                System.out.println("Index:" + i + "---->队列中阻塞的线程数：" + queue.size());
            }
        }
        // 禁止新任务加入thread pool
        threadPool.shutdown();
        /*
        while (!threadPool.isTerminated()) {
            print(String.format("wait all task in thread pool ending, done task count: %d", threadPool.getCompletedTaskCount()));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */
        try {
            print("Latch is await now");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        print(String.format("After thread pool shutdown, wait for all task down. poolSize: %d, activeCount: %d, taskDown: %d， Count: %d", threadPool.getPoolSize(), threadPool.getActiveCount(), threadPool.getCompletedTaskCount(), count.get()));

        /*
        AtomicInteger count = new AtomicInteger(0);

        ScheduledExecutorService es = Executors.newScheduledThreadPool(2);
        Runnable runnable1 = new ThreadPoolExample(count);
        Runnable runnable2 = new ThreadPoolExample(count);
        // es.scheduleAtFixedRate(runnable1, 5, 3, TimeUnit.SECONDS);
        // es.scheduleAtFixedRate(runnable2, 5, 5, TimeUnit.SECONDS);
        es.scheduleWithFixedDelay(runnable2, 5, 3, TimeUnit.SECONDS);
        try {
            es.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    @Test
    public void testExecuteService() {
        // ExecutorService es = Executors.newSingleThreadExecutor();
        // ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService esFixed = Executors.newFixedThreadPool(1);
        ExecutorService es = Executors.newScheduledThreadPool(2);
        Callable<String> call = new CallAbleThread();
        // Runnable runnable = new RunnableDemo();
        Future<String> future = es.submit(call);

        es.shutdown();

        try {
            int n = 10000;
            System.out.println("主线程进行10s睡眠时间，当前时间是：" + System.currentTimeMillis());
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            String result = future.get();
            print("result is：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCPUCount() {
        int nCpu = Runtime.getRuntime().availableProcessors();
        print(String.format("CPU number is %d", nCpu));
    }

    @Test
    public void testMod() {
        int v = 0;
        for (int i = 1; i < 10; ++i) {
            assert (v % i) == 0;
        }
    }

    @Test
    public void testMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; ++i) {
            map.put(i, i * 10);
        }

        Set<Integer> keys = map.keySet();
        print("Output key:");
        StringBuilder sb = new StringBuilder();

        for(Integer key : keys) {
            sb.append(key);
            sb.append("\n");
        }

        print(sb.toString());

        Collection<Integer> values = map.values();

        for (int v : values) {
            print(String.format("v: %d", v));
        }


        Integer[] array = values.toArray(new Integer[0]);
        Arrays.sort(array, (a,b)->(b-a));
        for (Integer v : array) {
            print("toArray : " + v);
        }

        Set<Integer> keySet = map.keySet();

        for (Integer key : keySet) {
            print(key);
        }
    }

    @Test
    public void testEqualObject() {
        Integer v1 = 0;
        Integer v2 = 0;
        for (int i = 0; i < 128; ++i) {
            v1 = i;
            v2 = i;
            print(":" + v1);
            Assert.assertTrue(v1 == v2);
        }

        v1 = 0;
        v2 = 0;
        Assert.assertTrue("0 == 0", v1 == v2);

        Integer v3 = 826;
        Integer v4 = 826;
        Assert.assertTrue(String.format("Integer Object v3: %s, v4: %s", v3, v4), v3 != v4);
    }

    @Test
    public void test() {
        // List<Integer> list = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(3);
        list.add(13);
        list.add(23);
        list.add(9);
        list.add(8);

        print(String.format("original: %s", list));

        Iterator<Integer> it = list.iterator();

        Integer v = 0;
        // int v;

        while (it.hasNext()) {
            v = it.next();
            if (v != null && (v % 3) == 0) {
            // if ((v % 3) == 0) {
                it.remove();
            }
        }

        print(String.format("new: %s", list));
    }

    @Test
    public void testVolatile() {
        int n = 100;
        ThreadDemo ins = new ThreadDemo();
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; ++i) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; ++i) {
                        ins.increase();
                    }
                }
            };
        }

        // start thread
        for (int i = 0; i < n; ++i) {
            threads[i].start();
        }

        while (true) {
            boolean isAllDone = true;
            for (Thread thread: threads) {
                if (thread.isAlive()) {
                    isAllDone = false;
                    break;
                }
            }

            if (isAllDone) {
                break;
            }

            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ins.show();
    }

    @Test
    public void testNegative() {
        int negativeVal = -5;
        int v = (negativeVal & 1);
        assert v != 0;

        print(String.format("v: %d, %d\n", v, negativeVal / 2));
    }

    @Test
    public void testCharNumber() {
        int v_0 = '0';
        print(String.format("char: %c, int: %d", '0', v_0));
        int v_9 = '9';
        print(String.format("char: %c, int: %d", '0', v_9));
    }

    @Test
    public void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>(4);
        for (int i = 10; i >= 0; --i) {
            queue.add(i);
            queue.remove();
        }

        print(String.format("queue size: %d, content: %s", queue.size(), queue));

        while (!queue.isEmpty()) {
            print(String.format("val: %d", queue.poll()));
        }

    }
}

class ThreadDemo extends Thread {
    // 只保证可见性，不能保证原子性
    volatile int v = 0;

    ThreadDemo() {
        v = 0;
    }

    @Override
    public void run() {
        increase();
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void increase() {
        v += 1;
    }

    public void show() {
        System.out.println(String.format("v: %d", v));
    }
}

class CallAbleThread implements Callable<String> {
    @Override
    public String call() throws Exception{
        int n = 2000;
        Thread.sleep(n);
        System.out.println(String.format("进入Call, 进行%d睡眠时间, 当前时间是：%d", n, System.currentTimeMillis()));
        return "Today stop sth.";
    }
}

class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("execute run function");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
