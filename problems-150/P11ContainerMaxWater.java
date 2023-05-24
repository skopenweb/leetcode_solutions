

class P11ContainerMaxWater {
    public int maxArea(int[] h) {
        
        // int max = 0;
        // for (int i=0; i<h.length; i++) {
        //     for (int j=i+1; j< h.length; j++) {
        //         int m = Math.min(h[i], h[j]);
        //         int area = m*(j-i);
        //         if (area > max) {
        //             max = area;
        //         }
        //     }
        // }

        int max = 0;
        int l = 0; 
        int r = h.length-1;

        while(l < r) {
            int dist = r-l;
            int area;
            if (h[l] < h[r]) {
                area = h[l] * dist;
                l++;
            } else {
                area = h[r] * dist;
                r--;
            }
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println("a = " + new P11ContainerMaxWater().maxArea(a));
    }
}