package reports;

import entities.Member;
import interfaces.Report;

import java.util.Set;

public class MemberReport implements Report<Member> {
    private Set<Member> members;

    public MemberReport(Set<Member> members) {
        this.members = members;
    }

    @Override
    public void generateReport(Member member) {
        System.out.println("Member: " + member.getName() + ", Email: " + member.getEmail() + ", Fine: " + member.getFine());
    }

    public void generateCompleteReport() {
        System.out.println("===== Member Report =====");
        for (Member member : members) {
            generateReport(member);
        }
    }
}
