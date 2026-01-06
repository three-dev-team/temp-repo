package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public String getBoard() {
        return "Board Data";
    }

    @Override
    public Long insert(BoardDTO boardDTO) {
        Long bno = boardRepository.save(convertDtoToEntity(boardDTO)).getBno();
        return bno;
    }
}
