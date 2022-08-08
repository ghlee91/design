package com.example.design;

import com.example.design.repo.MemberRepo;
import java.util.Optional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class DesignApplication {

    private final MemberRepo memberRepo;

    public static void main(String[] args) {

        SpringApplication.run(DesignApplication.class, args);





    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                   .setSkipNullEnabled(true);
        return modelMapper;
    }
}
