package com.trainingspring.springormtraining.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SupplierRepository extends CrudRepository <Supplier, UUID> {

    @Query("select s from Supplier s")
    List<Supplier> findAllSuppliers();

    @Query("select s from Supplier s where s.supplierName like 'Sat%5' ")
    List<Supplier> findAllSuppliersLike();

    @Query("select s from Supplier s where s.totalDebit > :debitMin")
    List<Supplier> findSuppliersMin(@Param("debitMin") double debitMin);

    @Query("select avg(s.totalDebit) from Supplier s where s.totalDebit > :debitMin")
    double findSuppliersAvg(@Param("debitMin")  double totalDebitMin);

}
