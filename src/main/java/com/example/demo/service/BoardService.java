package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

    default Board convertDtoToEntity(BoardDTO boardDTO){
        return Board.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .writer(boardDTO.getWriter())
                .content(boardDTO.getContent())
                .readCount(boardDTO.getReadCount())
                .cmtQty(boardDTO.getCmtQty())
                .fileQty(boardDTO.getFileQty())
                .build();
    }

    default BoardDTO convertEntityToDto(Board board) {
        return null;
    }


    List<BoardDTO> getList();
}