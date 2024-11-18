package vn.iotstar.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iotstar.repository.UserInfoRepository;
import vn.iotstar.entity.UserInfo;

@Service
public record UserService (UserInfoRepository repository, PasswordEncoder passwordEncoder) {
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "them thanh cong";
    }
}