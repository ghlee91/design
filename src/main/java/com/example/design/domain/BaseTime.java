package com.example.design.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.asm.Advice.Local;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@ToString
public class BaseTime {

    @CreatedBy
    private String createdBy;


    @CreatedDate
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Comment("생성일")
    private LocalDateTime createdAt;

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Comment("수정일")
    private LocalDateTime modifiedAt;

    private String createdAtStr;

    public String getCreatedAtFommat() {
        return this.createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getCreateAtDate() {
        return this.createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getCreateAtTime() {
        return this.createdAt.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
/*    @PrePersist
    public void onPrePersist() {
//        Timestamp -> insert Into .. VALUES ("2022-07-01 13:10:00.000");
        LocalDateTime time = LocalDateTime.now();
        this.createdAt = time;
        this.createdAtStr = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.modifiedAt = time;

        // INSERT INTO member (name, created_at) VALUES ("영한", TIMESTAMP.NOW());
        // INSERT INTO member (name, created_at) VALUES ("영한", "2022-01-01 13:02:04");
    }

    @PreUpdate
    public void onPreUpdate() {
        this.modifiedAt = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

     2022-08-03 00:33:19.709357000
    @PrePersist
    public String getCreatedAt(){
        this.createdAt = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return String.valueOf(createdAt);
    }*/

}
