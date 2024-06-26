package de.bixilon.kotlinglm

import de.bixilon.kotlinglm.GLM.abs
import de.bixilon.kotlinglm.GLM.greaterThan
import de.bixilon.kotlinglm.GLM.lessThan
import de.bixilon.kotlinglm.quaternion.Quat
import de.bixilon.kotlinglm.quaternion.QuatD
import de.bixilon.kotlinglm.vec1.Vec1
import de.bixilon.kotlinglm.vec1.Vec1bool
import de.bixilon.kotlinglm.vec1.Vec1d
import de.bixilon.kotlinglm.vec2.*
import de.bixilon.kotlinglm.vec3.*
import de.bixilon.kotlinglm.vec4.*

/**
 * Created by GBarbieri on 11.11.2016.
 */


interface Epsilon {


    fun epsilonEqual(a: Float, b: Float, epsilon: Float): Boolean = abs(a - b) < epsilon
    fun epsilonEqual(a: Double, b: Double, epsilon: Double): Boolean = abs(a - b) < epsilon

    fun epsilonEqual(a: Vec1, b: Vec1, epsilon: Float, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1(epsilon), res)
    fun epsilonEqual(a: Vec1, b: Vec1, epsilon: Vec1, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), epsilon, res)

    fun epsilonEqual(a: Vec1d, b: Vec1d, epsilon: Double, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), Vec1d(epsilon), res)
    fun epsilonEqual(a: Vec1d, b: Vec1d, epsilon: Vec1d, res: Vec1bool = Vec1bool()) = lessThan(abs(a - b), epsilon, res)

    fun epsilonEqual(a: Vec2, b: Vec2, epsilon: Float, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2(epsilon), res)
    fun epsilonEqual(a: Vec2, b: Vec2, epsilon: Vec2, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon, res)

    fun epsilonEqual(a: Vec2d, b: Vec2d, epsilon: Double, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), Vec2d(epsilon), res)
    fun epsilonEqual(a: Vec2d, b: Vec2d, epsilon: Vec2d, res: Vec2bool = Vec2bool()) = lessThan(abs(a - b), epsilon, res)

    fun epsilonEqual(a: Vec3, b: Vec3, epsilon: Float, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3(epsilon), res)
    fun epsilonEqual(a: Vec3, b: Vec3, epsilon: Vec3, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon, res)

    fun epsilonEqual(a: Vec3d, b: Vec3d, epsilon: Double, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), Vec3d(epsilon), res)
    fun epsilonEqual(a: Vec3d, b: Vec3d, epsilon: Vec3d, res: Vec3bool = Vec3bool()) = lessThan(abs(a - b), epsilon, res)

    fun epsilonEqual(a: Vec4, b: Vec4, epsilon: Float, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4(epsilon), res)
    fun epsilonEqual(a: Vec4, b: Vec4, epsilon: Vec4, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon, res)

    fun epsilonEqual(a: Vec4d, b: Vec4d, epsilon: Double, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), Vec4d(epsilon), res)
    fun epsilonEqual(a: Vec4d, b: Vec4d, epsilon: Vec4d, res: Vec4bool = Vec4bool()) = lessThan(abs(a - b), epsilon, res)

    fun epsilonEqual(a: Quat, b: Quat, epsilon: Float, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) < epsilon
        res.y = abs(a.y - b.y) < epsilon
        res.z = abs(a.z - b.z) < epsilon
        res.w = abs(a.w - b.w) < epsilon
        return res
    }

    fun epsilonEqual(a: QuatD, b: QuatD, epsilon: Double, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) < epsilon
        res.y = abs(a.y - b.y) < epsilon
        res.z = abs(a.z - b.z) < epsilon
        res.w = abs(a.w - b.w) < epsilon
        return res
    }


    fun epsilonNotEqual(a: Float, b: Float, epsilon: Float): Boolean = abs(a - b) >= epsilon
    fun epsilonNotEqual(a: Double, b: Double, epsilon: Double): Boolean = abs(a - b) >= epsilon

    fun epsilonNotEqual(a: Vec1, b: Vec1, epsilon: Float, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1(epsilon), res)
    fun epsilonNotEqual(a: Vec1, b: Vec1, epsilon: Vec1, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), epsilon, res)

    fun epsilonNotEqual(a: Vec1d, b: Vec1d, epsilon: Double, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), Vec1d(epsilon), res)
    fun epsilonNotEqual(a: Vec1d, b: Vec1d, epsilon: Vec1d, res: Vec1bool = Vec1bool()) = greaterThan(abs(a - b), epsilon, res)

    fun epsilonNotEqual(a: Vec2, b: Vec2, epsilon: Float, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2(epsilon), res)
    fun epsilonNotEqual(a: Vec2, b: Vec2, epsilon: Vec2, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon, res)

    fun epsilonNotEqual(a: Vec2d, b: Vec2d, epsilon: Double, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), Vec2d(epsilon), res)
    fun epsilonNotEqual(a: Vec2d, b: Vec2d, epsilon: Vec2d, res: Vec2bool = Vec2bool()) = greaterThan(abs(a - b), epsilon, res)

    fun epsilonNotEqual(a: Vec3, b: Vec3, epsilon: Float, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3(epsilon), res)
    fun epsilonNotEqual(a: Vec3, b: Vec3, epsilon: Vec3, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon, res)

    fun epsilonNotEqual(a: Vec3d, b: Vec3d, epsilon: Double, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), Vec3d(epsilon), res)
    fun epsilonNotEqual(a: Vec3d, b: Vec3d, epsilon: Vec3d, res: Vec3bool = Vec3bool()) = greaterThan(abs(a - b), epsilon, res)

    fun epsilonNotEqual(a: Vec4, b: Vec4, epsilon: Float, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4(epsilon), res)
    fun epsilonNotEqual(a: Vec4, b: Vec4, epsilon: Vec4, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon, res)

    fun epsilonNotEqual(a: Vec4d, b: Vec4d, epsilon: Double, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), Vec4d(epsilon), res)
    fun epsilonNotEqual(a: Vec4d, b: Vec4d, epsilon: Vec4d, res: Vec4bool = Vec4bool()) = greaterThan(abs(a - b), epsilon, res)

    fun epsilonNotEqual(a: Quat, b: Quat, epsilon: Float, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) >= epsilon
        res.y = abs(a.y - b.y) >= epsilon
        res.z = abs(a.z - b.z) >= epsilon
        res.w = abs(a.w - b.w) >= epsilon
        return res
    }

    fun epsilonNotEqual(a: QuatD, b: QuatD, epsilon: Double, res: Vec4bool = Vec4bool()): Vec4bool {
        res.x = abs(a.x - b.x) >= epsilon
        res.y = abs(a.y - b.y) >= epsilon
        res.z = abs(a.z - b.z) >= epsilon
        res.w = abs(a.w - b.w) >= epsilon
        return res
    }
}
