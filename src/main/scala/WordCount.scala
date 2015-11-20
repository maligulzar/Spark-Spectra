/**
 * Created by ali on 11/9/15.
 */
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.spark.SparkContext.rddToPairRDDFunctions
import org.apache.spark.{SparkConf, SparkContext}


object WordCount
{
	def main(args: Array[String]) {
		if(args(0).contains("a")){
			for(i <- 1 to 10){
				println("a")
			}
		}else {
				println("b")
			}



//		val conf = new SparkConf()
//		var lineage = true
//		var logFile = "hdfs://scai01.cs.ucla.edu:9000/clash/data/size-500"
//		logFile = "/Users/malig/workspace/git/spark-lineage/README.md"
//		//logFile = "/home/ali/test.txt"
//		lineage = true
//
//		println("Program started")
//		conf.setAppName("WordCount-" + lineage + "-" + logFile).setMaster("local[1]")
//
//		val sc = new SparkContext(conf)
//		//		val lc = new LineageContext(sc)
//		//		lc.setCaptureLineage(true)
//		//
//
//		val file = sc.textFile(logFile, 1)
//		val fm = file.flatMap{line => line.trim().split(" ")}.filter(word  => !word.contains(","))
//
//		val pair = fm.map{word =>
//			if(word.contains(","))	(word.replace("," , ""), 1) else (word, 1)
//		}
//		val count = pair.reduceByKey(_ + _)
//		val d = count.collect()
//		println(d)
//		sc.stop()
	}
}
