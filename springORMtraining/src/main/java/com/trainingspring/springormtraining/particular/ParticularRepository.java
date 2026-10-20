package com.trainingspring.springormtraining.particular;

import com.trainingspring.springormtraining.Query.Supplier;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ParticularRepository extends PagingAndSortingRepository <Supplier, UUID>{
}
