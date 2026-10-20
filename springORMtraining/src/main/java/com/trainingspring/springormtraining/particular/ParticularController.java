package com.trainingspring.springormtraining.particular;

import com.trainingspring.springormtraining.Query.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/particular")
public class ParticularController {

    ParticularRepository particularRepository;
    public ParticularController(ParticularRepository particularRepository) {
        this.particularRepository = particularRepository;
    }

    @GetMapping("/page") // sayfalama,
    public Iterable <Supplier> getPage() { // Iterable List, ArrayList vb. çoğul parametre dönen methodların atasıdır.

        int pageNumber = 1;
        int pageSize = 15;
        return particularRepository.findAll(PageRequest.of(pageNumber, pageSize));


    }

    @GetMapping("/sort") // ücrete göre azalan sırala.
    public Iterable <Supplier> getSort() {

        return particularRepository
                .findAll(Sort.by("totalDebit").descending());

        //return particularRepository
        //      .findAll(Sort.by("supplierName").ascendinnn g());


    }

    @GetMapping("/pagesort")
    public Page<Supplier> getPageSort (){
        int pageNumber = 1;
        int pageSize = 15;
        String orderColumn = "totalDebit";
        Sort sort = Sort.by(orderColumn).ascending();
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        return particularRepository.findAll(pageRequest);


    }

}
