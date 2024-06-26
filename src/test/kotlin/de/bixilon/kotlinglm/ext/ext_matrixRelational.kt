package de.bixilon.kotlinglm.ext

import de.bixilon.kotlinglm.mat4x4.Mat4
import de.bixilon.kotlinglm.shouldEqual
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.StringSpec

class ext_matrixRelational : StringSpec() {

    init {
//        int test_equal()
//        {
//            int Error = 0;
//
//            Error += glm::all(GLM::equal(GLM::mat4x3(1), glm::mat4x3(1), 0.001f)) ? 0 : 1;
//            Error += glm::all(GLM::equal(GLM::mat4x3(1), glm::mat4x3(2), glm::vec4(0.001f))) ? 1 : 0;
//
//            return Error;
//        }
//
//        int test_notEqual()
//        {
//            int Error = 0;
//
//            Error += !glm::any(GLM::notEqual(GLM::mat4x3(1), glm::mat4x3(1), 0.001f)) ? 0 : 1;
//            Error += !glm::any(GLM::notEqual(GLM::mat4x3(1), glm::mat4x3(2), glm::vec4(0.001f))) ? 1 : 0;
//
//            return Error;
//        }
//

        "test equal"        {

            Mat4(1) shouldEqual Mat4(1)
            Mat4(1).allEqual(Mat4(2)) shouldBe false
        }

        "test notEqual"        {

            Mat4(1) shouldEqual Mat4(1)
            Mat4(1).allEqual(Mat4(2)) shouldBe false
        }
    }
}
