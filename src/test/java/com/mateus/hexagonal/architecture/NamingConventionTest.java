package com.mateus.hexagonal.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.mateus.hexagonal")
public class NamingConventionTest {

    @ArchTest
    public static final ArchRule consumer_reside_only_consumer_package = classes()
            .that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapters.in.consumer")
            .as("Menssagem classe consumer reside dentro do pacote cosumer no pacote adapter.in");

    @ArchTest
    public static final ArchRule mapper_reside_only_mapper_package = classes()
            .that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage("..adapters.in.consumer.mapper", "..adapters.in.controller.mapper", "..adapters.out.client.mapper", "..adapters.out.repository.mapper")
            .as("Menssagem classe mapper reside dentro do pacote mapper nos pacotes ...");

    @ArchTest
    public static final ArchRule should_be_suffixed_mapper = classes()
            .that()
            .resideInAnyPackage("..mapper")
            .should()
            .haveSimpleNameEndingWith("Mapper")
            .orShould()
            .haveSimpleNameEndingWith("MapperImpl");

    @ArchTest
    public static final ArchRule should_be_suffixed_consumer = classes()
            .that()
            .resideInAnyPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer");
}
