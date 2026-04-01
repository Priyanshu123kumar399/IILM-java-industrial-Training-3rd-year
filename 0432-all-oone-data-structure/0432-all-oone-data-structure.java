import java.util.*;

class AllOne {

    class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Node> map;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next != tail && head.next.count == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            } else {
                Node node = new Node(1);
                node.keys.add(key);
                insertAfter(head, node);
                map.put(key, node);
            }
        } else {
            Node cur = map.get(key);
            Node nextNode = cur.next;
            int newCount = cur.count + 1;

            cur.keys.remove(key);

            if (nextNode != tail && nextNode.count == newCount) {
                nextNode.keys.add(key);
                map.put(key, nextNode);
            } else {
                Node node = new Node(newCount);
                node.keys.add(key);
                insertAfter(cur, node);
                map.put(key, node);
            }

            if (cur.keys.isEmpty()) {
                removeNode(cur);
            }
        }
    }

    public void dec(String key) {
        Node cur = map.get(key);
        cur.keys.remove(key);

        if (cur.count == 1) {
            map.remove(key);
        } else {
            Node prevNode = cur.prev;
            int newCount = cur.count - 1;

            if (prevNode != head && prevNode.count == newCount) {
                prevNode.keys.add(key);
                map.put(key, prevNode);
            } else {
                Node node = new Node(newCount);
                node.keys.add(key);
                insertAfter(prevNode, node);
                map.put(key, node);
            }
        }

        if (cur.keys.isEmpty()) {
            removeNode(cur);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.keys.iterator().next();
    }

    private void insertAfter(Node prevNode, Node newNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */