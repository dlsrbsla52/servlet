package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Member member = new Member("hello", 20);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(member);
    }


    @Test
    void findAll(){

        // given
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hello", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);


        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members).hasSize(2);
        assertThat(members).contains(member1, member2);

    }

    @Test
    public void 진짜테스트(){
        String str = "abacabcd";
        boolean[] seen = new boolean[256];
        System.out.print(calculFn(str, str.length()-1,seen));
    }

    public String calculFn(String str, int index, boolean[] booleans){
        if(index < 0) return "";
        char c = str.charAt(index);
        String result = calculFn(str, index-1, booleans);

        if(!booleans[c]){
            booleans[c] = true;
            return c + result;
        }


        return result;
    }
}
