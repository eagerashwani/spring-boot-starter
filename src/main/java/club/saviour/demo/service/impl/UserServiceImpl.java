package club.saviour.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.saviour.demo.Dto.UserRequestDto;
import club.saviour.demo.entity.User;
import club.saviour.demo.repository.UserRepository;
import club.saviour.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String createUser(UserRequestDto userRequestDto) {
        User user = this.dtoToUser(userRequestDto);
        User fetchUser = userRepository.save(user);
        return fetchUser.getName();
    }

    private User dtoToUser(UserRequestDto userRequestDto){
        User user = this.modelMapper.map(userRequestDto, User.class);
        return user;
    }
    
}
