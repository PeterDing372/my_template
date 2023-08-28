package hello
import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.flatspec.AnyFlatSpec

class helloSpec extends AnyFreeSpec with ChiselScalatestTester{
    "hello should properly pass through" in {

    test(new HelloModule ) { c =>
        println("Testing HelloModule:")
        c.io.in.poke(42.U)
        c.io.out.expect(42.U)
    }

    }
    
}

class SimpleTest extends AnyFlatSpec with ChiselScalatestTester {
    "DUT" should "pass" in {
        test(new DeviceUnderTest) { dut =>
            dut.io.a.poke(0.U)
            dut.io.b.poke(1.U)
            dut.clock.step()
            println("Result is: " + dut.io.out.peek().toString)
            dut.io.a.poke(3.U)
            dut.io.b.poke(2.U)
            dut.clock.step()
            println("Result is: " + dut.io.out.peek().toString)
        }
    }
}


class WaveformTest extends AnyFlatSpec with ChiselScalatestTester {
    "Waveform" should "pass" in {
        test(new DeviceUnderTest)
            .withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
                dut.io.a.poke(0.U)
                dut.io.b.poke(0.U)
                dut.clock.step()
                dut.io.a.poke(0.U)
                dut.io.b.poke(1.U)
                dut.clock.step()
                dut.io.a.poke(1.U)
                dut.io.b.poke(0.U)
                dut.clock.step()
                dut.io.a.poke(1.U)
                dut.io.b.poke(1.U)
                dut.clock.step()
            }
    }
}


class WaveformTestWithIteration extends AnyFlatSpec with ChiselScalatestTester {
    "WaveformIteration" should "pass" in {
        test(new DeviceUnderTest)
        .withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
            for (a <- 0 until 4) {
                for (b <- 0 until 4) {
                    dut.io.a.poke(a.U)
                    dut.io.b.poke(b.U)
                    dut.clock.step()
                }
            }
        }
    }
}
