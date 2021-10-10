package org.zerock.jex01.board.service;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.jex01.board.dto.BoardDTO;
import org.zerock.jex01.common.dto.PageRequestDTO;
import org.zerock.jex01.common.dto.PageResponseDTO;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;

@Transactional
public interface BoardService {

    Long register(BoardDTO boardDTO);

    PageResponseDTO<BoardDTO> getDTOList(PageRequestDTO pageRequestDTO);

    BoardDTO read(Long bno);

    boolean remove(Long bno);

    boolean modify(BoardDTO boardDTO);


}
