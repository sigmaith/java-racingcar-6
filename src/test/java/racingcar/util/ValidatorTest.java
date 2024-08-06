package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("유효한 자동차이름 배열 테스트")
    void testValidCarNames() {
        // Given: 유효한 자동차 이름 문자열
        String validaCarNames = "car1,car2,car3";

        // When: 자동차 이름 검증 메서드 실행
        String[] names = assertDoesNotThrow(() -> Validator.validateCarNames(validaCarNames));

        // Then: 변형된 배열이 null이 아니고, 올바른 길이를 가지고 있어야 함.
        assertNotNull(names);
        assertEquals(3, names.length);
    }

    @Test
    @DisplayName("유효하지 않은 자동차이름 배열 테스트")
    void testInvalidCarNames() {
        // Given: 유효하지 않은 자동차 이름 문자열
        String invalidCarNames = "car123456,car";

        // When: 자동차 이름 검증 메서드 실행
        // Then: IllegalArgumentException 발생해야 함.
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(invalidCarNames));
    }

    @Test
    @DisplayName("유효한 시도횟수 테스트")
    void testValidAttemptCount() {
        // Given: 유효한 시도 횟수
        String validAttemptCount = "5";

        // When: 시도 횟수 검증 메서드 실행
        int count = assertDoesNotThrow(() -> Validator.validateAttemptCount(validAttemptCount));

        // Then: 반환된 횟수가 입력값과 동일해야 함.
        assertEquals(5, count);
    }

    @Test
    @DisplayName("유효하지 않은 시도횟수 테스트")
    void testInvalidAttemptCount() {
        // Given: 유효하지 않은 시도 횟수
        String invalidAttemptCount = "-1";

        // When: 시도 횟수 검증 메서드 실행
        // Then: IllegalArgumentException 발생해야 함.
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAttemptCount(invalidAttemptCount));
    }
}