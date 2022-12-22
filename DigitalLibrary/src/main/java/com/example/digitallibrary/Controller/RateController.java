package com.example.digitallibrary.Controller;
import com.example.digitallibrary.Dto.ApiResponse;
import com.example.digitallibrary.Model.Book;
import com.example.digitallibrary.Model.LibraryUser;
import com.example.digitallibrary.Model.Rate;
import com.example.digitallibrary.Service.BookService;
import com.example.digitallibrary.Service.RateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rate")
public class RateController {
    private final RateService rateService;

    @GetMapping("/get")
    public ResponseEntity get(){
        List<Rate> rate = rateService.get();
        return ResponseEntity.status(200).body(rate);
    }
    @PostMapping("/add/{id}")
    public ResponseEntity add(@PathVariable Integer id,@RequestBody @Valid Rate rate, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        rateService.add(id,rate);
        return ResponseEntity.status(200).body(new ApiResponse("Rating added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid Rate rate,Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        rateService.update(id, rate);
        return ResponseEntity.status(200).body(new ApiResponse("Rating updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        rateService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("Rating deleted"));
    }
    @GetMapping("/allbybookname")
    public ResponseEntity allByBookname(@RequestBody String name){
        List<Rate> rates= rateService.allByBookname(name);
        return ResponseEntity.status(200).body(rates);
    }
    @GetMapping("/greaterequal")
    public ResponseEntity greaterEqual(@RequestBody Integer r){
        List<Rate> rates= rateService.greaterThanEqual(r);
        return ResponseEntity.status(200).body(rates);
    }
    @GetMapping("/lessequal")
    public ResponseEntity lessEqual(@RequestBody Integer r){
        List<Rate> rates= rateService.lessThanEqual(r);
        return ResponseEntity.status(200).body(rates);
    }
}
