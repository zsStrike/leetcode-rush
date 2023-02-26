package contest.template;


/**
 * 线段树，用于解决区间更新和查询问题
 * update(int start, int end, int l, int r, int delta): 需要更新 [l, r] 中的值，变化量是 delta，从上往下更新
 * int query(int start, int end, int l, int r)：计算 [l, r] 中的统计量
 * pushUp(Node node): 用于更新下层节点后向上更新
 * pushDown(Node node, int leftNum, int rgihtNum): 对于当前的节点需要向下推进，leftNum 表示左边有几个叶子节点， rightNum 表示右边有几个叶子结点
 */
class SegmentTree {
    
    class Node {
        Node left, right;
        int val, lazyVal;
    }

    int N;
    Node root;

    SegmentTree(int max) {
        this.N = max;
        root = new Node();
    }

    void update(int start, int end, int l, int r, int delta) {
        update(root, start, end, l, r, delta);
    }

    int query(int start, int end, int l, int r) {
        return query(root, start, end, l, r);
    }
 
    void update(Node node, int start, int end, int l, int r, int delta) {
        if (l <= start && end <= r) {
            node.val += (end - start + 1) * delta;
            node.lazyVal += delta;
            return;
        }
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) {
            update(node.left, start, mid, l, r, delta);
        }
        if (r > mid) {
            update(node.right, mid + 1, end, l, r, delta);
        }
        pushUp(node);
    }

    int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) {
            return node.val;
        }
        int ans = 0;
        int mid = (start + end) >> 1;
        pushDown(node, mid - start + 1, end - mid);
        if (l <= mid) {
            ans += query(node.left, start, mid, l, r);
        }
        if (r > mid) {
            ans += query(node.right, mid + 1, end, l, r);
        }
        return ans;
    }

    void pushUp(Node node) {
        node.val = node.left.val + node.right.val;
    }

    void pushDown(Node node, int leftNum, int rightNum) {
        if (node.left == null) {
            node.left = new Node();
        }
        if (node.right == null) {
            node.right = new Node();
        }
        if (node.lazyVal == 0) {
            return;
        }
        node.left.val += node.lazyVal * leftNum;
        node.right.val += node.lazyVal * rightNum;
        node.left.lazyVal += node.lazyVal;
        node.right.lazyVal += node.lazyVal;
        node.lazyVal = 0;
    }

}
