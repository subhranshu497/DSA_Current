public class MinimumCommonValue {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,6};
        int [] nums2 = {2,3,4,5};
        System.out.println(getCommon(nums1,nums2));
    }

    private static int getCommon(int[] nums1, int[] nums2) {
        int i =0;
        int j =0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]) i++;
            else if(nums1[i]>nums2[j])j++;
            else return nums1[i];
        }
        return -1;
    }
}
