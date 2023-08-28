package hello
import chisel3._
import chisel3.util._

class HelloModule extends Module {
    val io = IO(new Bundle {
        val in = Input(UInt(8.W))
        val out = Output(UInt(8.W)) 
    })
    io.out := io.in
    println("Hello! This is a hello module by Quanchen.")
}


// import chisel3._
// import chiseltest._
// import org.scalatest.flatspec.AnyFlatSpec

class DeviceUnderTest extends Module {
    val io = IO(new Bundle {
        val a = Input(UInt(2.W))
        val b = Input(UInt(2.W))
        val out = Output(UInt(2.W))
    })
    
    io.out := io.a & io.b
}






