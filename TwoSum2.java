
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum2 
{
    static int[] findPairs(int arr[], int sum)

{

Map<Integer, Integer> s = new HashMap<>();

for (int i = 0; i < arr.length; ++i) {

int temp = sum - arr[i];

if (s.containsKey(temp)) {

return new int[] {s.get(temp), i};

}

s.put(arr[i], i);

}

return new int[] {-1, -1};

}

public static void main(String[] args)

{

    int arr[] = {54, 100, -4, 93, 18, -22, -76, 71, 18, 44, -15, 14, 38, -84, 81, 57, 34, 63, 55, -98, -30, 88, -83, -63, -16, 66, -7, -38, -47, 65, -54, 30, -76, 98, 58, -4, -56, 78, -73, -27, 41, 56, -99, 15, 70, 55, -83, -94, -71, 61, 32, 60, -47, 51, 15, 56, 10, 24, 20, 41, 68, 11, -92, -11, 47, -61, 46, 15, 65, 22, 79, 34, -82, 100, 25, 4, -66, 77, 94, 12, 35, 31, 84, -21, 29, 44, 67, 65, -71, -3, -59, 98, -15, 78, 53, 13, -57, 0, -61, 55};

    int n = 95;

    System.out.println(Arrays.toString(findPairs(arr, n)));

    }
}
