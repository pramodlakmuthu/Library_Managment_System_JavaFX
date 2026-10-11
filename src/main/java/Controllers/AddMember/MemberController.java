package Controllers.AddMember;

import Model.Members;
import java.util.ArrayList;
import java.util.List;

public class MemberController {
    private static List<Members> memberList = new ArrayList<>();

    public boolean addMember(Members member) {
        if (member != null && member.getMemberId() != null && !member.getMemberId().isEmpty()) {
            // Check if member already exists
            for (Members m : memberList) {
                if (m.getMemberId().equals(member.getMemberId())) {
                    return false; // Already exists
                }
            }
            memberList.add(member);
            return true;
        }
        return false;
    }

    public boolean updateMember(Members updatedMember) {
        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).getMemberId().equals(updatedMember.getMemberId())) {
                memberList.set(i, updatedMember);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMember(String memberId) {
        return memberList.removeIf(m -> m.getMemberId().equals(memberId));
    }

    public int getTotalMembersCount() {
        return memberList.size();
    }

    public List<Members> getAllMembers() {
        return memberList;
    }
}