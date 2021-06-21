import java.lang.StringBuilder

fun main(args: Array<String>) {

    println("Hello World!")
    getMedianOfSortedArrays(intArrayOf(2,4,10,12,16), intArrayOf(3,8,19,20,30))


//println(getLargestSubsequence("abxbab"))
//    val l1= ListNode(9, ListNode(9, ListNode(9, null)))
//    val l2 = ListNode(9, ListNode(9, null))
//    addTwoNumbers(l1,l2)


    //zolandoProblen3(intArrayOf(2, -2, 3,0,4,-7))
    //var list = listOf(1, 2)
//    for (i in 1..3) {
//        println(i)
//    }
//    for (i in 6 downTo 0 step 2) {
//        println(i)
//    }

//    var person  = Person("there")
//    person.varargtest("", "",value = 1)
//    var another = anotherChild(2)
//    println(another.hello1)
//    another.hello1 = 30
//    println(another.hello1)
}

fun getMedianOfSortedArrays(arr1: IntArray, arr2: IntArray): Int{
    var isEvenSize = (arr1.size + arr2.size) % 2 == 0
    var l1Index = 0
    var r1Index = 1
    var l2Index = arr2.size - 2
    var r2Index = arr2.size -1
    var l1 = arr1[l1Index]
    var r1 = arr1[r1Index]
    var l2 = arr2[l2Index]
    var r2 = arr2[r2Index]
    println("l1")
    println(l1)
    println("r1")
    println(r1)
    println("r2")
    println(r2)
    println("l2")
    println(l2)
    while(!(l1<r2 && l2<r1)){
        if(l1 >= r2){
            l1Index++
            r1Index++
            l2Index--
            r2Index--

        }
        if(l2>=r1){
            l1Index++
            r1Index++
            l2Index--
            r2Index--
        }
       // println(arr1.size)
        //println(l1Index)
        l1 = if(l1Index > arr1.size-1) 0 else  arr1[l1Index]
        l2 = if(l2Index > arr2.size-1) 0 else arr2[l2Index]
        r1 = if(r1Index> arr1.size-1) 0 else arr1[r1Index]
        r2 = if(r2Index> arr2.size-1) 0 else arr2[r2Index]

        println("loop")
    }
//    println(arr1[l1Index])
//    println(arr2[l2Index])
//    println(arr1[r1Index])
//    println(arr2[r2Index])
    val minElement = Math.min(r1,r2)
    val maxElement = Math.max(l1,l2)
    var median = 0
    if(isEvenSize){
        median = minElement + maxElement /2
    }
    return median
}

fun getLargestSubsequence(s: String) : Int{
    if (s.isEmpty() ) {
        return 0
    }
    var startPointer = 0
    var endPointer = 0
    var length = 0
    val set: MutableSet<Char> = HashSet()
    while (endPointer < s.length) {
        println("reading character")
        println(s[endPointer])
        println("start:"+startPointer)
        println("end:"+endPointer)
        if (set.add(s[endPointer])) {
            println("adding character")
            println(s[endPointer])
            endPointer++
            length = length.coerceAtLeast(set.size)
        } else {
            println("removing character")
            println(s[startPointer])
            set.remove(s[startPointer])
            startPointer++
        }
    }
    println(set.toString())
    return length
}


interface iAmInterface{
    val name: String
    val anotherName: String
     get() = "Name"


}

class imp(override val name: String) : iAmInterface{

}
class Person{
    fun varargtest(vararg string: String, value: Int){

    }
    init {
        println("I am another buddy")
    }
    constructor(name: String){
        println("Test 3")
    }

    constructor(another: String, anotherBuddy: String){
        println("Test 2")
    }

    init {
        println("Test 1")
    }
}

class Teacher (){
    constructor(name: String): this()
}

open class baseClass{
    constructor(name: String)
}

class childClass : baseClass(""){

}

open class anotherBaseClass(another: Float){
    constructor(test: String): this(0.3f)
    constructor(number : Int): this(0.5f)
}

class anotherChild(hello: Int) : anotherBaseClass(0.1f){
    constructor(name: String): this(1)
    //constructor(name: String, anotherNmae: String): super("")
    var iamvalue = 10
    var again = 10
    val aginIn = 12
    val againNull: Boolean? = null
    var testField : Boolean = false
      get() {
          if(hello1 ==10){

          }
          return  iamvalue != 10
      }
    var hello1 = 20
      set(value) {
          if(testField == false){
              field = 50
          }
      }
}

fun zolandoProblen3(A: IntArray): Int{
    var count  = 0
    if(A.size > 1000000000){
        return -1
    }else if(A.all {  it  == 0 }){
        return A.size
    }
    else{
        var sum = 0
        A.forEachIndexed {
          index, i ->
            sum = sum + i
            for(j in index+1..A.size-1){
                println(j)
                sum = sum + A[j]
             }
            //println(sum)
            if(sum == 0){
                count ++
            }else{
                sum = 0
            }
        }
        println(count)
        return count
    }

}

fun solutionZolando2(N: Int): Int {
    if(N<0){
       val negativeNo =   N.toString().removeRange(0,1)
       val finalResult =  "-5"+negativeNo
       return finalResult.toInt()
    }else if(N == 0) {
        val result = N + 50
        return result
    }else if(!N.toString().contains('0')) {
        val result = ("5" + N.toString()).toInt()
        return result
    }
    else{
        val noInStringFormat = N.toString()
        noInStringFormat.forEachIndexed{index, c ->

            if(c == '0'){
                var subString1 = noInStringFormat.substring(0, index)
                var subString2 = noInStringFormat.substring(index, noInStringFormat.length)
                val finalNo = (subString1 + "5" + subString2).toInt()
                return finalNo
            }
        }
    }
    return 0
}

fun solutionOfZolando(N: Int): String {
    val plus = '+'
    val minus = '-'
    var finalString = ""
    for(i in 0 until N){
        if(i%2 == 0){
            finalString += plus
        }else{
            finalString += minus
        }
    }
    println(finalString)
    return finalString
}
    fun twoSum(nums: IntArray, target: Int): IntArray {
    var resultantArray = IntArray(2)
    nums.forEachIndexed { index, it ->
        nums.forEachIndexed { index2, num2 ->
            if (index != index2) {
                if (it + num2 == target) {
                    resultantArray[0] = index
                    resultantArray[1] = index2
                }


            }
        }
    }
  return resultantArray
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var resultList : ListNode? = ListNode()
    var list1 = l1
    var list2 = l2
    var carry = 0
    var pointerResultList = resultList
    if(list1 == null && list2 == null){
        return resultList

    }

    while(list1!=null || list2!=null || carry > 0){
        val first = list1?.data ?: 0
        val second = list2?.data ?: 0
        val currentSum = first + second + carry
        carry = currentSum / 10
        pointerResultList?.next = ListNode()

        pointerResultList?.next?.data = currentSum % 10
        pointerResultList = pointerResultList?.next

        list1 = list1?.next
        list2 = list2?.next
    }
    while(resultList?.next!=null){
       println(resultList.next?.data)
       resultList = resultList.next
   }
   return resultList?.next
}
