package de.bixilon.kotlinglm

import de.bixilon.kotlinglm.mat4x4.Mat4
import de.bixilon.kotlinglm.quaternion.Quat
import de.bixilon.kotlinglm.vec3.Vec3
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class testMatrixInterpolation : StringSpec() {

    init {
        "matrix interpolation" {

            val p = 0.171654f
            val m1 = Mat4(
                    -0.9946f, 0.0f, -0.104531f, 0.0f,
                    0.0f, 1.0f, 0.0f, 0.0f,
                    0.104531f, 0.0f, -0.9946f, 0.0f,
                    0.0f, 0.0f, 0.0f, 1.0f)
            val m2 = Mat4(
                    -0.992624f, 0.0f, -0.121874f, 0.0f,
                    0.0f, 1.0f, 0.0f, 0.0f,
                    0.121874f, 0.0f, -0.992624f, 0.0f,
                    0.0f, 0.0f, 0.0f, 1.0f)

            val m1rot = GLM.extractMatrixRotation(m1)
            val dltRotation = m2 * m1rot.transpose()

            val dltAxis = Vec3()
            val dltAngle = GLM.axisAngle(dltRotation, dltAxis)

            dltAxis shouldBe Vec3(0f, -1f, 0f)
            dltAngle shouldBe 0.7853982f

            val q = dltRotation.toQuat()
            q shouldBe Quat(1.0000008f, 0f, -0.008727945f, 0f)
            val yaw = GLM.yaw(q)
            yaw shouldBe -0.017456792f
        }
    }
}
