package org.zerock.board.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;
import org.zerock.board.entity.Reply;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertReplys(){
//        IntStream.rangeClosed(1,100).forEach(i->{
//            long bno = (long)(Math.random()*100)+1;
//            Board board = Board.builder().bno(bno).build();
//            Member member = Member.builder().email("user"+i+"@aaa.com").build();
//
//            Reply reply = Reply.builder()
//                    .text("Reply...."+i)
//                    .replyer(member)
//                    .board(board)
//                    .build();
//
//            replyRepository.save(reply);
//
//        });
    }

    @Test
    public void readReply1(){
        Optional<Reply> result = replyRepository.findById(1L);

        Reply reply = result.get();

        System.out.println(reply);
        System.out.println(reply.getBoard());
        System.out.println(reply.getReplyer());
    }

    @Test
    public void testListByBoard(){
        List<Reply> replyList = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(26L).build());
        replyList.forEach(System.out::println);
    }
}
