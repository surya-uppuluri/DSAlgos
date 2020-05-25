package surya.practice.geeks.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PackageNameShortenerTest {

    @Test
    void shortenTheName() {
        PackageNameShortener packageNameShortener = new PackageNameShortener();
        String shortenedName = packageNameShortener.shortenTheNameUsingSplit("com.organization.teamName.application");
        assertEquals("c.o.t.application", shortenedName);
    }
}