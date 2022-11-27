package com.tomorrow.tomorrow.services;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tomorrow.tomorrow.entities.Lead;
import com.tomorrow.tomorrow.entities.exceptions.EntityObjectNotFoundException;
import com.tomorrow.tomorrow.entities.exceptions.LeadCreateFailureException;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;
import com.tomorrow.tomorrow.repositories.LeadRepository;

@Service
public class LeadService extends FormatDataInput {

    @Autowired
    private LeadRepository leadRepository;

    public Lead create(Lead lead) {
        try {
            lead.setName(NAME_FORMAT(lead.getName()));
            lead.setPhone(NAME_FORMAT(lead.getPhone()));
            lead.setDateRegister(DATE_FORMAT());
            lead.setStatus_2(NAME_FORMAT(lead.getStatus_2()));
            lead.setNewDateContact(DATE_FORMAT());
            lead.setObservation(NAME_FORMAT(lead.getObservation()));
        } catch (RuntimeException violationException) {
            throw new LeadCreateFailureException("Lead registration failure");
        }
        return leadRepository.save(lead);
    }

    public Lead findById(Long id) {
        Optional<Lead> lead = leadRepository.findById(id);
        return lead.orElseThrow(() -> new EntityObjectNotFoundException("Lead not found Id" + id +
                "cause type: " + Lead.class.getName()));
    }

    public List<Lead> findAll() {
        return leadRepository.findAll();
    }

    // update
    public void updateLead(Lead lead) throws DataFormatException {
        Lead new_lead_data = leadRepository.getReferenceById(lead.getId_lead());
        new_lead_data = update_DATA(new_lead_data, lead);
        if (lead.getPhone() == null && lead.getObservation() == null && lead.getStatus_2() == null) {
            throw new DataFormatException("No change data has been entered");
        } else {
            leadRepository.save(new_lead_data);
        }
    }

    public void deleteLead(Long id) {
        try {
            leadRepository.deleteById(id);
        } catch (EmptyResultDataAccessException dataAccessException) {
            throw new EntityObjectNotFoundException("Student not found! Id: " + id + "Cause type: "
                    + Lead.class.getName());
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            dataIntegrityViolationException.getMessage();
        }
    }

    protected Lead update_DATA(Lead lead, Lead new_Data) {
        if (new_Data.getPhone() != null && new_Data.getObservation() != null && new_Data.getStatus_2() != null) {
            lead.setPhone(NUMBER_FORMAT(new_Data.getPhone()));
            lead.setObservation(NAME_FORMAT(new_Data.getObservation()));
            lead.setStatus_2(NAME_FORMAT(new_Data.getStatus_2()));
        }else if(new_Data.getPhone() != null){
            lead.setPhone(NUMBER_FORMAT(new_Data.getPhone()));
        }else if (new_Data.getObservation() != null) {
            lead.setObservation(new_Data.getObservation());
        }else if (new_Data.getStatus_2() != null) {
            lead.setStatus_2(NAME_FORMAT(new_Data.getStatus_2()));
        }
        return lead;
    }

}
