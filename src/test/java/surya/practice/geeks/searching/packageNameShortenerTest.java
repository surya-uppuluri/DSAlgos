package surya.practice.geeks.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageNameShortenerTest {

    @Test
    void shortenTheName() {
        PackageNameShortener packageNameShortener = new PackageNameShortener();
        String shortenedName = packageNameShortener.shortenTheNameUsingJavaSplit("com.organization.teamName.application");
        assertEquals("c.o.t.application", shortenedName);
    }
}