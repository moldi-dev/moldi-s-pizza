package org.moldidev.moldispizza.service;

import org.moldidev.moldispizza.dto.UserDTO;
import org.moldidev.moldispizza.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface UserService {
    ResponseEntity<String> save(User user);

    User authenticate(String username, String password);

    UserDTO findById(Long userId);
    UserDTO findByUsername(String username);
    UserDTO findByEmail(String email);
    UserDTO findByVerificationToken(String verificationToken);
    List<UserDTO> findAll();

    ResponseEntity<String> verifyByVerificationToken(String email, String verificationToken);

    UserDTO updatePassword(Long userId, String oldPassword, String newPassword);

    UserDTO updateById(Long userId, User updatedUser);
    UserDTO updateByUsername(String username, User updatedUser);

    void deleteById(Long userId);
    void deleteByUsername(String username);
}
