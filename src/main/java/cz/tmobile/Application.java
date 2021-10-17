package cz.tmobile;

public class Application {

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No argument provided");
        }

        Solution solution = new Solution();
        String result = solution.solution(args[0]);
        System.out.println(result);
    }
}
