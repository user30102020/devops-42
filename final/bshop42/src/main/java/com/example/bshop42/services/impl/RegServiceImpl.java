package com.example.bshop42.services.impl;

import com.example.bshop42.dto.RegForm;
import com.example.bshop42.model.Registration;
import com.example.bshop42.model.User;
import com.example.bshop42.repository.BarberRepository;
import com.example.bshop42.repository.OfficeRepository;
import com.example.bshop42.repository.RegistrationRepository;
import com.example.bshop42.repository.UserRepository;
import com.example.bshop42.services.RegService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegServiceImpl implements RegService {
    private final RegistrationRepository registrationRepository;
    private final BarberRepository barberRepository;
    private final OfficeRepository officeRepository;
    private final UserRepository userRepository;

    @Override
    public void saveReg(RegForm form, String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException());
        Registration reg = Registration.builder()
                .date(form.getDate())
                .time(form.getTime())
                .barber(barberRepository.findById(form.getBarber_id()).orElseThrow(() -> new RuntimeException()))
                .user(user)
                .offices(officeRepository.findAllById(form.getOffices()))
                .build();
        if (!isRegExpired(reg) && !isTimeReserved(reg)) {
            registrationRepository.save(reg);
        } else {
            System.out.println("Невозможно записаться");
        }
    }
    @Override
    public void deleteReg(UUID id) {
        registrationRepository.deleteById(id);
    }
    @Override
    public List<Registration> getAllRegs() {
        return registrationRepository.findAll();
    }
    @Override
    public List<Registration> getRegsByUser(User user) {
        return registrationRepository.getAllByUser(user);
    }

    private boolean isRegExpired(Registration reg) {
        Date regDate = reg.getDate();
        Date currentDate = Date.valueOf(LocalDate.now());

        Calendar calendar = Calendar.getInstance();

        Integer regTime = reg.getTime();
        Integer currentTime = calendar.get(Calendar.HOUR);

        if (regDate.after(currentDate) || (regDate.equals(currentDate) && regTime > currentTime)) return false;

        return true;
    }

    private boolean isTimeReserved(Registration reg) {
        Date regDate = reg.getDate();
        Integer regTime = reg.getTime();

        List<Registration> savedRegs = registrationRepository.findAll();
        for (Registration savedReg : savedRegs) {
            if (savedReg.getDate() == regDate && savedReg.getTime() == regTime) return true;
        }
        return false;
    }
    @Override
    public List<Registration> getExpiredRegs(List<Registration> regs) {
        List<Registration> expiredRegs = new ArrayList<>();

        for (Registration reg : regs) {
            if (isRegExpired(reg)) {
                expiredRegs.add(reg);
            }
        }
        return expiredRegs;
    }
    @Override
    public List<Registration> getActiveRegs(List<Registration> regs) {
        List<Registration> activeRegs = new ArrayList<>();

        for (Registration reg : regs) {
            if (!isRegExpired(reg)) {
                activeRegs.add(reg);
            }
        }
        return activeRegs;
    }
}
