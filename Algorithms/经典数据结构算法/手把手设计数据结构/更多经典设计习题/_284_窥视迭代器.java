package Algorithms.经典数据结构算法.手把手设计数据结构.更多经典设计习题;

import java.util.Iterator;

// https://leetcode.cn/problems/peeking-iterator/
public class _284_窥视迭代器 {
    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iter;
        
        // 把迭代器的下一个元素提前拿出来并缓存起来
        private Integer nextElem;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iter = iterator;
            this.nextElem = iterator.next();
        }

        public Integer peek() {
            return nextElem;
        }

        @Override
        public Integer next() {
            Integer res = nextElem;
            // 更新 nextElem
            if (iter.hasNext()) {
                nextElem = iter.next();
            } else {
                nextElem = null;
            }
            return res;
        }

        @Override
        public boolean hasNext() {
            return nextElem != null;
        }
    }
}
