package hello.core.member;


import java.util.HashMap;
import java.util.Map;

/**
 * 메모리 회원 저장소 구현체
 */
public class MemoryMemberRepository implements MemberRepository {

    // hashMap은 동시성 이슈가 발생할 수 있다. 이런경우 ConcurrentHashMap을 사용하자
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
