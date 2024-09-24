package com.innova.events.application.service.user;

import com.innova.events.application.mapper.UserMapper;
import com.innova.events.domain.dto.UserDTO;
import com.innova.events.infrastructure.persistence.entity.UserEntity;
import com.innova.events.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserDTO)
                .orElse(null);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = userMapper.toUserEntity(userDTO);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toUserDTO(savedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
