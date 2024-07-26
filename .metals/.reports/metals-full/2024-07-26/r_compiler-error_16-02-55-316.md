file://<WORKSPACE>/labuladong/%E5%85%B6%E4%BB%96%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7/%E6%95%B0%E5%AD%A6%E8%BF%90%E7%94%A8%E6%8A%80%E5%B7%A7/%E5%A6%82%E4%BD%95%E5%90%8C%E6%97%B6%E5%AF%BB%E6%89%BE%E7%BC%BA%E5%A4%B1%E5%92%8C%E9%87%8D%E5%A4%8D%E7%9A%84%E5%85%83%E7%B4%A0/_645_%E9%94%99%E8%AF%AF%E7%9A%84%E9%9B%86%E5%90%88.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/Library/Caches/Coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/labuladong/%E5%85%B6%E4%BB%96%E5%B8%B8%E8%A7%81%E7%AE%97%E6%B3%95%E6%8A%80%E5%B7%A7/%E6%95%B0%E5%AD%A6%E8%BF%90%E7%94%A8%E6%8A%80%E5%B7%A7/%E5%A6%82%E4%BD%95%E5%90%8C%E6%97%B6%E5%AF%BB%E6%89%BE%E7%BC%BA%E5%A4%B1%E5%92%8C%E9%87%8D%E5%A4%8D%E7%9A%84%E5%85%83%E7%B4%A0/_645_%E9%94%99%E8%AF%AF%E7%9A%84%E9%9B%86%E5%90%88.java
text:
```scala
package labuladong.其他常见算法技巧.数学运用技巧.如何同时寻找缺失和重复的元素;


public class _645_错误的集合 {
    
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