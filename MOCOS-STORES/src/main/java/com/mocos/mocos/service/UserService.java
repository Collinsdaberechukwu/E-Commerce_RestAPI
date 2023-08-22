package com.mocos.mocos.service;

import com.mocos.mocos.dto.ResponseDto;
import com.mocos.mocos.dto.SignInDto;
import com.mocos.mocos.dto.SignInResponseDto;
import com.mocos.mocos.dto.SignupDto;
import com.mocos.mocos.exception.AuthenticationFailedException;
import com.mocos.mocos.exception.CustomException;
import com.mocos.mocos.model.AuthenticationToken;
import com.mocos.mocos.model.User;
import com.mocos.mocos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {

        @Autowired
        UserRepository userRepository;

        @Autowired
        AuthenticationService authenticationService;

        Logger logger = LoggerFactory.getLogger(UserService.class);

@Transactional
        public ResponseDto signUp(SignupDto signupDto) throws CustomException {
            // Check to see if the current email address has already been registered.
            if (Objects.nonNull(userRepository.findByEmail(signupDto.getEmail()))) {
                // If the email address has been registered then throw an exception.
                throw new CustomException("User already exists");
            }
            // first encrypt the password
            String encryptedPassword = signupDto.getPassword();
            try {
                encryptedPassword = hashPassword(signupDto.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                logger.error("hashing password failed {}", e.getMessage());
            }
            User user = new User(signupDto.getFirstName(), signupDto.getLastName(),
                    signupDto.getEmail(), encryptedPassword);

            User createdUser;
            ResponseDto responseDto = new ResponseDto("success", "Dummy Response");
            return responseDto;
        }
    String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash =
                DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDto signIn(SignInDto signInDto) throws NoSuchAlgorithmException {
    // find user by email
        User user = userRepository.findByEmail(signInDto.getEmail());
        if (Objects.nonNull(user)){
            throw new AuthenticationFailedException("user is not valid");
        }
        // hash the password
       if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
          throw new AuthenticationFailedException(" wrong password");
       }
        // compare the password in DB
        //if password match
        AuthenticationToken token = authenticationService.getToken(user);
        //retrieve token
        if(Objects.isNull(token)){
            throw new CustomException("token is not present");
        }
        return  new SignInResponseDto("success",token.getToken());
    }
}


