package com.wbchao.tls;

public class Shipping {
    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        int large = items/5;
        if (large > availableLargePackages) {
            if(5 * availableLargePackages + availableSmallPackages< items){
                return -1;
            }else{
                return availableLargePackages + (items - 5 *availableLargePackages);
            }
        }else{
            int small = items % 5;
            if(small <= availableSmallPackages){
                return large + small;
            }else{
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 2, 10));
    }
}
