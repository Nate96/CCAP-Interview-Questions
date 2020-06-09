import org.scalatest.FunSuite

class JobQuestionTest extends FunSuite{
  test("JobQuestion.isPositiveNumber"){
    assert(!JobQuestions.isPositiveNumber('A'))
    assert(JobQuestions.isPositiveNumber('3'))
  }

  test("JobQuestions.IsValidString"){
    assert(JobQuestions.isValidString("19TN123"))
    assert(JobQuestions.isValidString("13TN0"))
    assert(!JobQuestions.isValidString("13TN"))
    assert(!JobQuestions.isValidString("12345678910"))
  }

  test("JobsQuestions.getYear"){
    assert(JobQuestions.getYear("14NA0").toString() == "2014")
    assert(JobQuestions.getYear("NANA0") == null)
  }

  test("JobQuestions.getCaseType"){
    assert(JobQuestions.getCaseType("19TN0").toString() == "TN" )
    assert(JobQuestions.getCaseType("19140") == null)
  }

  test("JobQuestions.getCaseID"){
    assert(JobQuestions.getCaseID("19TN123").toString() == "000123")
    assert(JobQuestions.getCaseID("19TN1").toString() == "000001")
    assert(JobQuestions.getCaseID("12TN12345").toString() == "012345")
  }

}
