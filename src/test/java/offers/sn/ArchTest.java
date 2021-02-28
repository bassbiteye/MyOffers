package offers.sn;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("offers.sn");

        noClasses()
            .that()
            .resideInAnyPackage("offers.sn.service..")
            .or()
            .resideInAnyPackage("offers.sn.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..offers.sn.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
