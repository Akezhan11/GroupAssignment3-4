package service;

import entities.MembershipType;
import exception.MembershipExpiredException;
import repositories.MembershipRepository;

import java.time.LocalDate;

public class MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    public void buyMembership(int memberId, String type, int days) {

        MembershipType m = new MembershipType();
        m.setMemberId(memberId);
        m.setType(type);
        m.setStartDate(LocalDate.now());
        m.setEndDate(LocalDate.now().plusDays(days));
        m.setActive(true);

        membershipRepository.save(m);
    }

    public void checkActive(int memberId) {
        MembershipType m = membershipRepository.findByMemberId(memberId);

        if (m == null || !m.isActive() || m.isExpired()) {
            throw new MembershipExpiredException();
        }
    }
}
