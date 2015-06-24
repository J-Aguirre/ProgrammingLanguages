import scala.math._
import advmath._
import util.Error

object RungeKutta
{
    def integrate (f: Derivative, y0: Double, t: Double,
                   t0: Double = 0., _step: Double = defaultStepSize): Double =
    {
        val t_t0 = t - t0
        val steps: Int = (round (t_t0 / _step)).asInstanceOf [Int]
        var step = t_t0 / steps.asInstanceOf [Double]
        var ti = t0
        var y = y0
        var k1 = 0.; var k2 = 0.; var k3 = 0.; var k4 = 0.

        for (i <- 1 to steps) {
            ti += step
            if (ti > t) { step -= ti - t; ti = t }
            k1  = step * f (ti, y)
            k2  = step * f (ti + step/2., y + k1/2.)
            k3  = step * f (ti + step/2., y + k2/2.)
            k4  = step * f (ti + step, y + k3)

            y += (k1 + 2*k2 + 2*k3 + k4) / 6.

            if (i % 1000 == 0) println ("integrate: iteration " + i + " ti = " + ti + " y = " + y)
        }
        y
    }
}

object RungeKuttaTest extends App
{
    import scalation.dynamics.RungeKutta._

    val y0 = 1.
    val t  = 2.

    def derv1 (t: Double, y: Double) = 2. * t
    println ("\n==> at t = " + t + " y = " + integrate (derv1, y0, t))
    println ("\n==> t^2 + c = " + 5)

    def derv2 (t: Double, y: Double) = y
    println ("\n==> at t = " + t + " y = " + integrate (derv2, y0, t))
    println ("\n==> e = " + E + " e^2 = " + E * E)

    def derv3 (t: Double, y: Double) = t + y
    println ("\n==> at t = " + t + " y = " + integrate (derv3, y0, t))

    println ("\n==> at t = " + t + " y = " +
             integrateV (Array (derv1, derv2), Vec(1., 2.), t))

} // RungeKuttaTest object