file://<WORKSPACE>/labuladong/%E5%85%B6%E4%BB%96%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7/%E6%95%B0%E5%AD%A6%E8%BF%90%E7%94%A8%E6%8A%80%E5%B7%A7/%E9%98%B6%E4%B9%98%E7%AE%97%E6%B3%95%E9%A2%98/_793_%E9%98%B6%E4%B9%98%E5%87%BD%E6%95%B0%E5%90%8EK%E4%B8%AA%E9%9B%B6.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/labuladong/%E5%85%B6%E4%BB%96%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7/%E6%95%B0%E5%AD%A6%E8%BF%90%E7%94%A8%E6%8A%80%E5%B7%A7/%E9%98%B6%E4%B9%98%E7%AE%97%E6%B3%95%E9%A2%98/_793_%E9%98%B6%E4%B9%98%E5%87%BD%E6%95%B0%E5%90%8EK%E4%B8%AA%E9%9B%B6.java
text:
```scala
package labuladong.其他常见算法技巧.数学运用技巧.阶乘算法题;

// https://leetcode.cn/problems/preimage-size-of-factorial-zeroes-function/
public class _793_阶乘函数后K个零 {
    // 搜索有多少个 n 满足 trailingZeroes(n) == K，
    // 其实就是在问满足条件的 n 最小是多少，最大是多少，
    // 最大值和最小值一减，就可以算出来有多少个 n 满足条件了
    // 那不就是 二分查找 中「搜索左侧边界」和「搜索右侧边界」这两个事儿嘛？

    // 在区间 [0, LONG_MAX] 中寻找满足 trailingZeroes(n) == K 的左侧边界和右侧边界。
    // 二分查找算法框架，搜索左侧边界和右侧边界的框架

    class Solution {
        public int preimageSizeFZF(int k) {
            // 左边界和右边界之差 + 1 就是答案
            return (int) (right_bound(k) - left_bound(k) + 1);
        }

        /* 搜索 trailingZeroes(n) == K 的左侧边界 */
        long left_bound(int target) {
            long lo = 0, hi = Long.MAX_VALUE;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                if (trailingZeroes(mid) < target) {
                    lo = mid + 1;
                } else if (trailingZeroes(mid) > target) {
                    hi = mid;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        /* 搜索 trailingZeroes(n) == K 的右侧边界 */
        long right_bound(int target) {
            long lo = 0, hi = Long.MAX_VALUE;
            while (lo < hi) {
                long mid = lo + (hi - lo) / 2;
                if (trailingZeroes(mid) < target) {
                    lo = mid + 1;
                } else if (trailingZeroes(mid) > target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo - 1;
        }

        // 逻辑不变，数据类型全部改成 long
        long trailingZeroes(long n) {
            long res = 0;
            for (long d = n; d / 5 > 0; d = d / 5) {
                res += d / 5;
            }
            return res;
        }
    }
}

```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.WithCompilationUnit.<init>(WithCompilationUnit.scala:28)
	scala.meta.internal.pc.SimpleCollector.<init>(PcCollector.scala:367)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:111)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator