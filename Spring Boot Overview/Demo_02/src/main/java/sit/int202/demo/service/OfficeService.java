package sit.int202.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int202.demo.entities.Office;
import sit.int202.demo.repositories.OfficeRepository;

import java.util.List;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    private Office getOffice(String officeCode) {
        return officeRepository.findById(officeCode).orElse(null);
    }

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office createOffice(Office office) {
        Office existingOffice = getOffice(office.getOfficeCode());
        if (existingOffice != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("Office id '%s' already exists",office.getOfficeCode()));
        }
        return officeRepository.save(office);
    }
    public Office updateOffice(Office office) {
        Office existingOffice = getOffice(office.getOfficeCode());
        if (existingOffice == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Office id '%s' does not exists",office.getOfficeCode()));
        }
        return officeRepository.save(office);
    }

    public Office deleteOffice(String officeCode) {
        Office existingOffice = getOffice(officeCode);
        if (existingOffice == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Office id '%s' does not exists",officeCode));
        }
        officeRepository.delete(existingOffice);
        return existingOffice;
    }

    public Office getOfficeByCode(String officeCode) {
        return getOffice(officeCode);
    }
}
