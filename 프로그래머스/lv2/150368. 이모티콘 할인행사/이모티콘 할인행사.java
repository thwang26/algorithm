import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int maxServiceUser = 0;
    int maxSales = 0;
    List<Integer> combinationList = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        combination(emoticons);
        calCombination(users, emoticons);
        return new int[]{maxServiceUser, maxSales};
    }

    public void combination(int[] emoticons) {
        int minCases = 0;
        int maxCases = (int) Math.pow(4, emoticons.length);
        int n = emoticons.length;

        for (int i = minCases; i < maxCases; i++) {
            int cases = Integer.parseInt(Integer.toString(i, 4));
            int fixNumber = Integer.parseInt("1".repeat(n));
            combinationList.add(cases + fixNumber);
        }
    }

    public void calCombination(int[][] users, int[] emoticons) {
        for (int combination : combinationList) {
            int serviceUser = 0;
            int sales = 0;
            int[] discountArr = Arrays.stream(String.valueOf(combination).split(""))
                    .mapToInt(Integer::parseInt).toArray();

            for (int[] user : users) {
                int eachUserSales = 0;

                for (int j = 0; j < discountArr.length; j++) {
                    if (discountArr[j] * 10 >= user[0]) {
                        eachUserSales += emoticons[j] * (10 - discountArr[j]) / 10;
                    }
                }

                if (eachUserSales >= user[1]) {
                    serviceUser++;
                } else {
                    sales += eachUserSales;
                }
            }

            if (maxServiceUser < serviceUser) {
                maxServiceUser = serviceUser;
                maxSales = sales;
            } else if (maxServiceUser == serviceUser) {
                maxSales = Math.max(maxSales, sales);
            }
        }
    }
}