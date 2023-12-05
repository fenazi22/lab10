package com.example.jobseeking.Service;

import com.example.jobseeking.Model.User;
import com.example.jobseeking.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){

    userRepository.save(user);

        }



public Boolean updateUser(Integer id,User user){
    User user1=userRepository.getById(id);



    if (user==null){
    return  false;
}
user1.setName(user.getName());
user1.setRole(user.getRole());
user1.setAge(user.getAge());
user1.setEmail(user.getEmail());
user1.setPassword(user.getPassword());
userRepository.save(user1);
return true;
    }



    public Boolean deletUser(Integer id){
    User user1=userRepository.getReferenceById(id);
    if (user1==null){
        return false;
    }
userRepository.delete(user1);
    return  true;
    }

    public  Boolean VerifyUser(Integer id){
        for (User x:userRepository.findAll()) {
            if (x.getId().equals(id)){
                return true;
            }
            }
return false;
        }


}
