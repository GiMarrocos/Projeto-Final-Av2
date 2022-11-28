package com.tomorrow.tomorrow.services;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import com.tomorrow.tomorrow.entities.Holiday;
import com.tomorrow.tomorrow.entities.exceptions.EntityObjectNotFoundException;
import com.tomorrow.tomorrow.entities.exceptions.HolidayCreateFailureException;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tomorrow.tomorrow.repositories.HolidayRepository;

@Service
public class HolidayService extends FormatDataInput {
	
	@Autowired
    private HolidayRepository holidayRepository;

	public Holiday save(Holiday holiday){

        try {

			holiday.setDescription(holiday.getDescription());
			holiday.setHolidayDate(holiday.getHolidayDate());

		} catch (RuntimeException violationException) {

			throw new HolidayCreateFailureException("Holiday registration failure");

		}

		return holidayRepository.save(holiday);
    }

	public Holiday findById(Long id){

        Optional<Holiday> holiday =  holidayRepository.findById(id);
		
		return holiday.orElseThrow(() -> new EntityObjectNotFoundException("Holiday not found! Id:" + id +
		"Cause type: " + Holiday.class.getName()));
    }

	public List<Holiday> findAll(){

        return holidayRepository.findAll();

    }

    //update
    public void updateHoliday(Holiday holiday) throws DataFormatException {

        Holiday new_holiday_data = holidayRepository.getReferenceById(holiday.getHoliday_id());

        new_holiday_data = update_DATA(new_holiday_data, holiday);

        if(holiday.getDescription() == null && holiday.getHolidayDate() == null){

            throw new DataFormatException("No change data has been entered");

        } else {

            holidayRepository.save(new_holiday_data);

        }
    }

	//delete
	public void  deleteHoliday(Long id){

        try {

            holidayRepository.deleteById(id);

        } catch (EmptyResultDataAccessException dataAccessException){

            throw new EntityObjectNotFoundException("Holiday not found! Id: " + id + "Cause type: "
                    + Holiday.class.getName());

        } catch (DataIntegrityViolationException dataIntegrityViolationException){

            dataIntegrityViolationException.getMessage();

        }
    }

	//data change method
    protected Holiday update_DATA(Holiday holiday, Holiday new_data){

        //permission to change phone and address only
        if(new_data.getDescription() != null && new_data.getHolidayDate() != null) {

            holiday.setDescription(new_data.getDescription());
			holiday.setHolidayDate(new_data.getHolidayDate());

        } else if(new_data.getDescription() != null && new_data.getHolidayDate() == null) {

			holiday.setDescription(new_data.getDescription());

        } else if(new_data.getHolidayDate() != null && new_data.getDescription() == null) {

			holiday.setHolidayDate(new_data.getHolidayDate());
		}

        return holiday;
    }
}
