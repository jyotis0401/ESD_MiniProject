package com.example.esd_project.mapper;

import com.example.esd_project.dto.domainRequest;
import com.example.esd_project.dto.domainResponse;
import com.example.esd_project.entity.Domain;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DomainMapper {
    public Domain toentity(domainRequest domainRequest) {
        return Domain.builder()
                .program(domainRequest.program()) //this is to convert the request dto to entity.
                .batch(domainRequest.batch())
                .capacity(domainRequest.capacity())
                .qualification(domainRequest.qualification())
                .build();
    }
    public domainResponse toDomainResponse(Domain domain) {
        //dto is record so we need to call constructor unlike above


        //getprogram()----lombok
        return new domainResponse(domain.getProgram(), domain.getBatch(), domain.getCapacity(), domain.getQualification());
    }

    //we will get list from the repo so we will need this funciton to return list of dtos
    public List<domainResponse> toListDomainResponse(List<Domain> domains) {
        List<domainResponse> domainResponses = new ArrayList<>();
        for(Domain domain : domains) {
            domainResponses.add(toDomainResponse(domain));
        }
        return domainResponses;
    }

}
