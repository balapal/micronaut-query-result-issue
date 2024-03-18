package micronaut.reproduce;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BookDto(
        Integer id,
        String title
) {
}
