class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        // Priority queue to hold available servers sorted by weight and index
        PriorityQueue<ServerInfo> available = new PriorityQueue<>((a, b) -> {
            if (a.weight == b.weight) return a.index - b.index;
            return a.weight - b.weight;
        });
        
        // Priority queue to hold servers that are currently processing tasks sorted by end time
        PriorityQueue<ProcessInfo> unavailable = new PriorityQueue<>((a, b) -> {
            if (a.endTime == b.endTime) return a.serverInfo.index - b.serverInfo.index;
            return a.endTime - b.endTime;
        });

        for (int i = 0; i < servers.length; i++) { available.offer(new ServerInfo(servers[i], i)); }

        int[] ans = new int[tasks.length];

        int currentTime = 0;

        for (int i = 0; i < tasks.length; i++) {
            currentTime = Math.max(currentTime, i);
            if (available.isEmpty()) {
                currentTime = unavailable.peek().endTime;
            }

            while (!unavailable.isEmpty() && currentTime >= unavailable.peek().endTime) {
                ProcessInfo pInfo = unavailable.poll();
                available.offer(pInfo.serverInfo);
            }

            ServerInfo serverChosen = available.poll();
            ans[i] = serverChosen.index;
            unavailable.offer(new ProcessInfo(tasks[i] + currentTime, serverChosen));
        }

        return ans;
    }
}

class ServerInfo {
    int weight;
    int index;
    public ServerInfo(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }
}

class ProcessInfo {
    int endTime;
    ServerInfo serverInfo;
    public ProcessInfo(int endTime, ServerInfo serverInfo) {
        this.endTime = endTime;
        this.serverInfo = serverInfo;
    }
}