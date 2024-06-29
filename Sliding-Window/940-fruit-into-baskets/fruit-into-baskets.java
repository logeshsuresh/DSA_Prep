class Solution {
    public int totalFruit(int[] fruits) {
        int start = 0, end = 0, n = fruits.length;
        Map<Integer, Integer> fruitBasket = new HashMap<>();
        int maxFruits = 0;

        while (end < n) {
            int curFruit = fruits[end];

            if (fruitBasket.containsKey(curFruit)) {
                fruitBasket.put(curFruit, fruitBasket.get(curFruit) + 1);
            } else {
                fruitBasket.put(curFruit, 1);
            }

            while (fruitBasket.size() > 2 && start <= end) {
                    int fruitAtStart = fruits[start];
                    int curFruitQty = fruitBasket.get(fruitAtStart);
                    fruitBasket.put(fruitAtStart, curFruitQty - 1);
                    if (fruitBasket.get(fruitAtStart) == 0) {
                        fruitBasket.remove(fruitAtStart);
                    }
                    start ++;
            }
            
            maxFruits = Math.max(maxFruits, end - start + 1);

            end ++;
        }

        return maxFruits;
    }
}