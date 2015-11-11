/**
 * Created by ali on 4/28/15.
 */


import org.apache.spark.SparkContext._

import scala.math.random

import org.apache.spark._

/** Computes an approximation to pi */
object Histo {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Spark Pi").setMaster("local[1]")
    val spark = new SparkContext(conf)
//       val lc = new LineageContext(spark)
//       lc.setCaptureLineage(true)
//    //val count = spark.parallelize(1 until n, slices)

      //  val m = count.map { i => (random * 200).toInt
     // }


       val hist = spark.textFile(args(0))
//"/home/ali/Desktop/hello.txt")

            val temp = hist.map{i => i.toInt}
                 val temp2 = temp.map{ i =>

            if(0<= i && i <= 50){
                 ("50",1)
            }else if(51 <= i && i <= 100){
                 ("100",1)
            }else if(101<=i && i <=150){
                 ("150",3)
            }else if(151<=i && i <200){
                 ("200" , 1)
            }
            else if(200<= i && i <=250){
                 ("250" , 1)
            }else{
            ("0",1)}
       }
       val histo = temp2.reduceByKey(_+_)

       println(histo.collect.mkString("\n"))
//
//       lc.setCaptureLineage(false)
//
//           var linRdd = histo.getLineage()
//
//       linRdd.collect().foreach(println)
//           linRdd.show
//       linRdd = linRdd.filter(2)
//           linRdd.collect.foreach(println)
//           linRdd.show
//           linRdd = linRdd.goBack()
//           linRdd.collect.foreach(println)
//           linRdd.show
//           linRdd = linRdd.goBack()
//           linRdd.collect.foreach(println)
//           linRdd.show
//




//    m.enableWatchpoint(true)
//          val r = m.reduce(_ + _)
//
//    println("Pi is roughly " + 4.0 * r / n)
    spark.stop()
  }
}
