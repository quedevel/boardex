package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.entity.Board;

import javax.transaction.Transactional;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardDTO dto = BoardDTO.builder()
                .title("Test...")
                .content("Content...")
                .writerEmail("user55@aaa.com")
                .build();
        Long bno = boardService.register(dto);
        System.out.println("bno............."+bno);
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();

        PageResultDTO<BoardDTO,Object[]> result = boardService.getList(pageRequestDTO);

        result.getDtoList().forEach(System.out::println);
    }

    @Test
    public void testGet(){
        Long bno = 100L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }

    @Test
    public void testRemove(){
        Long bno = 57L;
        boardService.removeWithReplies(bno);
    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(2L)
                .title("제목 변경하자")
                .content("내용 변경하자")
                .build();
        boardService.modify(boardDTO);
    }
}
