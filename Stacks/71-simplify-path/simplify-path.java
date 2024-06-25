class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] directories = path.split("/");

        for (String directory : directories) {
            if (directory.length() == 0 || directory.equals("." )) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(directory);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        int n = sb.length();

        String simplifiedPath = sb.toString();

        return (simplifiedPath.length() > 0) ? simplifiedPath : "/";
    }
}