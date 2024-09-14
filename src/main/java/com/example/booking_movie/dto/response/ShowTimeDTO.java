package com.example.booking_movie.dto.response;
import com.example.booking_movie.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowTimeDTO {
    private Long id;
    private Date startTime;
    private Room room;
}
