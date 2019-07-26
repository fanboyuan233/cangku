package com.czxy.controller;

import com.czxy.domain.Metting;
import com.czxy.service.MettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/metting")
public class MettingController {
    @Autowired
    private MettingService mettingService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Metting>> findAll(){
        try {
            List<Metting> list = mettingService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findMettingByMid/{mettingId}")
    public ResponseEntity<Metting> findMettingByMid(@PathVariable("mettingId") Integer mettingId){
        System.out.println("mettingId="+mettingId);
        try {
            Metting metting = mettingService.findMettingByMid(mettingId);
            System.out.println("metting"+metting);
            return new ResponseEntity<>(metting,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
