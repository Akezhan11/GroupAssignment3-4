/*package repositories.implementations;

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
        for (Member m : members) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
    @Override
    public List<Member> findAll(){
        return members;
    }
    @Override
    public Member findByPhone(String phoneNumber) {
        for (Member m : members) {
            if(phoneNumber.equals(m.getPhoneNumber())){
                return m;
            }
        }
        return null;
    }
    @Override
    public Member findByEmail(String email) {
        for(Member m : members){
            if(email.equals(m.getEmail())){
                return m;
            }
        }
        return null;
    }
}
*/