package scoverage.report

import _root_.scoverage.MeasuredFile

import scala.io.Source

/** @author Stephen Samuel */
class CodeGrid(mFile: MeasuredFile) {

  var maxValue = -1
  case class Cell(char: Char, var status: StatementStatus, var count:Int) /**DCover Edits*/

  private val lineBreak = System.getProperty("line.separator")

  // Array of lines, each line is an array of cells, where a cell is a character + coverage info for that position
  // All cells default to NoData until the highlighted information is applied
  // note: we must re-include the line sep to keep source positions correct.
  private val lines = source(mFile).split(lineBreak).map(line => (line.toCharArray ++ lineBreak).map(Cell(_, NoData, 0))) /**DCover Edits*/

  // useful to have a single array to write into the cells
  private val cells = lines.flatten

  // apply the instrumentation data to the cells updating their coverage info
  mFile.statements.foreach(stmt => {
    if(stmt.count>maxValue)maxValue=stmt.count

    for ( k <- stmt.start until stmt.end ) {

      if (k < cells.size) {
        // if the cell is set to Invoked, then it be changed to NotInvoked, as an inner statement will override
        // outer containing statements. If a cell is NotInvoked then it can not be changed further.
        // in that block were executed
        /**DCover Edits*/
        cells(k).status match {
          case Invoked =>
            cells(k).count = stmt.count
            if (!stmt.isInvoked) cells(k).status = NotInvoked
          case NoData =>
            if (!stmt.isInvoked) cells(k).status = NotInvoked
            else if (stmt.isInvoked){
              cells(k).status = Invoked
              cells(k).count = stmt.count
            }
          case NotInvoked =>
        }
      }
    }
  })
  val highlighted: String = {
    var lineNumber = 1
    val code = lines map (line => {
      var style = cellStyle(NoData, 0)
      val sb = new StringBuilder
      sb append  lineNumber + " "
      lineNumber = lineNumber + 1
      sb append spanStart(NoData, 0)
      line.map(cell => {
        val style2 = cellStyle(cell.status,cell.count)
        if (style != style2) {
          sb append "</span>"
          sb append spanStart(cell.status, cell.count)
          style = style2
        }
        sb.append(cell.char)
      })
      sb append "</span>"
      sb.toString
    }) mkString ""
    s"<pre style='font-size: 12pt; font-family: courier;'>$code</pre>"
  }

  private def source(mfile: MeasuredFile): String = Source.fromFile(mfile.source).mkString

  private def spanStart(status: StatementStatus, count:Int): String = s"<span style='${cellStyle(status, count)}'>"

  private def cellStyle(status: StatementStatus, count:Int): String = {
    val GREEN = "#AEF1AE"
    val RED = "#F0ADAD"
    val COUNT = getColor(count)
    status match {
      case Invoked => s"background: $GREEN"
      case NotInvoked => s"background: $RED"
      case NoData => ""
    }
  }
  private def getColor(value:Int): String = {
    println(maxValue + "  " + value)
    val min = 0d
    val max = maxValue.toDouble
    val v1 = value.toDouble - min
    val d1 = (max - min) * 0.5d
    var red = 00d
    var green = 00d
    if (v1 <= d1) {
      red = Math.floor((255d * v1) / d1 + 0.5d)
      green = 255d
    }
    else {
      red = 255d
      green = Math.floor(255d - (255d * (v1 - d1)) / (max - min - d1) + 0.5d)
    }
    var reds = Integer.toHexString(red.toInt)
    var greens = Integer.toHexString(green.toInt)
    if (reds.length < 2) {
      reds = reds + "0"
    }
    if (greens.length < 2) {
      greens = greens + "0"
    }
    return "#" + greens + reds + "00"
  }
}

