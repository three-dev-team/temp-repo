package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public List<BoardDTO> getList() {
        List<Board> boardList = boardRepository.findAll(
                Sort.by(Sort.Direction.DESC,"bno"));

        List<BoardDTO> boardDTOList = boardList
                    .stream()
                    .map(board -> convertEntityToDto(board))
                    .toList();
        return boardDTOList;
    }
}
