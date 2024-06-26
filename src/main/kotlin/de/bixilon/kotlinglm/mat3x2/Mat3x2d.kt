package  de.bixilon.kotlinglm.mat3x2

import de.bixilon.kotlinglm.ToDoubleBuffer
import de.bixilon.kotlinglm.d
import de.bixilon.kotlinglm.toDouble
import de.bixilon.kotlinglm.vec2.Vec2d
import de.bixilon.kotlinglm.vec2.Vec2t
import de.bixilon.kotlinkool.BYTES
import de.bixilon.kotlinkool.set
import java.nio.ByteBuffer
import java.nio.DoubleBuffer

/**
 * Created by GBarbieri on 09.12.2016.
 */

class Mat3x2d(var array: DoubleArray) : Mat3x2t<Double>(), ToDoubleBuffer {

    constructor(list: Iterable<*>, index: Int = 0) : this(DoubleArray(6) { list.elementAt(index + it)!!.toDouble })

    // -- Accesses --

    override operator fun get(index: Int) = Vec2d(index * 2, array)
    override operator fun get(column: Int, row: Int) = array[column * 2 + row]

    override operator fun set(column: Int, row: Int, value: Double) = array.set(column * 2 + row, value)

    override operator fun set(index: Int, value: Vec2t<out Number>) {
        array[index * 2] = value._x.d
        array[index * 2 + 1] = value._y.d
    }

    operator fun set(i: Int, v: Vec2d) {
        v.to(array, i * 2)
    }

    fun toDoubleArray(): DoubleArray = to(DoubleArray(length), 0)
    infix fun to(doubles: DoubleArray): DoubleArray = to(doubles, 0)
    fun to(doubles: DoubleArray, index: Int): DoubleArray {
        System.arraycopy(array, 0, doubles, index, length)
        return doubles
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
                .putDouble(offset + 0 * Double.BYTES, array[0])
                .putDouble(offset + 1 * Double.BYTES, array[1])
                .putDouble(offset + 2 * Double.BYTES, array[2])
                .putDouble(offset + 3 * Double.BYTES, array[3])
                .putDouble(offset + 4 * Double.BYTES, array[4])
                .putDouble(offset + 5 * Double.BYTES, array[5])
    }

    override fun to(buf: DoubleBuffer, offset: Int): DoubleBuffer {
        buf[offset + 0] = array[0]
        buf[offset + 1] = array[1]
        buf[offset + 2] = array[2]
        buf[offset + 3] = array[3]
        buf[offset + 4] = array[4]
        buf[offset + 5] = array[5]
        return buf
    }

    override var a0: Double
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Double
        get() = array[1]
        set(v) = array.set(1, v)

    override var b0: Double
        get() = array[2]
        set(v) = array.set(2, v)
    override var b1: Double
        get() = array[3]
        set(v) = array.set(3, v)

    override var c0: Double
        get() = array[4]
        set(v) = array.set(4, v)
    override var c1: Double
        get() = array[5]
        set(v) = array.set(5, v)


    companion object {
        const val length = Mat3x2t.length
        @JvmField
        val size = length * Double.BYTES
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Mat3x2d && array.contentEquals(other.array)

    override fun hashCode() = 31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()
}
