/**
 * Created by ali on 11/9/15.
 */

import collection.mutable.Stack
import org.scalatest._

class Test extends FlatSpec {

	"Test" should " Pass " in {
		WordCount.main(new Array[String](0))
		assert(true)
	}
}
