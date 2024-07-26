file://<WORKSPACE>/labuladong/%E5%85%B6%E4%BB%96%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7/%E6%95%B0%E5%AD%A6%E8%BF%90%E7%94%A8%E6%8A%80%E5%B7%A7/%E5%A6%82%E4%BD%95%E9%AB%98%E6%95%88%E5%AF%BB%E6%89%BE%E7%B4%A0%E6%95%B0/_204_%E8%AE%A1%E6%95%B0%E8%B4%A8%E6%95%B0.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
offset: 245
uri: file://<WORKSPACE>/labuladong/%E5%85%B6%E4%BB%96%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7/%E6%95%B0%E5%AD%A6%E8%BF%90%E7%94%A8%E6%8A%80%E5%B7%A7/%E5%A6%82%E4%BD%95%E9%AB%98%E6%95%88%E5%AF%BB%E6%89%BE%E7%B4%A0%E6%95%B0/_204_%E8%AE%A1%E6%95%B0%E8%B4%A8%E6%95%B0.java
text:
```scala
package labuladong.其他常见算法技巧.数学运用技巧.如何高效寻找素数;

import java.util.Arrays;

// https://leetcode.cn/problems/count-primes/
public class _204_计数质数 {
    // 素数筛选法

    class Solution {
        public int countPrimes(int n) {
            boolean[] isPri@@me = new boolean[n];
            Arrays.fill(isPrime, true);
            for (int i = 2; i * i < n; i++)
                if (isPrime[i])
                    for (int j = i * i; j < n; j += i)
                        isPrime[j] = false;

            int count = 0;
            for (int i = 2; i < n; i++)
                if (isPrime[i])
                    count++;

            return count;
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
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:36)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:380)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator