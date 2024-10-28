package com.sayaliblog.blogappapis.payloads;

import com.sayaliblog.blogappapis.entities.Category;
import com.sayaliblog.blogappapis.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {


//    private Long post_id;
    @NotEmpty
    @Size(min=3,message= "Title should be more then 3 letter")
    private String title;
    private String content;
    private String image;
    private Date addeddate;
     private CategoryDto categoryDto;
     private UserDto userDto;
}
