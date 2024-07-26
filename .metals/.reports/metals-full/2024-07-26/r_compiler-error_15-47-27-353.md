file://<WORKSPACE>/labuladong/%E5%85%B6%E4%BB%96%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7/%E6%95%B0%E5%AD%A6%E8%BF%90%E7%94%A8%E6%8A%80%E5%B7%A7/%E5%A6%82%E4%BD%95%E9%AB%98%E6%95%88%E8%BF%9B%E8%A1%8C%E6%A8%A1%E5%B9%82%E8%BF%90%E7%AE%97/_372_%E8%B6%85%E7%BA%A7%E6%AC%A1%E6%96%B9.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/labuladong/%E5%85%B6%E4%BB%96%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7/%E6%95%B0%E5%AD%A6%E8%BF%90%E7%94%A8%E6%8A%80%E5%B7%A7/%E5%A6%82%E4%BD%95%E9%AB%98%E6%95%88%E8%BF%9B%E8%A1%8C%E6%A8%A1%E5%B9%82%E8%BF%90%E7%AE%97/_372_%E8%B6%85%E7%BA%A7%E6%AC%A1%E6%96%B9.java
text:
```scala
package labuladong.其他常见算法技巧.数学运用技巧.如何高效进行模幂运算;

import java.util.Arrays;

// https://leetcode.cn/problems/super-pow/
public class _372_超级次方 {
    // b = [1,5,6,4]
    // a的[1, 5, 6, 4]
    // = a的4次方 x a的[1, 5, 6, 0]
    // = a的4次方 x (a的[1, 5, 6])的10次方

    // superPow(a, [1,5,6,4])
    // = a的4次方 x （superPow(a, [1,5,6])）的10次方

    // 计算 a 的 k 次方的结果
    // 后文我们会手动实现
    int mypow(int a, int k) {
        return 0;
    }

    public int superPow(int a, int[] b) {
        // 递归的 base case
        if (b.length == 0)
            return 1;
        // 取出最后一个数
        int last = b[b.length - 1];
        int[] newArr = Arrays.copyOfRange(b, 0, b.length - 1);
        // 将原问题化简，缩小规模递归求解
        int part1 = mypow(a, last);
        int part2 = mypow(superPow(a, newArr), 10);
        // 合并出结果
        return part1 * part2;
    }

    // 如何处理 mod 运算
    // 由于计算机的编码方式，形如 (a * b) % base
    /这样的运算，乘法的结果可能导致溢出，我们希望找到一种技巧，能够化简这种表达式，避免溢出同时得到结果。
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