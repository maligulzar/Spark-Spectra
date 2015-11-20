/**
 * Created by ali on 11/9/15.
 */

import collection.mutable.Stack
import org.scalatest._

class Test extends FlatSpec {

	"Test" should " Pass " in {
		WordCount.main(Array("a"))
  //            WordCountFail.main(new Array[String](0))
//		Histo.main(Array("/Users/malig/workspace/git/Spark-Spectra/success.txt"))
//		HistoFail.main(Array("/Users/malig/workspace/git/Spark-Spectra/fail.txt"))
//		TC.main(new Array[String](0))
		assert(true)
	}
}
