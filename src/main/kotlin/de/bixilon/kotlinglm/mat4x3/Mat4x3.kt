package  de.bixilon.kotlinglm.mat4x3

/**
 * Created by GBarbieri on 09.12.2016.
 */

import de.bixilon.kotlinglm.ToFloatBuffer
import de.bixilon.kotlinglm.f
import de.bixilon.kotlinglm.toFloat
import de.bixilon.kotlinglm.vec3.Vec3
import de.bixilon.kotlinglm.vec3.Vec3t
import de.bixilon.kotlinkool.BYTES
import de.bixilon.kotlinkool.set
import java.nio.ByteBuffer
import java.nio.FloatBuffer


class Mat4x3(var array: FloatArray) : Mat4x3t<Float>(), ToFloatBuffer {

    constructor(list: Iterable<*>, index: Int = 0) : this(FloatArray(12) { list.elementAt(index + it)!!.toFloat })

    // -- Accesses --

    override operator fun get(index: Int) = Vec3(index * 3, array)
    override operator fun get(column: Int, row: Int) = array[column * 3 + row]

    override operator fun set(column: Int, row: Int, value: Float) = array.set(column * 3 + row, value)

    override operator fun set(index: Int, value: Vec3t<out Number>) {
        array[index * 3] = value._x.f
        array[index * 3 + 1] = value._y.f
        array[index * 3 + 2] = value._z.f
    }

    operator fun set(i: Int, v: Vec3) {
        v.to(array, i * 3)
    }

    fun toFloatArray(): FloatArray = to(FloatArray(length), 0)
    infix fun to(floats: FloatArray): FloatArray = to(floats, 0)
    fun to(floats: FloatArray, index: Int): FloatArray {
        System.arraycopy(array, 0, floats, index, length)
        return floats
    }

    override fun to(buf: ByteBuffer, offset: Int): ByteBuffer {
        return buf
                .putFloat(offset + 0 * Float.BYTES, array[0])
                .putFloat(offset + 1 * Float.BYTES, array[1])
                .putFloat(offset + 2 * Float.BYTES, array[2])
                .putFloat(offset + 3 * Float.BYTES, array[3])
                .putFloat(offset + 4 * Float.BYTES, array[4])
                .putFloat(offset + 5 * Float.BYTES, array[5])
                .putFloat(offset + 6 * Float.BYTES, array[6])
                .putFloat(offset + 7 * Float.BYTES, array[7])
                .putFloat(offset + 8 * Float.BYTES, array[8])
                .putFloat(offset + 9 * Float.BYTES, array[9])
                .putFloat(offset + 10 * Float.BYTES, array[10])
                .putFloat(offset + 11 * Float.BYTES, array[11])
    }


    override fun to(buf: FloatBuffer, offset: Int): FloatBuffer {
        buf[offset + 0] = array[0]
        buf[offset + 1] = array[1]
        buf[offset + 2] = array[2]
        buf[offset + 3] = array[3]
        buf[offset + 4] = array[4]
        buf[offset + 5] = array[5]
        buf[offset + 6] = array[6]
        buf[offset + 7] = array[7]
        buf[offset + 8] = array[8]
        buf[offset + 9] = array[9]
        buf[offset + 10] = array[10]
        buf[offset + 11] = array[11]
        return buf
    }

    override var a0: Float
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Float
        get() = array[1]
        set(v) = array.set(1, v)
    override var a2: Float
        get() = array[2]
        set(v) = array.set(2, v)

    override var b0: Float
        get() = array[3]
        set(v) = array.set(3, v)
    override var b1: Float
        get() = array[4]
        set(v) = array.set(4, v)
    override var b2: Float
        get() = array[5]
        set(v) = array.set(5, v)

    override var c0: Float
        get() = array[6]
        set(v) = array.set(6, v)
    override var c1: Float
        get() = array[7]
        set(v) = array.set(7, v)
    override var c2: Float
        get() = array[8]
        set(v) = array.set(8, v)

    override var d0: Float
        get() = array[9]
        set(v) = array.set(9, v)
    override var d1: Float
        get() = array[10]
        set(v) = array.set(10, v)
    override var d2: Float
        get() = array[11]
        set(v) = array.set(11, v)


    companion object {
        const val length = Mat4x3t.length
        @JvmField
        val size = length * Float.BYTES
    }

    override fun size() = size

    override fun elementCount() = length

    override fun equals(other: Any?) = other is Mat4x3 && array.contentEquals(other.array)

    override fun hashCode() = 31 * (31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()) + this[3].hashCode()
}
