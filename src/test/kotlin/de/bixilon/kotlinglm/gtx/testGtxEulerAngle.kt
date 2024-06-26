package de.bixilon.kotlinglm.gtx

import de.bixilon.kotlinglm.GLM
import de.bixilon.kotlinglm.mat3x3.Mat3
import de.bixilon.kotlinglm.mat4x4.Mat4
import de.bixilon.kotlinglm.shouldEqual
import de.bixilon.kotlinglm.vec3.Vec3
import de.bixilon.kotlinglm.vec4.Vec4
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class testGtxEulerAngle : StringSpec() {

    init {

        val X = Vec3(1f, 0f, 0f)
        val Y = Vec3(0f, 1f, 0f)
        val Z = Vec3(0f, 0f, 1f)

        "eulerAngleX" {

            val angle = GLM.PIf * 0.5f
            val x = Vec3(1f, 0f, 0f)

            val y = Vec4(0f, 1f, 0f, 1f)
            val y1 = GLM.rotate(Mat4(1f), angle, x) * y
            val y2 = GLM.eulerAngleX(angle) * y
            val y3 = GLM.eulerAngleXY(angle, 0f) * y
            val y4 = GLM.eulerAngleYX(0f, angle) * y
            val y5 = GLM.eulerAngleXZ(angle, 0f) * y
            val y6 = GLM.eulerAngleZX(0f, angle) * y
            val y7 = GLM.eulerAngleYXZ(0f, angle, 0f) * y
            y1.shouldEqual(y2, 0.00001f)
            y1.shouldEqual(y3, 0.00001f)
            y1.shouldEqual(y4, 0.00001f)
            y1.shouldEqual(y5, 0.00001f)
            y1.shouldEqual(y6, 0.00001f)
            y1.shouldEqual(y7, 0.00001f)

            val z = Vec4(0f, 0f, 1f, 1f)
            val z1 = GLM.rotate(Mat4(1f), angle, x) * z
            val z2 = GLM.eulerAngleX(angle) * z
            val z3 = GLM.eulerAngleXY(angle, 0f) * z
            val z4 = GLM.eulerAngleYX(0f, angle) * z
            val z5 = GLM.eulerAngleXZ(angle, 0f) * z
            val z6 = GLM.eulerAngleZX(0f, angle) * z
            val z7 = GLM.eulerAngleYXZ(0f, angle, 0f) * z
            z1.shouldEqual(z2, 0.00001f)
            z1.shouldEqual(z3, 0.00001f)
            z1.shouldEqual(z4, 0.00001f)
            z1.shouldEqual(z5, 0.00001f)
            z1.shouldEqual(z6, 0.00001f)
            z1.shouldEqual(z7, 0.00001f)
        }

        "eulerAngleY" {

            val angle = GLM.PIf * 0.5f
            val y = Vec3(0f, 1f, 0f)

            val x = Vec4(1f, 0f, 0f, 1f)
            val x1 = GLM.rotate(Mat4(1f), angle, y) * x
            val x2 = GLM.eulerAngleY(angle) * x
            val x3 = GLM.eulerAngleYX(angle, 0f) * x
            val x4 = GLM.eulerAngleXY(0f, angle) * x
            val x5 = GLM.eulerAngleYZ(angle, 0f) * x
            val x6 = GLM.eulerAngleZY(0f, angle) * x
            val x7 = GLM.eulerAngleYXZ(angle, 0f, 0f) * x
            x1.shouldEqual(x2, 0.00001f)
            x1.shouldEqual(x3, 0.00001f)
            x1.shouldEqual(x4, 0.00001f)
            x1.shouldEqual(x5, 0.00001f)
            x1.shouldEqual(x6, 0.00001f)
            x1.shouldEqual(x7, 0.00001f)

            val z = Vec4(0f, 0f, 1f, 1f)
            val z1 = GLM.eulerAngleY(angle) * z
            val z2 = GLM.rotate(Mat4(1f), angle, y) * z
            val z3 = GLM.eulerAngleYX(angle, 0f) * z
            val z4 = GLM.eulerAngleXY(0f, angle) * z
            val z5 = GLM.eulerAngleYZ(angle, 0f) * z
            val z6 = GLM.eulerAngleZY(0f, angle) * z
            val z7 = GLM.eulerAngleYXZ(angle, 0f, 0f) * z
            z1.shouldEqual(z2, 0.00001f)
            z1.shouldEqual(z3, 0.00001f)
            z1.shouldEqual(z4, 0.00001f)
            z1.shouldEqual(z5, 0.00001f)
            z1.shouldEqual(z6, 0.00001f)
            z1.shouldEqual(z7, 0.00001f)
        }

        "eulerAngleZ" {

            val angle = GLM.PIf * 0.5f
            val z = Vec3(0f, 0f, 1f)

            val x = Vec4(1f, 0f, 0f, 1f)
            val x1 = GLM.rotate(Mat4(1f), angle, z) * x
            val x2 = GLM.eulerAngleZ(angle) * x
            val x3 = GLM.eulerAngleZX(angle, 0f) * x
            val x4 = GLM.eulerAngleXZ(0f, angle) * x
            val x5 = GLM.eulerAngleZY(angle, 0f) * x
            val x6 = GLM.eulerAngleYZ(0f, angle) * x
            val x7 = GLM.eulerAngleYXZ(0f, 0f, angle) * x
            x1.shouldEqual(x2, 0.00001f)
            x1.shouldEqual(x3, 0.00001f)
            x1.shouldEqual(x4, 0.00001f)
            x1.shouldEqual(x5, 0.00001f)
            x1.shouldEqual(x6, 0.00001f)
            x1.shouldEqual(x7, 0.00001f)

            val y = Vec4(1f, 0f, 0f, 1f)
            val z1 = GLM.rotate(Mat4(1f), angle, z) * y
            val z2 = GLM.eulerAngleZ(angle) * y
            val z3 = GLM.eulerAngleZX(angle, 0f) * y
            val z4 = GLM.eulerAngleXZ(0f, angle) * y
            val z5 = GLM.eulerAngleZY(angle, 0f) * y
            val z6 = GLM.eulerAngleYZ(0f, angle) * y
            val z7 = GLM.eulerAngleYXZ(0f, 0f, angle) * y
            z1.shouldEqual(z2, 0.00001f)
            z1.shouldEqual(z3, 0.00001f)
            z1.shouldEqual(z4, 0.00001f)
            z1.shouldEqual(z5, 0.00001f)
            z1.shouldEqual(z6, 0.00001f)
            z1.shouldEqual(z7, 0.00001f)
        }

        "derivedEulerAngles" {

            fun derivedEulerAngles(rotationFunc: (Float) -> Mat4, testDerivedFunc: (Float, Float) -> Mat4, basis: Vec3) {

                val zeroAngle = 0f
                val angle = GLM.PIf * 0.75f
                val negativeAngle = -angle
                val zeroAngleVelocity = 0f
                val angleVelocity = GLM.PIf * 0.27f
                val negativeAngleVelocity = -angleVelocity

                listOf(
                        zeroAngle to zeroAngleVelocity,
                        zeroAngle to angleVelocity,
                        zeroAngle to negativeAngleVelocity,
                        angle to zeroAngleVelocity,
                        angle to angleVelocity,
                        angle to negativeAngleVelocity,
                        negativeAngle to zeroAngleVelocity,
                        negativeAngle to angleVelocity,
                        negativeAngle to negativeAngleVelocity).forEach {

                    val w = GLM.matrixCross4(basis * it.second)
                    val rotMt = GLM.transpose(rotationFunc(it.first))
                    val derivedRotM = testDerivedFunc(it.first, it.second)

                    w.shouldEqual(derivedRotM * rotMt, 0.00001f)
                }
            }

            derivedEulerAngles(GLM::eulerAngleX, GLM::derivedEulerAngleX, X)
            derivedEulerAngles(GLM::eulerAngleY, GLM::derivedEulerAngleY, Y)
            derivedEulerAngles(GLM::eulerAngleZ, GLM::derivedEulerAngleZ, Z)
        }

        "eulerAngleXY" {

            val v = Vec4(1f)

            val angleX = GLM.PIf * 0.5f
            val angleY = GLM.PIf * 0.25f

            val v1 = (GLM.rotateX(Mat4(1f), angleX) * GLM.rotateY(Mat4(1f), angleY)) * v
            val v2 = GLM.eulerAngleXY(angleX, angleY) * v
            val v3 = GLM.eulerAngleX(angleX) * GLM.eulerAngleY(angleY) * v
            v1.shouldEqual(v2, 0.00001f)
            v1.shouldEqual(v3, 0.00001f)
        }

        "eulerAngleYX" {

            val v = Vec4(1f)

            val angleX = GLM.PIf * 0.5f
            val angleY = GLM.PIf * 0.25f

            val v1 = (GLM.rotateY(Mat4(1f), angleY) * GLM.rotateX(Mat4(1f), angleX)) * v
            val v2 = GLM.eulerAngleYX(angleY, angleX) * v
            val v3 = GLM.eulerAngleY(angleY) * GLM.eulerAngleX(angleX) * v
            v1.shouldEqual(v2, 0.00001f)
            v1.shouldEqual(v3, 0.00001f)
        }

        "eulerAngleXZ" {

            val v = Vec4(1f)

            val angleX = GLM.PIf * 0.5f
            val angleZ = GLM.PIf * 0.25f

            val v1 = (GLM.rotateX(Mat4(1f), angleX) * GLM.rotateZ(Mat4(1f), angleZ)) * v
            val v2 = GLM.eulerAngleXZ(angleX, angleZ) * v
            val v3 = GLM.eulerAngleX(angleX) * GLM.eulerAngleZ(angleZ) * v
            v1.shouldEqual(v2, 0.00001f)
            v1.shouldEqual(v3, 0.00001f)
        }

        "eulerAngleZX" {

            val v = Vec4(1f)

            val angleX = GLM.PIf * 0.5f
            val angleZ = GLM.PIf * 0.25f

            val v1 = (GLM.rotateZ(Mat4(1f), angleZ) * GLM.rotateX(Mat4(1f), angleX)) * v
            val v2 = GLM.eulerAngleZX(angleZ, angleX) * v
            val v3 = GLM.eulerAngleZ(angleZ) * GLM.eulerAngleX(angleX) * v
            v1.shouldEqual(v2, 0.00001f)
            v1.shouldEqual(v3, 0.00001f)
        }

        "eulerAngleYZ" {

            val v = Vec4(1f)

            val angleY = GLM.PIf * 0.5f
            val angleZ = GLM.PIf * 0.25f

            val v1 = (GLM.rotateY(Mat4(1f), angleY) * GLM.rotateZ(Mat4(1f), angleZ)) * v
            val v2 = GLM.eulerAngleYZ(angleY, angleZ) * v
            val v3 = GLM.eulerAngleY(angleY) * GLM.eulerAngleZ(angleZ) * v
            v1.shouldEqual(v2, 0.00001f)
            v1.shouldEqual(v3, 0.00001f)
        }

        "eulerAngleZY" {

            val v = Vec4(1f)

            val angleY = GLM.PIf * 0.5f
            val angleZ = GLM.PIf * 0.25f

            val v1 = (GLM.rotateZ(Mat4(1f), angleZ) * GLM.rotateY(Mat4(1f), angleY)) * v
            val v2 = GLM.eulerAngleZY(angleZ, angleY) * v
            val v3 = GLM.eulerAngleZ(angleZ) * GLM.eulerAngleY(angleY) * v
            v1.shouldEqual(v2, 0.00001f)
            v1.shouldEqual(v3, 0.00001f)
        }

        "eulerAngleYXZ" {

            val first = 1.046f
            val second = 0.52f
            val third = -0.785f

            val rotationEuler = GLM.eulerAngleYXZ(first, second, third)

            val rotationInvertedY = GLM.eulerAngleY(-1f * first) * GLM.eulerAngleX(second) * GLM.eulerAngleZ(third)
            val rotationDumb = Mat4()
                    .rotateYassign(first)
                    .rotateXassign(second)
                    .rotateZ(third)

            val res = Mat3(
                    0.050483525f, -0.61339647f, -0.78815997f,
                    0.6583315f, 0.61388505f, -0.4355969f,
                    0.7510333f, -0.4968801f, 0.43480933f)

            Mat3(rotationEuler) shouldBe res
            Mat3(rotationDumb) shouldBe res
            Mat3(rotationInvertedY) shouldBe Mat3(
                    0.6583715f, -0.61339647f, 0.43622434f,
                    0.049959302f, 0.61388505f, 0.7878128f,
                    -0.7510333f, -0.4968801f, 0.43480933f)

//            std::printf("\nRESIDUAL\n")
//            std::printf("%s\n", glm::to_string(GLM::fmat3(rotationEuler - (rotationDumb))).c_str())
//            std::printf("%s\n", glm::to_string(GLM::fmat3(rotationEuler - (rotationInvertedY))).c_str())
        }

        "eulerAngles" {

            fun test(testRotationFunc: (Float, Float, Float) -> Mat4, i: Vec3, j: Vec3, k: Vec3) {

                val minAngle = -GLM.PIf
                val maxAngle = GLM.PIf
                val maxAngleWithDelta = maxAngle - 0.0000001f
                val minMidAngle = -GLM.PIf * 0.5f
                val maxMidAngle = GLM.PIf * 0.5f

                listOf(
                        Vec3(1.046f, 0.52f, -0.785f),
                        Vec3(minAngle, minMidAngle, minAngle),
                        Vec3(minAngle, minMidAngle, maxAngle),
                        Vec3(minAngle, minMidAngle, maxAngleWithDelta),
                        Vec3(minAngle, maxMidAngle, minAngle),
                        Vec3(minAngle, maxMidAngle, maxAngle),
                        Vec3(minAngle, maxMidAngle, maxAngleWithDelta),
                        Vec3(maxAngle, minMidAngle, minAngle),
                        Vec3(maxAngle, minMidAngle, maxAngle),
                        Vec3(maxAngle, minMidAngle, maxAngleWithDelta),
                        Vec3(maxAngleWithDelta, minMidAngle, maxAngle),
                        Vec3(maxAngleWithDelta, minMidAngle, maxAngleWithDelta),
                        Vec3(maxAngle, maxMidAngle, minAngle),
                        Vec3(maxAngleWithDelta, maxMidAngle, minAngle),
                        Vec3(maxAngle, maxMidAngle, maxAngle),
                        Vec3(maxAngle, maxMidAngle, maxAngleWithDelta),
                        Vec3(maxAngleWithDelta, maxMidAngle, maxAngle),
                        Vec3(maxAngleWithDelta, maxMidAngle, maxAngleWithDelta),
                        Vec3(minAngle, 0f, minAngle),
                        Vec3(minAngle, 0f, maxAngle),
                        Vec3(maxAngle, maxAngle, minAngle),
                        Vec3(maxAngle, maxAngle, maxAngle)).forEach { angles ->

                    val rotationEuler = testRotationFunc(angles.x, angles.y, angles.z)

                    val rotationDumb = Mat4(1f)
                            .rotateAssign(angles.x, i)
                            .rotateAssign(angles.y, j)
                            .rotateAssign(angles.z, k)

                    val v = Vec4(1f)
                    val v1 = rotationEuler * v
                    val v2 = rotationDumb * v

                    v1.shouldEqual(v2, 0.00001f)
                }
            }

            test(GLM::eulerAngleXZX, X, Z, X)
            test(GLM::eulerAngleXYX, X, Y, X)
            test(GLM::eulerAngleYXY, Y, X, Y)
            test(GLM::eulerAngleYZY, Y, Z, Y)
            test(GLM::eulerAngleZYZ, Z, Y, Z)
            test(GLM::eulerAngleZXZ, Z, X, Z)
            test(GLM::eulerAngleXZY, X, Z, Y)
            test(GLM::eulerAngleYZX, Y, Z, X)
            test(GLM::eulerAngleZYX, Z, Y, X)
            test(GLM::eulerAngleZXY, Z, X, Y)
        }

        "extractsEulerAngles" {

            fun test(rotationFunc: (Float, Float, Float) -> Mat4, testExtractionFunc: (Mat4) -> Vec3) {

                val minAngle = -GLM.PIf
                val maxAngle = GLM.PIf
                val maxAngleWithDelta = maxAngle - 0.0000001f
                val minMidAngle = -GLM.PIf * 0.5f
                val maxMidAngle = GLM.PIf * 0.5f

                listOf(
                        Vec3(1.046f, 0.52f, -0.785f),
                        Vec3(minAngle, minMidAngle, minAngle),
                        Vec3(minAngle, minMidAngle, maxAngle),
                        Vec3(minAngle, minMidAngle, maxAngleWithDelta),
                        Vec3(minAngle, maxMidAngle, minAngle),
                        Vec3(minAngle, maxMidAngle, maxAngle),
                        Vec3(minAngle, maxMidAngle, maxAngleWithDelta),
                        Vec3(maxAngle, minMidAngle, minAngle),
                        Vec3(maxAngle, minMidAngle, maxAngle),
                        Vec3(maxAngle, minMidAngle, maxAngleWithDelta),
                        Vec3(maxAngleWithDelta, minMidAngle, maxAngle),
                        Vec3(maxAngleWithDelta, minMidAngle, maxAngleWithDelta),
                        Vec3(maxAngle, maxMidAngle, minAngle),
                        Vec3(maxAngleWithDelta, maxMidAngle, minAngle),
                        Vec3(maxAngle, maxMidAngle, maxAngle),
                        Vec3(maxAngle, maxMidAngle, maxAngleWithDelta),
                        Vec3(maxAngleWithDelta, maxMidAngle, maxAngle),
                        Vec3(maxAngleWithDelta, maxMidAngle, maxAngleWithDelta),
                        Vec3(minAngle, 0f, minAngle),
                        Vec3(minAngle, 0f, maxAngle),
                        Vec3(maxAngle, maxAngle, minAngle),
                        Vec3(maxAngle, maxAngle, maxAngle)).forEach { angles ->

                    val rotation = rotationFunc(angles.x, angles.y, angles.z)

                    val extractedEulerAngles = testExtractionFunc(rotation)
                    val extractedRotation = rotationFunc(extractedEulerAngles.x, extractedEulerAngles.y, extractedEulerAngles.z)

                    val v = Vec4(1f)
                    val v1 = rotation * v
                    val v2 = extractedRotation * v

                    v1.shouldEqual(v2, 0.00001f)
                }
            }

            test(GLM::eulerAngleYXZ, GLM::extractEulerAngleYXZ)
            test(GLM::eulerAngleXZX, GLM::extractEulerAngleXZX)
            test(GLM::eulerAngleXYX, GLM::extractEulerAngleXYX)
            test(GLM::eulerAngleYXY, GLM::extractEulerAngleYXY)
            test(GLM::eulerAngleYZY, GLM::extractEulerAngleYZY)
            test(GLM::eulerAngleZYZ, GLM::extractEulerAngleZYZ)
            test(GLM::eulerAngleZXZ, GLM::extractEulerAngleZXZ)
            test(GLM::eulerAngleXZY, GLM::extractEulerAngleXZY)
            test(GLM::eulerAngleYZX, GLM::extractEulerAngleYZX)
            test(GLM::eulerAngleZYX, GLM::extractEulerAngleZYX)
            test(GLM::eulerAngleZXY, GLM::extractEulerAngleZXY)
        }
    }
}
