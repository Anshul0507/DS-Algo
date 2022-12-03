class Node{
    char ch;
    int val;
    Node(char c, int v){
        this.ch=c;
        this.val=v;
    }
}

class NodeComparator implements Comparator<Node>{
    public int compare(Node n1, Node n2){
        return n2.val-n1.val;
    }
}

class Solution {
    public String frequencySort(String s) {
        Map<Character,Node> m = new HashMap<>();
        List<Node> nodeList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            Node node = m.get(curr);
            if(node==null){
                Node n = new Node(curr,1);
                m.put(curr, n);
                nodeList.add(n);
            }
                
            else
                node.val++;
        }
        Collections.sort(nodeList,new NodeComparator());
        StringBuilder sb = new StringBuilder();
        for(Node n: nodeList){
            for(int i=0;i<n.val;i++)
                sb.append(n.ch);
        }
        return sb.toString();
    }
}