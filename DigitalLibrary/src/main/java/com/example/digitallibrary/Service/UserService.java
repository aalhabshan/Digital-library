package com.example.digitallibrary.Service;

import com.example.digitallibrary.Exception.ApiException;
import com.example.digitallibrary.Model.LibraryUser;
import com.example.digitallibrary.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<LibraryUser> get(){
        return userRepository.findAll();
    }
    public void add(LibraryUser user){
        userRepository.save(user);
    }
    public void update(Integer id,LibraryUser user){
        LibraryUser u = userRepository.findLibraryUserById(id);
        if (u==null)
            throw new ApiException("Wrong ID!!");
        u.setName(user.getName());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        userRepository.save(u);
    }
    public void delete(Integer id){
        LibraryUser u = userRepository.findLibraryUserById(id);
        if (u==null)
            throw new ApiException("Wrong ID!!");
        userRepository.deleteById(id);
    }
    public void check(String un, String pass){
        LibraryUser user= userRepository.findByUsernameAndPassword(un,pass);
        if(user == null)
            throw new ApiException("Wrong username or password!!");
    }
    public LibraryUser byId(Integer id){
        LibraryUser user= userRepository.findLibraryUserById(id);
        if (user==null)
            throw new ApiException("Wrong ID!!");
        return user;
    }

}
