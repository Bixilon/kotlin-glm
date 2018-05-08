package  glm_.mat3x3

import glm_.*
import glm_.glm.inverse
import glm_.glm.transpose
import glm_.mat2x2.Mat2
import glm_.mat2x2.Mat2d
import glm_.mat2x2.Mat2x2t
import glm_.mat2x3.Mat2x3t
import glm_.mat2x4.Mat2x4t
import glm_.mat3x2.Mat3x2t
import glm_.mat3x3.operators.mat3d_operators
import glm_.mat3x4.Mat3x4t
import glm_.mat4x2.Mat4x2t
import glm_.mat4x3.Mat4x3t
import glm_.mat4x4.Mat4
import glm_.mat4x4.Mat4d
import glm_.quat.QuatD
import glm_.vec2.Vec2t
import glm_.vec3.Vec3d
import glm_.vec3.Vec3t
import glm_.vec4.Vec4t
import java.nio.DoubleBuffer
import java.util.*

/**
 * Created by GBarbieri on 10.11.2016.
 */

class Mat3d(dummy: Int, var array: DoubleArray) : Mat3x3t<Double>() {

    // -- Constructors --

    constructor() : this(1)

    constructor(s: Number) : this(s, s, s)

    constructor(x: Number, y: Number, z: Number) : this(
            x, 0, 0,
            0, y, 0,
            0, 0, z)

    constructor(v: Vec2t<*>) : this(v.x, v.y, 0)
    constructor(v: Vec2t<*>, z: Number) : this(v.x, v.y, z)
    constructor(v: Vec3t<*>) : this(v.x, v.y, v.z)
    constructor(v: Vec4t<*>) : this(v.x, v.y, v.z)

    constructor(x0: Number, y0: Number, z0: Number,
                x1: Number, y1: Number, z1: Number,
                x2: Number, y2: Number, z2: Number) : this(0, doubleArrayOf(
            x0.d, y0.d, z0.d,
            x1.d, y1.d, z1.d,
            x2.d, y2.d, z2.d))

    constructor(v0: Vec3t<out Number>, v1: Vec3t<out Number>, v2: Vec3t<out Number>) : this(
            v0.x, v0.y, v0.z,
            v1.x, v1.y, v1.z,
            v2.x, v2.y, v2.z)

    constructor(block: (Int) -> Number) : this(
            block(0).d, block(1).d, block(2).d,
            block(3).d, block(4).d, block(5).d,
            block(6).d, block(7).d, block(8).d)

    constructor(list: Iterable<*>, index: Int = 0) : this(
            list.elementAt(index)!!.toDouble, list.elementAt(index + 1)!!.toDouble, list.elementAt(index + 2)!!.toDouble,
            list.elementAt(index + 3)!!.toDouble, list.elementAt(index + 4)!!.toDouble, list.elementAt(index + 5)!!.toDouble,
            list.elementAt(index + 6)!!.toDouble, list.elementAt(index + 7)!!.toDouble, list.elementAt(index + 8)!!.toDouble)

    // -- Matrix conversions --


    constructor(mat2: Mat2) : this(
            mat2[0, 0], mat2[0, 1], 0f,
            mat2[1, 0], mat2[1, 1], 0f,
            0f, 0f, 1f)

    constructor(mat2: Mat2d) : this(
            mat2[0, 0], mat2[0, 1], 0.0,
            mat2[1, 0], mat2[1, 1], 0.0,
            0.0, 0.0, 1.0)

    constructor(mat3: Mat3) : this(0, DoubleArray(length) { mat3.array[it].d })
    constructor(mat3: Mat3d) : this(0, mat3.array.clone())

    constructor(mat4: Mat4) : this(
            mat4[0, 0], mat4[0, 1], mat4[0, 2],
            mat4[1, 0], mat4[1, 1], mat4[1, 2],
            mat4[2, 0], mat4[2, 1], mat4[2, 2])

    constructor(mat4: Mat4d) : this(
            mat4[0, 0], mat4[0, 1], mat4[0, 2],
            mat4[1, 0], mat4[1, 1], mat4[1, 2],
            mat4[2, 0], mat4[2, 1], mat4[2, 2])

    constructor(mat2x3: Mat2x3t<*>) : this(
            mat2x3[0, 0], mat2x3[0, 1], mat2x3[0, 2],
            mat2x3[1, 0], mat2x3[1, 1], mat2x3[1, 2],
            0, 0, 1)

    constructor(mat3x2: Mat3x2t<*>) : this(
            mat3x2[0, 0], mat3x2[0, 1], 0,
            mat3x2[1, 0], mat3x2[1, 1], 0,
            mat3x2[2, 0], mat3x2[2, 1], 1)

    constructor(mat2x4: Mat2x4t<*>) : this(
            mat2x4[0, 0], mat2x4[0, 1], mat2x4[0, 2],
            mat2x4[1, 0], mat2x4[1, 1], mat2x4[1, 2],
            0, 0, 1)

    constructor(mat4x2: Mat4x2t<*>) : this(
            mat4x2[0, 0], mat4x2[0, 1], 0,
            mat4x2[1, 0], mat4x2[1, 1], 0,
            mat4x2[2, 0], mat4x2[2, 1], 1)

    constructor(mat3x4: Mat3x4t<*>) : this(
            mat3x4[0, 0], mat3x4[0, 1], mat3x4[0, 2],
            mat3x4[1, 0], mat3x4[1, 1], mat3x4[1, 2],
            mat3x4[2, 0], mat3x4[2, 1], mat3x4[2, 2])

    constructor(mat4x3: Mat4x3t<*>) : this(
            mat4x3[0, 0], mat4x3[0, 1], mat4x3[0, 2],
            mat4x3[1, 0], mat4x3[1, 1], mat4x3[1, 2],
            mat4x3[2, 0], mat4x3[2, 1], mat4x3[2, 2])

    constructor(doubles: DoubleArray, transpose: Boolean = false) : this(0,
            if (transpose) doubleArrayOf(
                    doubles[0], doubles[3], doubles[6],
                    doubles[1], doubles[4], doubles[7],
                    doubles[2], doubles[5], doubles[8])
            else doubles.clone())

    // to
//    fun to(mat2x2: Mat2x2t<*>) {
//        mat2x2[0, 0] = array[0]; mat2x2[0, 1] = array[1]
//        mat2x2[1, 0] = array[3]; mat2x2[1, 1] = array[4]
//    }

//    fun to(scalar: Number) {
//        value = mutableListOf(
//                Vec3d(scalar.main.getF, 0),
//                Vec3d(0, scalar.main.getF))
//    }
//
//    fun to(x0: Number, x1: Number, y0: Number, y1: Number) {
//        value = mutableListOf(
//                Vec3d(x0.main.getF, y0.main.getF),
//                Vec3d(x1.main.getF, y1.main.getF))
//    }
//
//    fun to(v0: Vec3dt<*>, v1: Vec3dt<*>) {
//        value = mutableListOf(
//                Vec3d(v0),
//                Vec3d(v1))
//    }

    // -- Accesses --

    override inline operator fun get(index: Int) = Vec3d(index * 3, array)
    override inline operator fun get(c: Int, r: Int) = array[c * 3 + r]

    override inline operator fun set(c: Int, r: Int, s: Double) = array.set(c * 3 + r, s)
    override inline operator fun set(i: Int, v: Vec3t<out Number>) {
        array[i * 3] = v.x.d
        array[i * 3 + 1] = v.y.d
        array[i * 3 + 2] = v.z.d
    }

    inline operator fun set(i: Int, v: Vec3d) {
        v.to(array, i * 3)
    }

    // -- Matrix functions --

    val det get() = glm.determinant(this)

    @JvmOverloads
    fun inverse(res: Mat3d = Mat3d()) = inverse(res, this)

    fun inverseAssign() = inverse(this, this)

    @JvmOverloads
    fun transpose(res: Mat3d = Mat3d()) = transpose(res, this)

    fun transposeAssign() = transpose(this, this)


    infix fun put(s: Double) = put(s, s, s)
    infix fun put(v: Vec3d) = put(v.x, v.y, v.z)

    fun put(x: Double, y: Double, z: Double): Mat3d {

        array[0] = x
        array[1] = 0.0
        array[2] = 0.0

        array[3] = 0.0
        array[4] = y
        array[5] = 0.0

        array[6] = 0.0
        array[7] = 0.0
        array[8] = z

        return this
    }

    // TODO others
    infix fun to(res: Mat4d): Mat4d {

        res[0, 0] = this[0, 0]
        res[0, 1] = this[0, 1]
        res[0, 2] = this[0, 2]
        res[0, 3] = 0.0

        res[1, 0] = this[1, 0]
        res[1, 1] = this[1, 1]
        res[1, 2] = this[1, 2]
        res[1, 3] = 0.0

        res[2, 0] = this[2, 0]
        res[2, 1] = this[2, 1]
        res[2, 2] = this[2, 2]
        res[2, 3] = 0.0

        res[3, 0] = 0.0
        res[3, 1] = 0.0
        res[3, 2] = 0.0
        res[3, 3] = 1.0

        return res
    }

    fun toMat4() = to(Mat4())

    infix fun to(res: QuatD) = glm.quatD_cast(this, res)
    fun toQuatD() = glm.quatD_cast(this, QuatD())


    infix fun to(dfb: DoubleBuffer) = to(dfb, 0)

    fun to(dfb: DoubleBuffer, offset: Int): DoubleBuffer {
        dfb[offset + 0] = array[0]
        dfb[offset + 1] = array[1]
        dfb[offset + 2] = array[2]
        dfb[offset + 3] = array[3]
        dfb[offset + 4] = array[4]
        dfb[offset + 5] = array[5]
        dfb[offset + 6] = array[6]
        dfb[offset + 7] = array[7]
        dfb[offset + 8] = array[8]
        return dfb
    }


    // -- Unary arithmetic operators --

    operator fun unaryPlus() = this

    operator fun unaryMinus() = Mat3d(
            -array[0], -array[1], -array[2],
            -array[3], -array[4], -array[5],
            -array[6], -array[7], -array[8])


// -- Increment main.and decrement operators --

    operator fun inc(res: Mat3d = Mat3d()): Mat3d = plus(res, this, 1.0)
    fun incAssign() = plus(this, this, 1.0)

    operator fun dec(res: Mat3d = Mat3d()): Mat3d = minus(res, this, 1.0)
    fun decAssign() = minus(this, this, 1.0)


// -- Specific binary arithmetic operators --

    infix operator fun plus(b: Double) = plus(Mat3d(), this, b)
    infix operator fun plus(b: Mat3d) = plus(Mat3d(), this, b)

    fun plus(b: Double, res: Mat3d) = plus(res, this, b)
    fun plus(b: Mat3d, res: Mat3d) = plus(res, this, b)

    infix operator fun plusAssign(b: Double) {
        plus(this, this, b)
    }

    infix operator fun plusAssign(b: Mat3d) {
        plus(this, this, b)
    }


    infix operator fun minus(b: Double) = minus(Mat3d(), this, b)
    infix operator fun minus(b: Mat3d) = minus(Mat3d(), this, b)

    fun minus(b: Double, res: Mat3d) = minus(res, this, b)
    fun minus(b: Mat3d, res: Mat3d) = minus(res, this, b)

    infix operator fun minusAssign(b: Double) {
        minus(this, this, b)
    }

    infix operator fun minusAssign(b: Mat3d) {
        minus(this, this, b)
    }


    infix operator fun times(b: Double) = times(Mat3d(), this, b)
    infix operator fun times(b: Vec3d) = times(Vec3d(), this, b)
    infix operator fun times(b: Mat3d) = times(Mat3d(), this, b)

    fun times(b: Double, res: Mat3d) = times(res, this, b)
    fun times(b: Vec3d, res: Vec3d) = times(res, this, b)
    fun times(b: Mat3d, res: Mat3d) = times(res, this, b)

    infix operator fun timesAssign(b: Double) {
        times(this, this, b)
    }

    infix operator fun timesAssign(b: Vec3d) {
        times(b, this, b)
    }

    infix operator fun timesAssign(b: Mat3d) {
        times(this, this, b)
    }


    infix operator fun div(b: Double) = div(Mat3d(), this, b)
    infix operator fun div(b: Mat3d) = div(Mat3d(), this, b)

    fun div(b: Double, res: Mat3d) = div(res, this, b)
    fun div(b: Mat3d, res: Mat3d) = div(res, this, b)

    infix operator fun divAssign(b: Double) {
        div(this, this, b)
    }

    infix operator fun divAssign(b: Mat3d) {
        div(this, this, b)
    }


    infix fun isEqual(b: Mat3d) = this[0].isEqual(b[0]) && this[1].isEqual(b[1]) && this[2].isEqual(b[2])

    // TODO others
    override var a0: Double
        get() = array[0]
        set(v) = array.set(0, v)
    override var a1: Double
        get() = array[1]
        set(v) = array.set(1, v)
    override var a2: Double
        get() = array[2]
        set(v) = array.set(2, v)

    override var b0: Double
        get() = array[3]
        set(v) = array.set(3, v)
    override var b1: Double
        get() = array[4]
        set(v) = array.set(4, v)
    override var b2: Double
        get() = array[5]
        set(v) = array.set(5, v)

    override var c0: Double
        get() = array[6]
        set(v) = array.set(6, v)
    override var c1: Double
        get() = array[7]
        set(v) = array.set(7, v)
    override var c2: Double
        get() = array[8]
        set(v) = array.set(8, v)


    override val isIdentity
        get() = this[0, 0] == 1.0 && this[1, 0] == 0.0 && this[2, 0] == 0.0 &&
                this[0, 1] == 0.0 && this[1, 1] == 1.0 && this[2, 1] == 0.0 &&
                this[0, 2] == 0.0 && this[1, 2] == 0.0 && this[2, 2] == 1.0

    companion object : mat3d_operators() {
        const val length = Mat3x3t.length
        @JvmField
        val size = length * Double.BYTES
    }

    override fun size() = size

    override fun equals(other: Any?) = other is Mat3d && Arrays.equals(array, other.array)

    override fun hashCode() = 31 * (31 * this[0].hashCode() + this[1].hashCode()) + this[2].hashCode()
}