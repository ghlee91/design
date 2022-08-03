package com.example.design;

import com.example.design.repo.MemberRepo;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // audit = 감시하다, 감사하다
public class DesignApplication {

//    private final MemberRepo memberRepo;

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
