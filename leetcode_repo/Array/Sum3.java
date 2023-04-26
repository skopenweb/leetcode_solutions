import java.util.*;

public class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ll = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] ) {
                continue;
            }
            int curr = -nums[i];

            int a = 0;
            int b = nums.length - 1;

            while (a < b) {
                if (nums[a] + nums[b] == curr) {
                    if (a != i && b != i) {
                        List<Integer> l = new ArrayList<Integer>();

                        int min;
                        int max;

                        if (nums[a] >= nums[b]) {
                            min = nums[b];
                            max = nums[a];
                            if (nums[i] < min) {
                                min = nums[i];
                            }
                            if (nums[i] > max) {
                                max = nums[i];
                            }
                        } else {
                            min = nums[a];
                            max = nums[b];
                            if (nums[i] < min) {
                                min = nums[i];
                            }
                            if (nums[i] > max) {
                                max = nums[i];
                            }
                        }

                        int third = - min - max;
                        l.add(min);
                        l.add(max);
                        l.add(third);

                        if (!isExist(ll, l)) {
                            ll.add(l);
                        }
                    }
                    a++;
                    b--;
                } else if (nums[a] + nums[b] < curr) {
                    a++;
                } else {
                    b--;
                }
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        Sum3 s = new Sum3();
        int[] a = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> ll = s.threeSum(a);

        for (int i = 0; i < ll.size(); i++) {
            List<Integer> l = ll.get(i);
            for (int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j) + " ");
            }
            System.out.println();
        }

        System.out.println("Main");
    }

    private boolean isExist(List<List<Integer>> ll, List<Integer> l) {
        boolean exists = false;
        for (int i = 0; i < ll.size(); i++) {
            List<Integer> le = ll.get(i);
            exists = true;
            for (int j = 0; j < le.size(); j++) {
                if (le.get(j) != l.get(j)) {
                    exists = false;
                    break;
                }
            }
            if (exists == true) {
                break;
            }
            System.out.println();
        }
        return exists;
    }
}