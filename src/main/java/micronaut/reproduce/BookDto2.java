package micronaut.reproduce;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record BookDto2(
        Integer id_renamed,
        String title
) {
}
