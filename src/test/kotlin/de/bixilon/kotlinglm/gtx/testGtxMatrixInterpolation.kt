package de.bixilon.kotlinglm.gtx

import de.bixilon.kotlinglm.GLM
import de.bixilon.kotlinglm.mat4x4.Mat4
import de.bixilon.kotlinglm.vec3.Vec3
import io.kotest.core.spec.style.StringSpec

class testGtxMatrixInterpolation : StringSpec() {

    init {

        "axisAngle" {

            val p = 0.171654f
            val m1 = Mat4(-0.9946f, 0f, -0.104531f, 0f,
                    0f, 1f, 0f, 0f,
                    0.104531f, 0f, -0.9946f, 0f,
                    0f, 0f, 0f, 1f)
            val m2 = Mat4(-0.992624f, 0f, -0.121874f, 0f,
                    0f, 1f, 0f, 0f,
                    0.121874f, 0f, -0.992624f, 0f,
                    0f, 0f, 0f, 1f)

            val m1rot = GLM.extractMatrixRotation(m1)
            val dltRotation = m2 * m1rot.transpose()

            val dltAxis = Vec3()
            val dltAngle = GLM.axisAngle(dltRotation, dltAxis)

            println("dltAngle: $dltAxis, dltAngle: $dltAngle")

            val q = dltRotation.toQuat()
            println("q: $q")
            val yaw = GLM.yaw(q)
            println("Yaw: $yaw")
        }
    }
}
