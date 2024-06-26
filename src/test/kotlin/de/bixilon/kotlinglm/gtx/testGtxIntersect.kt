package de.bixilon.kotlinglm.gtx

import de.bixilon.kotlinglm.GLM
import de.bixilon.kotlinglm.GLM.epsilonF
import de.bixilon.kotlinglm.shouldEqual
import de.bixilon.kotlinglm.vec2.Vec2
import de.bixilon.kotlinglm.vec3.Vec3
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class testGtxIntersect : StringSpec() {

    init {

        "ray-triangle intersection" {

            val orig = Vec3(0, 0, 2)
            val dir = Vec3(0, 0, -1)
            val vert0 = Vec3()
            val vert1 = Vec3(-1, -1, 0)
            val vert2 = Vec3(1, -1, 0)
            val baryPosition = Vec2()

            val distance = GLM.intersectRayTriangle(orig, dir, vert0, vert1, vert2, baryPosition)!!

            baryPosition shouldEqual Vec2()
            (GLM.abs(distance - 2f) <= epsilonF) shouldBe true
        }

        "line-triangle intersect" {

            val orig = Vec3(0, 0, 2)
            val dir = Vec3(0, 0, -1)
            val vert0 = Vec3(0, 0, 0)
            val vert1 = Vec3(-1, -1, 0)
            val vert2 = Vec3(1, -1, 0)
            val position = Vec3(2f, 0f, 0f)

            val result = GLM.intersectLineTriangle(orig, dir, vert0, vert1, vert2, position)

            position shouldEqual Vec3(2f, 0f,0f)
            result shouldBe true
        }

        "ray-plane intersection" {

            run {
                val orig = Vec3(0, 0, 2)
                val dir = Vec3(0, 0, -1)
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(0, 0, 1)

                val distance = GLM.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 2f
            }

            run {
                val orig = Vec3(1, 0, 4)
                val dir = Vec3(0, 0, -1)
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(0, 0, 1)

                val distance = GLM.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 4f
            }

            run {
                val orig = Vec3(1, 2, 4)
                val dir = Vec3(0, 0, -1)
                val planeOrig = Vec3(0, 0, 1)
                val planeNormal = Vec3(0, 0, 1)

                val distance = GLM.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 3f
            }

            run {
                //dot product == 0
                val orig = Vec3(0, 0, 4)
                val dir = Vec3(0, 0, -1)
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(1, 0, 0)

                val distance = GLM.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe null
            }

            run {
                val orig = Vec3(0, 0, 3)
                val dir = Vec3(-4, 0, -3).normalize()
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(0, 0, 1)

                val distance = GLM.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 5f
            }

            run {
                val orig = Vec3(1, 2, 3)
                val dir = Vec3(-2, -4, -3).normalize()
                val planeOrig = Vec3(0)
                val planeNormal = Vec3(0, 0, 1)

                val distance = GLM.intersectRayPlane(orig, dir, planeOrig, planeNormal)
                distance shouldBe 5.385165f
            }
        }
    }

}
