class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
        Queue<Triplet> q = new LinkedList<>();

        Map<Character, Integer> taskCnt = new HashMap<>();

        for (char task : tasks) {
            taskCnt.put(task, taskCnt.getOrDefault(task, 0) + 1);
        }

        for (Character ch : taskCnt.keySet()) {
            maxHeap.offer(new Pair(ch, taskCnt.get(ch)));
        }

        System.out.println(maxHeap.size());

        int t = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            if (!maxHeap.isEmpty()) {
                Pair p = maxHeap.poll();
                p.cnt--;
                if (p.cnt >= 1) { 
                    q.offer(new Triplet(p.ch, t + n + 1, p.cnt)); 
                }
                t++;
            } else {
                t = q.peek().end;
            }

            while (!q.isEmpty() && q.peek().end == t) {
                Triplet triplet = q.poll();
                maxHeap.offer(new Pair(triplet.ch, triplet.cnt));
            }
        }

        return t;
    }
}

class Pair {
    char ch;
    int cnt;
    public Pair(char ch, int cnt) {
        this.ch = ch;
        this.cnt = cnt;
    }
}

class Triplet {
    char ch;
    int end;
    int cnt;
    public Triplet(char ch, int end, int cnt) {
        this.ch = ch;
        this.end = end;
        this.cnt = cnt;
    }
}