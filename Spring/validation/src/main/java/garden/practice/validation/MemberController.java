package garden.practice.validation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MemberController {

    @PostMapping("/member")
    public String createMember(@Valid @RequestBody MemberDto memberDto) {
        System.out.println("memberDto.getRealName() = " + memberDto.getRealName());
        System.out.println("memberDto.getPassword() = " + memberDto.getPassword());
        System.out.println("memberDto.getNickName() = " + memberDto.getNickName());
        System.out.println("memberDto.getAge() = " + memberDto.getAge());
        // 비지니스 로직이 들어가는 자리.
        return "성공!";
    }
}
