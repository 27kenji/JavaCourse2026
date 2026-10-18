package com.base.assertj_homework;
import com.OrderHelpers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderHelpersTest {

    @Test
    void formatBuildsHumanString() {
        assertThat(OrderHelpers.format(42, "PAID", 199.0))
                .isEqualTo("Order #42 | PAID | 199.0");
    }

    @Test
    void finalForPaidNotForCreated() {
        assertThat(OrderHelpers.isFinal("PAID"))
                .isTrue();
        assertThat(OrderHelpers.isFinal("CREATED"))
                .isFalse();

    }

    @ParameterizedTest(name = "{0} → {1}")
    @CsvSource({"CREATED, false",
            "PAID, true",
            "READY, true",
            "COMPLETED, true",
            "UNKNOWN, false"
    })
    void finalStatusTable(String status, boolean expected) {
        assertThat(OrderHelpers.isFinal(status)).isEqualTo(expected);
    }

    @Test
    void keepFinalFiltersOnlyFinalStatuses() {
        assertThat(OrderHelpers.keepFinal((List.of("CREATED", "PAID", "READY", "CANCELLED"))))
                .hasSize(3)
                .contains("PAID", "READY")
                .doesNotContain("CREATED");
    }
}
