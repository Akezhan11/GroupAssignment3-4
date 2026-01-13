package repositories.implementations;

import entities.Member;
import repositories.MemberRepository;
import java.util.ArrayList;
import java.util.List;

public class InMemoryMemberRepository implements MemberRepository{
    private List<Member> members = new ArrayList<>();

    @Override
    public void save(Member member) {
        members.add(member);
    }
    @Override
    public Member findById(int id) {
        return members.stream().filter(m-> m.getId() == id).findFirst().orElse(null);
    }
    @Override
    public List<Member> findAll(){
        return members;
    }
}
