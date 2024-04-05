import java.util.*;

class P207CourseSchedule {

    enum State {
        gray,
        green,
        yellow,
        red
    }

    private static class Node {
        List<Integer> adj = new ArrayList<>();
        State state = State.gray;

        void store(int i) {
            adj.add(i);
        }
    }

    int dfs(Node n, Node[] nodes) {
        n.state = State.yellow;
        int curr = 0;
        for (int i: n.adj) {
            if (curr == -1 || nodes[i].state == State.yellow) {
                return -1;
            }
            if (nodes[i].state == State.gray) {
                curr = dfs(nodes[i], nodes);
            }
        }

        n.state = State.green;
        return curr;
    }

    public boolean canFinish(int num, int[][] pre) {
        Node[] nodes = new Node[num];

        for (int i=0; i<num; i++) {
            nodes[i] = new Node();
        }
        for (int[] ar: pre) {
            nodes[ar[0]].store(ar[1]);
        }

        for (Node n: nodes) {
            if (n.state == State.gray) {
                int v = dfs(n, nodes);
                if (v == -1) {
                    return false;
                }
            }
        }
        return true;
    }
}