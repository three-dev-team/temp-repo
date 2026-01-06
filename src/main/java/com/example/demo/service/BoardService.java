package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {

    BoardDTO getDetail(long bno);

    default BoardDTO convertEntityToDto(Board board) {
        return BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .writer(board.getWriter())
                .content(board.getContent())
                .readCount(board.getReadCount())
                .cmtQty(board.getCmtQty())
                .fileQty(board.getFileQty())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .build();
    }
}
