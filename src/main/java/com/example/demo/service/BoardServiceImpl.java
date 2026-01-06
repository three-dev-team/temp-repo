package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

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

    @Transactional
    @Override
    public BoardDTO getDetail(long bno) {
        Board board = boardRepository.findById(bno)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글입니다."));

        // 조회수 증가(원치 않으면 이 줄 삭제)
        board.setReadCount(board.getReadCount() + 1);

        return convertEntityToDto(board);
    }
}
