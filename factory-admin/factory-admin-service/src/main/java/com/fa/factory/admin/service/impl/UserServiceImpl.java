
package com.fa.factory.admin.service.impl;

import com.fa.factory.admin.validation.Validation;
import com.fa.factory.admin.dto.UserDto;
import com.fa.factory.admin.mapper.UserMapper;
import com.fa.factory.admin.model.Role;
import com.fa.factory.admin.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.fa.factory.admin.model.User;
import com.fa.factory.admin.repository.UserRepository;
import com.fa.factory.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;

    public String encoderPassword(String rawPassword) {
        return new BCryptPasswordEncoder().encode(rawPassword);
    }

    @Override
    public Boolean save(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        List<Role> roles = new ArrayList<>();
        if (checkUserDto(userDto)) {
            if (this.checkUserExist(user.getUserName()) || this.checkEmailExist(user.getEmail()) || this.checkSsoExist(user.getSso()))
                return false;
            else {
                user.setPassword(encoderPassword(userDto.getPassword()));
                for (int i : userDto.getListRoleId()) {
                    roles.add(roleRepository.findById(i));
                }
                user.setRoles(roles);
                userRepository.save(user);
                return true;
            }
        } else {
            return false;
        }
    }


    @Override
    public Boolean deleteByID(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public Boolean checkUserExist(String userName) {
        User user = userRepository.findByUserName(userName);
        return user != null;
    }

    public Boolean checkEmailExist(String email) {
        if (email == null)
            return false;
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public Boolean checkSsoExist(String sso) {
        if (sso == null)
            return false;
        User user = userRepository.findBySso(sso);
        return user != null;
    }

    @Override
    public UserDto findById(int id) {
        return userMapper.userToUserDto(userRepository.findById(id).orElse(null));
    }

    @Override
    public List<UserDto> loadAllUser() {

        List<User> listUser = userRepository.findAll();
        List<UserDto> listUserDto = new ArrayList<>();
        List<Integer> listRole = new ArrayList<>();
        for (User user : listUser) {
            listRole.clear();
            UserDto userDto = userMapper.userToUserDto(user);
            for (Role role : user.getRoles()) {
                listRole.add(role.getRoleId());
            }
            userDto.setListRoleId(listRole);
            listUserDto.add(userDto);
        }
        return listUserDto;
    }

    private Boolean checkUserDto(UserDto userDTO) {
        return userDTO.getFactoryId() != 0 && userDTO.getListRoleId().get(0) != 0 && Validation.validateMail(userDTO.getEmail()) && Validation.validateSso(userDTO.getSso());
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUserName(username);
        UserDto userDto = userMapper.userToUserDto(user);
        ArrayList<Integer> temp = new ArrayList<>();
        for (Role role : user.getRoles()) {
            temp.add(role.getRoleId());
        }
        userDto.setListRoleId(temp);
        return userDto;
    }
}

