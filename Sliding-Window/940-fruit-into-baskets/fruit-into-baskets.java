class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;

        int start = 0, end = 0;

        Map<Integer, Integer> fruitBasket = new HashMap<>(); // size of 2

        int maxFruits = 0;

        while (end < n) {
            int fruit = fruits[end];

            fruitBasket.put(fruit, fruitBasket.getOrDefault(fruit, 0) + 1);

            while (fruitBasket.size() > 2 && start <= end) {
                int fruitAtStart = fruits[start];
                int cnt = fruitBasket.get(fruitAtStart);
                fruitBasket.put(fruitAtStart, cnt - 1);
                if (cnt - 1 == 0) { 
                    fruitBasket.remove(fruitAtStart); 
                }
                start++;
            }

            maxFruits = Math.max(maxFruits, end - start + 1);

            end++;
        }

        return maxFruits;
    }
}