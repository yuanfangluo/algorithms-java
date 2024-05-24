package labuladong.My;

public class DoublyListNode {
    int val;
    DoublyListNode next, prev;

    DoublyListNode(int x) {
        val = x;
    }

    DoublyListNode createDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyListNode newNode = new DoublyListNode(arr[i]);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }
        return head;
    }

    // 遍历，查找，修改
    void traverse() {
        DoublyListNode head = createDoublyLinkedList(new int[] { 1, 2, 3, 4, 5 });
        // 从头遍历
        for (DoublyListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
        }

        DoublyListNode tail = null;
        // 从尾遍历
        for (DoublyListNode p = tail; p != null; p = p.prev) {
            System.out.println(tail.val);
        }
    }

    void insertAtHead() {
        // 创建一条双链表
        DoublyListNode head = createDoublyLinkedList(new int[] { 1, 2, 3, 4, 5 });

        // 在双链表头部插入新节点 0
        DoublyListNode newHead = new DoublyListNode(0);
        newHead.next = head;
        head.prev = newHead;
        head = newHead;
        // 现在链表变成了 0 -> 1 -> 2 -> 3 -> 4 -> 5
    }

    void insertAtTail() {
        // 创建一条双链表
        DoublyListNode head = createDoublyLinkedList(new int[] { 1, 2, 3, 4, 5 });

        DoublyListNode tail = head;
        // 先走到链表的最后一个节点
        while (tail.next != null) {
            tail = tail.next;
        }

        // 在双链表尾部插入新节点 6
        DoublyListNode newNode = new DoublyListNode(6);
        tail.next = newNode;
        newNode.prev = tail;
        // 更新尾节点引用
        tail = newNode;

        // 现在链表变成了 1 -> 2 -> 3 -> 4 -> 5 -> 6
    }

    void insertAtBetween() {
        // 创建一条双链表
        DoublyListNode head = createDoublyLinkedList(new int[] { 1, 2, 3, 4, 5 });

        // 在第 3 个节点后面插入新节点 66
        // 找到第 3 个节点
        DoublyListNode p = head;
        for (int i = 0; i < 2; i++) {
            p = p.next;
        }

        // 组装新节点
        DoublyListNode newNode = new DoublyListNode(66);
        newNode.next = p.next;
        newNode.prev = p;

        // 插入新节点
        p.next.prev = newNode;
        p.next = newNode;

        // 现在链表变成了 1 -> 2 -> 3 -> 66 -> 4 -> 5

    }

    void deleteNode() {
        // 创建一条双链表
        DoublyListNode head = createDoublyLinkedList(new int[] { 1, 2, 3, 4, 5 });

        // 删除第 4 个节点
        // 先找到第 3 个节点
        DoublyListNode p = head;
        for (int i = 0; i < 2; i++) {
            p = p.next;
        }

        // 现在 p 指向第 3 个节点，我们它后面那个节点摘除出去
        DoublyListNode toDelete = p.next;

        // 把 toDelete 从链表中摘除
        p.next = toDelete.next;
        toDelete.next.prev = p;

        // 把 toDelete 的前后指针都置为 null 是个好习惯（可选）
        toDelete.next = null;
        toDelete.prev = null;

        // 现在链表变成了 1 -> 2 -> 3 -> 5

    }

    void deleteHead() {
        // 创建一条双链表
        DoublyListNode head = createDoublyLinkedList(new int[] { 1, 2, 3, 4, 5 });

        // 删除头结点
        DoublyListNode toDelete = head;
        head = head.next;
        head.prev = null;

        // 清理已删除节点的指针
        toDelete.next = null;

        // 现在链表变成了 2 -> 3 -> 4 -> 5

    }

    void deleteTail() {
        // 创建一条双链表
        DoublyListNode head = createDoublyLinkedList(new int[] { 1, 2, 3, 4, 5 });

        // 删除尾节点
        DoublyListNode p = head;
        // 找到尾结点
        while (p.next != null) {
            p = p.next;
        }

        // 现在 p 指向尾节点
        // 把尾节点从链表中摘除
        p.prev.next = null;

        // 把被删结点的指针都断开是个好习惯（可选）
        p.prev = null;

        // 现在链表变成了 1 -> 2 -> 3 -> 4

    }

    
}
