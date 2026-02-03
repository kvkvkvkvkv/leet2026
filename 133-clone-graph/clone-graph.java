/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        List<Node> neigh = newNode.neighbors;
        map.put(node, newNode);

        for(Node next: node.neighbors) {
            neigh.add(cloneGraph(next));
        }
        return newNode;
    }
}