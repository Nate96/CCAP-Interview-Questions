/**
 * Purpose:   An interviewing question given from CCAP for a job.
 *
 * Authors:   Nate Brauhkoff
 */
object JobQuestions {
  private final val MAX_STRING_LENGTH: Int = 10
  private final val MIN_STRING_LENGTH: Int = 5
  private final val UPPER_CASE_A: Int = 65
  private final val LOWER_CASE_Z: Int = 122

  def main(args: Array[String]): Unit = {
    val givenString: String = "19TR123"

    if (isValidString(givenString)) {
      try
        println(getYear(givenString).append(getCaseType(givenString)).append(getCaseID(givenString)))
      catch{
        case nullPointerException: NullPointerException =>
          println("Invalid Input")
      }
    } else
      println("Invalid Input")
  }

  /**
   * checks if the string with in the valid lengths
   * @param string string given by user
   * @return boolean
   */
  def isValidString(string: String): Boolean = {
    string.length >= MIN_STRING_LENGTH && string.length <= MAX_STRING_LENGTH
  }

  /**
   * checks if the character is a number
   * @param char character from given string
   * @return boolean
   */
  def isPositiveNumber(char: Char): Boolean = {
    char.asDigit <= 9 && char.asDigit >= 0
  }

  /**
   * converts the character into a integer, then uses the ASCII values of the chars to determine if it
   * is a valid character
   * @param char
   * @return boolean
   */
  def isValidCharacter(char: Char): Boolean = {
      char.toInt >= UPPER_CASE_A && char.toInt <= LOWER_CASE_Z
  }

  /**
   * gets the year that is contained in the given string.
   * Pre-condition: string.length >= 4
   * @param string string given by user
   * @return StringBuilder
   */
  def getYear(string: String): StringBuilder = {
    val stringBuilder: StringBuilder = new StringBuilder()
    val yearStartIndex: Int = 0

    stringBuilder.append("20")  //for years 2000 - 2099

    for (i <- yearStartIndex to (yearStartIndex + 1))
      if(isPositiveNumber(string(i)))
        stringBuilder.append(string(i))
      else
        return null

    stringBuilder
  }

  /**
   * gets the case type that is contained in the given string
   * Pre-Condition: string.length >= 4
   * @param string string given by user
   * @return
   */
  def getCaseType(string: String): StringBuilder = {
    val stringBuilder: StringBuilder = new StringBuilder()
    val startCaseTypeIndex: Int = 2

    for(i <- startCaseTypeIndex to (startCaseTypeIndex + 1))
      if(isValidCharacter(string(i)))
        stringBuilder.append(string(i))
      else
        return null

    stringBuilder
  }

  /**
   * gets the case ID that is contained in the given string
   * Pre-Condition: string.length >= 4
   * @param string string given by user
   * @return StringBuilder
   */
  def getCaseID(string: String): StringBuilder = {
    val stringBuilder: StringBuilder = new StringBuilder()
    val startCaseIDIndex: Int = 4

    for (i <- 1 to MAX_STRING_LENGTH - string.length)
      stringBuilder.append("0")

    for (i <- startCaseIDIndex until string.length)
      if (isPositiveNumber(string(i)))
        stringBuilder.append(string(i))
      else
        return null

    stringBuilder
  }
}
