/**
 * Created by malig on 11/18/15.
 */
import scala.xml.XML
import scala.io.Source
object ReCount {

   def main (args: Array[String]) {
     val min=0d
     val max=10d
for(a <- 1 to 10) {
  var v1 = a.toDouble - min
    var d1 = (max - min) * 0.5d
  var red =00d;
  var green = 00d;
  if (v1 <= d1) {
   red = Math.floor((255d * v1) / d1 + 0.5d)
   green = 255d}
  else {
    red = 255d
    green = Math.floor(255d - (255d * (v1 - d1)) / (max - min - d1) + 0.5d)

  }
  var reds = Integer.toHexString(red.toInt)
  var greens = Integer.toHexString(green.toInt)
  if(reds.length<2){
reds = reds + "0"
  }

  if(greens.length < 2){

    greens = greens + "0"
  }
println(greens)
   println(a+"#"+greens+reds+"00")
}








//     val xml = XML.loadFile("/Users/al/Projects/Scala/yahoo-weather.xml")
//
//     val filename = "/Users/malig/workspace/git/Spark-Spectra/target/scala-2.10/scoverage-data/scoverage.measurements.29"
//     val count= scala.collection.mutable.Map[Int, Int]()
//     for (line <- Source.fromFile(filename).getLines()) {
//       println(line)
//       var n = line.trim.toInt
//       if(count.contains(n)){
//         count(n) = count(n) +1
//       }
//       else
//         count += (n -> 1)
//     }
//
//
//     println(count)
//
//     /**
//      * XML Reader
//      * */
//     val xml = XML.loadFile("/Users/al/Projects/Scala/yahoo-weather.xml")



  }


}
