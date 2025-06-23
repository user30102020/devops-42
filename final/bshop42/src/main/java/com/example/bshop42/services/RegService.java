package com.example.bshop42.services;

import com.example.bshop42.dto.RegForm;
import com.example.bshop42.model.Registration;
import com.example.bshop42.model.User;

import java.util.List;
import java.util.UUID;

public interface RegService {
    void saveReg(RegForm form, String email);
    void deleteReg(UUID id);
    List<Registration> getAllRegs();
    List<Registration> getRegsByUser(User user);
    List<Registration> getExpiredRegs(List<Registration> regs);
    List<Registration> getActiveRegs(List<Registration> regs);
}
