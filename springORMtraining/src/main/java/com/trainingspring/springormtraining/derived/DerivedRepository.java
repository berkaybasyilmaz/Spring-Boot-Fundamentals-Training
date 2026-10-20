package com.trainingspring.springormtraining.derived;

import com.trainingspring.springormtraining.Query.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DerivedRepository extends JpaRepository<Supplier, UUID> {

    List<Supplier> findBySupplierName(String supplierName);

    List<Supplier> findBySupplierNameLike(String supplierNamePattern);

    List<Supplier>findBySupplierNameStartingWith(String supplierNameStart);

    List<Supplier> findBySupplierNameEndingWith(String supplierNameEnd);

    List<Supplier> findByTotalDebit(double totalDebit);

    List<Supplier> findByTotalDebitGreaterThan(double totalDebit);

    List<Supplier> findByTotalDebitBetween(double totalDebitMin,  double totalDebitMax);

}
