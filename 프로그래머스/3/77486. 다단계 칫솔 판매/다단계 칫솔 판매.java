import java.util.*;

class Solution {
    private class Graph {
        private final Map<String, Node> index = new HashMap<>();
    }

    private class Node {
        String name;
        Node Parent;
        int sales;
        List<Node> reffered;

        Node(String name) {
            this.name = name;
            this.sales = 0;
            this.reffered = new ArrayList<>();
        }

        void addChild(Node child) {
            reffered.add(child);
            child.Parent = this;
        }

        void addSales(int sale) {
            int shit = sale / 10;
            if (shit < 1) {
                this.sales += sale;
                return;
            }
            this.sales += sale - shit;

            if (this.Parent == null) return;
            this.Parent.addSales(shit);
        }

        void printBFS() {
            Queue<Node> queue = new LinkedList<>();
            System.out.println("-------※BFS Search※------");
            queue.add(this);

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                System.out.println("▶ Current Node: " + current.name);
                if (current.Parent != null) {
                System.out.println("  └─ Parent: " + current.Parent.name);
                }
                if (current.reffered.isEmpty()) {
                    System.out.println("  └─ Children: (none)");
                } else {
                    System.out.print("  └─ Children: ");
                    Iterator<Node> children = current.reffered.listIterator();
                    while (children.hasNext()) {
                        Node child = children.next();
                        System.out.print(child.name + " ");
                        queue.add(child);
                    }
                    System.out.println();
                }
            }
            System.out.println("--------------------------------");
        }
    }


    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        Node node = new Node("-");
        Graph graph = new Graph();

        graph.index.put("-", node);
        for (int i=0; i<n; i++) {
            Node newNode = new Node(enroll[i]);
            graph.index.put(enroll[i], newNode);
            if(!graph.index.containsKey(referral[i])) {
                Node parentTmp = new Node(referral[i]);
                graph.index.put(enroll[i], parentTmp);
            }
            graph.index.get(referral[i]).addChild(newNode);
        }
        //node.printBFS();

        int m = seller.length;
        for (int j=0; j<m; j++) {
            Node sellNode = graph.index.get(seller[j]);
            int value = amount[j];
            sellNode.addSales(value*100);
        }

        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            answer[i] = graph.index.get(enroll[i]).sales;
        }
        return answer;
    }
}