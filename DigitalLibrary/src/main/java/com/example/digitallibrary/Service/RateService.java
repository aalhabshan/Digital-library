package com.example.digitallibrary.Service;

import com.example.digitallibrary.Exception.ApiException;
import com.example.digitallibrary.Model.Book;
import com.example.digitallibrary.Model.LibraryUser;
import com.example.digitallibrary.Model.Rate;
import com.example.digitallibrary.Repository.BookRepsitory;
import com.example.digitallibrary.Repository.RateRepository;
import com.example.digitallibrary.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService {
    private final RateRepository rateRepository;
    private final UserRepository userRepository;

    public List<Rate> get(){
        return rateRepository.findAll();
    }
    public void add(Integer id, Rate rate){
        LibraryUser user= userRepository.findLibraryUserById(id);
        if (user == null)
            throw new ApiException("Wrong user ID!!");
        rate.setUser(user);
        rateRepository.save(rate);
    }
    public void update(Integer id,Rate rate){
        Rate r = rateRepository.findRateById(id);
        if (r==null)
            throw new ApiException("Wrong ID!!");
        r.setRating(rate.getRating());
        r.setComment(rate.getComment());
        r.setBookname(rate.getBookname());
        rateRepository.save(r);
    }
    public void delete(Integer id){
        Rate r = rateRepository.findRateById(id);
        if (r==null)
            throw new ApiException("Wrong ID!!");
        rateRepository.deleteById(id);
    }
    public List<Rate> allByBookname(String name){
        List<Rate> users= rateRepository.findAllByBookname(name);
        if(users.isEmpty())
            throw new ApiException("Wrong name");
        return users;
    }
    public List<Rate> greaterThanEqual(Integer r){
        List<Rate> users= rateRepository.findAllByRatingGreaterThanEqual(r);
        if(users.isEmpty())
            throw new ApiException("there is no rating Greater than or equal this number");
        return users;
    }
    public List<Rate> lessThanEqual(Integer r){
        List<Rate> users= rateRepository.findAllByRatingLessThanEqual(r);
        if(users.isEmpty())
            throw new ApiException("there is no rating less than or equal this number");
        return users;
    }


}
