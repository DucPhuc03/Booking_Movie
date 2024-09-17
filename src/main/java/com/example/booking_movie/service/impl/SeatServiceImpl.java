package com.example.booking_movie.service.impl;

import com.example.booking_movie.dto.response.BookSeatDTO;
import com.example.booking_movie.dto.response.SeatDTO;
import com.example.booking_movie.entity.BookedSeat;
import com.example.booking_movie.entity.Seat;
import com.example.booking_movie.mapper.SeatMapper;
import com.example.booking_movie.repository.BookSeatReposiory;
import com.example.booking_movie.repository.SeatRepository;
import com.example.booking_movie.service.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements ISeatService {
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    SeatMapper seatMapper;
    @Autowired
    BookSeatReposiory bookSeatReposiory;
    @Override
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seat update(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<SeatDTO> getSeat(Long id) {
        List<Long> bookSeats=bookSeatReposiory.findByShowId(id);
        List<SeatDTO> listSeat=seatMapper.toDtos(seatRepository.findAll());
        listSeat.forEach(item->{
            if(bookSeats.stream().anyMatch(seat->seat.equals(item.getId()))){
                item.setTaken(true);
            }
                }
                );
        return listSeat ;
    }
}
