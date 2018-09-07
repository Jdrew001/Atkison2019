package com.atkison.atkison2018.services;

import com.atkison.atkison2018.models.Reserved;
import com.atkison.atkison2018.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {

    @Autowired
    private ReserveRepository reserveRepository;

    public ReserveService(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    public List<Reserved> getAllReservations()
    {
        List<Reserved> rsvp = this.reserveRepository.findAll();

        return rsvp;
    }

    public boolean addNewReservation(Reserved reserved)
    {
        try {
            Reserved rsvp = new Reserved(reserved);
            this.reserveRepository.save(rsvp);
        } catch(Exception ex) {
            return false;
        }
        return true;
    }

    public List<Reserved> updateReservation(Reserved reserved)
    {
        try {
            Reserved rsvp = this.reserveRepository.getOne(reserved.getId());
            rsvp.setFirstname(reserved.getFirstname());
            rsvp.setLastname(reserved.getLastname());
            rsvp.setPartyNumberCeremony(reserved.getPartyNumberCeremony());
            rsvp.setPartyNumberReception(reserved.getPartyNumberReception());
            System.out.println("The update result: " + this.reserveRepository.save(rsvp));


            return this.reserveRepository.findAll();

        } catch(Exception ex) {
            System.out.println("Something bad went wrong in update: " + ex.getLocalizedMessage());

            return null;
        }
    }

    public List<Reserved> deleteReservation(Reserved reserved)
    {
        try {
            Optional<Reserved> rsvp = this.reserveRepository.findById(reserved.getId());
            rsvp.orElseThrow(() -> new RuntimeException("RSVP NOT FOUND IN DELETE"));
            this.reserveRepository.delete(rsvp.get());

            return this.reserveRepository.findAll();

        } catch(Exception ex) {
            System.out.println("Something bad went wrong in delete: " + ex.getLocalizedMessage());
            return null;
        }
    }
}
