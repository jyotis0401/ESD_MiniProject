package com.example.esd_project.service;

import com.example.esd_project.dto.domainRequest;
import com.example.esd_project.dto.domainResponse;
import com.example.esd_project.entity.Domain;
import com.example.esd_project.mapper.DomainMapper;
import com.example.esd_project.repository.DomainRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DomainService {
    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private DomainMapper domainMapper;
    public String createDomain(@Valid domainRequest request) {
        domainRepository.save(domainMapper.toentity(request));
        //so we need to save this to repo so we will call .save function and pass entity(made using mapperobject and toentity funciton wtih passing dto
        return "Created";
    }


    public List<domainResponse> getdomainsall() {
        //we will get list of data from repo here

        List<Domain> domains = domainRepository.findAll();
        return domainMapper.toListDomainResponse(domains);

    }

    public String updateDomain(String program, int batch, domainRequest updatedDomain) {
        Domain domain = domainRepository.findByProgramAndBatch(program, batch); //if not found then?
        // Update the fields
        domain.setProgram(updatedDomain.program());
        domain.setBatch(updatedDomain.batch());
        domain.setCapacity(updatedDomain.capacity());
        domain.setQualification(updatedDomain.qualification());
        //save to the repo the updated domain
        domainRepository.save(domain);

        return "Updated";

    }
}
