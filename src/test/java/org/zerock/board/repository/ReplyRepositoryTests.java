package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;
import org.zerock.board.entity.Reply;

import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReplys(){
        IntStream.rangeClosed(1,100).forEach(i->{
            long bno = (long)(Math.random()*100)+1;
            Board board = Board.builder().bno(bno).build();
            Member member = Member.builder().email("user"+i+"@aaa.com").build();

            Reply reply = Reply.builder()
                    .text("Reply...."+i)
                    .replyer(member)
                    .board(board)
                    .build();

            replyRepository.save(reply);

        });
    }
}
