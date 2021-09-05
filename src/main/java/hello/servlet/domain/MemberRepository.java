package hello.servlet.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AutomicLong  고려
 */
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<Long, Member>();

    private static long sequence = 0L;

    // 지금 스프링을 쓰는게 아니라서 싱글톤 패턴으로 만들어준다.
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // 스토어에 있는 모든 값들을 꺼내서 ArrayList에 담아준다.
    }

    public void clearStore() {
        store.clear();
    }




}
