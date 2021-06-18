public class Test {

    public static void main(String[] args) {
        String[] arr = {"a", "", "ac", "ad", "b", "", "ba"};
        int res = indexOf(arr, "abc");
        System.out.println(res);
    }

    private static int indexOf(String[] arr, String p) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin <= end) {
            int indexOfMid = begin + ((end - begin) >> 1);
            while (arr[indexOfMid].equals("")) {
                indexOfMid++;
                if (indexOfMid > end) {
                    return -1;
                }
            }
            if (arr[indexOfMid].compareTo(p) > 0) {
                end = indexOfMid - 1;
            } else if (arr[indexOfMid].compareTo(p) < 0) {
                begin = indexOfMid + 1;
            } else {
                return indexOfMid;
            }
        }
        return -1;
    }
}


