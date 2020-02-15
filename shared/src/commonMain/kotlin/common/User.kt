package common

data class User(val firstName: String, val lastName: String)

expect fun printHello()

fun printPlatformHello(){
  printHello()
}