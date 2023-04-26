public class P4Median {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m+n;
        int mid = total/2;

        boolean isOdd = (total & 1) == 1;

        int i1 = 0;
        int i2 = 0;
    

        if (nums1.length == 0 && nums2.length == 0) {
            return -1;
        } else if (nums1.length == 0) {
            if (isOdd) {
                return nums2[mid];
            } else {
                return nums2[mid] + (nums2[mid-1] - nums2[mid] )/2.0;
            }
        } else if (nums2.length == 0) {
            if (isOdd) {
                return nums1[mid];
            } else {
                return nums1[mid] + (nums1[mid-1] - nums1[mid])/2.0;
            }
        }

        int curr = nums1[0] <= nums2[0] ? nums1[0]: nums2[0];
        int prev = curr;

        while (i1 < m && i2 < n && (i1 + i2) <= mid) {
            prev = curr;
            if (nums1[i1] <= nums2[i2]) {
                curr = nums1[i1];
                i1++;
            } else {
                curr = nums2[i2];
                i2++;
            }
        }

        if (i1 + i2 == mid + 1) {
            if (isOdd) {
                return curr;
            } else {
                return curr + (prev - curr)/2.0;
            }
        } else {
            int diff = mid - (i1 +i2);
            if (i1 == m) {
                if (isOdd) {
                    return nums2[i2 + diff];
                } else {
                    if (i2 + diff == 0) {
                        prev=  curr;
                    } else {
                        prev = nums2[i2 + diff- 1];
                    }
                    return nums2[i2 + diff] + (prev - nums2[i2 + diff])/2.0;
                }
            } else {
                 if (isOdd) {
                    return nums1[i1 + diff];
                } else {
                    if (i1 + diff == 0) {
                        prev=  curr;
                    } else {
                        prev = nums1[i1 + diff- 1];
                    }
                    return nums1[i1 + diff] + (prev - nums1[i1 + diff])/2.0;
                }
            }
        }
    }

    // return median in array at mid
    // int median(int[] a, int mid, boolean even) {
    //     if (a == null || a.length < mid) {
    //         throw new IllegalStateException("median not possible at "+ mid);
    //     }

    //     if (even) {

    //     }

    // }
    public static void main(String[] args) {
        int[] a = {0,0,0,0,0};
        int[] b = {-1,0,0,0,0,0,1};
        System.out.println("P4Median\t "+ new P4Median().findMedianSortedArrays(a, b));

    }    
}
